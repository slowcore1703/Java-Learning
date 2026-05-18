import java.nio.file.*;
import java.io.IOException;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Path path = Paths.get("storage/files/back.json");
        System.out.println("Приемник запущен, ожидание поступления данных от пользователя");

        while(true){
            if(Files.exists(path)){
                try(BufferedReader reader = Files.newBufferedReader(path)){
                    String jsonFromFront = reader.readLine();
                    if(jsonFromFront != null){
                        System.out.println("Получен запрос от пользователя: " + jsonFromFront);
                        Files.delete(path);
                        System.out.println("Файл обработан и очищен, ожидание следующего запроса");
                    }
                }catch(IOException error){
                    System.err.println("Ошибка чтения: " + error.getMessage());
                }
            }
            Thread.sleep(500);
        }
    }
}