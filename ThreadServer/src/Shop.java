import java.io.Serializable;

public class Shop implements Serializable {
    private String model;
    private int price;

    public Shop(String model, int price){
        this.model = model;
        this.price = price;
    }

    @Override

    public String toString(){
        return "Модель: " + model + " Цена: " + price;
    }
}
