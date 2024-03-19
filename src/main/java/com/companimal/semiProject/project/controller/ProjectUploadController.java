package com.companimal.semiProject.project.controller;

import com.google.gson.JsonObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class ProjectUploadController {

//    @Value("${file.upload.path}") // 외부 설정 파일에서 파일 업로드 경로를 가져오도록 설정
//    private String fileUploadPath;
//
//    @RequestMapping(value = "/uploadSummernoteImageFile", produces = "application/json; charset=UTF-8")
//    @ResponseBody
//    public Map<String, String> uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile) {
//        Map<String, String> response = new HashMap<>();
//
//        String originalFileName = multipartFile.getOriginalFilename();
//        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
//        String savedFileName = UUID.randomUUID() + extension;
//
//        File targetFile = new File(fileUploadPath + savedFileName);
//
//        try {
//            InputStream fileStream = multipartFile.getInputStream();
//            FileUtils.copyInputStreamToFile(fileStream, targetFile);
//            String imageUrl = "/summernote/resource/fileupload/" + savedFileName;
//            response.put("url", imageUrl);
//            response.put("responseCode", "success");
//        } catch (IOException e) {
//            FileUtils.deleteQuietly(targetFile);
//            response.put("responseCode", "error");
//            e.printStackTrace();
//        }
//
//        return response;
//    }

    // application.yml에서 설정한 경로를 가져오기 위한 @Value 어노테이션 사용
    @Value("${file.upload-dir}")
    private String uploadDir;

    @RequestMapping(value = "/uploadSummernoteImageFile", produces = "application/json; charset=UTF-8")
    public String uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {

        JsonObject jsonObject = new JsonObject();

        // 설정한 파일 업로드 경로를 사용
        String fileRoot = uploadDir + "fileupload/"; // '/proStory/fileupload/' 경로에 파일을 저장

        String originalFileName = multipartFile.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));

        String savedFileName = UUID.randomUUID() + extension;

        File targetFile = new File(fileRoot + savedFileName);
        try {
            InputStream fileStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);
            jsonObject.addProperty("url", "/resource/fileupload/" + savedFileName);
            jsonObject.addProperty("responseCode", "success");

        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile); // 파일 저장 실패 시, 생성된 파일 삭제
            jsonObject.addProperty("responseCode", "error");
            e.printStackTrace();
        }

        return jsonObject.toString();
    }
}
