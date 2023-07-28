package com.powernode.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.powernode.config.WxConfig;
import com.powernode.constant.AuthConstant;
import com.powernode.domain.LoginMember;
import com.powernode.domain.LoginSysUser;
import com.powernode.mapper.LoginMemberMapper;
import com.powernode.mapper.LoginSysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LoginSysUserMapper loginSysUserMapper;

    @Autowired
    private LoginMemberMapper loginMemberMapper;

    @Autowired
    private WxConfig wxConfig;

    @Autowired
    private RestTemplate restTemplate;


    // 自定义用户登录方法
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从 ServletRequestAttributes 中获取 获取请求 并 获取角色类型
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String loginType = request.getHeader(AuthConstant.LOGIN_TYPE);
        // 如果没有角色类型，则认定为非法访问
        if (!StringUtils.hasText(loginType)){
            throw new IllegalArgumentException("非法的用户类型");
        }
        LoginSysUser loginSysUser = null;
        // 根据访问角色的类型来决定用户权限
        switch (loginType){
            // 管理员权限
            case AuthConstant.SYS_USER:{
                // 根据用户名查询用户表
                loginSysUser = loginSysUserMapper.selectOne(new LambdaQueryWrapper<LoginSysUser>()
                        .eq(LoginSysUser::getUsername,username));
                // 如果该用户存在,则获取该用户的权限
                if (!ObjectUtils.isEmpty(loginSysUser)){
                    Set<String> myPerms = loginSysUserMapper.selectPermsById(loginSysUser.getUserId());
                    // 如果权限不为空，则将权限存放到LoginSysUser中
                    if (!CollectionUtils.isEmpty(myPerms)){
                        loginSysUser.setPerms(myPerms);
                    }
                    myPerms.forEach(System.out::println);
                    // 将UserDetails的实现类返回出去
                    return loginSysUser;
                }
            }
            // 如果是会员角色 ，则调用该方法 根据 code 和 openid appsecret 调用微信api接口 code2Session
            case AuthConstant.MEMBER:{
                String appId = wxConfig.getAppId();
                String secret = wxConfig.getAppSecret();
                String tokenUrl = wxConfig.getWxTokenUrl();

                // 替换微信请求url
                String realUrl = String.format(tokenUrl, appId, secret, username);
                // 向微信服务器发送请求获取openId
                String wxResult = restTemplate.getForObject(realUrl, String.class);
                JSONObject jsonObject = JSON.parseObject(wxResult);
                /**
                 {
                 "openid":"xxxxxx",
                 "session_key":"xxxxx",
                 "unionid":"xxxxx",
                 "errcode":0,
                 "errmsg":"xxxxx"
                 }
                 * 可以获取到的数据
                 */
                String openid = jsonObject.getString("openid");
                if (!StringUtils.hasText(openid)){
                    throw new IllegalArgumentException("身份获取失败，请联系微信管理员");
                }
                // 根据openid获取会员表中是否存在
                LoginMember loginMember = loginMemberMapper.selectOne(new LambdaQueryWrapper<LoginMember>().eq(LoginMember::getOpenId, openid));
                if (ObjectUtils.isEmpty(loginMember)){
                    System.out.println("第一次登陆，注册信息到会员表");
                    loginMember = new LoginMember();
                    loginMember.setCreateTime(new Date());
                    loginMember.setOpenId(openid);
                    loginMember.setScore(0);
                    loginMember.setUserLastip(request.getRemoteAddr());
                    loginMember.setUserLasttime(new Date());
                    loginMember.setStatus(1);
                    loginMember.setUserRegip(request.getRemoteAddr());
                    loginMember.setUpdateTime(new Date());
                    // 插入数据到会员表
                    loginMemberMapper.insert(loginMember);
                }else{
                    // 曾经登录过
                    // 修改最后登录ip地址
                    loginMember.setUserLastip(request.getRemoteAddr());
                    // 修改最后登录时间
                    loginMember.setUserLasttime(new Date());

                    loginMemberMapper.updateById(loginMember);
                }

                return loginMember;

            }
        }
        return null;
    }
}
