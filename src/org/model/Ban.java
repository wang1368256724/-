package org.model;
/**\]
 * CREATE TABLE ban(
bid INT PRIMARY KEY AUTO_INCREMENT,
btext VARCHAR(60),
btype INT
);
 * @author Administrator
 *
 */
public class Ban {
	private Integer bid;
	private String btext;
	private Integer btype;//0-->id,1-->ip
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBtext() {
		return btext;
	}
	public void setBtext(String btext) {
		this.btext = btext;
	}
	public Integer getBtype() {
		return btype;
	}
	public void setBtype(Integer btype) {
		this.btype = btype;
	}
	

}
