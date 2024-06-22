package Logical;

import java.util.HashSet;

public class ShortestDistinctString {
    public static void main(String[] args) {
            // Your code goes here
            String str="CCCbAbbBbbCdfdsvfrdegfb";
            // str=str.toLowerCase();
            int a[]=new int[150];
            int b[]=new int[150];
            int s=0;int e=0;int s1=0;int e1=0,k=0,l=Integer.MAX_VALUE;
            System.out.println('c'-'Z');
            for(int i=0;i<str.length();i++){
                // if(str.charAt(i)-'A'>=0 && str.charAt(s1)-'Z'<=0){
                    a[str.charAt(i)-'A']++;
                    if(a[str.charAt(i)-'A']==1){
                        k++;
                    }
            }
            int c=0;
            while(e1<str.length()){
                    b[str.charAt(e1)-'A']++;
                    if(b[str.charAt(e1)-'A']==1){
                        c++;
                    }
                while(c>=k){
                    l=Math.min(l,e1-s1+1);
                        b[str.charAt(s1)-'A']--;
                        if(b[str.charAt(s1)-'A']==0){
                            c--;
                        }
                    s1++;
                }
                e1++;
            }
            // approach1(a, str);
        System.out.println(l);            
    }
    static void approach1(int a[],String str){
        // print(a);
        int s=0;int e=0;int s1=0;int e1=str.length()-1;
        while(s!=1){
            if(str.charAt(s1)-'A'>=0 && str.charAt(s1)-'Z'<=0){
                //  System.out.println(str.charAt(s1));
                if(a[str.charAt(s1)-'A']==1){
                    System.out.println(str.charAt(s1));
                    s=1;
                    break;
                }
                else if(s!=1 && a[str.charAt(s1)-'A']>1){
                    System.out.println(str.charAt(s1)+" "+a[str.charAt(s1)-'A']);
                    a[str.charAt(s1)-'A']=a[str.charAt(s1)-'A']-1;
                }
            } else {
                // System.out.println(str.charAt(s1));
                if(a[str.charAt(s1)-'a']==1){
                    System.out.println(str.charAt(s1));
                    System.out.println(a[str.charAt(s1)-'a']);
                    s=1;
                    break;
                }
                else if(s!=1 && a[str.charAt(s1)-'a']>1){
                    a[str.charAt(s1)-'a']=a[str.charAt(s1)-'a']-1;
                }
            }
            s1++;
        }
        while(e!=1){
            if(str.charAt(e1)-'A'>=0 && str.charAt(e1)-'Z'<=0){
                if(a[str.charAt(e1)-'A']==1){
                    e=1;
                    break;
                } else if(e!=1 && a[str.charAt(e1)-'A']>1){
                    System.out.println(str.charAt(e1)+" "+a[str.charAt(e1)-'A']);
                    a[str.charAt(e1)-'A']=a[str.charAt(e1)-'A']-1;
                }
            } else {
                if(a[str.charAt(e1)-'a']==1){
                    System.out.println(a[str.charAt(e1)-'a']);
                    e=1;
                    break;
                } else if(e!=1 && a[str.charAt(e1)-'a']>1){
                    a[str.charAt(e1)-'a']=a[str.charAt(e1)-'a']-1;
                }
            }
            e1--;
        }
        System.out.println(s1+" "+e1); 
    }
    static void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
