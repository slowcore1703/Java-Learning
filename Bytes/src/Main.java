import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("picture/png.dat");
        Path source = Paths.get("gopota.jpg");
        try {
            if(Files.notExists(path)){
                Files.createDirectories(path.getParent());
            }
            try(BufferedInputStream out = new BufferedInputStream(Files.newInputStream(source));
                OutputStream dropToFile = Files.newOutputStream(path))
            {
                int byteData;
                int key = 42;
//                int key = 42 - уровень криптографии - шифрование и поломка файла
                while((byteData = out.read()) != -1){
                    dropToFile.write(byteData ^ key);
                }
//                try (InputStream in = Files.newInputStream(source);
//                  OutputStream out = Files.newOutputStream(path)) {
//                  in.transferTo(out); // Одной строчкой: быстро, эффективно, с буферизацией
//}
                System.out.println("Перенос байтов завершен");
            }
        }catch(IOException error){
            System.err.println("Ошибка внутри кода " + error.getMessage());
        }
    }
}