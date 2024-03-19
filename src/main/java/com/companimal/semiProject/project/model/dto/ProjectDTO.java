package com.companimal.semiProject.project.model.dto;

import com.companimal.semiProject.evaluation.model.dto.CalculationListDTO;
import com.companimal.semiProject.evaluation.model.dto.ProjectEvaDTO;
import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.order.model.dto.OrderOptDTO;
import com.companimal.semiProject.order.model.dto.OrderProPaymentDTO;
import org.springframework.web.multipart.MultipartFile;
import com.companimal.semiProject.order.model.dto.OrderPaymentDTO;

import java.sql.Date;
import java.util.List;

public class ProjectDTO implements java.io.Serializable {

    private int proCode;                            // 프로젝트 코드
    private String proName;                         // 프로젝트 제목
    private String proIntro;                        // 프로젝트 소개
    private int goalAmount;                         // 목표 금액
    private Date startDate;                         // 시작일
    private Date endDate;                           // 종료일
    private String proStory;                        // 스토리
    private String polNoRefund;                     // 기타 환불 불가 규정
    private String polAs;                           // A/S 정책
    private String memId;                           // 크리에이터 아이디
    private Date estDate;                           // 발송예정일
    private int achRate;                            // 달성률
    private String evaStatus;                       // 심사 상황
    private int cateMain;                           // 메인 카테고리
    private int cateSub;                            // 서브 카테고리
    private int dDay;                              // 종료일 d-day
    private ProjectRewardDTO reward;          // 프로젝트 리워드 DTO
    private List<ProjectRewardOptDTO> rewardOpt;    // 프로젝트 리워드 옵션 DTO
    private List<ProjectImageDTO> image;            // 프로젝트 이미지 DTO
    private List<ProjectFileDTO> file;              // 프로젝트 파일 DTO
    private List<ProjectCateDTO> cate;              // 프로젝트 카테고리 DTO
    private int noOfOrder;                          // 주문 갯수
    private int orderAmount;                        // 주문 금액 (배송비 제외)
    private CreatorInfoDTO creatorInfo;             // 크리에이터 정보 DTO
    private MemberDTO member;                       // 회원 DTO
    private List<OrderPaymentDTO> orderPayment;
    private List<OrderOptDTO> orderOpt;
    private List<MemberDTO> defaultMember;
    private List<CalculationListDTO> calculationList;
    private List<OrderProPaymentDTO> orderProPayment;
    private ProjectEvaDTO projectEva;
    private ProjectCateDTO category;
    private ProjectCateSubDTO categorySub;

    public ProjectDTO() {
    }

    public ProjectDTO(int proCode, Date estDate) {
        this.proCode = proCode;
        this.estDate = estDate;
    }

    public ProjectDTO(int proCode, String proName, String proIntro, int goalAmount, Date startDate, Date endDate, String proStory, String polNoRefund, String polAs, String memId, Date estDate, int achRate, String evaStatus, int cateMain, int cateSub, int dDay, ProjectRewardDTO reward, List<ProjectImageDTO> image, List<ProjectFileDTO> file, List<ProjectCateDTO> cate, List<OrderPaymentDTO> orderPayment, List<OrderOptDTO> orderOpt, List<MemberDTO> defaultMember) {
        this.proCode = proCode;
        this.proName = proName;
        this.proIntro = proIntro;
        this.goalAmount = goalAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.proStory = proStory;
        this.polNoRefund = polNoRefund;
        this.polAs = polAs;
        this.memId = memId;
        this.estDate = estDate;
        this.achRate = achRate;
        this.evaStatus = evaStatus;
        this.cateMain = cateMain;
        this.cateSub = cateSub;
        this.dDay = dDay;
        this.reward = reward;
//        this.rewardOpt = rewardOpt;
        this.image = image;
        this.file = file;
        this.cate = cate;
        this.orderPayment = orderPayment;
        this.orderOpt = orderOpt;
    }

