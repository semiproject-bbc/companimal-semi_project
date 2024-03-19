package com.companimal.semiProject.evaluation.model.service;

import com.companimal.semiProject.evaluation.model.dto.CalculationListDTO;
import com.companimal.semiProject.evaluation.model.dto.EvaluationDTO;
import com.companimal.semiProject.evaluation.model.dto.ProjectEvaluationDTO;
import com.companimal.semiProject.project.model.dto.CreatorInfoDTO;
import com.companimal.semiProject.project.model.dto.ProjectDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public interface EvaluationService {
    List<CalculationListDTO> selectEvaCalculationList();

    @Transactional
    int updateCalAppDate(int proCode);

    List<EvaluationDTO> selectAllProjectEva();

    ProjectDTO selectProjectEvaDetail(int evaNum);

    @Transactional
    int updateProjectAccept(int evaNumInt);
    @Transactional
    Map<String, Object> updateProjectReject(int evaNumInt, String reaRejection);
}
