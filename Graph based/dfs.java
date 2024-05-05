import java.util.Scanner;
import java.util.Stack;

public class dfs {
    public static void main(String[] args) {
        int mat[][] = new int[4][4];
        Scanner kb = new Scanner(System.in);
        input(kb, mat);
        // output(mat);
        dfs(2, mat);
    }
    static void input(Scanner kb, int mat[][]) {
        for (int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                mat[i][j] = kb.nextInt();
            }
        }
    }
    static void output(int mat[][]) {
        for (int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void dfs(int node, int mat[][]) {
        boolean visited[] = new boolean[4];
        Stack<Integer> stack = new Stack<>();
        int arr[]=new int[4];
        int s=0;
        stack.push(node);
        while(stack.isEmpty() == false) {
            stack = reverse(stack);
            int n=stack.pop();
            arr[s++]=n;
            visited[n] = true;
            for(int i=0;i<4;i++) {
                if(mat[n][i] == 1 && !visited[i]) {
                    stack.push(i);
                }
            }
        }
        for(int i=0;i<4;i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static Stack<Integer> reverse(Stack<Integer> stack) {
        Stack<Integer> s1 = new Stack<>();
        if(stack.isEmpty()) {
            return s1;
        }
        while(!stack.isEmpty()) {
            s1.push(stack.pop());
        }
        return s1;
    }
}