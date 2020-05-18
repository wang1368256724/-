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
			 * �ɷ�������ҵ���߼�
			 */
			String realPath =         request.getServletContext().getRealPath(File.separator+"userfiles");
	        File file = new File(realPath);
	        if(!file.exists()){
	            file.mkdirs();
	            System.out.println("·���� "+realPath +" �����ɹ�!");
	        }
	 
	        // 2����ȡ�ϴ��ļ�����ļ���
	        Collection<Part> partList = request.getParts();
	        if(partList.size() == 1){
	            // �����ļ��ϴ�
	            Part part = request.getPart("uploadfile");
	            // ��ȡheader �磺 form-data; name="uploadfile"; filename="2018-08-11.mkv"
	            String header = part.getHeader("content-disposition");
	            // ��ȡ�ļ���
	            String fileName = header.split(";")[2].split("=")[1].replaceAll("\"", "");
	            // ִ��д����� --- �ϴ���ָ����Ŀ¼
	            part.write(realPath+File.separator+fileName);
	 
	        }else{
	            for (Part part : partList) {
	                // ����ļ��ϴ�
	                String header = part.getHeader("content-disposition");
	                String fileName = getFileName(header);
	                part.write(realPath+File.separator+fileName);
	            }
	        }
	}
	public String getFileName(String header) {
	      /**
	        * String[] tempArr1 = header.split(";");����ִ����֮���ڲ�ͬ��������£�tempArr1��        �������������������
	        * �������google������£�tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
	        * IE������£�tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
	        */
	        String[] tempArr1 = header.split(";");
	        /**
	        *�������google������£�tempArr2={filename,"snmp4j--api.zip"}
	        *IE������£�tempArr2={filename,"E:\snmp4j--api.zip"}
	        */
	        String[] tempArr2 = tempArr1[2].split("=");
	        //��ȡ�ļ��������ݸ����������д��
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
