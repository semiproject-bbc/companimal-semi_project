package com.companimal.semiProject.evaluation.model.service;

import com.companimal.semiProject.evaluation.model.dao.EvaluationMapper;
import com.companimal.semiProject.evaluation.model.dto.*;
import com.companimal.semiProject.project.model.dto.CreatorInfoDTO;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
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
            , String creatorId
    ) throws IOException {

        Map<String, String> producPlan = saveFile(creatorProductPlan);
        Map<String, String> producPortfolio = saveFile(creatorProductPortfolio);
        Map<String, String> img = saveFile(creatorImg);

        creatorInfoDTO.setMemId(creatorId);
        creatorInfoDTO.setCreImgName(img.get("savedFileName"));
        creatorInfoDTO.setCreImgPath(img.get("filePath"));
        creatorInfoDTO.setCreImgOriName(img.get("originFileName"));

        if (evaluationMapper.insertCreatorInfo(creatorInfoDTO)) {
            System.out.println("크리에이터 정보 등록 성공");
        } else {
            System.out.println("크리에이터 정보 등록 실패");
        }

        // 심사 테이블 등록
        EvaluationDTO evaluationDTO = new EvaluationDTO();
        evaluationDTO.setEvaDateTime(new Timestamp(System.currentTimeMillis()));
        evaluationDTO.setEvaSituation("처리중");
        evaluationMapper.insertEvaluation(evaluationDTO);

        // 크리에이터 심사 테이블 등록
        CreatorEvaDTO creatorEvaDTO = new CreatorEvaDTO(creatorId, evaluationDTO.getEvaNum());
        evaluationMapper.insertCreatorEva(creatorEvaDTO);

        int fileNo = 1;
        InsertCreatorFile(fileNo, creatorId ,producPlan);
        fileNo++;
        InsertCreatorFile(fileNo, creatorId ,producPortfolio);
        fileNo++;
        InsertCreatorFile(fileNo, creatorId ,img);

    }

    @Override
    public List<CreatorEvaluationDTO> selectCreatorEvaluationList() {
        return evaluationMapper.selectCreatorEvaluationList();
    }

    @Override
    public String selectCreatorId(int evaNum) {
        return evaluationMapper.selectCreatorId(evaNum);
    }

    @Override
    public CreatorEvaluationDetailDTO selectCreatorEvaluationDetail(int evaNum) {
        return evaluationMapper.selectCreatorEvaluationDetail(evaNum);
    }

    @Override
    @Transactional
    public void updateCreatorRole(String memId, String memberRole) {

        evaluationMapper.updateCreatorRole(memId, memberRole);
        System.out.println("크리에이터 권한 업데이트 성공");

        evaluationMapper.deleteCreatorEvaluation(memId);
        System.out.println("크리에이터 심사 삭제");

    }

    @Override
    @Transactional
    public void deleteCreatorEvaluation(int evaNum, String reaRejection, String memId) {

//        System.out.println("서비스 진입");

        evaluationMapper.deleteCreatorEvaluation(memId);
//        System.out.println("크리에이터 심사 삭제");

        evaluationMapper.deleteCreatorFile(memId);
//        System.out.println("크리에이터 파일 삭제");

        evaluationMapper.deleteCreatorInfo(memId);
//        System.out.println("크리에이터 정보 삭제");

        Map<String, Object> map = new HashMap<>();
        map.put("evaNum", evaNum);
        map.put("reaRejection", reaRejection);
        map.put("evaSituation", "반려");
        evaluationMapper.updateEvaluation(map);
//        System.out.println("심사 정보 업데이트");
    }

    public Map<String, String> saveFile(MultipartFile creatorFile) throws IOException {
        Map<String, String> fileInfo = new HashMap<>();

        Resource resource = resourceLoader.getResource("classpath:static/img/creatorFile");
        String filePath = null;

        if (!resource.exists()) {
            String root = "src/main/static/img/creatorFile";
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

    @Transactional
    public void InsertCreatorFile(int fileNo, String creatorId, Map<String, String> creatorFile) {
        CreatorFileDTO creatorFileDTO = new CreatorFileDTO();

        creatorFileDTO.setCreEvaNum(fileNo);
        creatorFileDTO.setMemId(creatorId);
        creatorFileDTO.setCreFilePath(creatorFile.get("filePath"));
        creatorFileDTO.setCreFileName(creatorFile.get("savedFileName"));
        creatorFileDTO.setCreFileOriName(creatorFile.get("originFileName"));

        if (evaluationMapper.InsertCreatorFile(creatorFileDTO)) {
            System.out.println("크리에이터 파일 등록 성공");
        } else {
            System.out.println("크리에이터 파일 등록 실패");

        }

    }


}
