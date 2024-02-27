package kh.mclass.jdbc.model.dto;

import java.sql.Date;

// EmpDto 사원 정보 상세 보기
public class EmpDto {
//	 이름                                      널?      유형
//	----------------------------------------- -------- ----------------------------
//	 EMPNO                                     NOT NULL NUMBER(4)
//	 ENAME                                              VARCHAR2(10)
//	 JOB                                                VARCHAR2(9)
//	 MGR                                                NUMBER(4)
//	 HIREDATE                                           DATE
//	 SAL                                                NUMBER(7,2)
//	 COMM                                               NUMBER(7,2)
//	 DEPTNO                                             NUMBER(2)

	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String mgrEname; // 팀장이름 - DB의 도메인과 다름
	private Date hiredate;
	private double sal;
	private double comm;
	private int deptno;
	private String dname; // 부서명 - DB의 도메인과 다름
	private String loc; // 위치 - DB의 도메인과 다름

}
