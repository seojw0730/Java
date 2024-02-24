package kh.mclass;

public class SharedData {
	private int number = 12;
	private volatile boolean isChanged; // 휘발성
//	nv(non-volatile)
//	최적화(비휘발성): 메모리에 기록된 값을 계속 가져다 사용하는 것
	
	public SharedData() {
	}

//	동기화 처리된 메소드
	public synchronized void calcNumber() {
		number *= 3;
		System.out.println("changed... " + number);
	}

	public synchronized void printNumber() {
		System.out.println("number: " + number);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isChanged() { // boolean이면 is시리즈
		return isChanged;
	}

	public void setChanged(boolean isChanged) {
		this.isChanged = isChanged;
	}
}
