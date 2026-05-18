public class Main {
    public static int money = 10000;
    private static final Object lock = new Object();

    public static void main(String[] args){
        System.out.println("main поток стартовал");

        Thread threadNumbers = new Thread(() -> {
            for(int i = 1000; i <= 2000; i += 10){
                System.out.println("Счетчик: " + i);
                try {
                    Thread.sleep(500);
                }catch(InterruptedException error){
                    error.printStackTrace();
                }
            }
        });

        Thread threadChar = new Thread(() -> {
            for(char c = 'A'; c <= 'Z'; c++){
                System.out.println("Текущая буква: " + c);
                try{
                    Thread.sleep(1500);
                }catch(InterruptedException error){
                    error.printStackTrace();
                }
            }
        });

        Thread threadDouble = new Thread(() -> {
            for(double i = 0.5; i <= 20.10; i += 0.2){
                System.out.println("Текущее нецелое значение: " + i);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException error){
                    error.printStackTrace();
                }
            }
        });

//        threadNumbers.start();
//        threadChar.start();
//        threadDouble.start();

        Thread threadMoneyMinus = new Thread(() -> {
            for(int i = 0; i < 10000; i++){
                synchronized (lock){
                    money -= 10;
                    System.out.println("Итого денег: " + money);
                }
                try{
                    Thread.sleep(5);
                }catch(InterruptedException error){
                    error.printStackTrace();
                }
            }
        });

        Thread threadMoneyPlus = new Thread(() -> {
            for(int i = 0; i < 10000; i++){
                synchronized(lock){
                    money += 10;
                    System.out.println("Итого денег: " + money);
                }
                try{
                    Thread.sleep(5);
                }catch(InterruptedException error){
                    error.printStackTrace();
                }
            }
        });

        threadMoneyMinus.start();
        threadMoneyPlus.start();
    }
}
