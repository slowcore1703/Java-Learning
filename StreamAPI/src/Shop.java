public class Shop {
    private String model;
    private int price;
    private int count;
    public Shop(String model, int price, int count){
        this.model = model;
        this.price = price;
        this.count = count;
    }

    public String getModel() {
        return model;
    }

    public int  getPrice() {
        return price;
    }

    public int getCount(){
        return count;
    }

    public String toString(){
        return "Модель: " + model + " Цена: " + price;
    }
}
