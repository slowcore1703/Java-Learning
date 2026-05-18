import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Path path = Paths.get("Data/lists/list.dat");
        ArrayList<GPU> list = new ArrayList<>();

        try {
            if(Files.notExists(path)){
                Files.createDirectories(path.getParent());
            }
            if(Files.exists(path)){
                try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path)))
                {
                    list = (ArrayList<GPU>) in.readObject();
                    System.out.println("Всего моделей: " + list.size());
                }catch(IOException | ClassNotFoundException error){
                    error.printStackTrace();
                }
            }else {
                list.add(new GPU("RTX 5090", 350000));
                list.add(new GPU("RTX 4090", 249999));

                try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path)))
                {
                    out.writeObject(list);
                }catch(IOException error){
                    System.err.println("Ошибка сохранения дефолтных моделей " + error.getMessage());
                }
            }
        }catch(IOException error){
            error.printStackTrace();
        }

        while(true){
            System.out.println("Добавить модель к существующим? 1.да 2.нет сохранить дефолтный данные");
            int choice = input.nextInt();
            input.nextLine();
            if(choice == 2) break;
            if(choice == 1){
                System.out.print("Введите модель:");
                String model = input.nextLine();
                System.out.print("Введите цену: ");
                int price = input.nextInt();
                input.nextLine();
                list.add(new GPU(model,price));
                try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path)))
                {
                    out.writeObject(list);
                    System.out.println("Новая модель добавлена");
                }catch(Exception error){
                    error.getMessage();
                }
            }
        }
    }
}