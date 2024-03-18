package com.companimal.semiProject.project.controller;

import com.companimal.semiProject.auth.model.AuthDetails;
import com.companimal.semiProject.project.model.dto.ProjectDTO;
import com.companimal.semiProject.project.model.dto.ProjectRewardDTO;
import com.companimal.semiProject.project.model.dto.ProjectRewardOptDTO;
import com.companimal.semiProject.project.model.service.ProjectService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    private int rewardNumber = 1;

    private ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public String selectAllProject(Model model) {
        List<ProjectDTO> selectAllProjectList = projectService.selectAllProject();

        model.addAttribute("selectAllProjectList", selectAllProjectList);

        return "main";
    }

    @GetMapping("/projectPage")
    public String selectProject(Model model) {

        ProjectDTO selectProject = projectService.selectProject();

        model.addAttribute("selectProject", selectProject);

        return "contents/project/projectDetail";
    }

    @GetMapping("/projectDetail/{proCode}")
    public String selectProjectDetail(Model model, @PathVariable("proCode") Integer proCode) {

        ProjectDTO selectProject = projectService.selectProjectDetail(proCode);

        System.out.println(selectProject);

        model.addAttribute("selectProject", selectProject);

        return "contents/project/projectDetail";
    }

    @GetMapping("/projectRegistBefore")
    public String goInsertProjectBefore() {
        return "contents/project/projectRegistBefore";
    }

    @GetMapping("/projectRegist")
    public String goInsertProject() {
        return "contents/project/projectRegist";
    }

    @PostMapping("/projectRegist")
    public String insertProject(@RequestParam("files") List<MultipartFile> files,
                                @ModelAttribute ProjectDTO project,
                                @ModelAttribute("ProjectRewardOptDTO") ProjectRewardOptDTO projectRewardOpt,
                                Authentication authentication,
                                Model model) throws IOException {

        AuthDetails authDetails = (AuthDetails) authentication.getPrincipal();
        String memId = authDetails.getUsername();


        /* 콘솔 찍어보기 */
        System.out.println("Logged-in User ID: " + memId);

        System.out.println("화면에서 받은 files : " + files);

        System.out.println("화면에서 받은 project : " + project);

        ProjectRewardDTO projectReward = project.getReward();

        System.out.println("화면에서 받은 리워드 : " + projectReward);

        System.out.println("화면에서 받은 리워드 옵션 : " + projectRewardOpt.getRewOptName());
        System.out.println("화면에서 받은 리워드 옵션 : " + projectRewardOpt.getRewOptVal());
        System.out.println("화면에서 받은 리워드 옵션 : " + projectRewardOpt.getRewOptLimit());
        System.out.println("화면에서 받은 리워드 옵션 : " + projectRewardOpt.getRewAmount());

        String[] rewOptName = projectRewardOpt.getRewOptName().split(",");
        String[] RewOptVal = projectRewardOpt.getRewOptVal().split(",");
        String[] RewOptLimit = projectRewardOpt.getRewOptLimit().split(",");
        String[] RewAmount = projectRewardOpt.getRewAmount().split(",");

        System.out.println("rewOptName 의 length : " + rewOptName.length);
        System.out.println("RewOptVal 의 length : " + RewOptVal.length);
        System.out.println("RewOptLimit 의 length : " + RewOptLimit.length);
        System.out.println("RewAmount 의 length : " + RewAmount.length);

        /* 셋팅 */
        project.setMemId(memId);
        project.setProStory(files.toString());
        project.setEvaStatus("N");

        List<ProjectRewardOptDTO> projectRewardOpts = new ArrayList<ProjectRewardOptDTO>();
        for(int i = 0; i < rewOptName.length; i++) {
            ProjectRewardOptDTO rewOpt = new ProjectRewardOptDTO();
            rewOpt.setRewOptName(rewOptName[i]);
            rewOpt.setRewOptVal(RewOptVal[i]);
            rewOpt.setRewOptLimit(RewOptLimit[i]);
            rewOpt.setRewAmount(RewAmount[i]);

            projectRewardOpts.add(rewOpt);
        }
        project.getReward().setRewardOpt(projectRewardOpts);

        System.out.println("project에 리워드 옵션 넣기 : " + project.getReward().getRewardOpt());

        projectService.insertProject(files, project, memId);

        System.out.println("Uploaded files: " + files);
        System.out.println("DB 저장 후 ProjectDTO: " + project);



        return "contents/project/projectRegistAfter";
    }

    @GetMapping("/projectImage")
    public String imageInsert() {
        return "contents/project/projectImage";
    }

    @PostMapping("projectImage")
    public String projectImage(@RequestParam MultipartFile file1
            /*@RequestParam MultipartFile file2*/) {

        projectService.insertImage(file1);

        return "contents/project/projectRegistAfter";
    }

    /* 진행 종료 프로젝트 조회 */
    @GetMapping("/endprolist")
    public String selectEndProList(Authentication authentication, Model model) {
        String id = authentication.getName();

        List<ProjectDTO> selectEndProjectList = projectService.selectEndProjectList(id);

        model.addAttribute("endProjectList", selectEndProjectList);

        return "contents/project/creatorendpj";
    }

    /* 발송 예정일 입력 */
    @ResponseBody
    @PostMapping("/updateShipment")
    public String updateShipment(@RequestParam("proCode") int proCode, @RequestParam("estDate") String estDate) {
        ProjectDTO estDateDto = new ProjectDTO();
        estDateDto.setProCode(proCode);
        estDateDto.setEstDate(Date.valueOf(estDate));

        int result = projectService.updateShipment(estDateDto);

        if (result > 0) {
            System.out.println(":)");
        } else {
            System.out.println(":(");
        }

        return "redirect:/creatorendpj";
    }

    /* 프로젝트에 대한 서포터 후원 참여 내역 목록*/
    @GetMapping("/supportlist/{proCode}")
    public String selectSupportList(@PathVariable("proCode") int proCode, Model model) {
        System.out.println("진행 종료 프로젝트 후원 내역 조회");
        System.out.println("프로젝트 번호 확인 " + proCode);

        List<ProjectDTO> supportList = projectService.selectSupportList(proCode);

        System.out.println("으아아아아아 ::::: " + supportList.toString());

        model.addAttribute("supportList", supportList);

        return "contents/project/creatorsupportlist";
    }

    /* 후원 정산 내역 조회 */
    @RequestMapping("/calculationlist")
    public String selectCalculationList(Authentication authentication, Model model) {
        String id = authentication.getName();

        List<ProjectDTO> calculationList = projectService.selectCalculationList(id);

        model.addAttribute("calculationList", calculationList);

        return "contents/project/calculationlist";
    }

//    @ResponseBody
    @PostMapping("/insertCalculationList")
    public String insertCalculationList(@RequestParam("proCode") String proCode) {

        int result = projectService.insertCalculationList(proCode);

        if(result > 0) {
            System.out.println("승인 신청 완료");
        }else {
            System.out.println("승인 신청 실패");
        }

        return "redirect:/calculationlist";
    }

}
