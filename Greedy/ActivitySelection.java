package Greedy;

import java.util.Map;
import java.util.PriorityQueue;

public class ActivitySelection {
    public static void main(String[] args) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (p1,p2)-> p1.s2-p2.s2
        );
        int s[]={1, 3, 0, 5, 8, 5};
        int f[]={2, 4, 6, 7, 9, 9};
        for(int i=0;i<s.length;i++)
        {
            Pair p1=new Pair(s[i], f[i]);
            pq.add(p1);
        }
        int n=1,k=pq.poll().s2;
        for(int i=1;i<s.length;i++){
            Pair p2=pq.poll();
            int k2=p2.s1,k3=p2.s2;
            System.out.println(k2+" "+k3);
            if(k2>=k){
                n++;
                k=k3;
            }
        }
        System.out.println(n);
    }
    static void sort(int s[],int f[]){
        for(int i=0;i<s.length;i++){
            for(int j=i+1;j<s.length;j++){
                if(f[i]>f[j]){
                    int t1=f[i];
                    int t2=s[i];
                    s[i]=s[j];
                    f[i]=f[j];
                    s[j]=t2;
                    f[j]=t1;
                }
            }
        }
    }
    static class Pair {
        int s1,s2;
        Pair(int s1,int s2){
            this.s1=s1;
            this.s2=s2;
        }
    }
}
