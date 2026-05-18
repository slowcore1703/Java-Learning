import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Shop> list = new ArrayList<>();
    private static final Object lock = new Object();

    public static void main(String[] args) {
        list.add(new Shop("RTX5090", 320000));
        final boolean ACCESS = true;
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            System.out.println("Сервак запущен...");

            while (ACCESS) {

                Socket client = serverSocket.accept();
                System.out.println("Клиент зашел!");

                new Thread(() -> {
                    try (ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
                         InputStream in = client.getInputStream()) {
                        int command = in.read();

                        if (command == 1) {
                            synchronized (lock) {
                                out.writeObject(list);
                                out.flush();
                                System.out.println("Поток отправил список и вышел из Object lock");
                            }
                        } else if (command == 2) {
                            out.writeObject("Привет=)");
                        } else out.writeObject("упс...не туда нажал!");
                    } catch (IOException error) {
                        error.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
