package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Nqueen {
    public static void main(String[] args) {
        int n=9;
        int mat[][]=new int[n][n];
        int q[]=new int[n];
        List<String> s=new ArrayList<>();
        fun(mat,q,0,s);
        for(String s1:s){
            System.out.println(s1);
        }

    }
    static void fun(int mat[][],int q[], int k,List<String> s){

        if(k==q.length){
            print(q);
            // store(mat,s);
            return;
        }
        for(int i1=0;i1<q.length;i1++){
            // System.out.println("Checking "+k+" "+i1);
            if(isValid(mat, k, i1, q.length)){
                // System.out.println("Placing queen "+k+" at "+k+" "+i1);
                mat[k][i1]=1;
                q[k]=i1;
                fun(mat,q,k+1,s);
                mat[k][i1]=0;
            }
        }
    }
    static boolean isValid(int mat[][],int m,int n,int k){
        for(int i=0;i<m;i++){
            if(mat[i][n]==1){
                return false;
            }
        }
        // System.out.println("Checking for "+m+" "+n);
        int m1=m-1,n1=n-1;
        while(m1>=0 && n1>=0){
            // System.out.println("Checking "+m1+" "+n1);
            if(mat[m1][n1]==1){
                return false;
            }
            m1--;n1--;
        }
        int m2=m-1,n2=n+1;
        while(m2>=0 && n2<k){
            // System.out.println("Checking "+m2+" "+n2);
            // print(mat);
            if(mat[m2][n2]==1){
                return false;
            }
            m2--;n2++;
        }
        return true;
    }
    static String comb(int[] mat){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<mat.length;i++){
            if(mat[i]==1){
                sb.append("Q");
            }else{
                sb.append(".");
            }
        }
        return sb.toString();
    }
    static void print(int mat[][]){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    static void store(int mat[][],List<String> s){
        for(int i=0;i<mat.length;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<mat[0].length;j++){
                sb.append(mat[i][j]==0?".":"Q");
            }
            s.add(sb.toString());
        }
    }
}
