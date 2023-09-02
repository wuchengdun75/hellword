public class Test {
    public static void main(String[] args) throws InterruptedException {

        JoinThread joinThread = new JoinThread();
        System.out.println(joinThread.getState());
        joinThread.start();
        Thread.State state = joinThread.getState();
        System.out.println("state=" + state);

        while (joinThread.getState() != Thread.State.TERMINATED) {
            System.out.println(joinThread.getState());
            Thread.sleep(200);
        }
        System.out.println(joinThread.getState());



    }
}

class JoinThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " hi " + i);
        }
    }
}
