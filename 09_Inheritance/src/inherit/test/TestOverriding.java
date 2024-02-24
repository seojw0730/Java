package inherit.test;

import inherit.sample.Child;
import inherit.sample.Parent;

public class TestOverriding {
	
	public static void main(String[] args) {
		Parent p = new Parent();
		Child c = new Child();

		p.display();
		c.display();
	}
}
