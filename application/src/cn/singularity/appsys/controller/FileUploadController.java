package cn.singularity.appsys.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	
	@RequestMapping(value="/fileupload" )
	public void upload(@RequestParam("a_downloadLink") MultipartFile uploadFile,HttpSession seesion) throws Exception{
		String path = seesion.getServletContext().getRealPath(File.separator + "statics" + File.separator + "uploadfiles" );
		System.out.println(path);
		File file = new File(path, uploadFile.getOriginalFilename());
		if (!file.exists()) {
			file.mkdirs();
		}
		uploadFile.transferTo(file);
		
	}
	
	
}
