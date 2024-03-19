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
    public boolean selectCreatorInfo(String creatorId) {
        return evaluationMapper.selectCreatorInfo(creatorId);
    }

    @Override
    @Transactional
    public void updateEvaSituation(Map<String, Object> map) {
        evaluationMapper.updateEvaSituation(map);
    }

    @Override
    @Transactional
    public void insertCreatorInfo(MultipartFile creatorProductPlan
            , MultipartFile creatorProductPortfolio
            , MultipartFile creatorImg
            , CreatorInfoDTO creatorInfoDTO
            , String creatorId
    ) throws IOException {

        // 받아온 파일마다 저장경로, 저장명, 원본명을 받아오기 위해 따로 메소드에서 Map 타입으로 반환
        Map<String, String> producPlan = saveFile(creatorProductPlan);
        Map<String, String> producPortfolio = saveFile(creatorProductPortfolio);
        Map<String, String> img = saveFile(creatorImg);

        // html에서 넘어올 때 dto에 못담은 값 따로 삽입
        creatorInfoDTO.setMemId(creatorId);
        creatorInfoDTO.setCreImgName(img.get("savedFileName"));
        creatorInfoDTO.setCreImgPath(img.get("filePath"));
        creatorInfoDTO.setCreImgOriName(img.get("originFileName"));

        // CREATOR_INFO 테이블에 creatorInfoDTO로 INSERT
        evaluationMapper.insertCreatorInfo(creatorInfoDTO);

        // 심사 테이블 등록
        EvaluationDTO evaluationDTO = new EvaluationDTO();
        evaluationDTO.setEvaDateTime(new Timestamp(System.currentTimeMillis()));
        evaluationDTO.setEvaSituation("처리중");
        evaluationMapper.insertEvaluation(evaluationDTO);

        // 크리에이터 심사 테이블 등록 ( 심사 테이블 등록하면서 select key로 반환된 심사번호로 등록)
        CreatorEvaDTO creatorEvaDTO = new CreatorEvaDTO(creatorId, evaluationDTO.getEvaNum());
        evaluationMapper.insertCreatorEva(creatorEvaDTO);

        // CREATRO_FILE 테이블에 받아온 파일들 INSERT
        int fileNo = 1;
        InsertCreatorFile(fileNo, creatorId, producPlan);
        fileNo++;
        InsertCreatorFile(fileNo, creatorId, producPortfolio);
        fileNo++;
        InsertCreatorFile(fileNo, creatorId, img);
    }

    @Override
    @Transactional
    public void updateCreatorInfo(MultipartFile creatorProductPlan, MultipartFile creatorProductPortfolio, MultipartFile creatorImg, CreatorInfoDTO creatorInfoDTO, String creatorId) throws IOException {

        // 받아온 파일마다 저장경로, 저장명, 원본명을 받아오기 위해 따로 메소드에서 Map 타입으로 반환
        Map<String, String> producPlan = saveFile(creatorProductPlan);
        Map<String, String> producPortfolio = saveFile(creatorProductPortfolio);
        Map<String, String> img = saveFile(creatorImg);

        // html에서 넘어올 때 dto에 못담은 값 따로 삽입
        creatorInfoDTO.setMemId(creatorId);
        creatorInfoDTO.setCreImgName(img.get("savedFileName"));
        creatorInfoDTO.setCreImgPath(img.get("filePath"));
        creatorInfoDTO.setCreImgOriName(img.get("originFileName"));

        // creatorInfo 테이블에 creatorInfoDTO로 UPDATE
        evaluationMapper.updateCreatorInfo(creatorInfoDTO);

        // 심사 테이블 등록
        EvaluationDTO evaluationDTO = new EvaluationDTO();
        evaluationDTO.setEvaDateTime(new Timestamp(System.currentTimeMillis()));
        evaluationDTO.setEvaSituation("처리중");
        evaluationMapper.insertEvaluation(evaluationDTO);

        // 크리에이터 심사 테이블 등록 ( 심사 테이블 등록하면서 select key로 반환된 심사번호로 등록)
        CreatorEvaDTO creatorEvaDTO = new CreatorEvaDTO(creatorId, evaluationDTO.getEvaNum());
        evaluationMapper.insertCreatorEva(creatorEvaDTO);

        // CREATRO_FILE 테이블에 받아온 파일들 INSERT
        int fileNo = 1;
        InsertCreatorFile(fileNo, creatorId, producPlan);
        fileNo++;
        InsertCreatorFile(fileNo, creatorId, producPortfolio);
        fileNo++;
        InsertCreatorFile(fileNo, creatorId, img);
    }

    @Override
    @Transactional
    public void insertCreatorBusiness(MultipartFile businessRegistration
            , CreatorBusinessDTO creatorBusinessDTO
            , String creatorId) throws IOException {

        System.out.println("서비스 진입");

        // 저장 후 저장경로, 저장명, 원본명을 받아오기 위해 따로 메소드에서 Map 타입으로 반환
        Map<String, String> registration = saveFile(businessRegistration);

        // dto에 없는 값 추가로 삽입
        creatorBusinessDTO.setMemId(creatorId);

        // CREATOR_BUSINESS 테이블에 INSERT
        if (evaluationMapper.InsertCreatorBusiness(creatorBusinessDTO)) {
            System.out.println("사업자 정보 등록 완료");
        } else {
            System.out.println("사업자 정보 등록 실패");
        }

        // 크리에이터 정보를 등록할 때 3개의 파일이 들어갔으니 파일번호는 4번으로 추가
        InsertCreatorFile(4, creatorId, registration);
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
//        System.out.println("크리에이터 권한 업데이트 성공");
    }

    public void updateReaRejection(Map<String, Object> map) {
        evaluationMapper.updateEvaluation(map);
    }

    public void deleteCreFileAndBusinessInfo(String memId) {
        evaluationMapper.deleteCreatorFile(memId);
        evaluationMapper.deleteCreatorBusinessEvaluation(memId);
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

        // 매개변수로 전달받은 값들을 creatorFileDTO에 삽입 후 DB에 저장
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
