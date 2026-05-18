import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try(Socket socket = new Socket("localhost",8081);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            OutputStream out = socket.getOutputStream())
        {
            System.out.println("Что получить от сервера? 1.Лист 2.Приветствие");
            int choice = input.nextInt();
            input.nextLine();

            if(choice == 1){
                out.write(1);
                ArrayList<Shop> restoredList = (ArrayList<Shop>) ois.readObject();
                for(Shop show : restoredList){
                    System.out.println(show);
                }
            }else if(choice == 2){
                out.write(2);
                System.out.println(ois.readObject());
            }else{
                out.write(choice);
                System.out.println(ois.readObject());
            }
        }catch(IOException | ClassNotFoundException error){
            error.printStackTrace();
        }
    }
}
