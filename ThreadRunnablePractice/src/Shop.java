import java.util.ArrayList;
import java.util.List;

public class Shop implements Runnable {
    private String model;
    private int price;
    public int count;
    public Shop(String model, int price) {
        this.model = model;
        this.price = price;
        count++;
    }

    @Override
    public void run(){
        for(int i = 0; i < count; i++){
            System.out.println("Поток: " + Thread.currentThread().getName() + " | " + "Модель выведена: " + getmodel() + " Цена: " + getPrice());
        }
    }

    public String getmodel(){
        return model;
    }
    public int getPrice(){
        return price;
    }
}
