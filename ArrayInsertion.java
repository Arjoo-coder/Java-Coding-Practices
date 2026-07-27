import java.util.Scanner;

public class ArrayInsertion{
    public static void main(String[] args) {
        int arr[] = new int[5];
        Scanner sc = new Scanner(System.in);
        int n = 5;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            System.out.println(arr[i] + " ");
        }
        sc.close();
    }
}