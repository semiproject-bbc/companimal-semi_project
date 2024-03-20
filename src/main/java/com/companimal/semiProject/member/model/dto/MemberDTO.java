package com.companimal.semiProject.member.model.dto;

import com.companimal.semiProject.order.model.dto.OrderOptDTO;
import com.companimal.semiProject.order.model.dto.OrderPaymentDTO;
import com.companimal.semiProject.project.model.dto.CreatorInfoDTO;
import com.companimal.semiProject.project.model.dto.ProjectDTO;
import com.companimal.semiProject.project.model.dto.ProjectImageDTO;

import java.sql.Timestamp;
import java.util.List;

public class MemberDTO {

    private String memberId;
    private String memberPwd;
    private String memberNickname;
    private String memberName;
    private String memberPhone;
    private String memberEmail;
    private String memberRole;
    private List<ProjectDTO> project;
    private List<OrderPaymentDTO> orderPayment;
    private CreatorInfoDTO creatorInfo;
    private List<ProjectImageDTO> image;

    public MemberDTO() {
    }

    public MemberDTO(String memberId, String memberPwd, String memberNickname, String memberName, String memberPhone, String memberEmail, String memberRole, List<ProjectDTO> project, List<OrderPaymentDTO> orderPayment, CreatorInfoDTO creatorInfo, List<ProjectImageDTO> image) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberNickname = memberNickname;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.memberEmail = memberEmail;
        this.memberRole = memberRole;
        this.project = project;
        this.orderPayment = orderPayment;
        this.creatorInfo = creatorInfo;
        this.image = image;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
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

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public List<ProjectDTO> getProject() {
        return project;
    }

    public void setProject(List<ProjectDTO> project) {
        this.project = project;
    }

    public List<OrderPaymentDTO> getOrderPayment() {
        return orderPayment;
    }

    public void setOrderPayment(List<OrderPaymentDTO> orderPayment) {
        this.orderPayment = orderPayment;
    }

    public CreatorInfoDTO getCreatorInfo() {
        return creatorInfo;
    }

    public void setCreatorInfo(CreatorInfoDTO creatorInfo) {
        this.creatorInfo = creatorInfo;
    }

    public List<ProjectImageDTO> getImage() {
        return image;
    }

    public void setImage(List<ProjectImageDTO> image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", memberNickname='" + memberNickname + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberPhone='" + memberPhone + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberRole='" + memberRole + '\'' +
                ", project=" + project +
                ", orderPayment=" + orderPayment +
                ", creatorInfo=" + creatorInfo +
                ", image=" + image +
                '}';
    }
}
