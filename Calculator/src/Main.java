import java.lang.Math;
import java.util.Scanner;

public class Main {
    private static boolean isVaild(String choice){
        return choice.equals("+") || choice.equals("-") || choice.equals("*") || choice.equals("/") || choice.equals("sqrt");
    }

    public static void main(String[] args) {
        Scanner inputNumbers = new Scanner(System.in);
        Calculations calc = new Calculations();
        System.out.print("Выберете операцию: +, -, *, /, sqrt: ");
        String choice = inputNumbers.nextLine();
        if(!isVaild(choice)){
            System.out.println("Такой операции нет");
            return;
        }
        if(!choice.equals("sqrt")){
            System.out.print("Введите первое число: ");
            calc.setNumberA(Double.parseDouble((inputNumbers.nextLine())));
            System.out.print("Введите второе число: ");
            calc.setNumberB(Double.parseDouble((inputNumbers.nextLine())));
        }


        switch(choice){
            case "+":
                System.out.println("Результат: " + calc.getPlus());
                break;
            case "-":
                System.out.println("Результат: " + calc.getMinus());
                break;
            case "*":
                System.out.println("Результат: " + calc.getMultiply());
                break;
            case "/":
                System.out.println("Результат: " + calc.getDevision());
                break;
            case "sqrt":
                System.out.print("Введите число для корня: ");
                calc.setSqrt(Double.parseDouble(inputNumbers.nextLine()));
                System.out.println("Результат: " + calc.getSqrt());
                break;
            default:
                System.out.println("Неизвестная или еще не добавленная операция");
        }
    }
}