import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Main {
    public static void main(String[] args) {
       Path dataFile = Paths.get("Data/Modules/Files/data.dat");
       Path localDir = Paths.get("NewData/Modules/newFiles");
       String text = "Напоминание темы и повторение прошлых уроков";
       try {
           if(Files.notExists(dataFile)){
               Files.createDirectories(dataFile.getParent());
           }
           if(Files.notExists(localDir)){
               Files.createDirectories(localDir);
           }

           try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(dataFile))){
               out.writeObject(text);
               System.out.println("Файл сериализован и добавлен");
           }

           try(OutputStream out = Files.newOutputStream(dataFile);
                GZIPOutputStream gzip = new GZIPOutputStream(out);
                ObjectOutputStream lastOut = new ObjectOutputStream(gzip))
           {
               lastOut.writeObject(text);
               System.out.println("Файл сжат");
           }

           Path copyToLocalDir = localDir.resolve("backup.dat");
           Files.copy(dataFile, copyToLocalDir, StandardCopyOption.REPLACE_EXISTING);
           System.out.println("сжатый файл скопирован и добавлен в новый путь");
       }catch(IOException error){
           error.printStackTrace();
       }

//       Чтение сжатого файла

        try(InputStream in = Files.newInputStream(dataFile);
            GZIPInputStream inGzip = new GZIPInputStream(in);
            ObjectInputStream inRead = new ObjectInputStream(inGzip))
        {
            String restoreFile = (String) inRead.readObject();
            System.out.println("Расшифровка: " + restoreFile);
        }catch(IOException | ClassNotFoundException error){
            error.printStackTrace();
        }
    }
}