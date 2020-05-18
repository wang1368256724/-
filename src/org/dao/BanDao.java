package org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.db.DBconn;
import org.model.Ban;
import org.model.Reply;

public class BanDao {
	Connection conn = DBconn.getConn();; // 数据库连接对象
	PreparedStatement pstmt;

	public void add(Ban ban) {
		// TODO Auto-generated method stub
		try {
			pstmt = conn.prepareStatement("insert into  ban  (btext,btype) values(?,?)");
			pstmt.setString(1,ban.getBtext());
			pstmt.setInt(2, ban.getBtype());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	public ArrayList<Ban> queryAll() {
		try {
			ArrayList<Ban> al = new ArrayList<Ban>();
			pstmt = conn.prepareStatement("select * from  ban ");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Ban mb = new Ban();
				mb.setBid(rs.getInt(1));
				mb.setBtext(rs.getString(2));
				mb.setBtype(rs.getInt(3));
				
				al.add(mb);
			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


}
