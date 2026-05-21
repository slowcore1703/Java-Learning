public class SecretUser {
    private String userName = "Bob";
    private String password = "password123";
    private String city = "Moscow";

    private String getUserName(){
        return userName;
    }
    private String getPassword(){
        return password;
    }
    private String getCity(){
        return city;
    }

    private void Plus(){
        int a = 10 + 10;
        System.out.println("Ура логика выполнена: " + a);
    }
}
