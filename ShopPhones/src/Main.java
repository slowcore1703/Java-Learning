import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Phone iphone = new Phone("Iphone 15 pro max", "Apple A17 Pro",8, 100000);
        Phone samsung = new Phone("Samsung Galaxy s25 Ultra", "SnapDragon8",12, 130000);
        Phone xiaomi = new Phone("Xiaomi 15 Ultra", "SnapDragon8",16, 190000);

        Phone[] massiveOfPhones = new Phone[3];
        massiveOfPhones[0] = iphone;
        massiveOfPhones[1] = samsung;
        massiveOfPhones[2] = xiaomi;
        boolean isRunning = true;
        int walletClient = 1000000;
        while(isRunning) {
            System.out.print("1 - зайти в магазин, 2 - выход: ");
            int enter = input.nextInt();
            if (enter == 1) {
                System.out.println("Добро пожаловать!");
                System.out.print("Выберите цифру взависимости от ваших потребностей: 1.Посмотреть список телефонов 2.Консультация с сотрудником 3.Выход: ");
                int choice = input.nextInt();

                if (choice == 1) {
                    for (int i = 0; i < massiveOfPhones.length; i++) {
                        System.out.println("№:" + i + " " + massiveOfPhones[i].getModelName());
                    }
                    System.out.print("Под каким номером телефон вам приглянулся?: ");
                    int choicePhone = input.nextInt();
                    if (choicePhone >= 0 && choicePhone < massiveOfPhones.length) {
                        System.out.println("Прекрасный выбор! ваш телефон: ");
                        Phone selectPhone = massiveOfPhones[choicePhone];
                        System.out.println(selectPhone.getModelName());
                    } else {
                        System.out.println("Извините, телефона с таким номером у нас нет");
                    }

                    System.out.print("Подтвердите покупку нажав 1 - оплатить или 2 - выход: ");
                    int confirm = input.nextInt();
                    if (confirm == 1 && walletClient >= massiveOfPhones[choicePhone].getPrice()) {
                        System.out.println("Покупка оплачена");
                        walletClient -= massiveOfPhones[choicePhone].getPrice();
                    } else if (confirm == 2) {
                        System.out.println("Покупка отменена");
                    } else {
                        System.out.println("Недостаточно средств");
                    }

                } else if (choice == 2) {
                    System.out.println("Принято, пожалуйста присайживайтесь, консультант к вам подойдет");
                } else if (choice == 3) {
                    System.out.println("До свидания!");
                    isRunning = false;
                } else {
                    System.out.print("Неккоретный ввод");
                }

            } else if (enter == 2) {
                System.out.println("До свидания!");
                isRunning = false;
            } else {
                System.out.println("Ввод некорректного значения, попробуйте еще раз");
            }
        }
    }
}
