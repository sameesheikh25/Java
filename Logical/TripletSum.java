package Logical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TripletSum {
    public static void main(String[] args) {
        int a[]={-7,9,8,3,1,1};
        int n=6,t=25,ans=-1,d1=Integer.MAX_VALUE;
        HashSet<Integer> set=new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> m =new HashMap<>();
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                set.add(a[i]+a[j]);
                m.put(a[i]+a[j], new ArrayList<>(List.of(i,j)));
            }
        }
        System.out.println(set);
        for(Integer i1:set){
            for(int i=0;i<n;i++){
                ArrayList<Integer> l=m.get(i1);
                if(l.contains(i)){
                    continue;
                }
                int s=(i1+a[i]);
                // System.out.print(s+" "+i+" ");
                int d=Math.abs(t-s);
                if(d<d1){
                    d1=d;
                    ans=s;
                } else if(d==d1 && s>ans){
                    ans=s;
                }
            }
        }
        System.out.println(ans);
    }
}
