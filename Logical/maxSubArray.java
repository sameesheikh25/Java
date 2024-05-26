package Logical;

public class maxSubArray {
    public static void main(String[] args) {
        // int a[]={2,6,8,1,4};
        // int a[]={-1,-2,-3,-4};
        int a[]={-2,1,-3,4,-1,2,1,-5,4};
        int m1=max(a);
        int m2=min(a);
        System.out.println(m1+" "+m2);
    }
    static int max(int a[]){
        int m=a[0],s=a[0],s1=0;
        for(int i=1;i<a.length;i++){
            s1=s+a[i];
            if(s1>m){
                m=s1;
            }
            if(s1<a[i]){
                s=a[i];
                m=Integer.max(s,m);
            }
            else{
                s=s1;
            }
        }
        return m;
    }
    static int min(int a[]){
        int m=a[0],s=a[0],s1=0;
        for(int i=1;i<a.length;i++){
            s1=s+a[i];
            if(s1<m){
                m=s1;
            }
            if(s1>a[i]){
                s=a[i];
                m=Integer.min(s,m);
            }
            else{
                s=s1;
            }
        }
        return m;
    }
}
