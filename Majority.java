public class Majority {
    public static void main(String[] args) {
        int arr[] = {4,5,2,2,1,8};
        int n = arr.length;
        int count = 0;
        int temp=0;
        for(int i =0; i<n; i++){
            count = 0;
            for(int j= i+1; j<n; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count > temp){
                temp = count;
            }
        }
        System.out.println("The majority element  occurs " + temp + " times.");
    }
}