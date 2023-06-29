package hl.hjc.newsdemo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author : hupo, 创建于:2023/3/18
 */
public interface FileService {
    ResponseEntity upload(MultipartFile img);
}
