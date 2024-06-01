package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Nqueen {
    public static void main(String[] args) {
        int n=6;
        int mat[][];
        int q[]=new int[n];
        List<String> s;
        for(int i=0;i<n;i++){
            q[0]=i;
            mat=new int[n][n];
            s=new ArrayList<>();
            mat[0][i]=1;
            s.add(comb(mat[0]));
            // System.out.println("Placing queen 0 at 0 "+s);
            fun(mat,q,1,0,s);
        }
    }
    static void fun(int mat[][],int q[], int k,int pos,List<String> s){
        int i=0;
        boolean placed=false;
        if(pos==-1 && k==0){
            return;
        }
        if(pos==-1){
            mat[k][q[k]]=0;
            i=q[k]+1;
            s.remove(k);
        }
        for(int i1=i;i1<q.length;i1++){
            // System.out.println("Checking "+k+" "+i1);
            if(isValid(mat, k, i1, q.length)){
                // System.out.println("Placing queen "+k+" at "+k+" "+i1);
                mat[k][i1]=1;
                q[k]=i1;
                placed=true;
                break;
            }
        }
        if(placed){
            String s1=comb(mat[k]);
            s.add(s1);
            // System.out.println(s1);
            if(k==q.length-1){
                print(mat);
                for(String s2:s){
                    System.out.println(s2);
                }
                return;
            }
            fun(mat,q,k+1,0,s);
        } else {
            fun(mat,q,k-1,-1,s);
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
}
