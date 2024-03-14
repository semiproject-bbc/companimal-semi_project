package com.companimal.semiProject.evaluation.model.dto;

import java.sql.Timestamp;
import java.util.Date;

public class CreatorEvaluationDTO {
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

}
