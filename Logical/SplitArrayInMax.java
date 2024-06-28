package Logical;

public class SplitArrayInMax {
    public static void main(String[] args) {
        int a[]={1,9,2,8,6,4,3};
        int n=7,k=4,s=0,m=0;
        for(int i=0;i<n;i++){
            m=Integer.max(m,a[i]);
            s+=a[i];
        }
        int l=m,r=s,max=s;
        while(l<=r){
            int mid=(l+r)/2;
            int c=check(a,mid,k);
            if(c<=k)
            max=Integer.min(max,(l+r)/2);
            if(c<=k){
                r=mid-1;
            } else if(c>k) {
                l=mid+1;
            } 
        }
        System.out.println(max);
    }
    static int check(int a[],int sum,int k){
        int s=0,c=1;
        for(int i=0;i<a.length;i++){
            if(s+a[i]<=sum){
                s+=a[i];
            } else {
                c++;
                s=a[i];
            }
        }
        System.out.println("c="+c);
        return c;
    }
}
