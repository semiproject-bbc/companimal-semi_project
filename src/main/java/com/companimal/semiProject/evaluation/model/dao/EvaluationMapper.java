package com.companimal.semiProject.evaluation.model.dao;

import com.companimal.semiProject.evaluation.model.dto.*;
import com.companimal.semiProject.project.model.dto.CreatorInfoDTO;
import com.companimal.semiProject.project.model.dto.ProjectDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EvaluationMapper {

    boolean selectCreatorInfo(String creatorId);

    boolean insertCreatorInfo(CreatorInfoDTO creatorInfoDTO);

    boolean updateCreatorInfo(CreatorInfoDTO creatorInfoDTO);

    boolean InsertCreatorFile(CreatorFileDTO creatorFileDTO);

    void insertEvaluation();

    List<CalculationListDTO> selectEvaCalculationList();

    int updateCalAppDate(int proCode);

    boolean insertEvaluation(EvaluationDTO evaluationDTO);

    boolean InsertCreatorBusiness(CreatorBusinessDTO creatorBusinessDTO);

    boolean insertCreatorEva(CreatorEvaDTO creatorEvaDTO);

    List<CreatorEvaluationDTO> selectCreatorEvaluationList(int offset, int limit);

    CreatorEvaluationDetailDTO selectCreatorEvaluationDetail(int evaNum);

    String selectCreatorId(int evaNum);

    void updateCreatorRole(String memId, String memberRole);

    void deleteCreatorFile(String memId);

    void deleteCreatorInfo(String memId);

    void updateEvaluation(Map<String, Object> map);

    int selectCreatorFile(String memId);

    void deleteCreatorBusinessEvaluation(String memId);

    List<ProjectEvaluationDTO> selectAllProjectEva();

    void updateEvaSituation(Map<String, Object> map);

    int countTotalItems();

    List<EvaluationDTO> selectAllProjectEvaluation();

    void updateProjectReject(Map<String, Object> map);

    int updateProjectAccept(int evaNumInt);

    List<ProjectDTO> selectProjectEvaDetail(int evaNum);
}
