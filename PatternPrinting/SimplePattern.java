package PatternPrinting;

public class SimplePattern {
    public static void main(String agrs[]){
        int n = 4;
        for(int i =n; i>=1; i--){
            for(int j=i; j>=1; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }  
}
