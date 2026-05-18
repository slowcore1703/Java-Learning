public class CountMoney {
    private static final Object lock = new Object();
    private static int money = 10000;

    public void countMoneyPlus(){
        for(int i = 0; i < 50; i++){
            synchronized (lock){
                money += 100;
            }
            sleep();
        }
    }
    public void countMoneyMinus(){
        for(int i = 0; i < 50; i++){
            synchronized (lock){
                money -= 100;
            }
            sleep();
        }
    }

    private void sleep(){
        try {
            Thread.sleep(5);
        }catch (InterruptedException error){
            Thread.currentThread().interrupt();
        }
    }

    public static int getMoney(){
        synchronized (lock){
            return money;
        }
    }
}
