package com.companimal.semiProject.project.model.service;

import com.companimal.semiProject.project.model.dto.ProjectDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> selectProject();

    @Transactional
    void insertProject(ProjectDTO project);

    List<ProjectDTO> selectProjectDetail();

    List<ProjectDTO> selectEndProjectList();

    ProjectDTO selectSupportList(int id);

    int updateShipment(ProjectDTO estDateDto);

//    List<ProjectDTO> selectCalculationList();
}
