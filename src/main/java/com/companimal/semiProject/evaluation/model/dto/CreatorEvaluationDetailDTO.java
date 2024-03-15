package com.companimal.semiProject.evaluation.model.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class CreatorEvaluationDetailDTO {

    private int evaNum;                 // 심사 번호
    private Timestamp evaDatetime;      // 심사 요청 일시
    private String evaSituation;        // 심사 상황
    private String reaRejection;        // 반려 사유
    private String memId;               // '크리에이터 아이디'
    private String creInqPhone;         // '문의 전화번호'
    private String creInqEmail;         // '문의 이메일'
    private String creImgName;          // '크리에이터 이미지 저장명'
    private String creImgPath;          // '크리에이터 이미지 저장경로'
    private String creImgOriName;       // '크리에이터 이미지 원본 이미지명'
    private String bankName;            // '은행명'
    private String accountNo;           // '계좌 번호'
    private String depositorName;       // '예금주명'
    private String busiNum;             // '사업자등록번호'
    private String busiName;            // '상호/법인명'
    private Date busiDate;              // '설립일'
    private String busiType;            // '기업형태'
    private String busiIndu;            // '업종'
    private String busiLoca;            // '소재지'
    private String busiSize;            // '기업규모'
    private String busiUrl;             // '홈페이지'
    private String authName;            // '담당자 이름'
    private String authNum;             // '담당자 전화번호'
    private String creatorType;         // '크리에이터 유형'
    private int creEvaNum;         // '파일 번호'
    private List<CreatorFileDTO> files; // 파일 정보 리스트

    public CreatorEvaluationDetailDTO() {
    }

    public CreatorEvaluationDetailDTO(int evaNum, Timestamp evaDatetime, String evaSituation, String reaRejection, String memId, String creInqPhone, String creInqEmail, String creImgName, String creImgPath, String creImgOriName, String bankName, String accountNo, String depositorName, String busiNum, String busiName, Date busiDate, String busiType, String busiIndu, String busiLoca, String busiSize, String busiUrl, String authName, String authNum, String creatorType, int creEvaNum, List<CreatorFileDTO> files) {
        this.evaNum = evaNum;
        this.evaDatetime = evaDatetime;
        this.evaSituation = evaSituation;
        this.reaRejection = reaRejection;
        this.memId = memId;
        this.creInqPhone = creInqPhone;
        this.creInqEmail = creInqEmail;
        this.creImgName = creImgName;
        this.creImgPath = creImgPath;
        this.creImgOriName = creImgOriName;
        this.bankName = bankName;
        this.accountNo = accountNo;
        this.depositorName = depositorName;
        this.busiNum = busiNum;
        this.busiName = busiName;
        this.busiDate = busiDate;
        this.busiType = busiType;
        this.busiIndu = busiIndu;
        this.busiLoca = busiLoca;
        this.busiSize = busiSize;
        this.busiUrl = busiUrl;
        this.authName = authName;
        this.authNum = authNum;
        this.creatorType = creatorType;
        this.creEvaNum = creEvaNum;
        this.files = files;
    }

    public int getEvaNum() {
        return evaNum;
    }

    public void setEvaNum(int evaNum) {
        this.evaNum = evaNum;
    }

    public Timestamp getEvaDatetime() {
        return evaDatetime;
    }

    public void setEvaDatetime(Timestamp evaDatetime) {
        this.evaDatetime = evaDatetime;
    }

    public String getEvaSituation() {
        return evaSituation;
    }

    public void setEvaSituation(String evaSituation) {
        this.evaSituation = evaSituation;
    }

    public String getReaRejection() {
        return reaRejection;
    }

    public void setReaRejection(String reaRejection) {
        this.reaRejection = reaRejection;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getCreInqPhone() {
        return creInqPhone;
    }

    public void setCreInqPhone(String creInqPhone) {
        this.creInqPhone = creInqPhone;
    }

    public String getCreInqEmail() {
        return creInqEmail;
    }

    public void setCreInqEmail(String creInqEmail) {
        this.creInqEmail = creInqEmail;
    }

    public String getCreImgName() {
        return creImgName;
    }

    public void setCreImgName(String creImgName) {
        this.creImgName = creImgName;
    }

    public String getCreImgPath() {
        return creImgPath;
    }

    public void setCreImgPath(String creImgPath) {
        this.creImgPath = creImgPath;
    }

    public String getCreImgOriName() {
        return creImgOriName;
    }

    public void setCreImgOriName(String creImgOriName) {
        this.creImgOriName = creImgOriName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getDepositorName() {
        return depositorName;
    }

    public void setDepositorName(String depositorName) {
        this.depositorName = depositorName;
    }

    public String getBusiNum() {
        return busiNum;
    }

    public void setBusiNum(String busiNum) {
        this.busiNum = busiNum;
    }

    public String getBusiName() {
        return busiName;
    }

    public void setBusiName(String busiName) {
        this.busiName = busiName;
    }

    public Date getBusiDate() {
        return busiDate;
    }

    public void setBusiDate(Date busiDate) {
        this.busiDate = busiDate;
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

    public String getBusiIndu() {
        return busiIndu;
    }

    public void setBusiIndu(String busiIndu) {
        this.busiIndu = busiIndu;
    }

    public String getBusiLoca() {
        return busiLoca;
    }

    public void setBusiLoca(String busiLoca) {
        this.busiLoca = busiLoca;
    }

    public String getBusiSize() {
        return busiSize;
    }

    public void setBusiSize(String busiSize) {
        this.busiSize = busiSize;
    }

    public String getBusiUrl() {
        return busiUrl;
    }

    public void setBusiUrl(String busiUrl) {
        this.busiUrl = busiUrl;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthNum() {
        return authNum;
    }

    public void setAuthNum(String authNum) {
        this.authNum = authNum;
    }

    public String getCreatorType() {
        return creatorType;
    }

    public void setCreatorType(String creatorType) {
        this.creatorType = creatorType;
    }

    public int getCreEvaNum() {
        return creEvaNum;
    }

    public void setCreEvaNum(int creEvaNum) {
        this.creEvaNum = creEvaNum;
    }

    public List<CreatorFileDTO> getFiles() {
        return files;
    }

    public void setFiles(List<CreatorFileDTO> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "CreatorEvaluationDetailDTO{" +
                "evaNum=" + evaNum +
                ", evaDatetime=" + evaDatetime +
                ", evaSituation='" + evaSituation + '\'' +
                ", reaRejection='" + reaRejection + '\'' +
                ", memId='" + memId + '\'' +
                ", creInqPhone='" + creInqPhone + '\'' +
                ", creInqEmail='" + creInqEmail + '\'' +
                ", creImgName='" + creImgName + '\'' +
                ", creImgPath='" + creImgPath + '\'' +
                ", creImgOriName='" + creImgOriName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", depositorName='" + depositorName + '\'' +
                ", busiNum='" + busiNum + '\'' +
                ", busiName='" + busiName + '\'' +
                ", busiDate=" + busiDate +
                ", busiType='" + busiType + '\'' +
                ", busiIndu='" + busiIndu + '\'' +
                ", busiLoca='" + busiLoca + '\'' +
                ", busiSize='" + busiSize + '\'' +
                ", busiUrl='" + busiUrl + '\'' +
                ", authName='" + authName + '\'' +
                ", authNum='" + authNum + '\'' +
                ", creatorType='" + creatorType + '\'' +
                ", creEvaNum=" + creEvaNum +
                ", files=" + files +
                '}';
    }
}
