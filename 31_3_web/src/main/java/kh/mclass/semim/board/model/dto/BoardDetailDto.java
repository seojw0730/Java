package kh.mclass.semim.board.model.dto;

import java.util.List;

public class BoardDetailDto {
//	BOARD

//	BOARD_ID     NOT NULL NUMBER         
//	TITLE        NOT NULL VARCHAR2(120)  
//	CONTENT               VARCHAR2(4000) 
//	WRITE_TIME   NOT NULL TIMESTAMP(6)   
//	BOARD_WRITER NOT NULL VARCHAR2(20)   
//	LOG_IP                VARCHAR2(15)   
//	READ_COUNT   NOT NULL NUMBER

	private Integer boardId;
	private String title;
	private String content;
	private String writeTime;
	private String boardWriter; // TIMESTAMP
	private Integer readCount;

	private List<BoardReplyDto> boardReplyList;

}
