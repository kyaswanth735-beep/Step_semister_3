import java.util.Scanner;
class Seat{
    int seatnumbers;
    int b = -1;
    void checkDuplicateSeats(int[] seatnumbers){
        for(int i=0;i<seatnumbers.length;i++){
            for(int j = i+1;j<seatnumbers.length;j++){
                if(seatnumbers[i] == seatnumbers[j]){
                    System.out.println("Duplicate Seat Number Found : " + seatnumbers[i]);
                }
          else{
        System.out.println("No Duplicate Seats Found");
          }
            }
        }
    }
};
public class duplicate{
    int seatnumbers;
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
int seatnumbers[] = new int[5];
 System.out.println("Enter Seat Numbers :");
for(int i =0;i<seatnumbers.length;i++){
   seatnumbers[i] = sc.nextInt();
}
Seat s = new Seat();
s.checkDuplicateSeats(seatnumbers);
}
}