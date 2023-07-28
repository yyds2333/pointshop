package com.powernode.feign.impl;

import com.powernode.domain.Member;
import com.powernode.feign.MemberFeign;

import java.util.Collections;
import java.util.List;

public class MemberFeignImpl implements MemberFeign {
    @Override
    public List<Member> getMemberListFeign(List<String> openIds) {
        return Collections.emptyList();
    }
}
