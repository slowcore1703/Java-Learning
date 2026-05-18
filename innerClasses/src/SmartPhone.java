public class SmartPhone {
    private String model;
    private int charge;
    private boolean isPowerOn = false;
    public SmartPhone(String model,int charge){
        this.model = model;
        this.charge = charge;
    }

    public void pressPowerButton(){
        if(charge == 0){
            System.out.println("Телефон выключен, зарядка 0%");
        }else if(charge > 15 && charge <= 100){
            this.isPowerOn = true;
            System.out.println("Телефон включен");
        }else if(charge > 100) {
            System.out.println("Такое невозможно!");
        }else if(charge >= 1 && charge <= 15){
            this.isPowerOn = true;
            System.out.println("Низкий уровень заряда: " + charge + "% подключите зарядное устройство");
        }else{
            System.out.println("Заряд не может быть отрицательным");
        }
    }

    public class Proccessor {
        private String nameOfProccessor;
        public Proccessor(String nameOfProccessor){
            this.nameOfProccessor = nameOfProccessor;
        }

        public String getNameOfProccessor(){
            return nameOfProccessor;
        }

        public void start(){
            if(isPowerOn){
                System.out.println("Система запущена, обработка данных на процессоре " + getNameOfProccessor() + " пошла...");
            }else{
                System.out.println("Ошибка, телефон не включен");
            }
        }
    }
}
