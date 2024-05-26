package Logical;

public class maxSubArray {
    public static void main(String[] args) {
        // int a[]={-2,1,-3,4,-1,2};
        int a[]={-1,-2,-3,-4};
        int m=a[0],s=a[0],s1=0;
        for(int i=1;i<a.length;i++){
            s1=s+a[i];
            if(s1>m){
                m=s1;
            } 
            if(s1<a[i]){
                s=a[i];
                m=Integer.max(m,s);
            }
            else {
                s=s1;
            }
        }
        System.out.println(m);
    }
}
