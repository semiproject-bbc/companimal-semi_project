package com.companimal.semiProject.project.model.service;

import com.companimal.semiProject.project.model.dto.ProjectDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProjectService {
    ProjectDTO selectProject();

    @Transactional
    void insertProject(MultipartFile file, ProjectDTO project) throws IOException;

    ProjectDTO selectProjectDetail();

    List<ProjectDTO> selectEndProjectList();

    ProjectDTO selectSupportList(int id);

    int updateShipment(ProjectDTO estDateDto);

    void insertImage(MultipartFile file);

//    List<ProjectDTO> selectCalculationList();
}
