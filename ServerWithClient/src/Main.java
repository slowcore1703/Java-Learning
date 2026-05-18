import java.io.*;
import java.nio.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String text = "Привет я сервер!";
        Path path = Paths.get("storage/data/data.dat");

        try{
            if(Files.notExists(path)){
                Files.createDirectories(path.getParent());
            }
            try(OutputStream out = Files.newOutputStream(path)){
                byte[] message = text.getBytes();
                out.write(message);
                try(InputStream in = Files.newInputStream(path)){
                    int byteData;
                    while((byteData = in.read()) != -1){
                        System.out.println("Отправлено байтов в файл образующих текст: " + byteData);
                    }
                }
            }
        }catch(IOException error){
            error.getMessage();
        }

        try(ServerSocket serverSocket = new ServerSocket(8081)){
            System.out.println("Сервер запущен");
            while(true){
                try(Socket client = serverSocket.accept();
                    PrintWriter print = new PrintWriter(client.getOutputStream(),true))
                {
                   List<String> list = Files.readAllLines(path);
                   print.println(list);
                }catch(IOException error){
                    error.getMessage();
                }
            }
        }catch(IOException error){
            System.err.println("Ошибка подключения сервера " + error.getMessage());
        }
    }
}