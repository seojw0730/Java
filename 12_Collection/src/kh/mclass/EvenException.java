package kh.mclass;

public class EvenException extends Exception {
	private Integer number = null;

	public EvenException(int number) {
		this.number = number;
	}

	@Override
	public String getMessage() {
		if (number == null) {
			return "숫자가 아닙니다.";
		} else {
			return number + "는 짝수가 아닙니다.";
		}
//		return super.getMessage();
	}
}
