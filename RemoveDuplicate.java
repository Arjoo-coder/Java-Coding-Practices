public class RemoveDuplicate {
    public static void main(String args[]){
        int arr[] = {15,19,4,6,12,7,4,10,18,76};
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                else{
                    System.out.println("Array is sorted");
                    break;
                }
            }
        }
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
