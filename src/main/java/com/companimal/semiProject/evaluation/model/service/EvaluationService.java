package com.companimal.semiProject.evaluation.model.service;

import com.companimal.semiProject.evaluation.model.dto.CalculationListDTO;
import com.companimal.semiProject.evaluation.model.dto.ProjectEvaluationDTO;
import com.companimal.semiProject.project.model.dto.CreatorInfoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface EvaluationService {
    List<CalculationListDTO> selectEvaCalculationList();

    @Transactional
    int updateCalAppDate(int proCode);

    List<ProjectEvaluationDTO> selectAllProjectEva();
}
