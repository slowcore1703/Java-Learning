public class Buyer {
    private String fullName;
    private int wallet;
    public Buyer(String fullName,int wallet){
        this.fullName = fullName;
        this.wallet = wallet;
    }
    public String getFullName(){
        return fullName;
    }
    public int getWallet(){
        return wallet;
    }

    public void setWallet(int wallet){
        this.wallet = wallet;
    }
}
