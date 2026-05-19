import java.sql.SQLOutput;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        AtomicInteger count = new AtomicInteger(0);


        Runnable task = () -> {
          for(int i = 0; i < 10; i++){
              int currentStepNumber = count.getAndIncrement();
              System.out.println("Общий счетчик готовности всех потоков: " +  currentStepNumber);
              System.out.println("Повар готовит пиццу (Этап"+ i +") в потоке: " + Thread.currentThread().getName());
              try{
                  Thread.sleep(3000);
              }catch(InterruptedException error){
                  error.printStackTrace();
              }
            }
            System.out.println("ПОВАР ЗАКОНЧИЛ ПРИГОТОВЛЕНИЕ ПИЦЦЫ...");
        };

        Runnable task2 = () -> {
            for(int i = 0; i <= 5; i++){
                int currentStepNumber = count.getAndIncrement();
                System.out.println("Общий счетчик готовности всех потоков: " +  currentStepNumber);
                System.out.println("Сборщик делает коробку Этап("+ i +") В потоке: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1500);
                }catch(InterruptedException error){
                    error.printStackTrace();
                }
            }
            System.out.println("СБОРЩИК СОБРАЛ КОРОБКУ...");
        };

        Runnable task3 = () -> {
            for(int i = 0; i <= 2; i++){
                int currentStepNumber = count.getAndIncrement();
                System.out.println("Общий счетчик готовности всех потоков: " +  currentStepNumber);
                System.out.println("Кассир обрабатывает заказ: Этап(" + i +") в потоке: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(900);
                }catch(InterruptedException error){
                    error.printStackTrace();
                }
            }
            System.out.println("КАССИР ОБРАБОТАЛ КЛИЕНТА...");
        };

        System.out.println("Начинаем работу по приготовлению пиццы...");
        executor.submit(task);
        executor.submit(task2);
        executor.submit(task3);

        executor.shutdown();
    }
}
