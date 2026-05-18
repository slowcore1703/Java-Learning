import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

public class Client implements Serializable {
    public static void main(String[] args) {
        System.out.println("Жду сервак...");
        try(Socket socket = new Socket("localhost", 8081);
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream()))
        {
            ArrayList<Shop> list = (ArrayList<Shop>) in.readObject();
            for(Shop show : list){
                System.out.println("Пришло от сервера: " + show);
            }
        }catch(IOException | ClassNotFoundException error){
            error.getMessage();
        }
    }
}
