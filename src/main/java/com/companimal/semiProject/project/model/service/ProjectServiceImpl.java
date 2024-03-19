package com.companimal.semiProject.project.model.service;

import com.companimal.semiProject.evaluation.model.dto.EvaluationDTO;
import com.companimal.semiProject.evaluation.model.dto.ProjectEvaluationDTO;
import com.companimal.semiProject.project.model.dao.ProjectMapper;
import com.companimal.semiProject.project.model.dto.*;
import groovy.util.Eval;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectMapper projectMapper;
    private final ResourceLoader resourceLoader;

    public ProjectServiceImpl(ProjectMapper projectMapper, ResourceLoader resourceLoader) {
        this.projectMapper = projectMapper;
        this.resourceLoader = resourceLoader;
    }


    @Override
    public List<ProjectDTO> selectAllProject() {
        List<ProjectDTO> selectAllProjectList = projectMapper.selectAllProject();

        return selectAllProjectList;
    }

    /* 하드코딩 (지울예정) */
    @Override
    public ProjectDTO selectProject() {
        return projectMapper.selectProject();
    }

    @Override
    @Transactional
    public void insertProject(List<MultipartFile> images, ProjectDTO project, MultipartFile file, Model model) throws IOException {

        System.out.println("Service에서 project 찍어보기 : " + project);

        int result1 = projectMapper.insertProject(project);

        System.out.println("proCode : " + project.getProCode());

        /* 리워드 셋팅 */
        project.getReward().setRewCode(project.getProCode() + "-1");
        project.getReward().setRewNum(1);
        project.getReward().setProCode(project.getProCode());

        System.out.println("rewCode : " + project.getReward().getRewCode());
        System.out.println("rewNum : " + project.getReward().getRewNum());
        System.out.println("proCode : " + project.getReward().getProCode());

        int result2 = projectMapper.insertProjectReward(project.getReward());

        List<ProjectRewardOptDTO> rewOpts = project.getReward().getRewardOpt();

        /* 리워드 옵션 셋팅 */
        for (int i = 0; i < rewOpts.size(); i++) {

            ProjectRewardOptDTO projectRewardOpt = rewOpts.get(i);

            projectRewardOpt.setRewOptCode(project.getProCode() + "-1-" + i);
            projectRewardOpt.setRewCode(project.getReward().getRewCode());
            projectRewardOpt.setRewOptNum(i);

            projectMapper.insertProjectRewardOpt(projectRewardOpt);
        }

        System.out.println("=====================리워드========================");
        System.out.println("service 에서 셋팅해준 리워드 : " + project.getReward());

        System.out.println("=====================리워드 옵션들======================");
        System.out.println("service 에서 셋팅해준 리워드옵션들 : " + rewOpts);
        
        /* 파일 저장 */
        /* 이미지(다건) 저장 */
        List<ProjectImagePathDTO> saveImages = new ArrayList<>(); // 이미지 경로들을 받게될 list

        for(int i = 0; i < images.size(); i++) {
            ProjectFileDTO fileDTO = FileUpload(images.get(i));

            if(fileDTO != null) {
                fileDTO.setProCode(project.getProCode());
                fileDTO.setProFileNum(i);

                projectMapper.insertProjectImage(fileDTO);

                System.out.println("static/image/store/" + fileDTO.getProFileName());

                System.out.println("이미지들 저장경로 : " + saveImages);

                ProjectImagePathDTO projectImagePath = new ProjectImagePathDTO();

                projectImagePath.setProImgPath("static/image/store" + fileDTO.getProFileName());

                saveImages.add(projectImagePath);
            }
        }

        model.addAttribute("imgs", saveImages);

        /* 심사서류 파일(단건) 저장 */
        ProjectFileDTO fileDTO = FileUpload(file);

        fileDTO.setProCode(project.getProCode());
        fileDTO.setProFileNum(1);

        projectMapper.insertProjectFile(fileDTO);

        /* 심사 셋팅 */
//        EvaluationDTO evaluation = new EvaluationDTO();
        ProjectEvaluationDTO projectEvaluation = new ProjectEvaluationDTO();

        int result3 = projectMapper.insertProjectEva(projectEvaluation);
        System.out.println(result3 + " : 심사 테이블 insert 성공!");
        System.out.println("projectEvaluation : " + projectEvaluation);
        System.out.println("evaNum : " + projectEvaluation.getEvaNum());

        projectEvaluation.setProCode(project.getProCode());
        projectEvaluation.setEvaNum(projectEvaluation.getEvaNum());

        int result4 = projectMapper.insertProjectEvaDetail(projectEvaluation);
        System.out.println(result3 + "프로젝트 심사 테이블 insert 성공!");

        if (result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0) {
            System.out.println("프로젝트 등록 성공!");
        } else {
            System.out.println("프로젝트 등록 실패~!");
        }
//        return ""
    }

    public ProjectFileDTO FileUpload(MultipartFile savefile) throws IOException {

        /* 파일 저장 경로 지정 */
        Resource resource = resourceLoader.getResource("classpath:static/image/store");
        // proFilePath : 파일 저장경로
        String proFilePath = null;

//        Map<String, List<ProjectFileDTO>> returnMap = new HashMap<>();

        if (!resource.exists()) {
            String root = "src/main/resources/static/image/store";
            File file = new File(root);
            file.mkdir();

            proFilePath = file.getAbsolutePath();

        } else {
            proFilePath = resource.getFile().getAbsolutePath();
        }

        /* 파일명 변경 처리 */
        // proFileOriName : 원본 파일명
        String proFileOriName = savefile.getOriginalFilename();
            String ext = proFileOriName.substring(proFileOriName.lastIndexOf("."));
        System.out.println("원본 파일명 : " + proFileOriName);

//        String ext = "";
//
//        if (proFileOriName != null) {
//            int lastIndex = proFileOriName.lastIndexOf(".");
//            if (lastIndex != -1 && lastIndex < proFileOriName.length() - 1) {
//                ext = proFileOriName.substring(lastIndex);
//            }
//        }
        // proFileName : 파일 저장명
        String proFileName = UUID.randomUUID().toString().replace("-", "") + ext;

        System.out.println("파일 저장명 : " + proFileName);

//        private int proFileNum;         // 파일 번호
//        private int proCode;            // 프로젝트 코드
//        private String proFilePath;     // 파일 저장경로
//        private String proFileName;     // 파일 저장명
//        private String proFileOriName;  // 원본 파일명

        ProjectFileDTO projectFileDTO = new ProjectFileDTO(1, 1, proFilePath, proFileName, proFileOriName);

        try {
            /* 파일 저장 */
            savefile.transferTo(new File(proFilePath + "/" + proFileName));

        } catch (Exception e) {
            projectFileDTO = null;
        }

        return projectFileDTO;
    }



    @Override
    public void insertImage(MultipartFile file) {

        ProjectImageDTO projectFile = null;
//        ProjectFileDTO projectImage = null;

        try {
            projectFile = ImageUpload(file);
//            projectImage = FileUpload(file);

        } catch (IOException e) {
            e.printStackTrace();
        }

        int result1 = projectMapper.insertImage(projectFile);
//        int result2 = projectMapper.insertImage(projectImage);

        if (result1 > 0) {
            System.out.println("이미지 파일 등록 성공~");
        }
    }

    public ProjectImageDTO ImageUpload(MultipartFile file) throws IOException {

        Resource resource = resourceLoader.getResource("classpath:static/image/store");
        String proFilePath = null;

        if (!resource.exists()) {
            String root = "src/main/resources/static/image/store";
            File directory = new File(root);
            directory.mkdirs();

            proFilePath = directory.getAbsolutePath();
        } else {
            proFilePath = resource.getFile().getAbsolutePath();
        }

        // proFilePath : 파일 저장경로
        // proFileOriName : 원본 파일명
        // proFileName : 파일 저장명

        String proFileOriName = file.getOriginalFilename();
        String ext = proFileOriName.substring(proFileOriName.lastIndexOf("."));
        String proFileName = UUID.randomUUID().toString().replace("-", "") + ext;

        try {
            /* 파일 저장 */
            file.transferTo(new File(proFilePath + "/" + proFileName));

            ProjectImageDTO projectFile = new ProjectImageDTO(0, 1, proFilePath, proFileName, proFileOriName);

            return projectFile;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ProjectDTO selectProjectDetail(int proCode) {
        return projectMapper.selectProjectDetail(proCode);
    }

    @Override
    public List<ProjectDTO> selectEndProjectList(String id) {
        return projectMapper.selectEndProjectList(id);
    }

    @Override
    public int updateShipment(ProjectDTO estDateDto) {
        int result = projectMapper.updateShipment(estDateDto);

        return result;
    }

    @Override
    public List<ProjectDTO> selectSupportList(int proCode) {
        return projectMapper.selectSupportList(proCode);
    }

    @Override
    public List<ProjectDTO> selectCalculationList(String id) {
        return projectMapper.selectCalculationList(id);
    }

    @Override
    public int insertCalculationList(String proCode) {
        int result = projectMapper.insertCalculationList(proCode);

        return result;
    }

    @Override
    public ProjectDTO selectFinalCal(int proCode) {
        return projectMapper.selectFinalCal(proCode);
    }

    @Override
    public List<ProjectDTO> selectMenuProject() {
        return projectMapper.selectMenuProject();
    }
}
