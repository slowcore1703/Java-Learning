import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try(Socket socket = new Socket("localhost", 8081);
            OutputStream out = socket.getOutputStream();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream()))
        {
            System.out.println("Выберите команду: 1.Отправить список моделей 2.Что то новое");
            int choice = input.nextInt();
            input.nextLine();
            if(choice == 1) {
                out.write(1);
                out.flush();
                ArrayList<Shop> serverList = (ArrayList<Shop>) in.readObject();
                serverList.forEach(System.out::println);
            }else if(choice == 2) System.out.println("Упс...еще не добавили :D следите за обновлениями!");
            else System.out.println("Невалидная команда!");
        }catch(IOException | ClassNotFoundException error){
            System.err.println("Ошибка передачи: " + error.getStackTrace());
        }
    }
}
