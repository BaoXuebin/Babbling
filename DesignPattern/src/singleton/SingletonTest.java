package singleton;

public class SingletonTest {

	public String test() {
		String result = null;

		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		Thread3 t3 = new Thread3();
		Thread4 t4 = new Thread4();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (t1.getInstance() == null || t2.getInstance() == null || t3.getInstance() == null || t4.getInstance() == null) {
			result = "无效";
		} else if (t1.getInstance() == t2.getInstance() &&  t2.getInstance() == t3.getInstance() && t3.getInstance() == t4.getInstance()) {
			result = "线程安全" + t1.getInstance();
		} else {
			result = "线程不安全"+ t1.getInstance() + ", " + t2.getInstance() + ", " + t3.getInstance() + ", " + t4.getInstance();
		}

		return result;
	}

	public static void main(String[] args) {
		SingletonTest singletonTest = new SingletonTest();
		
		for (int i = 0; i < 100; i++) {
			System.out.println(singletonTest.test());
			SingletonOne.setEmpty();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
