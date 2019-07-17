package com.example.demo.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;



/**
 * @author Zhu
 */
public class UploadFileUtil {
    private static final Logger log = LoggerFactory.getLogger(UploadFileUtil.class);

    /**
     * 验证文件是否已经存在
     * @param uploadPath
     * @param fileName
     */
    public static String checkFile(String uploadPath,String fileName) {
        String result="";
        String filePath = uploadPath + File.separator + fileName;
        File date = new File(filePath);
        if (date.exists()) {
            result="true";
        }
        else {
            result="false"; }
        return result;
    }

    /**
     * 文件上传
     * @param uploadFile
     * @param uploadPath
     * @param fileName
     */
    public static String uploadFile(MultipartFile uploadFile, String uploadPath,String fileName) {
        Map<String, Object> data = new HashMap<String, Object>(10);
        boolean result = Boolean.TRUE;
        try {


            String filePath = uploadPath + File.separator + fileName;
            File file = new File(filePath);
            uploadFile.transferTo(file);


        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result = Boolean.FALSE;
            data.put("errorMsg", "文件上传失败!");
        }
        data.put("success", result);
        data.put("resultMsg", fileName + "上传成功!");

        String jsonStr = data.toString();
        return jsonStr;
    }

}
