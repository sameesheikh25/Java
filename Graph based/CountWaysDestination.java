import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CountWaysDestination {
    public static void main(String[] args) {
        System.out.println("Enter the graph ");
        Scanner kb = new Scanner(System.in);
        int mat[][] = new int[8][8];
        input(kb, mat, 8, 8);
        System.out.println(ways(mat,0,8));
    }
    static void input(Scanner kb, int[][] mat, int m, int n) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                mat[i][j] = kb.nextInt();
            }
        }
    }
    static void output(int mat[][]) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                System.out.println(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int ways(int mat[][], int s, int d)  {
        int w = 0;
        PriorityQueue<Map<Integer, Integer>> pq = new PriorityQueue<>(new EntryComparator());
        int ways[] = new int[mat.length];
        ways[0] = 1;
        int dist[] = new int[mat.length];
        for(int i=0;i<mat.length;i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<mat[0].length;i++ ) {
            if(mat[s][i] !=0 ){
                pq.add(Map.of(mat[s][i], i));
                dist[i] = mat[s][i];
                ways[i] = 1;
            }
        }
        while (!pq.isEmpty()) {
            System.out.println(pq);
            Map<Integer, Integer> map = pq.poll();
            int len = map.keySet().stream().toList().get(0);
            int src = map.values().stream().toList().get(0);
            // ways[src] += 1;
            for (int i=0;i<mat[0].length;i++) {
                System.out.println("src: " + src + " i: " + i + " len: " + len + " mat[src][i]: " + mat[src][i] + " dist[i]: " + dist[i]);
                if(mat[src][i] !=0 ){
                    int total = len + mat[src][i];
                    if(dist[i] <total) {
                        pq.add(Map.of(total, i));
                        dist[i] = total;
                        ways[i] = ways[src]; 
                    }
                    else if(dist[i] == total) {
                        ways[i] = ways[i] + ways[src];
                    }

                }
            }
            System.out.println(pq + " " +src);
            return w;
        }
        System.out.println(pq);
        return w;
    }
}
class EntryComparator implements Comparator<Map<Integer, Integer>> {
    public int compare(Map<Integer, Integer> a, Map<Integer, Integer> b) {
        return Integer.compare(a.keySet().stream().toList().get(0), b.keySet().stream().toList().get(0));
    }
}