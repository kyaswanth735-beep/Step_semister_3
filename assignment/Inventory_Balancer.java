
class warehouse{
    int []a;
    int []b;
    int total;
    int total1;
    int max;
    int max1;
    void analyzeInventory(int[] sectionA, int[] sectionB){
        a = sectionA;
        b = sectionB;
        max = sectionA[0];
        max1 = sectionB[0];
        for(int i=0;i<a.length;i++){
            total +=a[i];
        }
        for(int i=0;i<b.length;i++){
            total1 +=b[i];
        }
        for(int i=0;i<a.length;i++){
            if(sectionA[i]>max){
                max =sectionA[i];
            }
        }
         for(int i=0;i<b.length;i++){
            if(sectionB[i]>max1){
                max1 =sectionB[i];
            }   
    }
}
void display(){
    StringBuilder result = new StringBuilder();
    if((total==total1)&&(max==max1)){
        result.append("Section A Total:").append(" ").append(total).append(" | ").append("Section B Total: ").append(" ").append(total1).append(" | ").append("Status: Balanced").append(" | ").append(" Highest Quantity:").append(max);
              System.out.println(result);
    }
}
};
public class Inventory_Balancer{
    public static void main(String[] args) {
        warehouse w = new warehouse();
       w.analyzeInventory(new int[]{20,15,30},new int[]{25,10,30});
        w.display();
    }
}