    /* 후원금 정산 진행 현황 DTO */
    public ProjectDTO(int proCode, String proName, String proIntro, int goalAmount, Date startDate, Date endDate, String proStory, String polNoRefund, String polAs, String memId, Date estDate, int achRate, String evaStatus, int cateMain, int cateSub, List<OrderPaymentDTO> orderPayment) {
        this.proCode = proCode;
        this.proName = proName;
        this.proIntro = proIntro;
        this.goalAmount = goalAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.proStory = proStory;
        this.polNoRefund = polNoRefund;
        this.polAs = polAs;
        this.memId = memId;
        this.estDate = estDate;
        this.achRate = achRate;
        this.evaStatus = evaStatus;
        this.cateMain = cateMain;
        this.cateSub = cateSub;
        this.orderPayment = orderPayment;
    }

    public ProjectDTO(int proCode, String proName, String proIntro, int goalAmount, Date startDate, Date endDate, String proStory, String polNoRefund, String polAs, String memId, Date estDate, int achRate, String evaStatus, int cateMain, int cateSub, int dDay, ProjectRewardDTO reward, List<ProjectImageDTO> image, List<ProjectFileDTO> file, List<ProjectCateDTO> cate, int noOfOrder, int orderAmount, List<OrderPaymentDTO> orderPayment, List<OrderOptDTO> orderOpt, List<MemberDTO> defaultMember) {
        this.proCode = proCode;
        this.proName = proName;
        this.proIntro = proIntro;
        this.goalAmount = goalAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.proStory = proStory;
        this.polNoRefund = polNoRefund;
        this.polAs = polAs;
        this.memId = memId;
        this.estDate = estDate;
        this.achRate = achRate;
        this.evaStatus = evaStatus;
        this.cateMain = cateMain;
        this.cateSub = cateSub;
        this.dDay = dDay;
        this.reward = reward;
//        this.rewardOpt = rewardOpt;
        this.image = image;
        this.file = file;
        this.cate = cate;
        this.noOfOrder = noOfOrder;
        this.orderAmount = orderAmount;
        this.orderPayment = orderPayment;
        this.orderOpt = orderOpt;
        this.defaultMember = defaultMember;
    }

    public ProjectDTO(int proCode, String proName, String proIntro, int goalAmount, Date startDate, Date endDate, String proStory, String polNoRefund, String polAs, String memId, Date estDate, int achRate, String evaStatus, int cateMain, int cateSub, int dDay, ProjectRewardDTO reward, List<ProjectRewardOptDTO> rewardOpt, List<ProjectImageDTO> image, List<ProjectFileDTO> file, List<ProjectCateDTO> cate, int noOfOrder, int orderAmount, CreatorInfoDTO creatorInfo, MemberDTO member, List<OrderPaymentDTO> orderPayment, List<OrderOptDTO> orderOpt, List<MemberDTO> defaultMember, List<CalculationListDTO> calculationList, List<OrderProPaymentDTO> orderProPayment) {
        this.proCode = proCode;
        this.proName = proName;
        this.proIntro = proIntro;
        this.goalAmount = goalAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.proStory = proStory;
        this.polNoRefund = polNoRefund;
        this.polAs = polAs;
        this.memId = memId;
        this.estDate = estDate;
        this.achRate = achRate;
        this.evaStatus = evaStatus;
        this.cateMain = cateMain;
        this.cateSub = cateSub;
        this.dDay = dDay;
        this.reward = reward;
        this.rewardOpt = rewardOpt;
        this.image = image;
        this.file = file;
        this.cate = cate;
        this.noOfOrder = noOfOrder;
        this.orderAmount = orderAmount;
        this.creatorInfo = creatorInfo;
        this.member = member;
        this.orderPayment = orderPayment;
        this.orderOpt = orderOpt;
        this.defaultMember = defaultMember;
        this.calculationList = calculationList;
        this.orderProPayment = orderProPayment;
    }

