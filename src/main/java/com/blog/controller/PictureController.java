package com.blog.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/**
 * 图片上传
 * @author Administrator
 */
@Controller
@RequestMapping(value="/picture")
public class PictureController {
	
	/**
	 * @param file
	 * @return 返回json格式的图片访问路径
	 * @throws Exception
	 */
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	public String upload(@RequestParam(value="myfile") MultipartFile file) throws Exception{
		String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D:\\pic\\"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        file.transferTo(new File(filePath+fileName));
        String url = "http://localhost:8088/blog/pic/"+fileName;
		return "{\"url\":"+"\""+url+"\"}";
	}
	
	/**
	 * 将字符串通过“base64，”分割，前面表示图片格式，后面为图片数据
	 * 将表示图片数据的字符串转成字节数组写入磁盘
	 * @param base64Data
	 * @return 返回文件名
	 * @throws Exception
	 */
	@RequestMapping(value="/uploadBase64",method=RequestMethod.POST)
	@ResponseBody
	public String uploadBase64(@RequestParam String base64Data) throws Exception {
		String [] d = base64Data.split("base64,");
		String dataPrix = d[0];
        String data = d[1];
		String suffix = "";
        if("data:image/jpeg;".equalsIgnoreCase(dataPrix)){//data:image/jpeg;base64,base64编码的jpeg图片数据
            suffix = ".jpg";
        } else if("data:image/gif;".equalsIgnoreCase(dataPrix)){//data:image/gif;base64,base64编码的gif图片数据
            suffix = ".gif";
        } else if("data:image/png;".equalsIgnoreCase(dataPrix)){//data:image/png;base64,base64编码的png图片数据
            suffix = ".png";
        }else{
            throw new Exception("上传图片格式不合法！");
        }
        String fileName = UUID.randomUUID() + suffix;
        byte[] bs = Base64Utils.decodeFromString(data);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\pic\\"+fileName));
        bos.write(bs);
        bos.close();
        return fileName;    
	}
}
