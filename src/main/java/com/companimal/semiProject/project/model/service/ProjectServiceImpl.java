package com.companimal.semiProject.project.model.service;

import com.companimal.semiProject.project.model.dao.ProjectMapper;
import com.companimal.semiProject.project.model.dto.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public void insertProject(List<MultipartFile> files, ProjectDTO project, String memId) {

        System.out.println("Service에서 project 찍어보기 : " + project);

        Map<String, List<ProjectFileDTO>> fileMap = null;

        try {
            fileMap = FileUpload(files);
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        /* 파일 셋팅 */
//        for (Map.Entry<String, List<ProjectFileDTO>> entry : fileMap.entrySet()) {
//            List<ProjectFileDTO> fileList = entry.getValue();
//            for (int i = 0; i < fileList.size(); i++) {
//
//                ProjectFileDTO projectFile = entry.getValue().get(i);
//
//                projectFile.setProFileNum(i);
//                projectFile.setProCode(project.getProCode());
//
//                projectMapper.insertProjectFile(projectFile);
//            }
//        }
        for (Map.Entry<String, List<ProjectFileDTO>> entry : fileMap.entrySet()) {

            List<ProjectFileDTO> projectFileList = fileMap.get("proFile");
            for (int i = 0; i < projectFileList.size(); i++) {

                ProjectFileDTO projectFile = entry.getValue().get(i);

                projectFile.setProFileNum(i);
                projectFile.setProCode(project.getProCode());

                projectMapper.insertProjectFile(projectFile);
            }

            List<ProjectFileDTO> projectImageList = fileMap.get("proImg");
            for (int i = 0; i < projectImageList.size(); i++) {

                ProjectFileDTO projectImage = entry.getValue().get(i);

                projectImage.setProFileNum(i);
                projectImage.setProCode(project.getProCode());

                projectMapper.insertProjectImage(projectImage);
            }

        }

        if (result1 > 0 && result2 > 0) {
            System.out.println("프로젝트 등록 성공!");
        } else {
            System.out.println("프로젝트 등록 실패~!");
        }
    }

    public Map<String, List<ProjectFileDTO>> FileUpload(List<MultipartFile> files) throws IOException {

        /* 파일 저장 경로 지정 */
        Resource resource = resourceLoader.getResource("classpath:static/image/store");
        // proFilePath : 파일 저장경로
        String proFilePath = null;

        Map<String, List<ProjectFileDTO>> returnMap = new HashMap<>();

        if (!resource.exists()) {
            String root = "src/main/resources/static/image/store";
            File file = new File(root);
            file.mkdir();

            proFilePath = file.getAbsolutePath();

        } else {
            proFilePath = resource.getFile().getAbsolutePath();
        }

        List<ProjectFileDTO> projectFileList = new ArrayList<>();
        List<ProjectFileDTO> projectImgList = new ArrayList<>();

        for (MultipartFile mf : files) {

            System.out.println(mf);

            /* 파일명 변경 처리 */
            // proFileOriName : 원본 파일명
            String proFileOriName = mf.getOriginalFilename();
//            String ext = proFileOriName.substring(proFileOriName.lastIndexOf("."));

            String ext = "";

            if (proFileOriName != null) {
                int lastIndex = proFileOriName.lastIndexOf(".");
                if (lastIndex != -1 && lastIndex < proFileOriName.length() - 1) {
                    ext = proFileOriName.substring(lastIndex);
                }
            }
            // proFileName : 파일 저장명
            String proFileName = UUID.randomUUID().toString().replace("-", "") + ext;

            try {
                /* 파일 저장 */
                mf.transferTo(new File(proFilePath + "/" + proFileName));

                if (mf.getName().substring(0, 6).equals("proImg")) {
                    projectImgList.add(new ProjectFileDTO(projectImgList.size() + 1, 0, proFilePath, proFileName, proFileOriName));
                } else {
                    projectFileList.add(new ProjectFileDTO(projectFileList.size() + 1, 0, proFilePath, proFileName, proFileOriName));
                }

            } catch (Exception e) {
                for (ProjectFileDTO file : projectImgList) {
                    new File(proFilePath + "/" + file.getProFileName()).delete();
                }
                for (ProjectFileDTO file : projectFileList) {
                    new File(proFilePath + "/" + file.getProFileName()).delete();
                }
            }

            returnMap.put("proImg", projectImgList);
            returnMap.put("proFile", projectFileList);

        }
        return returnMap;
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
}
