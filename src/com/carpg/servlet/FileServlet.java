package com.carpg.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FileServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File file ;
		int maxFileSize = 5000 * 1024;
		int maxMemSize = 5000 * 1024;
		String filePath = "e:\\";
		System.out.println("测试图片上传:");
		// 验证上传内容了类型
		   String contentType = request.getContentType();
		   System.out.println("上传类型:"+contentType);
		   if ((contentType.indexOf("multipart/form-data") >= 0)) {

		      DiskFileItemFactory factory = new DiskFileItemFactory();
		      // 设置内存中存储文件的最大值
		      factory.setSizeThreshold(maxMemSize);
		      // 本地存储的数据大于 maxMemSize.
		      factory.setRepository(new File("c:\\temp"));

		      // 创建一个新的文件上传处理程序
		      ServletFileUpload upload = new ServletFileUpload(factory);
		      // 设置最大上传的文件大小
		      upload.setSizeMax( maxFileSize );
		      try{ 
		         // 解析获取的文件
		         List fileItems = upload.parseRequest(request);

		         // 处理上传的文件
		         Iterator i = fileItems.iterator();

		         while ( i.hasNext () ) 
		         {
		            FileItem fi = (FileItem)i.next();
		            if ( !fi.isFormField () )	
		            {
		            // 获取上传文件的参数
		            String fieldName = fi.getFieldName();
		            String fileName = fi.getName();
		            boolean isInMemory = fi.isInMemory();
		            long sizeInBytes = fi.getSize();
		            // 写入文件
		            if( fileName.lastIndexOf("\\") >= 0 ){
		            file = new File( filePath , 
		            fileName.substring( fileName.lastIndexOf("\\"))) ;
		            }else{
		            file = new File( filePath ,
		            fileName.substring(fileName.lastIndexOf("\\")+1)) ;
		            }
		            fi.write( file ) ;
		            }
		         }
		      }catch(Exception ex) {
		         System.out.println(ex);
		      }
		   }
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
