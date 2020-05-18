package org.enums;

public enum BanEnum {
	BANID(1, "BANID"), BANIP(2, "BANIP");
	private Integer code;
	private String msg;

	private BanEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static BanEnum getByCode(Integer code) {
		BanEnum[] enums = values();
		for (BanEnum b : enums) {
			if (b.getCode().equals(code)) {
				return b;
			}
		}
		return null;
	}

}
