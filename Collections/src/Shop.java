import java.util.Objects;

public class Shop {
    private String model;
    private int price;
    public Shop(String model, int price){
        this.model = model;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return price == shop.price && Objects.equals(model, shop.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price);
    }

    @Override
    public String toString(){
        return "Модель: " + model + " Цена: " + price;
    }

}
