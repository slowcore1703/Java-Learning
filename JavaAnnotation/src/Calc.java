public class Calc {

    public int add(int a, int b){
        return a+b;
    }

    @Todo("Надо переписать метод, чтобы он работал со списком чисел")
        public int sumSeveralNumbers(){
        return 0;
    }

    @Todo("Добавить валидацию чтобы нельзя было делить на ноль")
    public double divide(double a, double b){
        return a / b;
    }

    @Todo
    public int multiply(int a, int b){
        return a*b;
    }
}
