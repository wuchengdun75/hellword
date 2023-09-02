public class ThreadMethod02 {
	public static void main(String[] args) throws InterruptedException {

		T2 t2 = new T2();
		t2.start();

		for (int i = 1; i <= 20; i++) {
			Thread.sleep(1000);
			System.out.println("主线程(小弟) 吃了 " + i + " 包子");
			if (i == 5) {
				System.out.println("主线程(小弟) 让 子线程(老大) 先吃");
				Thread.yield();
				System.out.println("线程(老大) 吃完了 主线程(小弟) 接着吃..");
			}

		}
	}
}

class T2 extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 20; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("子线程(老大) 吃了 " + i + " 包子");
		}
	}
}
