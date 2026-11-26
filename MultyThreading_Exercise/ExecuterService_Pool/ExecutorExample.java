import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 1. المهمة النقية (Task) - لا تعرف شيئاً عن الخيوط
class MyTask implements Runnable {
    private String taskName;

    MyTask(String name) {
        this.taskName = name;
    }

    @Override
    public void run() {
        // Thread.currentThread().getName() يجلب اسم العامل (الخيط) الذي ينفذ المهمة حالياً
        System.out.println(taskName + " started by: " + Thread.currentThread().getName());
        try {
            for (int count = 0; count < 5; count++) {
                Thread.sleep(400);
                System.out.println("In " + taskName + ", count is " + count);
            }
        } catch (InterruptedException exc) {
            System.out.println(taskName + " interrupted.");
        }
        System.out.println(taskName + " finished.");
    }
}

public class ExecutorExample {
    public static void main(String[] args) {
        System.out.println("Main thread starting.");

        // 2. إنشاء مدير الخيوط (مسبح يحتوي على خيطين فقط للعمل)
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 3. إرسال 3 مهام إلى المدير (لاحظ أن لدينا 3 مهام وخيطين فقط!)
        executor.execute(new MyTask("Task #1"));
        executor.execute(new MyTask("Task #2"));
        executor.execute(new MyTask("Task #3"));

        // 4. إغلاق المدير بعد انتهاء المهام المسندة إليه
        executor.shutdown();

        System.out.println("Main thread finished submitting tasks.");
    }
}
