public class Client implements Runnable {
    private String name;
    private String task;
    public Client(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println("Поток: " + Thread.currentThread().getName() + " | " + "Пользователь: " + name + " Задача: " + task + " попыток сделано: " + i);
            try {
                Thread.sleep(3000);
            }catch(InterruptedException error){
                error.printStackTrace();
            }
        }
    }
}
