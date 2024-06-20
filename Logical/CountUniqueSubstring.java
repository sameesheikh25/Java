package Logical;

import java.util.ArrayList;

public class CountUniqueSubstring {
    public static void main(String[] args) {
        String s = "abccdefefefeeefeeeekgimwwfnd";
        int k=3;
        int n = s.length();
        int ans=0;
        ArrayList<String> arr = new ArrayList<>();
        // for(int i=0;i<=n-k;i++){
        //     if(isUnique(s.substring(i, i+k), k-1)){
        //         ans++;
        //     }
        // }
        // System.out.println(ans);
        // System.out.println(ans)
        
    }
    static boolean isUnique(String s,int k){
        int arr[]=new int[26];
        int c=0;
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)-'a']==0){
                arr[s.charAt(i)-'a']++;
                c++;
            }
        }
        return c==k;
    }
    static void approach1(String s,int k){
        int a[]=new int[26];
        int n=s.length();
        String s1="";
        int i1=0,c=0,ans=0;
        while(i1<n){
            s1+=s.charAt(i1);
            // System.out.println(s1);
            a[s1.charAt(s1.length()-1)-'a']++;
            if(a[s1.charAt(s1.length()-1)-'a']==1) {
                // a[s1.charAt(s1.length()-1)-'a']++;
                c++;
            }
            if(s1.length()==k){
                System.out.println(s1+" "+c);
                if(c==k-1){
                    ans++;
                }
                System.out.println(a[s1.charAt(0)-'a']);
                if(a[s1.charAt(0)-'a']==1){
                    c--;
                }
                a[s1.charAt(0)-'a']--;
                s1=s1.substring(1);
            }
            i1++;
        }
    }
    static void approach2(String s,int k){
        int i1=0,c=0,ans=0,n=s.length();
        int a[]=new int[26];
        for(int i=0;i<k;i++){
            a[s.charAt(i)-'a']++;
            if(a[s.charAt(i)-'a']==1){
                c++;
            }
        }
        if(c==k-1){
            ans++;
        }
        for(int i=k;i<n;i++){
            char oc=s.charAt(i-k);
            char nc=s.charAt(i);
            a[oc-'a']--;
            if(a[oc-'a']==0){
                c--;
            }
            a[nc-'a']++;
            if(a[nc-'a']==1){
                c++;
            }
            if(c==k-1){
                ans++;
            }
        }
    }
    static void approach3(String s,int k){
        int i1=0,c=0,ans=0,n=s.length();
        int a[]=new int[26];
        while(i1<n){
            // s1+=s.charAt(i1);
            if(i1<k){
                // System.out.println(s1);
                a[s.charAt(i1)-'a']++;
                if(a[s.charAt(i1)-'a']==1) {
                    // a[s1.charAt(s1.length()-1)-'a']++;
                    System.out.println(s.charAt(i1));
                    c++;
                }
                if(i1==k-1 && c==k-1){
                    System.out.println(c);
                    ans++;
                }
            }

            if(i1>=k){
                // System.out.println(i1+" "+k);
                a[s.charAt(i1-k)-'a']--;
                if(a[s.charAt(i1-k)-'a']==0){
                    c--;
                }
                a[s.charAt(i1)-'a']++;
                if(a[s.charAt(i1)-'a']==1){
                    c++;
                }
                // System.out.println(s1+" "+c);
                if(c==k-1){

                    ans++;
                }
            }
            i1++;
        }
    }
}
