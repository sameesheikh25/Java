package Logical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxtipCalculator {
    public static void main(String[] args) {
        int arr[]={8, 7, 15, 19, 16, 16, 18};
        int brr[]={1,7, 15, 11, 12, 31, 9};
        int n=7,c1=3,c2=4;
        int p[]=new int[n];
        List<Pair> a1=new ArrayList<>();
        List<Pair> b1=new ArrayList<>();
        for(int i=0;i<n;i++){
            a1.add(new Pair(arr[i],i));
            b1.add(new Pair(brr[i],i));
        }
        Collections.sort(a1);
        Collections.sort(b1);
        // for(int i=0;i<n;i++){
        //     System.out.print(a1.get(i).num+" "+a1.get(i).pos+" ");
        // }
        // System.out.println();
        // for(int i=0;i<n;i++){
        //     System.out.print(b1.get(i).num+" "+b1.get(i).pos+" ");
        // }
        System.out.println(getTip(arr,brr,p,a1,b1,n,c1,c2));
    }
    static long getTip(int arr[], int brr[],int p[], List<Pair> a1, List<Pair> b1,int n,int c1,int c2){
        long s=0;
        int i1=0,i2=0;
        while(i1<n && i2<n){
            System.out.println("i1="+i1+" i2="+i2);
            if(a1.get(i1).num>b1.get(i2).num){
                // print(p);
                System.out.println("1 "+c1+" "+c2+" "+i1+" "+i2+" "+a1.get(i1).num);
                if(c1>0){
                    if(p[a1.get(i1).pos]==0){
                        c1--;
                        p[a1.get(i1).pos]=a1.get(i1).num;
                        s+=a1.get(i1).num;
                        i1=i1<n?++i1:i1;
                    } else {
                        if(p[b1.get(i2).pos]==0){
                            c2--;
                            p[b1.get(i2).pos]=b1.get(i2).num;
                            s+=b1.get(i2).num;
                            i2=i2<n?++i2:i2;
                        } else {
                            i2=i2<n?++i2:i2;
                            // i--;
                        }
                        i1=i1<n?++i1:i1;
                    }
                } else if(c2>0) {
                    if(p[b1.get(i2).pos]==0){
                        c2--;
                        p[b1.get(i2).pos]=b1.get(i2).num;
                        s+=b1.get(i2).num;
                        i2=i2<n?++i2:i2;
                    } else {
                        if(p[a1.get(i1).pos]==0){
                            c1--;
                            p[a1.get(i1).pos]=a1.get(i1).num;
                            s+=a1.get(i1).num;
                            i1=i1<n?++i1:i1;
                        } else {
                            i1=i1<n?++i1:i1;
                            // i--;
                        }
                        i2=i2<n?++i2:i2;
                    }
                } else {
                    i1=i1<n?++i1:i1;
                    i2=i2<n?++i2:i2;
                }
            } else if(a1.get(i1).num<b1.get(i2).num){
                // print(p);
                System.out.println("2 "+c1+" "+c2+" "+i1+" "+i2+" "+b1.get(i2).num);
                if(c2>0){
                    if(p[b1.get(i2).pos]==0){
                        c2--;
                        p[b1.get(i2).pos]=b1.get(i2).num;
                        s+=b1.get(i2).num;
                        i2=i2<n?++i2:i2;
                    } else {
                        i2=i2<n?++i2:i2;
                        // i--;
                    }
                } else if(c1>0) {
                    if(p[a1.get(i1).pos]==0) {
                        c1--;
                        p[a1.get(i1).pos]=a1.get(i1).num;
                        s+=a1.get(i1).num;
                        i1=i1<n?++i1:i1;
                    } else {
                        i1=i1<n?++i1:i1;
                        // i--;
                    }
                } else {
                    i1=i1<n?++i1:i1;
                    i2=i2<n?++i2:i2;
                }
            } else {
                // print(p);
                System.out.println("3 "+c1+" "+c2+" "+i1+" "+i2+" "+a1.get(i1).num+" "+b1.get(i2).num);
                if(c1>c2 || c1==c2){
                    if(p[a1.get(i1).pos]==0){
                        c1--;
                        p[a1.get(i1).pos]=a1.get(i1).num;
                        s+=a1.get(i1).num;
                        if(a1.get(i1).pos==b1.get(i2).pos){
                            // System.out.println("hello");
                            i2=i2<n?++i2:i2;
                        }
                        i1=i1<n?++i1:i1;
                        // System.out.println("s="+s+" c1="+c1+" c2="+c2);
                    } else {
                        if(c2>0){
                            if(p[b1.get(i2).pos]==0){
                                c2--;
                                p[b1.get(i2).pos]=b1.get(i2).num;
                                s+=b1.get(i2).num;
                            }
                            // System.out.println("hello1");
                            i2=i2<n?++i2:i2;
                            i1=i1<n?++i1:i1;
                        } else {
                            i1=i1<n?++i1:i1;
                            // i--;
                        }
                    }
                } else if(c2>c1) {
                    if(p[b1.get(i2).pos]==0){
                        c2--;
                        p[b1.get(i2).pos]=b1.get(i2).num;
                        s+=b1.get(i2).num;
                        // System.out.println("hello3");
                        if(a1.get(i1).pos==b1.get(i2).pos){
                            i1=i1<n?++i1:i1;
                        }
                        i2=i2<n?++i2:i2;
                    } else {
                        if(c1>0){
                            if(p[a1.get(i1).pos]==0){
                                c1--;
                                p[a1.get(i1).pos]=a1.get(i1).num;
                                s+=a1.get(i1).num;
                            }
                            i1=i1<n?++i1:i1;
                            i2=i2<n?++i2:i2;
                        } else {
                            // System.out.println("hello2");
                            i2=i2<n?++i2:i2;
                            // i--;
                        }
                    }
                } else {
                    i1=i1<n?++i1:i1;
                    i2=i2<n?++i2:i2;
                }
            }
        }
        return s;
    }
    static void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    static class Pair implements Comparable<Pair> {
        int num;
        int pos;

        Pair(int num, int pos) {
            this.num = num;
            this.pos = pos;
        }

        public int compareTo(Pair p){
            return Integer.compare(p.num, num);
        }
    }
}
