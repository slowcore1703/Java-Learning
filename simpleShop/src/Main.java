import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner choice = new Scanner(System.in);

        Buyer gamer = new Buyer("Иванов Сергей Владимирович",100000);
        Shop gamePc1 = new Shop("Сборка №1", 50000, 3);
        Shop gamePc2 = new Shop("Сборка №2", 70000, 3);
        Shop gamePc3 = new Shop("Сборка №3", 95000, 3);

        ArrayList<Shop> listOfPc = new ArrayList<>();
        listOfPc.add(gamePc1);
        listOfPc.add(gamePc2);
        listOfPc.add(gamePc3);

        System.out.print("Показать сборки? 1.Да 2.Выход: ");
        int show = choice.nextInt();
        switch(show){
            case 1:
                for(Shop s : listOfPc){
                System.out.println(s.getAssemblyName() +  " Цена " + s.getPrice());
            }
                break;
            case 2: return;
        }

        System.out.print("Какую выбираем: ");
        int choiceOfBuyer = choice.nextInt();
        if (choiceOfBuyer > 0 && choiceOfBuyer <= listOfPc.size()) {
            Shop selected = listOfPc.get(choiceOfBuyer - 1);

            if (gamer.getWallet() >= selected.getPrice()) {

                gamer.setWallet(gamer.getWallet() - selected.getPrice());
                selected.setQuantity(selected.getQuantity() - 1);


                try(BufferedWriter bill = new BufferedWriter(new FileWriter("bill.txt", true))) {
                    bill.write("Покупатель: " + gamer.getFullName() + " купил: " + selected.getAssemblyName());
                    bill.newLine();
                    System.out.println("Покупка прошла! Остаток: " + gamer.getWallet());
                } catch(IOException e) {
                    System.out.println("Ошибка печати: " + e.getMessage());
                }
            } else {
                System.out.println("Бро, не хватает денег!");
            }
        }
    }
}


// switch (choiceOfBuyer){
//            case 1:
//                try(BufferedWriter bill = new BufferedWriter(new FileWriter("bill1.txt",true))){
//                    int pc1 = gamer.getWallet() - gamePc1.getPrice();
//                    int countOfPc1 = gamePc1.getQuantity();
//                    countOfPc1--;
//                    gamer.setWallet(pc1);
//                    System.out.println("Успешная покупка, остаток на счёте " + gamer.getWallet());
//                    System.out.println("Количество сборок №1: " + countOfPc1);
//                    System.out.println("Чек распечатан, заберите его в папке");
//                    bill.write("Название: " + gamePc1.getAssemblyName() + " Цена: " + gamePc1.getPrice());
//                }catch(IOException error){
//                    System.out.println("Ошибка распечатки чека " + error.getMessage());
//                }
//                break;
//
//            case 2:
//                try(BufferedWriter bill = new BufferedWriter(new FileWriter("bill2.txt",true))){
//                    int pc2 = gamer.getWallet() - gamePc2.getPrice();
//                    int countOfPc2 = gamePc1.getQuantity();
//                    countOfPc2--;
//                    gamer.setWallet(pc2);
//                    System.out.println("Успешная покупка, остаток на счёте " + gamer.getWallet());
//                    System.out.println("Количество сборок №2: " + countOfPc2);
//                    System.out.println("Чек распечатан, заберите его в папке");
//                    bill.write("Название: " + gamePc2.getAssemblyName() + " Цена: " + gamePc2.getPrice());
//                }catch(IOException error){
//                    System.out.println("Ошибка распечатки чека " + error.getMessage());
//                }
//                break;
//            case 3:
//                try(BufferedWriter bill = new BufferedWriter(new FileWriter("bill3.txt",true))){
//                    int pc3 = gamer.getWallet() - gamePc3.getPrice();
//                    int countOfPc3 = gamePc3.getQuantity();
//                    countOfPc3--;
//                    gamer.setWallet(pc3);
//                    System.out.println("Успешная покупка, остаток на счёте " + gamer.getWallet());
//                    System.out.println("Количество сборок №3: " + countOfPc3);
//                    System.out.println("Чек распечатан, заберите его в папке");
//                    bill.write("Название: " + gamePc3.getAssemblyName() + " Цена: " + gamePc3.getPrice());
//                }catch(IOException error){
//                    System.out.println("Ошибка распечатки чека " + error.getMessage());
//                }
//                break;
//            default:
//                System.out.println("Ошибка");
//                return;
//        }