package com.lv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * Created by simperLv
 * on 2018/11/05 11:28
 *
 * @Description //TODO
 */
@Controller
@RequestMapping("file")
public class UploadController {

    @PostMapping("/upload")
    public @ResponseBody String upload(HttpServletRequest request, MultipartFile[] file){
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") +"upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if(!dir.exists())
            {
                dir.mkdir();
            }
            //遍历文件数组执行上传
            for (int i =0;i<file.length;i++) {
                if(file[i] != null) {
                    //调用上传方法
                    executeUpload(uploadDir, file[i]);
                }
            }
        }catch (Exception e)
        {
            //打印错误堆栈信息
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    /**
     * 上传方法
     * @param uploadDir
     * @param file
     * @throws Exception
     */
    private void executeUpload(String uploadDir,MultipartFile file) throws Exception{
        //上传真实文件名
        //String fileName = file.getOriginalFilename();
        //上传文件后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //使用UUID重新设置文件名字
        String fileName = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + fileName);
        //将上传文件写入服务器端文件内
        file.transferTo(serverFile);
    }
}
