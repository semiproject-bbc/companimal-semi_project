package com.companimal.semiProject.project.model.dao;

import com.companimal.semiProject.project.model.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface ProjectMapper {

    List<ProjectDTO> selectAllProject();

    ProjectDTO selectProject();

    int insertProject(ProjectDTO project);

    ProjectDTO selectProjectDetail(int proCode);

    int insertProjectReward(List<ProjectRewardDTO> reward);

    int insertProjectRewardOpt(List<ProjectRewardOptDTO> rewardOpt);

    int insertProjectFile(ProjectFileDTO projectFile);

    int insertProjectImage(ProjectFileDTO projectImage);

    void selectProjectCate(List<ProjectCateDTO> cate);

    List<ProjectDTO> selectEndProjectList(String id);

    int updateShipment(ProjectDTO estDateDto);

    List<ProjectDTO> selectSupportList(int proCode);

    int insertFile(ProjectFileDTO projectFile);

    int insertImage(ProjectImageDTO projectImage);

    List<ProjectDTO> selectCalculationList(String id);
}
