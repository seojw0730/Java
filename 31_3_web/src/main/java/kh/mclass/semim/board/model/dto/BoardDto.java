package kh.mclass.semim.board.model.dto;

public class BoardDto {
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

	@Override
	public String toString() {
		return "BoardDto [boardId=" + boardId + ", title=" + title + ", content=" + content + ", writeTime=" + writeTime
				+ ", boardWriter=" + boardWriter + ", logIp=" + logIp + ", readCount=" + readCount + "]";
	}

	public BoardDto(Integer boardId, String title, String content, String writeTime, String boardWriter, String logIp,
			Integer readCount) {
		super();
		this.boardId = boardId;
		this.title = title;
		this.content = content;
		this.writeTime = writeTime;
		this.boardWriter = boardWriter;
		this.logIp = logIp;
		this.readCount = readCount;
	}

	public Integer getBoardId() {
		return boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriteTime() {
		return writeTime;
	}

	public void setWriteTime(String writeTime) {
		this.writeTime = writeTime;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getLogIp() {
		return logIp;
	}

	public void setLogIp(String logIp) {
		this.logIp = logIp;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

}
