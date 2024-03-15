package com.companimal.semiProject.evaluation.model.service;

import com.companimal.semiProject.evaluation.model.dao.EvaluationMapper;
import com.companimal.semiProject.evaluation.model.dto.CalculationListDTO;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {
    private final EvaluationMapper evaluationMapper;
    private final ResourceLoader resourceLoader;

    public EvaluationServiceImpl(EvaluationMapper evaluationMapper, ResourceLoader resourceLoader) {
        this.evaluationMapper = evaluationMapper;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public List<CalculationListDTO> selectEvaCalculationList() {
        return evaluationMapper.selectEvaCalculationList();
    }

    @Override
    public int updateCalAppDate(int proCode) {
        int result = evaluationMapper.updateCalAppDate(proCode);

        return result;
    }
}
