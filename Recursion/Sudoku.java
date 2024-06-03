package Recursion;

public class Sudoku {
    public static void main(String[] args) {
        int mat[][]={{3,6,6,5,0,8,4,0,0},{5,2,0,0,0,0,0,0,0},{0,8,7,0,0,0,0,3,1},{0,0,3,0,1,0,0,8,0},
        {9,0,0,8,6,3,0,0,5},{0,5,0,0,9,0,6,0,0},{1,3,0,0,0,0,2,5,0},{0,0,0,0,0,0,0,7,4},{0,0,5,2,0,6,3,0,0}};
        // print(mat);
        System.out.println(func(mat,0,0));
    }
    static boolean func(int mat[][],int r,int c){
        
        if(r==9){
            print(mat);
            return true;
        }
        if(c==9){
            return func(mat,r+1,0);
        }
        // System.out.println(r+" "+c+" "+mat[r][c]);
        if(mat[r][c]!=0){
            if(c>=8){
                // System.out.println(r+" "+c);
               return func(mat,r+1,0);
            } else {
                // System.out.println(r+" "+c);
                return func(mat,r,c+1);
            }
            // func(mat,r,c+1);
        }
        for(int i=1;i<=9;i++){
            if(isValid(mat,r,c,i)){
                mat[r][c]=i;
                // System.out.println(r+" "+c+" "+i);
                if(c>=8){
                    if(func(mat,r+1,0)) return true;
                } else {
                    if(func(mat,r,c+1)) return true;
                }
                mat[r][c]=0;
            }
        }
        return false;
    }
    static boolean isValid(int mat[][],int m,int n,int k){
        int r=m;
        for(int c1=0;c1<9;c1++){
            // System.out.println(r+" "+c1);
            if(c1!=n && mat[r][c1]==k){
                return false;
            }
        }
        int c=n;
        for(int r1=0;r1<9;r1++){
            if(r1!=m && mat[r1][c]==k){
                return false;
            }
        }
        int m1=m<3?0:m/3;
        int n1=n<3?0:n/3;
        int r2=m1*3,c2=n1*3;
        // System.out.println(r2+" "+c2);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if((r2+i!=m || c2+j!=n) && mat[r2+i][c2+j]==k){
                    return false;
                }
            }
        }
        return true;
    }
    static void print(int mat[][]){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }
}
