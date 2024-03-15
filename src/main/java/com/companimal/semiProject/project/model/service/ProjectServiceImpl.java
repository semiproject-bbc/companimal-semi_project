package com.companimal.semiProject.project.model.service;

import com.companimal.semiProject.project.model.dao.ProjectMapper;
import com.companimal.semiProject.project.model.dto.ProjectDTO;
import com.companimal.semiProject.project.model.dto.ProjectFileDTO;
import com.companimal.semiProject.project.model.dto.ProjectImageDTO;
import com.companimal.semiProject.project.model.dto.ProjectRewardDTO;
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
    public void insertProject(List<MultipartFile> files, ProjectDTO project) {
        Map<String, List<ProjectFileDTO>> fileMap = null;

        try {
            fileMap = FileUpload(files);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int result1 = projectMapper.insertProject(project);

        ProjectRewardDTO projectRewardDTO = new ProjectRewardDTO();
        ProjectFileDTO projectFileDTO = new ProjectFileDTO();

        projectRewardDTO.setProCode(project.getProCode());
        projectFileDTO.setProCode(project.getProCode());

        int result2 = projectMapper.insertProjectReward(project.getReward());
        int result3 = projectMapper.insertProjectRewardOpt(project.getRewardOpt());

        for (Map.Entry<String, List<ProjectFileDTO>> entry : fileMap.entrySet()) {
            List<ProjectFileDTO> fileList = entry.getValue();
            for (ProjectFileDTO file : fileList) {
                int result4 = projectMapper.insertProjectFile(file);
                if (result4 <= 0) {
                    // 파일 저장 실패 시 처리
                }
            }
        }

        if (result1 > 0 && result2 > 0 && result3 > 0) {
            System.out.println("프로젝트 등록 성공!");
        } else {
            System.out.println("프로젝트 등록 실패~!");
        }
    }


//    @Override
//    @Transactional
//    public void insertProject(MultipartFile file, ProjectDTO project) {
//
//        ProjectFileDTO projectFile = null;
//        ProjectFileDTO projectImage = null;
//        try {
//            projectFile = FileUpload(file);
//            projectImage = FileUpload(file);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        int result1 = projectMapper.insertProject(project);
//
//        ProjectRewardDTO projectRewardDTO = new ProjectRewardDTO();
//        ProjectFileDTO projectFileDTO = new ProjectFileDTO();
//
////        projectDTO.getRewardOpt().get(1).getRewAmount(); => 펀딩 상세페이지 조회할 때 가져올 타임리프 정보
//
//        projectRewardDTO.setProCode(project.getProCode());
//        projectFileDTO.setProCode(project.getProCode());
//
//        int result2 = projectMapper.insertProjectReward(project.getReward());
//        int result3 = projectMapper.insertProjectRewardOpt(project.getRewardOpt());
//        int result4 = projectMapper.insertProjectFile(projectFile);
//        int result5 = projectMapper.insertProjectImage(projectImage);
//
////        projectMapper.insertProjectFile(projectFile);
//
//        if(result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0 && result5 > 0) {
//            System.out.println("프로젝트 등록 성공!");
//        } else {
//            System.out.println("프로젝트 등록 실패~!");
//        }
//    }

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

        if(result1 > 0) {
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

    public ProjectFileDTO FileUpload1(MultipartFile file) throws IOException {

        Resource resource = resourceLoader.getResource("classpath:static/image/store");
        String proFilePath = null;

        ProjectFileDTO projectFile = null;

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

            projectFile = new ProjectFileDTO(0, 1, proFilePath, proFileName, proFileOriName);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return projectFile;
    }


    public Map<String, List<ProjectFileDTO>> FileUpload(List<MultipartFile> files) throws IOException {

        Resource resource = resourceLoader.getResource("classpath:static/image/store");
        String proFilePath = null;

        Map<String, List<ProjectFileDTO>> returnMap = new HashMap<>();

        for (MultipartFile mf : files) {

            System.out.println(mf);

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

            // proFilePath : 파일 저장경로
            // proFileOriName : 원본 파일명
            // proFileName : 파일 저장명

            String proFileOriName = mf.getOriginalFilename();
            String ext = proFileOriName.substring(proFileOriName.lastIndexOf("."));
            String proFileName = UUID.randomUUID().toString().replace("-", "") + ext;


            try {
                /* 파일 저장 */
                mf.transferTo(new File(proFilePath + "/" + proFileName));

                if (mf.getName().substring(0, 3).equals("img")) {
                    projectImgList.add(new ProjectFileDTO(projectImgList.size() + 1, 0, proFilePath, proFileName, proFileOriName));
                } else {
                    projectFileList.add(new ProjectFileDTO(projectFileList.size() + 1, 0, proFilePath, proFileName, proFileOriName));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            returnMap.put("img", projectImgList);
            returnMap.put("file", projectFileList);

        }
        return returnMap;
    }

//    public ProjectFileDTO FileUpload(MultipartFile files) throws IOException {
//
//        Resource resource = resourceLoader.getResource("classpath:static/image/store");
//        String proFilePath = null;
//
//        if(!resource.exists()) {
//            String root = "src/main/resources/static/image/store";
//            File file = new File(root);
//            file.mkdir();
//
//            proFilePath = file.getAbsolutePath();
//        } else {
//            proFilePath = resource.getFile().getAbsolutePath();
//        }
//
//        List<ProjectFileDTO> projectFiles = new ArrayList<>();
//
//        String proFileOriName = files.getOriginalFilename();
//        String ext = proFileOriName.substring(proFileOriName.lastIndexOf("."));
//        String proFileName = UUID.randomUUID().toString().replace("-", "") + ext;
//
//        try {
//            projectFiles.add(new ProjectFileDTO(0, 0, proFilePath, proFileName, proFileOriName));
//            /* 파일 저장 */
//            files.transferTo(new File(proFilePath + "/" + proFileName));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return (ProjectFileDTO) projectFiles;
//    }


    @Override
    public ProjectDTO selectProjectDetail(int proCode) {
        return projectMapper.selectProjectDetail(proCode);
    }

    @Override
    public List<ProjectDTO> selectEndProjectList() {
        return projectMapper.selectEndProjectList();
    }

    @Override
    public int updateShipment(ProjectDTO estDateDto) {
        int result = projectMapper.updateShipment(estDateDto);

        return result;
    }

    @Override
    public List<ProjectDTO> selectSupportList(int id) {
        return projectMapper.selectSupportList(id);
    }

    //    @Override
//    public List<ProjectDTO> selectCalculationList() {
//        return projectMapper.selectCalculationList();
//    }


}
