package Greedy;

public class Minjumps {
    public static void main(String[] args) {
        int arr[] = {1,3,4,8,9,2,6,7,6,8,9};
        int c=0;
        int size=arr.length;
        int s1=size;
        int i1=0;
        int jump =0;
        if(size==1) {
            System.out.println(c);
            return;
        }
        for(int i=0;i<size;i++){
            jump=arr[i];
            s1=size-i-1;
            if(jump==0 || jump>=s1){
                c++;
                break;
            }
            int max=-1;
            for(int j=i+1;j<(i+jump+1) && j<size;j++){
                if((arr[j]+(j-i))>max){
                    max=arr[j]+(j-i);
                    i1=j;
                }
            }
            i=i1-1;
            c++;
        }
        if(jump<s1){
            c=-1;
        }
        System.out.println(c);
    }
}
