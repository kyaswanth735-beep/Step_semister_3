class typingspeed{
    String o;
    String t;
   int match =0;
   char ch;
   char ch1;
   int a;
   float a_p1;
   float a_p2;
     void checktypingaccuracy(String original, String typed){
        o = original;
        t = typed;
        for(int i=0;i <o.length();i++){
                if(o.charAt(i)==t.charAt(i)){
                    match++;
                }
                else if(o.charAt(i)!=t.charAt(i)){
                ch =o.charAt(i);
                ch1 =t.charAt(i);
                  a =i;
                }
                else{
                    System.out.println("Invalid input");
                }}
            a_p1 = ((float) (match) / o.length()) * 100;
            a_p2 = ((float) (match -a) / o.length()) * 100;
     }
     void display(){
        StringBuilder result = new StringBuilder();
        if( match ==o.length()){
             result.append("Matched :").append(match).append("/").append(o.length()).append(" | ").append("Accuracy :").append(a_p2).append("%").append(" | ").append(" No Mismatches ");
             System.out.println(result);
        }
        
        else if (match!=o.length()){
        result.append("Matched :").append(match).append("/").append(o.length()).append(" | ").append("Accuracy :").append(a_p1).append("%").append(" | ").append("First Mismatch at position ").append(a).append(" ").append("'").append(ch).append("' vs '").append(ch1).append("'");
       System.out.println(result); }
         else{
             System.out.println("Invalid Input");
         }
     }
};
public class Accurary_Checker{
public static void main(String[] args){
    typingspeed ts = new typingspeed();
    ts.checktypingaccuracy("hello world","hello world");
    ts.display();
}
}
