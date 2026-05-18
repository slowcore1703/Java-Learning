import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Container<String> stringBox = new Container<>();
        stringBox.setContent("Секретный документ");
        System.out.println(stringBox.getContent());

        Container<Shop> shopBox = new Container<>();
        shopBox.setContent(new Shop("Bob", 22));
        shopBox.setContent(new Shop("John", 32));
        shopBox.setContent(new Shop("Jack", 18));
        Shop myName = shopBox.getContent();
        System.out.println("В коробке: "  + myName);

        stringBox.printType();
        shopBox.printType();

        Container<Shop> listBox = new Container<>();
        listBox.addContent(new Shop("NEO", 23));
        listBox.addContent(new Shop("NEO2", 25));
        listBox.addContent(new Shop("NEO3", 28));

        listBox.getList();
    }
}

class Container<T> {
    private T content;
    private List<T> list = new ArrayList<>();

    public void setContent(T content){
        this.content = content;
    }

    public void addContent(T item){
        this.list.add(item);
    }

    public T getContent(){
        return content;
    }

    public void getList(){
        System.out.println(list);
    }

    public void printType(){
        if(content != null){
            System.out.println("Тип одиночного объекта: " + content.getClass().getName());
        }else if(!list.isEmpty()){
            System.out.println("Тип объектов в списке: " + list.getClass().getName());
        }
    }
}
