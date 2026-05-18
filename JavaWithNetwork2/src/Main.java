import javax.script.ScriptContext;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("Storage/data/list/list.data");
        List<Shop> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        if (Files.exists(path)) {
            try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
                list = (ArrayList<Shop>) in.readObject();
                System.out.println("Кол во объектов:" + list.size());
            } catch (IOException | ClassNotFoundException error) {
                error.getMessage();
            }
        } else {
            list.add(new Shop("RTX5090", 350000));
            list.add(new Shop("RTX 4090", 250000));
        }


        while (true) {
            System.out.println("Сервис записи файла запущен...");
            System.out.println("Хотите добавить новый файл уже к существующим? 1.Да 2.Нет");
            int choice = input.nextInt();
            input.nextLine();
            if (choice == 2) break;

            if (choice == 1) {
                System.out.print("Введите модель:");
                String model = input.nextLine();
                System.out.print("Введите прайс:");
                int price = input.nextInt();
                input.nextLine();
                list.add(new Shop(model, price));

                try {
                    if (Files.notExists(path)) {
                        Files.createDirectories(path.getParent());
                    }
                    try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
                        out.writeObject(list);
                    }
                } catch (IOException error) {
                    error.getMessage();
                }
            }
        }

        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            System.out.println("Сервер запущен");
            while(true){
                try(Socket client = serverSocket.accept();
                    ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream()))
                {
                    System.out.println("Клиент подключился");
                    out.writeObject(list);
                    System.out.println("Данные отправлены");
                }
            }
        }catch(IOException error){
            error.getMessage();
        }
    }
}