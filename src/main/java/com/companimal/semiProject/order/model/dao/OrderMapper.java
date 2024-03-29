package com.companimal.semiProject.order.model.dao;

import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import com.companimal.semiProject.order.model.dto.OrderPaymentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<CouponDTO> findCouponInfo(String memId); // 쿠폰 'y'만 사용할 수 있겠금 하기 위해서 DB에서 가져온다

    MemberDTO findMemberInfo(String memId); // session에 있는 멤버 정보를 가져오기 위해서

    void setOrderPaymentInfo(OrderPaymentDTO orderPaymentDTO); // 결제가 완료되면 DB에 저장을 하기 위햐서

    void updateUsedCoupon(String couCode); // 결제가 완료 되면 쿠폰 사용여부를 'y'에서 'n'으로 바꾸기 위해서

    void updateEstRate(int proCode, int totalPrice);
}
