package Recursion;

import java.util.Arrays;

public class CoinsChange {
    public static void main(String[] args) {
        int sum=10;
        int arr[]={2,5,3,6};
        int ways[]=new int[sum+1];
        Arrays.sort(arr);
        ways[0]=1;
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<sum+1;j++){
                if(j>=arr[i])
                    ways[j]=ways[j-arr[i]]+ways[j];
            }
        }
        for(int i=0;i<ways.length;i++){
            System.out.print(ways[i]+" ");
        }
    }
}
