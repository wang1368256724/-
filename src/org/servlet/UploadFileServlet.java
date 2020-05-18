package org.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadFileServlet
 */
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       
		
			/**
			 * 可发表，发表业务逻辑
			 */
			String realPath =         request.getServletContext().getRealPath(File.separator+"userfiles");
	        File file = new File(realPath);
	        if(!file.exists()){
	            file.mkdirs();
	            System.out.println("路径： "+realPath +" 创建成功!");
	        }
	 
	        // 2、获取上传文件对象的集合
	        Collection<Part> partList = request.getParts();
	        if(partList.size() == 1){
	            // 单个文件上传
	            Part part = request.getPart("uploadfile");
	            // 获取header 如： form-data; name="uploadfile"; filename="2018-08-11.mkv"
	            String header = part.getHeader("content-disposition");
	            // 获取文件名
	            String fileName = header.split(";")[2].split("=")[1].replaceAll("\"", "");
	            // 执行写入操作 --- 上传到指定的目录
	            part.write(realPath+File.separator+fileName);
	 
	        }else{
	            for (Part part : partList) {
	                // 多个文件上传
	                String header = part.getHeader("content-disposition");
	                String fileName = getFileName(header);
	                part.write(realPath+File.separator+fileName);
	            }
	        }
	}
	public String getFileName(String header) {
	      /**
	        * String[] tempArr1 = header.split(";");代码执行完之后，在不同的浏览器下，tempArr1数        组里面的内容稍有区别
	        * 火狐或者google浏览器下：tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
	        * IE浏览器下：tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
	        */
	        String[] tempArr1 = header.split(";");
	        /**
	        *火狐或者google浏览器下：tempArr2={filename,"snmp4j--api.zip"}
	        *IE浏览器下：tempArr2={filename,"E:\snmp4j--api.zip"}
	        */
	        String[] tempArr2 = tempArr1[2].split("=");
	        //获取文件名，兼容各种浏览器的写法
	        String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
	        return fileName;
	    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
