package com.powernode.service.impl;

import com.alibaba.fastjson.JSON;
import com.powernode.constant.SysMenuConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.powernode.domain.SysMenu;
import com.powernode.mapper.SysMenuMapper;
import com.powernode.service.SysMenuService;
import org.springframework.util.StringUtils;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService{

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 给前台提供一个获取和权限的集合,通过UserId
     * @param userId
     * @return
     */
    @Override
    public List<SysMenu> getMenuByUserId(Long userId) {
        // 从Redis查询UserId对应的权限信息
        String menuStr = stringRedisTemplate.opsForValue().get(SysMenuConstant.SYS_MENU_PREFIX + userId);
        if (StringUtils.hasText(menuStr)){
            // 如果Reids中存在SysMenu的信息,则将其转换为数组返回出去
            List<SysMenu> sysMenus = JSON.parseArray(menuStr, SysMenu.class);
            return sysMenus;
        }
        // 如果Redis中不存在 该 UserID的菜单集合 ,则去数据库查询 ,该集合有多层菜单组成
        List<SysMenu> sysMenus = sysMenuMapper.selectMenuByUserId(userId);
        for (SysMenu sysMenu:sysMenus) {
            System.out.println("sysMenu = " + sysMenu);
        }
        // 构建一个树形菜单
        List<SysMenu> treeMenus = buildTreeList(sysMenus,0L);
        treeMenus.forEach(System.out::println);
        // 保存 该集合到 Redis中去 过期时间设置为一周
        stringRedisTemplate.opsForValue().set(SysMenuConstant.SYS_MENU_PREFIX+userId,
                JSON.toJSONString(treeMenus),
                Calendar.DAY_OF_WEEK, TimeUnit.DAYS);

        return treeMenus;
    }

    /**
     * 将输入进来的list集合转换为一个树状集合,以pid为根节点
     * @param sysMenus
     * @param pid
     * @return
     */
    protected List<SysMenu> buildTreeList(List<SysMenu> sysMenus,Long pid){
        // 先获取值为pid的为根节点   通过stream流来过滤符合条件的集合中对象
        List<SysMenu> roots = sysMenus.stream()
                .filter(sysMenu -> sysMenu.getParentId().equals(pid))
                .collect(Collectors.toList());
        // 通过遍历根节点,将符合条件的子节点放到根节点中
        roots.forEach(root->{
            List<SysMenu> children = new ArrayList<>();
            // 在循环中循环遍历每一个节点,将其放到根节点的子集合中
            sysMenus.forEach(sysMenu -> {
                if (sysMenu.getParentId().equals(root.getMenuId())){
                    children.add(sysMenu);
                }
            });
            root.setList(children);
        });
        return roots;
    }
    /**
     * 将输入进来的list集合转换为一个树状集合,以pid为根节点  递归
     * 递归要素
     * 方法体
     * 递归
     * 结束方法
     * @param sysMenus
     * @param pid
     * @return
     */
    public List<SysMenu> buildTreeListRA(List<SysMenu> sysMenus,Long pid){
        // 先获取值为pid的为根节点   通过stream流来过滤符合条件的集合中对象
        List<SysMenu> roots = sysMenus.stream()
                .filter(sysMenu -> sysMenu.getMenuId().equals(pid))
                .collect(Collectors.toList());
        roots.forEach(root-> root.setList(buildTreeListRA(sysMenus,root.getMenuId())));
        return roots;
    }



}
