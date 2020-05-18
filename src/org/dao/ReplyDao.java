package org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.db.DBconn;
import org.model.MessBoar;
import org.model.Reply;

public class ReplyDao {
	Connection conn = DBconn.getConn();; // 数据库连接对象
	PreparedStatement pstmt;

	public ArrayList<Reply> findMbInfo() {
		try {
			ArrayList<Reply> al = new ArrayList<Reply>();
			pstmt = conn.prepareStatement("select * from  reply ");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Reply mb = new Reply();
				mb.setRid(rs.getInt(1));
				mb.setMid(rs.getInt(2));
				mb.setReplymessage(rs.getString(3));
				mb.setReplytime(rs.getString(4));
				al.add(mb);
			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void insert(int parseInt, String message, String format) {
		// TODO Auto-generated method stub
		
			try {
				pstmt = conn.prepareStatement("insert into  reply  (mid,replymessage,replytime) values(?,?,?)");
				pstmt.setInt(1,parseInt);
				pstmt.setString(2, message);
				pstmt.setString(3, format);
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		
	}
}
