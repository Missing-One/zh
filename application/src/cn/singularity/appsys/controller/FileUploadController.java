package cn.singularity.appsys.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 这个控制器作为信息查看
 * @author zh
 */
public class FileUploadController {
	

	/**
	 * 上传
	 */
	@RequestMapping(value="/fileupload" )
	public void upload(@RequestParam("a_downloadLink") MultipartFile uploadFile,HttpSession seesion) throws Exception{
		String path = seesion.getServletContext().getRealPath(File.separator + "statics" + File.separator + "uploadfiles" );
		System.out.println(path);
		File file = new File(path, uploadFile.getOriginalFilename());
		if (!file.exists()) {
			file.mkdirs();
		}
		//这里实际上传操作
		uploadFile.transferTo(file);
	}
	
	
	
	
	/**
	 * spring支持的方式下载
	 * 有局限文件大小不能超过2G
	 * @throws IOException 
	 */
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(String filePath,HttpServletRequest request) throws IOException {
		
		File file = new File(filePath);
		byte[] body = null;
		InputStream is = new FileInputStream(file);
		body = new byte[is.available()];
		is.read(body);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Disposition", "attachment;filename=" + file.getName());
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(body, httpHeaders, HttpStatus.OK);
		return responseEntity;
	}
	/**
	 * StreamingResponseBody是spring 4.2版本添加的一个接口处理文件输出
	 */
//	@RequestMapping("/download")
//	public StreamingResponseBody handle() {
//	    return new StreamingResponseBody() {
//	        @Override
//	        public void writeTo(OutputStream outputStream) throws IOException {
//	            // write...
//	        }
//	    };
//	}
	@RequestMapping("/download")
	public void download(HttpServletRequest request, HttpServletResponse response, String fileName, String filePath) throws IOException {
		
		//设置响应头
		response.setContentType("multipart/form-data");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
		//设置响应类型//应用程序强制下载
		response.setContentType("application/force-download");
		
		try {
	        //打开本地文件流
	        InputStream is = new FileInputStream(filePath);
	        //激活下载操作
	        OutputStream os = response.getOutputStream();
	        response.setContentLength(is.available());
	        
	        //循环写入输出流
	        byte[] b = new byte[2048];
	        int length;
	        while ((length = is.read(b)) > 0) {
	            os.write(b, 0, length);
//	            downloadedLength += b.length;
	        }
	        os.flush();
	        // 这里主要关闭。
	        os.close();
	        is.close();
	    } catch (Exception e){
//	        downloadRecord.setStatus(DownloadRecord.STATUS_ERROR);
	        throw e;
	    }

	}
	
}
