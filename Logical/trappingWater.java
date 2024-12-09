package Logical;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class trappingWater {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int a[]={0,1,0,2,1,0,1,3,2,1,2,1};
        HashSet<Integer> arr=new HashSet<>();
        for(int a1:a){
            arr.add(Integer.valueOf(a1));
        }
        // System.out.println(arr);
        List<Integer> arr1=new ArrayList<>(arr);
        List<Integer> arr2 = arr1.stream().sorted().toList();
        int m=trap(a,arr2);
        System.out.println(m);
    }
    static int trap(int a[],List<Integer> arr){
        int n=0;
        int b[]=new int[a.length];
        Integer k1=-1;
        for(int i=0;i<arr.size();i++){
            // System.out.println(arr.get(i));
            if(i>0){
                k1=arr.get(i-1);
            }
            Integer k=arr.get(i);
            // System.out.println("k="+k);
            for(int j=0;j<b.length;j++){
                if(a[j]>=k){
                    b[j]=k;
                }
                if(i>0 && a[j]<k){
                    b[j]=k1;
                }
            }
            n+=calculate(b,k);
        }
        return n;
    }
    static int calculate(int a[],int k){
        int c=0,n=a[0],i1=-1;
        // print(a);
        for(int i=0;i<a.length;i++){
            if(a[i]==k && i1==-1){
                i1=i;
            } else if(a[i]==k && i-i1>1){
                for(int j=i1+1;j<i && j<a.length;j++){
                    c+=k-a[j];
                }
                // System.out.println("i="+i+"i1="+i1+"c="+c);
                i1=i;
            } else if(a[i]==k){
                i1=i;
            }
        }
        // System.out.println("c="+c);
        return c;
    }
    static void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
