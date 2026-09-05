class  Movie_Review{
    String r;
    int a,b,c;
    void classifyWordLengths(String review){
        r = review;
        String[] words = review.split(" ");
        for(int i=0;i<words.length;i++){
                if(words[i].length()<=4){
                    a++;
                }
                else if(words[i].length()<=7){
                    b++;
                }
                else {
                    c++;
                }
            }
        }
    void display(){
     StringBuilder result =new StringBuilder();
     result.append("Short:").append(" ").append(a).append(" | ").append(" Medium: ").append(b).append(" | ").append("Long: ").append(c);
     System.out.println(result);
    }
};
public class Word_Length{
    public static void main(String[] args){
    Movie_Review m =new Movie_Review();
    m.classifyWordLengths("This movie was absolutely fantastic and thrilling");
    m.display();
    }
}