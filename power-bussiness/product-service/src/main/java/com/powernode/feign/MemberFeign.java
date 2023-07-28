package com.powernode.feign;

import com.powernode.domain.Member;
import com.powernode.feign.impl.MemberFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "member-service",fallback = MemberFeignImpl.class)
public interface MemberFeign {

    @GetMapping("/p/user/getMembersByOpenIds")
    List<Member> getMemberListFeign(@RequestParam("openIds")List<String> openIds);
}
