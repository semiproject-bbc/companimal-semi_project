package com.companimal.semiProject.evaluation.model.service;

import com.companimal.semiProject.evaluation.model.dao.EvaluationMapper;
import com.companimal.semiProject.evaluation.model.dto.CreatorFileDTO;
import com.companimal.semiProject.project.model.dto.CreatorInfoDTO;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class CreatorEvaluationServiceimpl implements CreatorEvaluationService {

    private final EvaluationMapper evaluationMapper;
    private final ResourceLoader resourceLoader;

    public CreatorEvaluationServiceimpl(EvaluationMapper evaluationMapper, ResourceLoader resourceLoader) {
        this.evaluationMapper = evaluationMapper;
        this.resourceLoader = resourceLoader;
    }
    @Override
    @Transactional
    public void insertCreatorInfo(MultipartFile creatorProductPlan
            , MultipartFile creatorProductPortfolio
            , MultipartFile creatorImg
            , CreatorInfoDTO creatorInfoDTO
            ) throws IOException {

        Map<String, String> producPlan = saveFile(creatorProductPlan);
        Map<String, String> producPortfolio = saveFile(creatorProductPortfolio);
        Map<String, String> img = saveFile(creatorImg);

        creatorInfoDTO.setCreImgName(img.get("savedFileName"));
        creatorInfoDTO.setCreImgPath(img.get("filePath"));
        creatorInfoDTO.setCreImgOriName(img.get("originFileName"));

        int result = evaluationMapper.insertCreatorInfo(creatorInfoDTO);

    }

    public Map<String, String> saveFile(MultipartFile creatorFile) throws IOException {
        Map<String, String> fileInfo = new HashMap<>();

        Resource resource = resourceLoader.getResource("classpath:static/img/creatorFile");
        String filePath = null;

        if (!resource.exists()) {
            String root = "src/main/resources/static/img/creatorFile";
            File file = new File(root);
            file.mkdirs();

            filePath = file.getAbsolutePath();

        } else {
            filePath = resource.getFile().getAbsolutePath();
        }

        String originFileName = creatorFile.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String savedFileName = UUID.randomUUID().toString().replace("-", "") + ext;

        try {
            creatorFile.transferTo(new File(filePath + "/" + savedFileName));
        } catch (Exception e) {
            System.out.println("등록 실패");
        }

        fileInfo.put("filePath", filePath);
        fileInfo.put("savedFileName", savedFileName);
        fileInfo.put("originFileName", originFileName);

        return fileInfo;
    }

}
