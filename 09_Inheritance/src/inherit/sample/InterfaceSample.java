package inherit.sample;

// import 가능
import kh.mclass.B;

public interface/* class가 아닌 interface */ InterfaceSample {
	public final int MAX_COUNT = 10;

	public abstract void method1(B b);

	public void method2();

	void method3();

	void method4();

	String testSum(); // 메소드 이름은 관례적으로 동사를 앞에 적음

	String sumTest();
}
