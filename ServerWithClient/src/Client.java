import java.io.*;
import java.net.Socket;
import java.nio.file.Files;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",8081);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())))
        {
            System.out.println("Жду ответа от сервера...");
            String line = reader.readLine();
            System.out.println("Сообщение с сервера: " + line);
        }catch(IOException error){
            System.err.println("Ошибка на серваке " + error.getMessage());
        }
    }
}
