package com.companimal.semiProject.member.model.dto;

import com.companimal.semiProject.common.MemberRole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemberDTO {

    private String memberId;
    private String memberPWD;
    private String memberNickname;
    private String memberPhone;
    private String memberEmail;
    private MemberRole memberRole;

    public MemberDTO() {
    }

    public MemberDTO(String memberId, String memberPWD, String memberNickname, String memberPhone, String memberEmail, MemberRole memberRole) {
        this.memberId = memberId;
        this.memberPWD = memberPWD;
        this.memberNickname = memberNickname;
        this.memberPhone = memberPhone;
        this.memberEmail = memberEmail;
        this.memberRole = memberRole;
    }

    public List<String> getRole() {
        if (this.memberRole.getRole().length() > 0) {
            return Arrays.asList(this.memberRole.getRole().split(","));
        }

        return new ArrayList<>();
    }
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPWD() {
        return memberPWD;
    }

    public void setMemberPWD(String memberPWD) {
        this.memberPWD = memberPWD;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberId='" + memberId + '\'' +
                ", memberPWD='" + memberPWD + '\'' +
                ", memberNickname='" + memberNickname + '\'' +
                ", memberPhone='" + memberPhone + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberRole='" + memberRole + '\'' +
                '}';
    }
}
