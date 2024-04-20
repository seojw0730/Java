package kh.mclass.semim.board.model.dto;

import java.util.List;

public class BoardReadDto {
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
	private String logIp;
	private Integer readCount;
	private List<FileReadDto> filedtolist;
//	private List<BoardReplyListDto> replydtolist;

	@Override
	public String toString() {
		return "BoardReadDto [boardId=" + boardId + ", title=" + title + ", content=" + content + ", writeTime="
				+ writeTime + ", boardWriter=" + boardWriter + ", logIp=" + logIp + ", readCount=" + readCount
				+ ", filedtolist=" + filedtolist + "]";
	}

	public BoardReadDto(Integer boardId, String title, String content, String writeTime, String boardWriter,
			String logIp, Integer readCount) {
		super();
		this.boardId = boardId;
		this.title = title;
		// 줄바꾸기, 띄워쓰기를 HTML 태그로 변경
		content.replaceAll("\\n", "<br>");
//		content.replaceAll("\\r", "<br>"); // \n, \r 둘 다 줄바꾸기
		content.replaceAll(" ", "&nbsp;");
		this.content = content;
		this.writeTime = writeTime;
		this.boardWriter = boardWriter;
		this.logIp = logIp;
		this.readCount = readCount;
	}


	public Integer getBoardId() {
		return boardId;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getWriteTime() {
		return writeTime;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public String getLogIp() {
		return logIp;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public List<FileReadDto> getFiledtolist() {
		return filedtolist;
	}

	public void setFiledtolist(List<FileReadDto> filedtolist) {
		this.filedtolist = filedtolist;
	}

}
