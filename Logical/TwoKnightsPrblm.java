package Logical;

import java.util.ArrayList;
import java.util.List;

public class TwoKnightsPrblm {
    public static void main(String[] args) {
        ArrayList<Integer> l1=new ArrayList<>(List.of(1,1,2));
        ArrayList<Integer> l2=new ArrayList<>(List.of(2,3,4,2,2,4));
        ArrayList<Integer> l3=new ArrayList<>(List.of(2,3,4,3,4,6,4,6,8));
        int n=59,m=30;
        long mat[][]=new long[n][m];
        if(n==1){
            // if(m==1){
            //       System.out.println(1);
            // } else {
                System.out.println(m*(m-1));
            // }
        } else if(n==2){
            if(m==2){
                System.out.println(12);
            }
            getPosCount1(n,m,l1,mat);
        } else if(n==3){
            if(m==3){
                System.out.println(56);
            }
            getPosCount1(n, m, l2, mat);
        } else {
            getPosCount1(n, m, l3, mat);
        }
        System.out.println(count(n,m,mat));
    }
    static void getPosCount1(long n,long m,ArrayList<Integer> l,long arr[][]){
        int c=0,c1=0;
        if(n==2) {
            if(m==2){
                return;
            }
            long m1=m%2==0 || m<4?m/2:m/2+1;
            for(long j=0;j<m1;j++){
                arr[0][(int)j]=l.get(c);
                if(c<2){
                    c++;
                }
            }
        }
        if(n==3){
            if(m==3){
                return;
            }
            int n1=2;
            long m1=m%2==0 || m<4?m/2:m/2+1;
            for(int i=0;i<n1;i++){
                if(i==1){
                    c1=c1+3;
                    c=c1;
                }
                for(long j=0;j<m1;j++){
                    // System.out.println("c="+c);
                    arr[i][(int)j]=l.get(c);
                    if(c<c1+2){
                        c++;
                    }
                }
            }
        }
        if(n>=4){
            long n1=n%2==0?n/2:n/2+1;
            long m1=m%2==0?m/2:m/2+1;
            for(long i=0;i<n1;i++){
                for(long j=0;j<m1;j++){
                    arr[(int)i][(int)j]=l.get(c);
                    if(c<c1+2){
                        c++;
                    }
                    if(j==m1-1 && i<2){
                        c1=c1+3;
                        c=c1;
                    }
                    if(j==m1-1 && i>=2){
                        c=c1;
                    }
                }
            }
        }
        print(arr);
    }
    static long count(long n,long m, long arr[][]){
        long k=(n*m)-1,c1=0,c2=0,c3=0,c4=0;
        long n1=n/2;
        long m1=m/2;
        for(long i=0;i<n1;i++){
            for(long j=0;j<m1;j++){
                c1+=(k-arr[(int)i][(int)j]);
            }
        }
        if(n%2==1){
            long n2=(n/2);
            for(long j=0;j<m1;j++){
                c2+=(k-arr[(int)n2][(int)j]);
            }
        }
        if(m%2==1){
            long m2=(m/2);
            for(long j=0;j<n1;j++){
                c3+=(k-arr[(int)j][(int)m2]);
            }
        }
        if(n%2==1 && m%2==1){
            long n2=(n/2);
            long m2=(m/2);
            c4+=(k-arr[(int)n2][(int)m2]);
        }
        System.out.println(c1+" "+c2+" "+c3+" "+c4);
        return (4*c1)+(2*(c2+c3))+c4;
    }
    static void print(long mat[][]){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
