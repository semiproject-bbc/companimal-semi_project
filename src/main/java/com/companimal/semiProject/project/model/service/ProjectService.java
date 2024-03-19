package com.companimal.semiProject.project.model.service;

import com.companimal.semiProject.project.model.dto.ProjectDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProjectService {

    List<ProjectDTO> selectAllProject();

    ProjectDTO selectProject();

    @Transactional
    void insertProject(List<MultipartFile> files, ProjectDTO project, String memId);

//    @Transactional
//    void insertProject(MultipartFile file, ProjectDTO project) throws IOException;

    ProjectDTO selectProjectDetail(int proCode);

    List<ProjectDTO> selectEndProjectList(String id);

    List<ProjectDTO> selectSupportList(int proCode);

    @Transactional
    int updateShipment(ProjectDTO estDateDto);

    void insertImage(MultipartFile file);

    List<ProjectDTO> selectCalculationList(String id);

    @Transactional
    int insertCalculationList(String proCode);

    List<ProjectDTO> selectMenuProject();

    ProjectDTO selectFinalCal(int proCode);
}
