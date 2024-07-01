package Logical;

import java.util.Arrays;
import java.util.HashMap;

public class SmallestPositive {
    public static void main(String[] args) {
        int a[]={1,2,10,3,11,6,15},s=0,i1=0,i2=0,s1=0;
        int n=a.length;
        for(int i=0;i<n;i++){
            s+=a[i];
        }
        for(int i=1;i<s;i++){
            boolean dp[]=new boolean[i+1];
            dp[0]=true;
            if(!check(a,i,n,dp)){
                System.out.println(i);
                break;
            }
        }
        // for(long i=1;i<s;i++){
        //     HashMap<Long,Boolean> dp=new HashMap<>();
        //     dp.put(Long.parseLong(String.valueOf(0)),true);
        //     if(!check(a,i,n,dp)){
        //         // System.out.println(i);
        //         return i;
        //     }
        // }
        System.out.println(s);
        System.out.println(check(a,49,n,new boolean[s+1]));
        // Arrays.sort(a);
        // for(int i=a[0];i<s;i++){
            
        //     if(i1+1<n && i==a[i1+1]){
        //         System.out.println(i+" "+(i1+1)+" "+a[i1+1]+" "+i2+" "+s1);
        //         i1++;
        //         continue;
        //     } else if(i>a[i1]){
        //         System.out.println(i+" "+i1+" "+a[i1]+" "+i2+" "+s1);
        //         if((i1+1)<n && i>a[i1+1]){
        //             i1++;
        //             continue;
        //         }
        //         i2=i1;
        //         s1=i;
        //     } 
        //     while(s1>0){
        //         if(i2==-1){
        //             System.out.println(i);
        //             break;
        //         }
        //         if(s1>=a[i2]){
        //             s1-=a[i2];
        //         }
        //         i2--;
        //     }
        // }
    }
    static boolean check(int a[],int t,int n,boolean dp[]){
        for(int i:a){
            for(int i1=t;i1>=i;i1--){
                dp[i1]=dp[i1] || dp[i1-i];
            }
        }
        return dp[t];
    }
    static boolean check(long a[],long t,int n,HashMap<Long,Boolean> dp){
        for(long i:a){
            for(long i1=t;i1>=i;i1--){
                dp.put(i1,((null==dp.get(i1)?false:dp.get(i1)==true) || (null==dp.get(i1-i)?false:dp.get(i1-i)==true)));
                // System.out.println(i1+" "+dp.get(i1));
            }
        }
        return dp.get(t)==null ? false : dp.get(t);
    }
    static long approcahFinal(int a[],int n){
        Arrays.sort(a);
        long result = 1;

        // Iterate over the array and update the result
        for (int i = 0; i < n && a[i] <= result; i++) {
            result += a[i];
            // System.out.print(result+" ");
        }

        return result;
    }
}
