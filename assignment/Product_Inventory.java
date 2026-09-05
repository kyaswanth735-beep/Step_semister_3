class CSV_Parser{
    String c;
    String words;
    void parseInventoryRecord(String csvLine) {
        c = csvLine;
        String [] words = c.split(",");
        StringBuilder result = new StringBuilder();
    if(words.length==3){
    result.append("Product: ").append(words[0]).append(" | ").append("SKU: ").append(words[1]).append(" | ").append("Qty: ").append(words[2]);
    System.out.println(result);
}
else{
    System.out.println("Invalid Record");
}
    }
};
public class  Product_Inventory{
    public static void main(String[] args){
    CSV_Parser  p = new CSV_Parser();
    p.parseInventoryRecord("Wireless Mouse,WM-2201,150");
}
}