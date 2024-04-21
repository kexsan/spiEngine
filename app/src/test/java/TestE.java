import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class TestE {
@Test
    public  void test() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable task = () -> {
            System.out.println("Task is running in thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000); // Задача спит 2 секунды для демонстрации
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task is completed in thread: " + Thread.currentThread().getName());
            return "null";
        };

        // executor.execute(task);
        Future submit = executor.submit(task);
        submit.get();
        System.out.println("Main thread is continuing");
    }
}
