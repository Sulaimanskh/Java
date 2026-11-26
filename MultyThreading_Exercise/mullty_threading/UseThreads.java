class MyThread implements Runnable {
    String thrdName;

    MyThread(String name) {
        thrdName = name;
    }

    // نقطة بداية تنفيذ الخيط الفرعي
    public void run() {
        System.out.println(thrdName + " starting.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + thrdName + ", count is " + count);
            }
        } catch (InterruptedException exc) {
            System.out.println(thrdName + " interrupted");
        }
        System.out.println(thrdName + " terminating");
    }
}

public class UseThreads {
    public static void main(String[] args) {
        System.out.println("Main thread starting");

        // 1. إنشاء المهمة والخيط الأول
        MyThread mt1 = new MyThread("Child #1");
        Thread newThrd1 = new Thread(mt1);

        // 2. إنشاء المهمة والخيط الثاني
        MyThread mt2 = new MyThread("Child #2");
        Thread newThrd2 = new Thread(mt2);

        // 3. إطلاق الخيطين معاً للعمل بالتوازي
        newThrd1.start();
        newThrd2.start();

        // عمل الخيط الرئيسي
        for (int i = 0; i < 50; i++) {
            System.out.print("@");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                System.out.println("Main thread interrupted");
            }
        }
        System.out.println("Main thread ending");
    }
}
