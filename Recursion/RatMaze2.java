package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class RatMaze2 {
    public static void main(String[] args) {
        int mat[][]={{3,1,0,0},{0,1,0,0},{0,1,0,1},{0,1,0,1}};
        int vis[][]=new int[mat.length][mat[0].length];
        List<Pair> list = new ArrayList<>();
        func(0,0,mat.length,mat,vis,0,list);
        Collections.sort(list);
        // for(Pair p:list){
        //     print(p.mat);
        //     System.out.println(p.count);
        // }
        if(list.size()>0){
            print(list.get(0).mat);
            System.out.println(list.get(0).count);
        }
        else{
            System.out.println("No path found");
        }
    }
    static void func(int r,int c,int n,int mat[][],int vis[][],int count,List<Pair> list){
        if(r==n-1 && c==n-1){
            vis[r][c]=1;
            Pair p =new Pair();
            p.setCount(count);
            p.setMat(vis);
            list.add(p);
            // print(vis);
            return;
        }
        if(mat[r][c]!=0){
            vis[r][c]=1;
            for(int i=1;i<=mat[r][c] && (c+i)<n;i++){
                // if(func(r,c+i,n,mat,vis,count++))
                // {
                //     return true;
                // }
                // System.out.println("r="+r+" c="+c+" count="+count);
                func(r,c+i,n,mat,vis,++count,list);
                --count;
            }
            // System.out.println("r2="+r+" c2="+c+" count="+count);
            for(int i=1;i<=mat[r][c] && (r+i)<n;i++){
                // if(func(r+i,c,n,mat,vis,count++)){
                //     return true;
                // }
                // System.out.println("r1="+r+" c1="+c+" count="+count);
                func(r+i,c,n,mat,vis,++count,list);
                --count;
            }
        }
        vis[r][c]=0;
        // return false;
    }
    static void print(int mat[][]){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    static class Pair implements Comparable<Pair>{
        int mat[][];
        int count;

        Pair(){
        }

        public void setCount(int count){
            this.count=count;
        }

        public void setMat(int mat[][]){
            this.mat=new int[mat.length][mat[0].length];
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    this.mat[i][j]=mat[i][j];
                }
            }
        }

        public int compareTo(Pair p){
            return Integer.compare(count, p.count);
        }
    }
}