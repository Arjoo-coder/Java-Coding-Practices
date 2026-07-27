public class SecondLargestInArray {
    public static void main(String args[]){

        int arr[]= {15,19,4,6,12,7,4,10,18,76};
        int largest = 0;
        int secondLargest = 0;
        int thirdLargest = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>largest){
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = arr[i];
            }
            if(arr[i]<largest && arr[i]>secondLargest){
                secondLargest = arr[i];
            }
            if(arr[i]<secondLargest && arr[i]>thirdLargest){
                thirdLargest = arr[i];
            }
        }
        System.out.println("1st Largest:"+ largest);
        System.out.println("2nd Largest:"+ secondLargest);
        System.out.println("3rd Largest:"+ thirdLargest);

    }
}