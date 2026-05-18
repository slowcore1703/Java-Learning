public class Main {
    public static void main(String[] args) {
        SmartPhone iphone = new SmartPhone("iphone", 75);
        SmartPhone.Proccessor cpu = iphone.new Proccessor("M4");
        iphone.pressPowerButton();
        cpu.start();
    }
}