    public ProjectDTO(int proCode, String proName, String proIntro, int goalAmount, Date startDate, Date endDate, String proStory, String polNoRefund, String polAs, String memId, Date estDate, int achRate, String evaStatus, int cateMain, int cateSub, int dDay, ProjectRewardDTO reward, List<ProjectRewardOptDTO> rewardOpt, List<ProjectImageDTO> image, List<ProjectFileDTO> file, List<ProjectCateDTO> cate, int noOfOrder, int orderAmount, CreatorInfoDTO creatorInfo, MemberDTO member, List<OrderPaymentDTO> orderPayment, List<OrderOptDTO> orderOpt, List<MemberDTO> defaultMember, List<CalculationListDTO> calculationList) {
        this.proCode = proCode;
        this.proName = proName;
        this.proIntro = proIntro;
        this.goalAmount = goalAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.proStory = proStory;
        this.polNoRefund = polNoRefund;
        this.polAs = polAs;
        this.memId = memId;
        this.estDate = estDate;
        this.achRate = achRate;
        this.evaStatus = evaStatus;
        this.cateMain = cateMain;
        this.cateSub = cateSub;
        this.dDay = dDay;
        this.reward = reward;
        this.rewardOpt = rewardOpt;
        this.image = image;
        this.file = file;
        this.cate = cate;
        this.noOfOrder = noOfOrder;
        this.orderAmount = orderAmount;
        this.creatorInfo = creatorInfo;
        this.member = member;
        this.orderPayment = orderPayment;
        this.orderOpt = orderOpt;
        this.defaultMember = defaultMember;
        this.calculationList = calculationList;
    }

    public ProjectDTO(int proCode, String proName, String proIntro, int goalAmount, Date startDate, Date endDate, String proStory, String polNoRefund, String polAs, String memId, Date estDate, int achRate, String evaStatus, int cateMain, int cateSub, int dDay, ProjectRewardDTO reward, List<ProjectImageDTO> image, List<ProjectFileDTO> file, List<ProjectCateDTO> cate, int noOfOrder, int orderAmount, CreatorInfoDTO creatorInfo, MemberDTO member, List<OrderPaymentDTO> orderPayment, List<OrderOptDTO> orderOpt, List<MemberDTO> defaultMember, List<CalculationListDTO> calculationList, ProjectEvaDTO projectEva, ProjectCateDTO category, ProjectCateSubDTO categorySub) {
        this.proCode = proCode;
        this.proName = proName;
        this.proIntro = proIntro;
        this.goalAmount = goalAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.proStory = proStory;
        this.polNoRefund = polNoRefund;
        this.polAs = polAs;
        this.memId = memId;
        this.estDate = estDate;
        this.achRate = achRate;
        this.evaStatus = evaStatus;
        this.cateMain = cateMain;
        this.cateSub = cateSub;
        this.dDay = dDay;
        this.reward = reward;
        this.image = image;
        this.file = file;
        this.cate = cate;
        this.noOfOrder = noOfOrder;
        this.orderAmount = orderAmount;
        this.creatorInfo = creatorInfo;
        this.member = member;
        this.orderPayment = orderPayment;
        this.orderOpt = orderOpt;
        this.defaultMember = defaultMember;
        this.calculationList = calculationList;
        this.projectEva = projectEva;
        this.category = category;
        this.categorySub = categorySub;
    }

    public int getProCode() {
        return proCode;
    }

