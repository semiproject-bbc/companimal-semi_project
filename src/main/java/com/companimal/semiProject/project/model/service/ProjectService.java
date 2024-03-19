package com.companimal.semiProject.project.model.service;

import com.companimal.semiProject.project.model.dto.ProjectDTO;
import com.google.gson.JsonObject;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

public interface ProjectService {

    List<ProjectDTO> selectAllProject();

    ProjectDTO selectProject();

    @Transactional
    void insertProject(List<MultipartFile> images, ProjectDTO project, MultipartFile file, Model model) throws IOException;

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

    @Transactional
    JsonObject SummerNoteImageFile(MultipartFile file);
}
