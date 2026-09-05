public class Reversal{
 public String reverseEachWord(String sentence){
     String a [] = sentence.split(" ");
      StringBuilder sb = new StringBuilder(a[1]);
      StringBuilder sc = new StringBuilder(a[2]);
       String b =sb.reverse()
                   .append(" ")
                   .append(sc.reverse())
                   .toString();
       return b;
  }
  public static void main(String[] args){
    Reversal r = new Reversal();
  String n = " hello club";
  System.out.println(r.reverseEachWord(n));
  }
}