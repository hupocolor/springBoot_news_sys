package hl.hjc.newsdemo.controller;

import hl.hjc.newsdemo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author : hupo, 创建于:2023/3/18
 */
@RestController
@RequestMapping
public class UploadController {
    @Autowired
    private FileService fileService;
    @PostMapping("/upload")
    public ResponseEntity uploadImg(@RequestParam("file") MultipartFile img){
        return fileService.upload(img);
    }
}
