class traffic{
    String s;
    char maxchar;
    int maxcount =0;
      int count [] = new int[256];
    void findLongestStreak(String signalLog){
        s=signalLog;
        maxchar =' ';
        maxcount =0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            count[c]++;
            if(count[c]>maxcount){
                maxcount = count[c];
                maxchar = c;
            }
        }
    }
    void display(){
        StringBuilder result = new StringBuilder();
     result.append("Longest Streak:")
           .append(" '")
           .append(maxchar)
           .append("' repeated ")
           .append(maxcount)
           .append(" Times ");
         System.out.println(result);
    }
};
public class Streak_Analyzer{
    public static void main(String[] args){
        traffic t = new traffic();
        t.findLongestStreak("RRRRYYGG");
        t.display();
    }
}