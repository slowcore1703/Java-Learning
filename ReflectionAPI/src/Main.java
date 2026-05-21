import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args){
        SecretUser secretUser = new SecretUser();
        Class<?> hacking = secretUser.getClass();
        try {
            Field hiddenField = hacking.getDeclaredField("userName");
            hiddenField.setAccessible(true);

            String value = (String) hiddenField.get(secretUser);
            System.out.println("Получено имя: " + value);

            hiddenField.set(secretUser, "John");
            System.out.println("Новое имя: " + hiddenField.get(secretUser));

        }catch (NoSuchFieldException error){
            System.err.println("Ошибка поиска полей или логики внутри блока: " + error.getMessage());
            error.printStackTrace();
        }catch(Exception error){
            error.printStackTrace();
        }
        System.out.println("\n");
        try {
            Method hiddenMethod = hacking.getDeclaredMethod("getPassword");
            hiddenMethod.setAccessible(true);

            String password = (String) hiddenMethod.invoke(secretUser);
            System.out.println("Полученный пароль: " + password);
        }catch(NoSuchMethodException error){
            System.err.println("Метод не найден: " + error.getMessage());
        }catch(Exception error){
            error.printStackTrace();
        }
        System.out.println("\n");

        try {
            Method hiddenMethod = hacking.getDeclaredMethod("Plus");
            hiddenMethod.setAccessible(true);
            System.out.println("Начинаем читать метод:");
            hiddenMethod.invoke(secretUser);

        }catch(NoSuchMethodException error){
            error.printStackTrace();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}