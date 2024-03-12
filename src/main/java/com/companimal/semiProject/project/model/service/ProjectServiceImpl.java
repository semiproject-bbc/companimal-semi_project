package com.companimal.semiProject.project.model.service;

import com.companimal.semiProject.project.model.dao.ProjectMapper;
import com.companimal.semiProject.project.model.dto.ProjectDTO;
import com.companimal.semiProject.project.model.dto.ProjectFileDTO;
import com.companimal.semiProject.project.model.dto.ProjectRewardDTO;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectMapper projectMapper;
    private final ResourceLoader resourceLoader;

    public ProjectServiceImpl(ProjectMapper projectMapper, ResourceLoader resourceLoader) {
        this.projectMapper = projectMapper;
        this.resourceLoader = resourceLoader;
    }

    /* 하드코딩 (지울예정) */
    @Override
    public List<ProjectDTO> selectProject() {
        return projectMapper.selectProject();
    }

    @Override
    @Transactional
    public void insertProject(MultipartFile file, ProjectDTO project) {

        ProjectFileDTO projectFile = null;
        ProjectFileDTO projectImage = null;
        try {
            projectFile = FileUpload(file);
            projectImage = FileUpload(file);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int result1 = projectMapper.insertProject(project);

//        code -> setting
        ProjectDTO projectDTO = new ProjectDTO();
        ProjectRewardDTO projectRewardDTO = new ProjectRewardDTO();
        ProjectFileDTO projectFileDTO = new ProjectFileDTO();

        projectRewardDTO.setProCode(projectDTO.getProCode());
        projectFileDTO.setProCode(projectDTO.getProCode());

        int result2 = projectMapper.insertProjectReward(project.getReward());
        int result3 = projectMapper.insertProjectRewardOpt(project.getRewardOpt());
        int result4 = projectMapper.insertProjectFile(projectFile);
        int result5 = projectMapper.insertProjectImage(projectImage);

//        projectMapper.insertProjectFile(projectFile);

        if(!(result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0 && result5 > 0)) {
            System.out.println("프로젝트 등록 성공!");
        } else {
            System.out.println("프로젝트 등록 실패~!");
        }
    }

    public ProjectFileDTO FileUpload(MultipartFile files) throws IOException {

        Resource resource = resourceLoader.getResource("classpath:static/image/store");
        String proFilePath = null;

        if(!resource.exists()) {
            String root = "src/main/resources/static/image/store";
            File file = new File(root);
            file.mkdir();

            proFilePath = file.getAbsolutePath();
        } else {
            proFilePath = resource.getFile().getAbsolutePath();
        }

        List<ProjectFileDTO> projectFiles = new ArrayList<>();

        String proFileOriName = files.getOriginalFilename();
        String ext = proFileOriName.substring(proFileOriName.lastIndexOf("."));
        String proFileName = UUID.randomUUID().toString().replace("-", "") + ext;

        try {
            projectFiles.add(new ProjectFileDTO(0, 0, proFilePath, proFileName, proFileOriName));
            /* 파일 저장 */
            files.transferTo(new File(proFilePath + "/" + proFileName));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return (ProjectFileDTO) projectFiles;
    }


    @Override
    public List<ProjectDTO> selectProjectDetail() {
        return projectMapper.selectProjectDetail();
    }
}
