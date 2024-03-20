package com.companimal.semiProject.member.model.service;

import com.companimal.semiProject.member.model.dao.MemberMapper;
import org.springframework.stereotype.Service;

@Service
public class DuplicateCheckService {

    private final MemberMapper memberMapper;

    public DuplicateCheckService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public boolean idDuplicateCheck(String id) {
        return memberMapper.idDuplicateCheck(id) > 0;
    }

}
