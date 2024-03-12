package com.companimal.semiProject.project.model.service;

import com.companimal.semiProject.project.model.dao.ProjectMapper;
import com.companimal.semiProject.project.model.dto.ProjectDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Override
    public List<ProjectDTO> selectProject() {
        return projectMapper.selectProject();
    }

    @Override
    @Transactional
    public void insertProject(ProjectDTO project) {

        int result = projectMapper.insertProject(project);

        if(!(result > 0)) {
            System.out.println("프로젝트 등록 실패!");
        }

    }

    @Override
    public List<ProjectDTO> selectProjectDetail() {
        return projectMapper.selectProjectDetail();
    }

    @Override
    public List<ProjectDTO> selectEndProjectList() {
        return projectMapper.selectEndProjectList();
    }

    @Override
    public ProjectDTO selectSupportList(int id) {
        return projectMapper.selectSupportList(id);
    }

    @Override
    public int updateShipment(ProjectDTO estDateDto) {
        int result = projectMapper.updateShipment(estDateDto);

        return result;
    }


    //    @Override
//    public List<ProjectDTO> selectCalculationList() {
//        return projectMapper.selectCalculationList();
//    }


}
