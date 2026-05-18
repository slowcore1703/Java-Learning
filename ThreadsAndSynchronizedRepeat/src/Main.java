import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountMoney counter = new CountMoney();

        Thread thread1 = new Thread(counter::countMoneyPlus);
        Thread thread2 = new Thread(counter::countMoneyMinus);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("--------------------------------------------------");
        System.out.println("Итого денег: " + CountMoney.getMoney());
    }
}
