package kh.mclass.semim.board.model.dto;

import java.sql.Connection;
import java.util.List;

public class BoardListDto {
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
	private String writeTime;
	private String boardWriter; // TIMESTAMP
	private Integer readCount;

	@Override
	public String toString() {
		return "BoardListDto [boardId=" + boardId + ", title=" + title + ", writeTime=" + writeTime + ", boardWriter="
				+ boardWriter + ", readCount=" + readCount + "]";
	}

	public BoardListDto() {
		super();
	}

	public BoardListDto(Integer boardId, String title, String writeTime, String boardWriter, Integer readCount) {
		super();
		this.boardId = boardId;
		this.title = title;
		this.writeTime = writeTime;
		this.boardWriter = boardWriter;
		this.readCount = readCount;
	}

	public Integer getBoardId() {
		return boardId;
	}

	public String getTitle() {
		return title;
	}

	public String getWriteTime() {
		return writeTime;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public Integer getReadCount() {
		return readCount;
	}

}
