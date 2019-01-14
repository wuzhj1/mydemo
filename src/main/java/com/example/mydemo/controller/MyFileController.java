package com.example.mydemo.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;

@Controller
public class MyFileController {

    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile file, Map<String, Object> map) throws IOException {

        String dest = null;

        String fileName = file.getOriginalFilename();
        if (!fileName.contains("\\")) {
            dest = "E:\\ideaProjects\\mydemo\\src\\main\\resources\\uploadfile\\" + fileName;
        } else {
            String subFileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
            dest = "E:\\ideaProjects\\mydemo\\src\\main\\resources\\uploadfile\\" + subFileName;
        }
        file.transferTo(new File(dest));
        map.put("dest", dest);
        map.put("name", file.getName());
        map.put("originName", file.getOriginalFilename());
        return "sucess";
    }

    @RequestMapping("/filedownload")
    public void fileDownload(HttpServletRequest request, HttpServletResponse response)  throws UnsupportedEncodingException{
        String fileName = "E:\\ideaProjects\\mydemo\\src\\main\\resources\\uploadfile\\31457.jpg";
        File file=new File(fileName);
        if (file.exists()) {

            // 配置文件下载
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

            // 实现文件下载
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                System.out.println("Download the song successfully!");
            } catch (Exception e) {
                System.out.println("Download the song failed!");
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}

