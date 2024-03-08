package com.companimal.semiProject.project.model.dao;

import com.companimal.semiProject.project.model.dto.ProjectDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {
    List<ProjectDTO> selectProject();

    int insertProject(ProjectDTO project);

    List<ProjectDTO> selectProjectDetail();
}
