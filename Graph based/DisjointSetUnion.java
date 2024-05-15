

import java.util.ArrayList;
import java.util.List;

public class DisjointSetUnion {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int V=6;
        arr.add(new ArrayList<>(List.of(1,5)));
        arr.add(new ArrayList<>(List.of(0,2)));
        arr.add(new ArrayList<>(List.of(2,4)));
        arr.add(new ArrayList<>(List.of(3,3)));
        int par[]=new int[V];
        for(int i=0;i<V;i++) {
            par[i]=i;
        }
        for(ArrayList<Integer> a:arr){
            par[a.get(0)]=merge(par,a.get(1));
        }
        int c=0;
        for(int i=0;i<V;i++){
            if(par[i]==i)
                c++;
        }
        System.out.println(c);
    }
    static int merge(int par[],int x){
        if(par[x]==x)
            return x;
        return merge(par,par[x]);
    }
}
