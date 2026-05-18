import java.io.Serializable;

public class GPU implements Serializable {
    private static final long serialVersionUID = 1L;
    private String model;
    private int price;

    public GPU(String model, int price){
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString(){
        return "Модель: " + model + " Цена: " + price;
    }
}
