package com.companimal.semiProject.project.controller;

import com.google.gson.JsonObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class ProjectUploadController {

    @RequestMapping(value = "/uploadSummernoteImageFile", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {

        JsonObject jsonObject = new JsonObject();

        String contextRoot = new HttpServletRequestWrapper(request).getSession().getServletContext().getRealPath("/");
        String fileRoot = contextRoot + "resource/fileupload/";

        String originalFileName = multipartFile.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));

        String savedFileName = UUID.randomUUID() + extension;

        File targetFile = new File(fileRoot + savedFileName);
        try {
            InputStream fileStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);
            jsonObject.addProperty("url", "/summernote/resource/fileupload/" + savedFileName);
            jsonObject.addProperty("responseCode", "success");

        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);
            jsonObject.addProperty("responseCode", "error");
            e.printStackTrace();
        }

        String jsonObjectString = jsonObject.toString();

        return jsonObjectString;
    }
}
