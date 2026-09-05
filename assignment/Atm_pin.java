class Validator{
    String p;
    void checkPinLength(String pin){
       p= pin;
         if(p.length()==4){
      System.out.println("PIN length OK.");
       }
       else{
        System.out.println("Invalid PIN -- must be exactly 4 digits. ");
       }
    }};
public class Atm_pin{
    public static void main(String[] args){
        Validator v = new   Validator();
        v. checkPinLength("482");
    }
}