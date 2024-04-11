package kh.mclass.open.star.model.service;

public class WeatherVo {
	// SKY: 맑음(1), 구름많음(3), 흐림(4)
	// PTY: 없음(0), 비(1), 비/눈(2), 눈(3), 소나기(4)
	private int locationCode;
	private String date;
	private String time;
	private int SKY;
	private int PTY;

	@Override
	public String toString() {
		return "WeatherVo [locationCode=" + locationCode + ", date=" + date + ", time=" + time + ", SKY=" + SKY
				+ ", PTY=" + PTY + "]";
	}

	public int getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(int locationCode) {
		this.locationCode = locationCode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getSKY() {
		return SKY;
	}

	public void setSKY(int sKY) {
		SKY = sKY;
	}

	public int getPTY() {
		return PTY;
	}

	public void setPTY(int pTY) {
		PTY = pTY;
	}

}
