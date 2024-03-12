package com.companimal.semiProject.project.model.dao;

import com.companimal.semiProject.project.model.dto.ProjectDTO;
import com.companimal.semiProject.project.model.dto.ProjectFileDTO;
import com.companimal.semiProject.project.model.dto.ProjectRewardDTO;
import com.companimal.semiProject.project.model.dto.ProjectRewardOptDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {
    List<ProjectDTO> selectProject();

    int insertProject(ProjectDTO project);

    List<ProjectDTO> selectProjectDetail();


    int insertProjectReward(List<ProjectRewardDTO> reward);

    int insertProjectRewardOpt(List<ProjectRewardOptDTO> rewardOpt);

    int insertProjectFile(ProjectFileDTO projectFile);

    int insertProjectImage(ProjectFileDTO projectImage);
  
    List<ProjectDTO> selectEndProjectList();

    ProjectDTO selectSupportList(int id);

    int updateShipment(ProjectDTO estDateDto);

//    List<ProjectDTO> selectCalculationList();


}
