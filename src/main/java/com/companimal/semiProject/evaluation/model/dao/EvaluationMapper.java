package com.companimal.semiProject.evaluation.model.dao;

import com.companimal.semiProject.evaluation.model.dto.CalculationListDTO;
import com.companimal.semiProject.evaluation.model.dto.CreatorFileDTO;
import com.companimal.semiProject.project.model.dto.CreatorInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EvaluationMapper {
    int insertCreatorInfo(CreatorInfoDTO creatorInfoDTO);
    //    List<CalculationListDTO> selectEvaCalculationList();
}
