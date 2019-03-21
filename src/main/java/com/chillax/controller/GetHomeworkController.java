package com.chillax.controller;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
@WebServlet("/GetHomeworkController")
public class GetHomeworkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int MEMORY_THRESHOLD=1024*1024*3;
	private static final int MAX_FILE_SIZE=1024*1024*40;
	private static final int MAX_REQUEST_SIZE=1024*1024*50;
    public GetHomeworkController() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
		 DiskFileItemFactory factory=new DiskFileItemFactory();
		 factory.setSizeThreshold(MEMORY_THRESHOLD);
		 ServletFileUpload upload=new ServletFileUpload(factory);
		 upload.setSizeMax(MAX_FILE_SIZE);
		 upload.setFileSizeMax(MAX_REQUEST_SIZE);
		 upload.setHeaderEncoding("UTF-8");
		 String uploadPath = "D:\\�ϴ��ļ���Ϣ";
		 File uploadDir=new File(uploadPath);
		 if(!uploadDir.exists()) {
			 uploadDir.mkdirs();
		 }
		 try {
			List<FileItem> formItems=upload.parseRequest(request);
			if(formItems!=null&&formItems.size()>0) {
				for(FileItem item:formItems) {
					if(!item.isFormField()) {
						String fileName=new File(item.getName()).getName();
						String filePath=uploadPath+File.separator+fileName;
						File storeFile=new File(filePath);
						item.write(storeFile);
						response.getWriter().write("�ļ��ϴ��ɹ�");
					}
				}
			}
		} catch (Exception e) {
			response.getWriter().write("�ļ��ϴ�ʧ��");
		}		
	}
}
