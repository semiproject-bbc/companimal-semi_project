package com.companimal.semiProject.evaluation.model.dao;

import com.companimal.semiProject.evaluation.model.dto.*;
import com.companimal.semiProject.project.model.dto.CreatorInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EvaluationMapper {

    boolean insertCreatorInfo(CreatorInfoDTO creatorInfoDTO);

    boolean InsertCreatorFile(CreatorFileDTO creatorFileDTO);

    boolean insertEvaluation(EvaluationDTO evaluationDTO);

    boolean insertCreatorEva(CreatorEvaDTO creatorEvaDTO);

    List<CreatorEvaluationDTO> selectCreatorEvaluationList();
    //    List<CalculationListDTO> selectEvaCalculationList();
}
