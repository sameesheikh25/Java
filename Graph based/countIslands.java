import java.util.Scanner;

public class countIslands {
    public static void main(String[] args) {
        int mat[][] = new int[5][5];
        input(new Scanner(System.in), mat);
        // output(mat);
        System.out.println(countIsland(mat));
    }
    static void input(Scanner kb, int mat[][]) {
        for (int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                mat[i][j] = kb.nextInt();
            }
        }
    }
    static void output(int mat[][]) {
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int countIsland(int mat[][]) {
        int c=0;
        boolean visited[][] = new boolean[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++) {
                if(mat[i][j]==1 && !visited[i][j]){
                    dfs(i,j,mat,visited);
                    c++;
                }
            }
        }
        return c;
    }
    static void dfs(int i, int j, int mat[][], boolean visited[][]) {
        visited[i][j] = true;
        int rows[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int cols[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        for(int k=0;k<8;k++){
            int r=i+rows[k], c=j+cols[k];
            if(r>=0 && r<mat.length && c>=0 && c<mat[0].length && !visited[r][c] && mat[r][c]==1){
                dfs(r,c,mat,visited);
            }
        }
    }
}
