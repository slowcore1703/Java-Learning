public class Calculations implements Calc {
    private double a;
    private double b;
    private double c;

    public void setNumberA(double a){
        this.a = a;
    }

    public void setNumberB(double b){
        this.b = b;
    }

    public void setSqrt(double c){
        this.c = c;
    }

    @Override
    public double getPlus(){
        return a + b;
    }

    @Override
    public double getMinus(){
        return a - b;
    }

    @Override
    public double getMultiply(){
        return a * b;
    }

    @Override
    public double getDevision(){
        if(b == 0) throw new ArithmeticException("Деление на ноль запрещенно");
        return a / b;
    }

    @Override
    public double getSqrt(){
        return Math.sqrt(c);
    }
}
