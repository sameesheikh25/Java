import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectedComponents {
    public static void main(String[] args) {
        int c=0;
        ArrayList<List<Integer>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        adj.add(List.of(1,2));
        adj.add(List.of(7,2));
        adj.add(List.of(3,5));
        adj.add(List.of(3,4));
        adj.add(List.of(4,5));
        int V=7;
        
        // int max = adj.stream().flatMap(List::stream).sorted().toList().get(adj.size()*2-1);
        int max1=0;
        boolean vis1[]=new boolean[V];
        boolean vis2[]=new boolean[V];
        int mat[][] = new int[V][V];
        System.out.println(adj.size());
        for(int i=0;i<adj.size();i++){
            mat[i][i]=1;
            mat[adj.get(i).get(0)-1][adj.get(i).get(1)-1]=1;
            mat[adj.get(i).get(1)-1][adj.get(i).get(0)-1]=1;
        }
        // print(mat);
        for(int i=0;i<V;i++){   
            adj1.add(new ArrayList<>());
        }
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    adj1.get(i).add(j);
                }
            }
        }
        System.out.println(adj1);
        for(int i=0;i<V;i++){
            if(!vis1[i]){
                dfs(i, vis1, mat);
                for(boolean b : vis1) {
                    System.out.print(b + " ");
                }
                System.out.println();
                ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
                for(int j=0;j<V;j++){
                    if(vis1[j] && !vis2[j]){
                        adj2.add(adj1.get(j));
                        vis2[j]=!vis2[j];
                    }
                }
                if(compare(adj2)){
                    c++;
                }
            }
        }
        System.out.println(c);
    }
    static void print(int mat[][]) {
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void dfs(int s, boolean vis[], int mat[][]){
        vis[s]=true;
        // System.out.print(s + "-");
        for(int j=0;j<mat[0].length;j++){
            if(!vis[j] && mat[s][j]==1){
                dfs(j, vis, mat);
            }
        }
    }
    static boolean compare(ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> l1=adj.get(0);
        for(int i=1;i<adj.size();i++){
            ArrayList<Integer> l2=adj.get(i);
            if(!Arrays.equals(l1.toArray(), l2.toArray())){
                return false;
            }
        }
        return true;
        // return adj.stream().allMatch(list -> list.stream().allMatch(l1::contains));
    }
}
