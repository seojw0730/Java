package kh.mclass.semim.board.model.dto;

import java.util.List;

public class BoardInsertDto {
//	BOARD

//	BOARD_ID     NOT NULL NUMBER         
//	TITLE        NOT NULL VARCHAR2(120)  
//	CONTENT               VARCHAR2(4000) 
//	WRITE_TIME   NOT NULL TIMESTAMP(6)   
//	BOARD_WRITER NOT NULL VARCHAR2(20)   
//	LOG_IP                VARCHAR2(15)   
//	READ_COUNT   NOT NULL NUMBER

	private String title;
	private String content;
	private String boardWriter; // TIMESTAMP
	private List<FileWriteDto> fileList;

	@Override
	public String toString() {
		return "BoardInsertDto [title=" + title + ", content=" + content + ", boardWriter=" + boardWriter
				+ ", filelist=" + fileList + "]";
	}

	public BoardInsertDto(String title, String content, String boardWriter, List<FileWriteDto> fileList) {
		super();
		this.title = title;
		this.content = content;
		this.boardWriter = boardWriter;
		this.fileList = fileList;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public List<FileWriteDto> getFilelist() {
		return fileList;
	}

}
