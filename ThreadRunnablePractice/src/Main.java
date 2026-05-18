import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        User user = new User("John", "Делает вычисления...");
        Client client = new Client("Alice", "Пытается получить информацию от сервера");
        List<Shop> list = new ArrayList<>();
        list.add(new Shop("RTX5090", 350000));
        list.add(new Shop("RTX4090", 250000));
        list.add(new Shop("RTX3090", 150000));
        list.add(new Shop("RTX2090", 90000));
        list.add(new Shop("GTX1660Super", 50000));


        Thread threadOfUser = new Thread(user);
        Thread threadOfClient = new Thread(client);
        Thread threadList = new Thread(() -> {
            for(Shop show : list){
                try{
                    new Thread(show).start();
                    Thread.sleep(2000);
                }catch(Exception error){
                    error.printStackTrace();
                }
            }
        });
        threadOfUser.start();
        threadOfClient.start();
        threadList.start();
    }
}