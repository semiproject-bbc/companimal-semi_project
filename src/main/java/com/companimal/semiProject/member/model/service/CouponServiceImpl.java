package com.companimal.semiProject.member.model.service;

import com.companimal.semiProject.member.model.dao.MemberMapper;
import com.companimal.semiProject.order.model.dao.OrderMapper;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    private final MemberMapper memberMapper;
    public CouponServiceImpl (MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }


    @Override
    public List<CouponDTO> getAvailableCouponInfo(String memId) {
        return memberMapper.getAvailableCouponInfo(memId);
    }

    @Override
    public List<CouponDTO> getUsedCouponInfo(String memId) {
        return memberMapper.getUsedCouponInfo(memId);
    }

    @Override
    public List<CouponDTO> downloadCouponInfo(String memId) {
        return memberMapper.downloadCouponInfo(memId);
    }
}
