public class User implements Runnable{
    private String name;
    private String task;

    public User(String name, String task){
        this.name = name;
        this.task = task;
    }

    @Override
    public void run(){
        for(int i = 0; i < 20; i++){
            System.out.println("Поток: " + Thread.currentThread().getName() + " | " + "Пользователь: " + name + " Задача: " + task + " Итого из 20 задач сделано: " + i);
            try{
                Thread.sleep(5000);
            }catch(InterruptedException error){
                error.printStackTrace();
            }
        }
    }
}
