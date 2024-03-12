package com.companimal.semiProject.project.model.dto;

import org.springframework.context.annotation.Bean;
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
    private String delStatus;                       // 삭제 여부
    private int cateMain;                           // 메인 카테고리
    private int cateSub;                            // 서브 카테고리
    private int dDay;                               // 종료일 d-day
    private List<ProjectRewardDTO> reward;          // 프로젝트 리워드 DTO
    private List<ProjectRewardOptDTO> rewardOpt;    // 프로젝트 리워드 옵션 DTO
    private List<ProjectImageDTO> image;            // 프로젝트 이미지 DTO
    private List<ProjectFileDTO> file;              // 프로젝트 파일 DTO
    private List<ProjectCateDTO> cate;              // 프로젝트 카테고리 DTO
    private int imageAttached;
    private MultipartFile projectImage;
    private List<OrderPaymentDTO> orderPayment;

    public ProjectDTO() {
    }

    public ProjectDTO(int proCode, Date estDate) {
        this.proCode = proCode;
        this.estDate = estDate;
    }

    public ProjectDTO(int proCode, String proName, String proIntro, int goalAmount, Date startDate, Date endDate, String proStory, String polNoRefund, String polAs, String memId, Date estDate, int achRate, String delStatus, int cateMain, int cateSub) {
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
        this.delStatus = delStatus;
        this.cateMain = cateMain;
        this.cateSub = cateSub;
    }

    public ProjectDTO(int proCode, String proName, String proIntro, int goalAmount, Date startDate, Date endDate, String proStory, String polNoRefund, String polAs, String memId, Date estDate, int achRate, String delStatus, int cateMain, int cateSub, int dDay, List<ProjectRewardDTO> reward, List<ProjectRewardOptDTO> rewardOpt, List<ProjectImageDTO> image, List<ProjectFileDTO> file, List<ProjectCateDTO> cate) {
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
        this.delStatus = delStatus;
        this.cateMain = cateMain;
        this.cateSub = cateSub;
        this.dDay = dDay;
        this.reward = reward;
        this.rewardOpt = rewardOpt;
        this.image = image;
        this.file = file;
        this.cate = cate;
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

    public String getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus;
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

    public List<ProjectRewardDTO> getReward() {
        return reward;
    }

    public void setReward(List<ProjectRewardDTO> reward) {
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

    public MultipartFile getFile() {
        return (MultipartFile) file;
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
                ", delStatus='" + delStatus + '\'' +
                ", cateMain=" + cateMain +
                ", cateSub=" + cateSub +
                ", dDay=" + dDay +
                ", reward=" + reward +
                ", rewardOpt=" + rewardOpt +
                ", image=" + image +
                ", file=" + file +
                ", cate=" + cate +
                '}';
    }
}
