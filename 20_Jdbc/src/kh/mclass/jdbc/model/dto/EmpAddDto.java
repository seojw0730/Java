package kh.mclass.jdbc.model.dto;

import java.sql.Date;

// 신입사원 등록시 사용자 입력 자료형(일부 정보만 입력 받고 나머지 생성)
public class EmpAddDto {
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
	private int mgr;
}
