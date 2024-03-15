package com.companimal.semiProject.evaluation.model.service;

import com.companimal.semiProject.evaluation.model.dto.CreatorEvaluationDTO;
import com.companimal.semiProject.evaluation.model.dto.CreatorEvaluationDetailDTO;
import com.companimal.semiProject.project.model.dto.CreatorInfoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface CreatorEvaluationService {

    void insertCreatorInfo(MultipartFile creatorProductPlan, MultipartFile creatorProductPortfolio, MultipartFile creatorImg, CreatorInfoDTO creatorInfoDTO, String creatorId) throws IOException;

    List<CreatorEvaluationDTO> selectCreatorEvaluationList();

    CreatorEvaluationDetailDTO selectCreatorEvaluationDetail(int evaNum);

    String selectCreatorId(int evaNum);

    void creatorAccept(String memberRole);
}
