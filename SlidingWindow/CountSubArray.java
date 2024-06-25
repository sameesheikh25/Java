package SlidingWindow;

import java.util.HashSet;

public class CountSubArray {
    public static void main(String[] args) {
        // int[] a = {15, 12, 16, 18, 12, 13, 16, 17, 19, 12, 14, 16, 18, 19, 13, 15, 17, 19, 12, 14, 16, 18, 18, 13, 15};
        // int[] a = {2,3,5,8,50,8,50,4,2};
        int[] a = {45, 23, 67, 89, 12, 34, 56, 78, 90, 21, 43, 65, 87, 9, 32, 54, 76, 98, 20, 42, 64, 86, 8, 31, 53, 75, 
            97, 19, 41, 63, 85, 7, 30, 52, 74, 96, 18, 40, 62, 84, 6, 29, 51, 73, 95, 17, 39, 61, 83, 5, 28, 50, 72, 94, 
            16, 38, 60, 82, 4, 27, 49, 71, 93, 15, 37, 59, 81, 3, 26, 48, 70, 92, 14, 36, 58, 80, 2, 25, 47, 69, 91, 13, 
            35, 57, 79, 1, 24, 46, 68, 90, 12, 34, 56, 78, 100, 22, 44, 66, 88, 10, 33, 55, 77, 99, 21, 43, 65, 87, 9, 32, 54, 76, 98};
        int s=0,e=0,e1=0,n=a.length;
        boolean v[]=new boolean[n];
        long m=0,c=0,l=4,r=113,m1=0;
        HashSet<Integer> hs=new HashSet<>();
        while(e<n){

            c+=a[e];
            if(a[s]>r){
                c=0;
                s++;
                e=s;
                System.out.println(s+" "+e+" "+c+" "+m);
                continue;
            }
            e1=e;
            if(a[e]>=l && a[e]<=r && !v[e]){
                
                // m+=1;
                m1+=1;
                hs.add(a[e]);
                System.out.println("1-"+a[e]);
                v[e]=true;
            }
            System.out.println(a[e]);
            // if(c>r && !v[e]){
            //     c-=a[e];
            //     v[e]=true;
            //     e--;
            // }
                while(s<e && (e==n-1 || (c>r))){
                    // c-=a[e];
                    // e--;
                    // while(c>=l && c<=r){
                        System.out.println(c+" "+a[s]+" "+e);
                        if(c>r){
                            c-=a[e];
                            // v[e]=true;
                            e--;
                        }
                        System.out.println(c+" "+a[s]+" "+e);
                        c-=a[s];
                        if(s>=e && a[s]>r){
                            s++;
                            e++;
                            break;
                        } else if(s>=e){
                            s++;
                            break;
                        }
                        
                        int t=a[s],i1=s+1;
                        while(t<l && i1<=e){
                            t+=a[i1];
                            i1++;
                        }
                        if(t>=l && t<=r){
                            if(s==i1-1){
                                if(e>s || (e==s && !v[s])){
                                    int n1=e-(i1-1);
                                    m+=n1;
                                    System.out.println("1-"+a[s]+" "+(a[i1-1])+" "+n1+" "+m);
                                }
                            } else {
                                int n1=e-(i1-1);
                                m+=1+n1;
                                System.out.println("2-"+a[s]+" "+(a[i1-1])+" "+n1+" "+m);
                            }
                        }
                        s++;
                    // }
                }
            
            // if(c>=l && c<=r && e==n-1){
            //     m+=1;
            //     System.out.println(m);
            // }
            e++;
        }
        System.out.println(m+" "+hs.size()+" "+m1);
        //approach 2
        System.out.println(approach2(a,r,n)-approach2(a, l-1, n));

    }
    static long approach2(int a[],long m,int n){
        long c=0,k=0;
        int e=0,s=0;
        while(e<n){
            c+=a[e];
            while(c>m){
                c-=a[s];
                s++;
            }
            k+=(e-s+1);
            e++;
        }
        return k;
    }
}
