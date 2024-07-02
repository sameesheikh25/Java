package Logical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RemoveStudents {
    public static void main(String[] args) {
        int a[]={1, 1, 2, 3, 1,1,5,4,6,7};
        int n=a.length;
        ArrayList<Integer> arr=new ArrayList<>();
        ArrayList<Integer> b=new ArrayList<>();
        int dp[][]=new int[n][n+1];
        // System.out.println(n-removeStudents(a,0,-1,n,dp));
        // System.out.println(Collections.max(arr));
        int n1=Collections.binarySearch(Arrays.stream(a).boxed().toList(), 4);
        // System.out.println(-(n1+1));
        System.out.println(removeStudents(a));
        // print(dp);
    }
    static void removeStudents(int a[],ArrayList<Integer> b,int i1,int n,ArrayList<Integer> arr){
        if(i1==n){
            if(b.size()>1 && check(b)){
                System.out.println(b);
                arr.add(b.size());
            }
            return;
        }
        b.add(a[i1]);
        removeStudents(a,b, i1+1, n, arr);
        b.remove(b.size()-1);
        removeStudents(a, b, i1+1, n, arr);
    }
    static int removeStudents(int a[],int ind,int prev,int n,int dp[][]){
        if(ind==n){
            return 0;
        }
        if(prev!=-1 && dp[ind][prev+1]!=0){
            return dp[ind][prev+1];
        }
        dp[ind][prev+1]=removeStudents(a, ind+1, prev, n, dp);
        if(prev == -1 || a[ind]>a[prev]){
            dp[ind][prev+1]=Integer.max(dp[ind][prev+1],1+removeStudents(a, ind+1, ind, n, dp));
        }
        // dp[ind][prev+1]= Integer.max(dp[ind][prev+1],removeStudents(a, ind+1, prev, n, dp));
        return dp[ind][prev+1];
    }
    static int removeStudents(int a[]){
        ArrayList<Integer> arr=new ArrayList<>();
        for(int n:a){
            if(arr.isEmpty() || arr.get(arr.size()-1)<n){
                arr.add(n);
            } else {
                int i=Collections.binarySearch(arr, n);
                if(i<0){
                    i=-(i+1);
                }
                arr.set(i,n);
            }
        }
        return arr.size();
    }
    static boolean check(ArrayList<Integer> a){
        for(int i=0;i<a.size()-1;i++){
            if(a.get(i)>=a.get(i+1))
                return false;
        }
        return true;
    }
    static void print(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
