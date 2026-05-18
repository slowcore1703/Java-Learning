import java.io.*;

public class Main {
    public static void main(String[] args) {
        Pc myPc = new Pc(150000, "HighModel X5");
        Pc myPc1 = new Pc(90000, "middleEnd X5");
        Pc myPc2 = new Pc(50000, "lowEnd X5");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save_pc.txt"))){
            oos.writeObject(myPc);
            System.out.println("Готово");
        }catch(IOException error){
            System.out.println("Ошибка при сохранении " + error.getMessage());
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save_pc.txt"))){
            Pc restoredPc = (Pc) ois.readObject();

            System.out.println("Объект десериализован");
            System.out.println(restoredPc);
        }catch(IOException | ClassNotFoundException error){
            error.printStackTrace();
        }



        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("save_pc1.txt"))){
            out.writeObject(myPc1);
            System.out.println("Файл готов");
        }catch(IOException error){
            System.out.println(error.getMessage());
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("save_pc1.txt"))){
            Pc restoredPc = (Pc) in.readObject();
            System.out.println(restoredPc);
        }catch(IOException | ClassNotFoundException error){
            error.printStackTrace();
        }



        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("save_pc2.txt"))){
            out.writeObject(myPc2);
            System.out.println("Файл создан в третий раз");
        }catch(IOException error){
            error.getMessage();
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("save_pc2.txt"))){
            Pc restoredPc = (Pc) in.readObject();
            System.out.println(restoredPc);
        }catch(IOException | ClassNotFoundException error){
            error.printStackTrace();
        }
    }
}