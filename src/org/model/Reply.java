package org.model;

/**
 * creaet TABLE reply(
rid INT PRIMARY KEY AUTO_INCREMENT,
MID INT,
replymessage VARCHAR(500)
);

 * @author Administrator
 *
 */
public class Reply {
	private Integer rid;
	private Integer mid;
	private String replymessage;
	private String replytime;
	
	public String getReplytime() {
		return replytime;
	}
	public void setReplytime(String replytime) {
		this.replytime = replytime;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getReplymessage() {
		return replymessage;
	}
	public void setReplymessage(String replymessage) {
		this.replymessage = replymessage;
	}
	
}
