public class QuickSort {
    public static void main(String args[]){
        int a[] = {4,7,2,8,3,7,2,9,0,1};
        int pos = 4;
        int key = 20;
        for(int i =a.length-1; i>pos; i--){
                a[i]=a[i-1];
                a[pos]=key;
        }
        for(int q:a){
            System.out.print(q+" ");
        }
    }
}
