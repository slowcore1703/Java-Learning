public class Main2 {
    public static void main(String[] args) {
        User[] user = new User[5];
        user[0] = new User1();
        user[1] = new User2();
        user[2] = new User3();
        user[3] = new User4();
        user[4] = new User5();
        System.out.println("Запрет на регистрацию для пользователей: ");
        for (User users : user) {
            Class<?> userClass = users.getClass();
            BanRegestration annotation = userClass.getAnnotation(BanRegestration.class);
            if (annotation != null) {
                System.out.print(userClass.getSimpleName() + ":");
                for (Days day : annotation.days()) {
                    System.out.println(day);
                }
            } else System.out.println("Аннотаций нет для объектов: " + users.getClass().getSimpleName());
        }
        System.out.println("\n");

        System.out.println("Перечисление const enum:");
        for (Days day : Days.values()) {
            System.out.println(day);
        }
    }
}
