package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class IndexesOfSubarray {
    public static void main(String[] args) {
        int arr[]={6, -2, -3, 6, -5, 2, -3, -5, 0, 2, -3, 6, -4, 9, 8 };
        int n=15;
        List<Integer> a=func(arr,n);
        System.out.println(a);
    }
    static ArrayList<Integer> func(int arr[],int n){
        int s1=0,s2=0;
        boolean f=false;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                f=true;
                s1=s2=i;
                break;
            }
            int s=arr[i];
            for(int j=i+1;j<n;j++){
                s+=arr[j];
                // System.out.print(s+" ");
                if(s==0){
                    f=true;
                    s1=i;s2=j;
                    break;
                }
            }
            // System.out.println();
            if(f==true){
                break;
            }
        }
        int i1=0;
        int sum=0;
        for(int j=i1;j<n;j++){
            sum+=arr[j];
            if(sum==0){
                s1=i1;s2=j;
                break;
            }
            if(j==n-1){
                i1++;
                j=i1;
                sum=arr[i1];
            }
        }
        // return f==true?new ArrayList<>(List.of(s1+1,s2+1)):new ArrayList<>(List.of());
        return new ArrayList<>(List.of(s1+1,s2+1));
    }
}
