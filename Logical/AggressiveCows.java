package Logical;

import java.util.Arrays;

public class AggressiveCows{
    public static void main(String[] args) {
        int a[]={3,4,7,8,9,10,14,11,6,13,19},k=10;
        int n=a.length;
        Arrays.sort(a);
        int l=1,r=a[n-1],max=0;
        while(l<=r){
            int mid=(l+r)/2;
            System.out.println(l+" "+r+" "+mid);
            if(check(a,mid,k)){
                max=Integer.max(max,mid);
                l=mid+1;
            } else {
                r=mid-1;
            }
        }
        System.out.println(max);
    }
    static boolean check(int a[],int k,int c1){
        int c=1,m=a[0]+k;
        if(c1==1){
            return true;
        }
        for(int i=0;i<a.length;i++){
            if(a[i]>=m){
                c++;
                if(c1==c){
                    return true;
                } else if(c1<c){
                    return false;
                }
                m=a[i]+k;
            }
        }
        // System.out.println(c+" "+c1+" "+k);
        return false;
    }
}