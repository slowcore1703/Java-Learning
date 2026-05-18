import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Path path = Paths.get("Storage/Data/data.dat");
        ArrayList<Shop> list = new ArrayList<>();
        list.add(new Shop("NewEX", 56000));
        list.add(new Shop("middle", 45000));

        try {
            if(Files.notExists(path)){
                Files.createDirectories(path.getParent());
            }
        }catch(IOException error){
            System.err.println("Ошибка внутри блока " + error.getStackTrace());
        }

        while(true){
            System.out.println("1. Добавить объект | 2. Запустить сервер и ждать клиента");
            int choice = input.nextInt();
            input.nextLine();

            if(choice == 2) break;

            if(choice == 1){
                System.out.print("Модель: ");
                String model = input.nextLine();
                System.out.print("Цена: ");
                int price = input.nextInt();
                input.nextLine();
                list.add(new Shop(model,price));

                try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path)))
                {
                    out.writeObject(list);
                    out.flush();
                    System.out.println("Файл успешно обновлен");
                }catch(IOException error){
                    System.err.println("Ошибка записи в файл: " + error.getStackTrace());
                }
            }
        }


        try(ServerSocket serverSocket = new ServerSocket(8081)){
            System.out.println("Сервер запущен, ожидание команд");

            while(true){
                try(Socket client = serverSocket.accept();
                    InputStream in = client.getInputStream();
                    ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream()))
                {
                    System.out.println("К нам зашли!");

                    int command = in.read();
                    System.out.println("Получена команда от клиента: " + command);

                    if(command == 1) {
                        out.writeObject(list);
                        System.out.println("Список отправлен клиенту!");
                    }else System.out.println("Невалидная команда");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}