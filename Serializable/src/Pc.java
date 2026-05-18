import java.io.Serializable;
public class Pc implements Serializable {
    private static final long serialVersionUID = 1L;

    private int price;
    private String model;

    public Pc(int price, String model){
        this.price = price;
        this.model = model;
    }

    @Override
    public String toString(){
        return "Мой комп [Модель: " + model + ", Цена: " + price + "]";
    }
}
