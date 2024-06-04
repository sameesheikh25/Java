package Recursion;

import java.util.ArrayList;

public class Ratmaze {
    public static void main(String[] args) {
        int mat[][]={{1, 0},
        {1, 0}};
        boolean v[][]=new boolean[4][4];
        ArrayList<String> res=new ArrayList<>();
        v[0][0]=true;
        ratmaze(mat,0,0,1,1,v,"",res);
        if(res.size()==0){
            System.out.println("No path found");
            return;
        }
        for(String s:res){
            System.out.println(s);
        }
    }
    static void ratmaze(int mat[][],int s1,int s2,int d1,int d2,boolean v[][],String s,ArrayList<String> res){
        // System.out.println(s1+" "+s2);
        if(s1==d1 && s2==d2){
            res.add(s);
            return;
        }
        if(mat[s1][s2]==0){
            res.add("-1");
            return;
        }
        if(s1+1<mat.length && mat[s1+1][s2]==1 && !v[s1+1][s2]){
            v[s1+1][s2]=true;
            ratmaze(mat,s1+1,s2,d1,d2,v,s+"D",res);
            v[s1+1][s2]=false;
        }
        if(s1-1>=0 && mat[s1-1][s2]==1 && !v[s1-1][s2]){
            v[s1-1][s2]=true;
            ratmaze(mat,s1-1,s2,d1,d2,v,s+"U",res);
            v[s1-1][s2]=false;
        }
        if(s2+1<mat[0].length && mat[s1][s2+1]==1 && !v[s1][s2+1]){
            v[s1][s2+1]=true;
            ratmaze(mat,s1,s2+1,d1,d2,v,s+"R",res);
            v[s1][s2+1]=false;
        }
        if(s2-1>=0 && mat[s1][s2-1]==1 && !v[s1][s2-1]){
            v[s1][s2-1]=true;
            ratmaze(mat,s1,s2-1,d1,d2,v,s+"L",res);
            v[s1][s2-1]=false;
        }
    }
}
