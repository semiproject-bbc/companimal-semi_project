package com.companimal.semiProject.evaluation.model.service;

import com.companimal.semiProject.evaluation.model.dao.EvaluationMapper;
import com.companimal.semiProject.evaluation.model.dto.CalculationListDTO;
import com.companimal.semiProject.evaluation.model.dto.EvaluationDTO;
import com.companimal.semiProject.evaluation.model.dto.ProjectEvaluationDTO;
import com.companimal.semiProject.project.model.dto.ProjectDTO;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<EvaluationDTO> selectAllProjectEva() {

        System.out.println("서비스 도착");

        List<EvaluationDTO> selectAllProjectEva = evaluationMapper.selectAllProjectEvaluation();

        return selectAllProjectEva;
    }

    @Override
    public List<ProjectDTO> selectProjectEvaDetail(int evaNum) {
        return evaluationMapper.selectProjectEvaDetail(evaNum);
    }

    @Override
    @Transactional
    public int updateProjectAccept(int evaNumInt) {

        int result = evaluationMapper.updateProjectAccept(evaNumInt);

        return result;
    }

    @Override
    @Transactional
    public Map<String, Object> updateProjectReject(int evaNumInt, String reaRejection) {

        Map<String, Object> map = new HashMap<>();
        map.put("evaNumInt", evaNumInt);
        map.put("reaRejection", reaRejection);
        map.put("evaSituation", "반려");

        evaluationMapper.updateProjectReject(map);

        System.out.println(map);

        return map;
    }
}
