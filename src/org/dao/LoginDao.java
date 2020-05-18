package org.dao;

import java.sql.*;
import java.text.SimpleDateFormat;

import org.model.*;
import org.db.*;
import java.util.ArrayList;

public class LoginDao {
	Connection conn = DBconn.getConn();; // ���ݿ����Ӷ���
	PreparedStatement pstmt;

	public Login checkLogin(String name, String password) { // ��֤�û�������
		try {
			pstmt = conn.prepareStatement("select * from loginss  where name= ? " + " and password= ?");
			pstmt.setString(1, name); // ����SQL������
			pstmt.setString(2, password); // ����SQL������
			ResultSet rs = pstmt.executeQuery(); // ִ�в�ѯ�����ؽ����
			if (rs.next()) { // ͨ��JavaBean����ֵ
				Login login = new Login();
				login.setId(rs.getInt(1));
				login.setName(name);
				login.setPassword(password);  
				login.setRole(rs.getInt(4));
				
				
				/**
				 * ��¼�ɹ�
				 */
				
				pstmt = conn.prepareStatement("update loginss set lastlogin=?  where id="+login.getId());
				pstmt.setString(1, new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())); // ����SQL������
				pstmt.executeUpdate(); 
				login.setLastlogin(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
				return login; // ����JavaBean����
			}
			return null; // ��֤ʧ�ܷ���null  
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}    
	
	public Login getLoginByName(String name) { // ��֤�û�������
		try {
			pstmt = conn.prepareStatement("select * from loginss  where name= ?");
			pstmt.setString(1, name); // ����SQL������
			ResultSet rs = pstmt.executeQuery(); // ִ�в�ѯ�����ؽ����
			if (rs.next()) { // ͨ��JavaBean����ֵ
				Login login = new Login();
				login.setId(rs.getInt(1));
				login.setName(rs.getString(2));
				login.setPassword(rs.getString(3));
				login.setRole(rs.getInt(4));
				login.setLastlogin(rs.getString(5));
				return login; // ����JavaBean����
			}
			return null; // ��֤ʧ�ܷ���null
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	

	public ArrayList<MessBoar> findMbInfo() {
		try {
			ArrayList<MessBoar> al = new ArrayList<MessBoar>();
			pstmt = conn.prepareStatement("select * from  messagess ");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MessBoar mb = new MessBoar();
				mb.setId(rs.getInt(1));
				mb.setName(rs.getString(2));
				mb.setTime(rs.getDate(3));
				mb.setTitle(rs.getString(4));
				mb.setMessage(rs.getString(5));
				al.add(mb);
			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getName(int id) {
		String name = null;
		try {
			pstmt = conn.prepareStatement("select name from  loginss  where id=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				name = rs.getString(1);
			}
			return name;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean addInfo(MessBoar mb) {
		try {
			pstmt = conn.prepareStatement("insert into  messagess  (name,time,title,message) values(?,?,?,?)");
			pstmt.setString(1, mb.getName());
			pstmt.setDate(2,  mb.getTime());
			pstmt.setString(3, mb.getTitle());
			pstmt.setString(4, mb.getMessage());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean insertUser(int id, String name, String password) {
		
		/**
		 * �ж��Ƿ����ע��
		 */
		try {
			pstmt = conn.prepareStatement("select * from loginss where name =?");
			pstmt.setString(1,name);
			ResultSet rs = pstmt.executeQuery(); // ִ�в�ѯ�����ؽ����
			if (rs.next()) { // ͨ��JavaBean����ֵ
				return false;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		
		try {
			pstmt = conn.prepareStatement("insert into  loginss (name,password,role)  values(?,?,?)");
			pstmt.setString(1,name);
			pstmt.setString(2, password);
			pstmt.setInt(3, 0);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}

	public void updatePass(String name, String pass) {
		// TODO Auto-generated method stub
		try {
		pstmt = conn.prepareStatement("update loginss set password=? where name=?");
		pstmt.setString(1,pass); // ����SQL������
		pstmt.setString(2,name); // ����SQL������
		pstmt.executeUpdate(); 
		}catch(Exception e) {
			
		}
	}

}
