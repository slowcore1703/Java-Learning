public class Shop {
    private String name;
    private int age;
    public Shop(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "Имя: " + name + " Возраст: " + age;
    }
}
