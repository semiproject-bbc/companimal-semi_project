package com.companimal.semiProject.evaluation.model.service;

import com.companimal.semiProject.project.model.dto.CreatorInfoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface CreatorEvaluationService {

    void insertCreatorInfo(MultipartFile creatorProductPlan, MultipartFile creatorProductPortfolio, MultipartFile creatorImg, CreatorInfoDTO creatorInfoDTO, String creatorId) throws IOException;
}
