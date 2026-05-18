public class Phone {
//   имена переменных которые будут в конструкторе
    private String modelName;
    private String nameCpu;
    private int ram;
    private int price;
//    Конструктор телефона с характеристиками
    public Phone(String modelName,String nameCpu,int ram,int price){
        this.modelName = modelName;
        this.nameCpu = nameCpu;
        this.ram = ram;
        this.price = price;
    }
    public String getModelName(){
        return "model: " + this.modelName + "\n" + "CPU: " + this.nameCpu + "\n" + "RAM: " + this.ram + "GB";
    }
    public int getPrice(){
        return this.price;
    }
}
