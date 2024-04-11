package kh.mclass.semim.member.model.dto;

public class MemberModifyDto {
//  MEMBER
//	MEM_ID    NOT NULL VARCHAR2(20)  
//	MEM_PWD   NOT NULL VARCHAR2(20)  
//	MEM_EMAIL NOT NULL VARCHAR2(100) 
//	MEM_NAME  NOT NULL VARCHAR2(15)
	private String memId;
	private String memPwd;
	private String memPwdNew;
	private String memEmail;
	private String memName;

	@Override
	public String toString() {
		return "MemberModifyDto [memId=" + memId + ", memPwd=" + memPwd + ", memPwdNew=" + memPwdNew + ", memEmail="
				+ memEmail + ", memName=" + memName + "]";
	}

	public MemberModifyDto(String memId, String memPwd, String memPwdNew, String memEmail, String memName) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
		this.memPwdNew = memPwdNew;
		this.memEmail = memEmail;
		this.memName = memName;
	}

	public String getMemId() {
		return memId;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public String getMemPwdNew() {
		return memPwdNew;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public String getMemName() {
		return memName;
	}

}
