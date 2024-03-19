package com.companimal.semiProject.evaluation.model.dao;

import com.companimal.semiProject.evaluation.model.dto.*;
import com.companimal.semiProject.project.model.dto.CreatorInfoDTO;
import com.companimal.semiProject.project.model.dto.ProjectDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EvaluationMapper {

    boolean insertCreatorInfo(CreatorInfoDTO creatorInfoDTO);

    boolean InsertCreatorFile(CreatorFileDTO creatorFileDTO);

    void insertEvaluation();

    List<CalculationListDTO> selectEvaCalculationList();

    int updateCalAppDate(int proCode);

    boolean insertEvaluation(EvaluationDTO evaluationDTO);

    boolean InsertCreatorBusiness(CreatorBusinessDTO creatorBusinessDTO);

    boolean insertCreatorEva(CreatorEvaDTO creatorEvaDTO);

    List<CreatorEvaluationDTO> selectCreatorEvaluationList();

    CreatorEvaluationDetailDTO selectCreatorEvaluationDetail(int evaNum);

    String selectCreatorId(int evaNum);

    void updateCreatorRole(String memId, String memberRole);

    void deleteCreatorEvaluation(String memId);

    void deleteCreatorFile(String memId);

    void deleteCreatorInfo(String memId);

    void updateEvaluation(Map<String, Object> map);

    int selectCreatorFile(String memId);

    void deleteCreatorBusinessEvaluation(String memId);

    List<EvaluationDTO> selectAllProjectEvaluation();

    ProjectDTO selectProjectEvaDetail(int evaNum);

    int updateProjectAccept(int evaNumInt);

    int updateProjectReject(Map<String, Object> map);
}
