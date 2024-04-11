package kh.mclass.semim.member.model.dto;

public class MemberInfoDto {
//  MEMBER
//	MEM_ID    NOT NULL VARCHAR2(20)
//	MEM_EMAIL NOT NULL VARCHAR2(100) 
//	MEM_NAME  NOT NULL VARCHAR2(15)
	private String memId;
	private String memEmail;
	private String memName;
	
	@Override
	public String toString() {
		return "MemberInfoDto [memId=" + memId + ", memEmail=" + memEmail + ", memName=" + memName + "]";
	}

	public MemberInfoDto(String memId, String memEmail, String memName) {
		super();
		this.memId = memId;
		this.memEmail = memEmail;
		this.memName = memName;
	}

	public String getMemId() {
		return memId;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public String getMemName() {
		return memName;
	}
	
}