    public void setProCode(int proCode) {
        this.proCode = proCode;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProIntro() {
        return proIntro;
    }

    public void setProIntro(String proIntro) {
        this.proIntro = proIntro;
    }

    public int getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(int goalAmount) {
        this.goalAmount = goalAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProStory() {
        return proStory;
    }

    public void setProStory(String proStory) {
        this.proStory = proStory;
    }

    public String getPolNoRefund() {
        return polNoRefund;
    }

    public void setPolNoRefund(String polNoRefund) {
        this.polNoRefund = polNoRefund;
    }

    public String getPolAs() {
        return polAs;
    }

    public void setPolAs(String polAs) {
        this.polAs = polAs;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public Date getEstDate() {
        return estDate;
    }

    public void setEstDate(Date estDate) {
        this.estDate = estDate;
    }

    public int getAchRate() {
        return achRate;
    }

    public void setAchRate(int achRate) {
        this.achRate = achRate;
    }

    public String getEvaStatus() {
        return evaStatus;
    }

    public void setEvaStatus(String evaStatus) {
        this.evaStatus = evaStatus;
    }

    public int getCateMain() {
        return cateMain;
    }

    public void setCateMain(int cateMain) {
        this.cateMain = cateMain;
    }

    public int getCateSub() {
        return cateSub;
    }

    public void setCateSub(int cateSub) {
        this.cateSub = cateSub;
    }

    public int getdDay() {
        return dDay;
    }

    public void setdDay(int dDay) {
        this.dDay = dDay;
    }

    public ProjectRewardDTO getReward() {
        return reward;
    }

    public void setReward(ProjectRewardDTO reward) {
        this.reward = reward;
    }

    public List<ProjectRewardOptDTO> getRewardOpt() {
        return rewardOpt;
    }

    public void setRewardOpt(List<ProjectRewardOptDTO> rewardOpt) {
        this.rewardOpt = rewardOpt;
    }

    public List<ProjectImageDTO> getImage() {
        return image;
    }

    public void setImage(List<ProjectImageDTO> image) {
        this.image = image;
    }

    public List<ProjectFileDTO> getFile() {
        return file;
    }

    public void setFile(List<ProjectFileDTO> file) {
        this.file = file;
    }

    public List<ProjectCateDTO> getCate() {
        return cate;
    }

    public void setCate(List<ProjectCateDTO> cate) {
        this.cate = cate;
    }

    public List<OrderPaymentDTO> getOrderPayment() {
        return orderPayment;
    }

    public void setOrderPayment(List<OrderPaymentDTO> orderPayment) {
        this.orderPayment = orderPayment;
    }

    public List<OrderOptDTO> getOrderOpt() {
        return orderOpt;
    }

    public void setOrderOpt(List<OrderOptDTO> orderOpt) {
        this.orderOpt = orderOpt;
    }
  
    public List<MemberDTO> getDefaultMember() {
        return defaultMember;
    }

    public void setDefaultMember(List<MemberDTO> defaultMember) {
        this.defaultMember = defaultMember;
    }
  
    public int getNoOfOrder() {
        return noOfOrder;
    }

    public void setNoOfOrder(int noOfOrder) {
        this.noOfOrder = noOfOrder;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public List<CalculationListDTO> getCalculationList() {
        return calculationList;
    }

    public void setCalculationList(List<CalculationListDTO> calculationList) {
        this.calculationList = calculationList;
    }
  
    public CreatorInfoDTO getCreatorInfo() {
        return creatorInfo;
    }

    public void setCreatorInfo(CreatorInfoDTO creatorInfo) {
        this.creatorInfo = creatorInfo;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    public List<OrderProPaymentDTO> getOrderProPayment() {
        return orderProPayment;
    }

    public void setOrderProPayment(List<OrderProPaymentDTO> orderProPayment) {
        this.orderProPayment = orderProPayment;
    }
  
    public ProjectEvaDTO getProjectEva() {
        return projectEva;
    }

    public void setProjectEva(ProjectEvaDTO projectEva) {
        this.projectEva = projectEva;
    }

    public ProjectCateDTO getCategory() {
        return category;
    }

    public void setCategory(ProjectCateDTO category) {
        this.category = category;
    }

    public ProjectCateSubDTO getCategorySub() {
        return categorySub;
    }

    public void setCategorySub(ProjectCateSubDTO categorySub) {
        this.categorySub = categorySub;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "proCode=" + proCode +
                ", proName='" + proName + '\'' +
                ", proIntro='" + proIntro + '\'' +
                ", goalAmount=" + goalAmount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", proStory='" + proStory + '\'' +
                ", polNoRefund='" + polNoRefund + '\'' +
                ", polAs='" + polAs + '\'' +
                ", memId='" + memId + '\'' +
                ", estDate=" + estDate +
                ", achRate=" + achRate +
                ", evaStatus='" + evaStatus + '\'' +
                ", cateMain=" + cateMain +
                ", cateSub=" + cateSub +
                ", dDay=" + dDay +
                ", reward=" + reward +
                ", rewardOpt=" + rewardOpt +
                ", image=" + image +
                ", file=" + file +
                ", cate=" + cate +
                ", noOfOrder=" + noOfOrder +
                ", orderAmount=" + orderAmount +
                ", creatorInfo=" + creatorInfo +
                ", member=" + member +
                ", orderPayment=" + orderPayment +
                ", orderOpt=" + orderOpt +
                ", defaultMember=" + defaultMember +
                ", calculationList=" + calculationList +
                ", projectEva=" + projectEva +
                ", category=" + category +
                ", categorySub=" + categorySub +
                '}';
    }
}
