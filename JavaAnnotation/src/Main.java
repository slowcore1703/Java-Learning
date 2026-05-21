import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args){
        Calc calc = new Calc();
        int result1 = calc.add(5,5);
        System.out.println("Результат нового метода: " + result1);
        System.out.println("\n");

        Class<?> clazz = calc.getClass();
        for(Method method : clazz.getDeclaredMethods()){
            if(method.isAnnotationPresent(Todo.class)){
                Todo annotation = method.getAnnotation(Todo.class);

                System.out.println("Найдена задача в методе: " + method.getName() + " " + annotation.value());
            }
        }
    }
}
