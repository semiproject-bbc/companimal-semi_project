package com.companimal.semiProject.project.model.dao;

import com.companimal.semiProject.project.model.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {
    ProjectDTO selectProject();

    int insertProject(ProjectDTO project);

    ProjectDTO selectProjectDetail();

    int insertProjectReward(List<ProjectRewardDTO> reward);

    int insertProjectRewardOpt(List<ProjectRewardOptDTO> rewardOpt);

    int insertProjectFile(ProjectFileDTO projectFile);

    int insertProjectImage(ProjectFileDTO projectImage);

    void selectProjectCate(List<ProjectCateDTO> cate);

    List<ProjectDTO> selectEndProjectList();

    ProjectDTO selectSupportList(int id);

    int updateShipment(ProjectDTO estDateDto);

    int insertFile(ProjectFileDTO projectFile);

    int insertImage(ProjectImageDTO projectImage);


//    List<ProjectDTO> selectCalculationList();


}
