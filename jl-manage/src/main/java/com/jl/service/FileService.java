package com.jl.service;

import com.jl.vo.EasyUIFile;
import org.springframework.web.multipart.MultipartFile;


public interface FileService {

	EasyUIFile fileUpload(MultipartFile uploadFile);

}
