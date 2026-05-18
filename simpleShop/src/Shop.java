public class Shop{
    private String assembly;
    private int price;
    private int quantity;
    public Shop(String assembly, int price, int quantity){
        this.assembly = assembly;
        this.price = price;
        this.quantity = quantity;
    }

    public String getAssemblyName(){
        return assembly;
    }
    public int getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
