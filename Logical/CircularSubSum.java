package Logical;

public class CircularSubSum {
    public static void main(String[] args) {
        // int a[]={8,-8,9,-9,10,-11,12,10,-3,-4,7,6,5,-4,-1};
        int a[]={-5, -3, -2, 5, -4, 6, -2, -1};
        // int[] a = {8, -8, 9, -9, 10, -11, 12, 10, -3, -4, 7, 6, 5, -4, -1, 2, -2, 3, -3, 4, -5, 6, 4, -1, -2, 5, 4, 3, -3, -4, 7, 8, 9, -9, -10, 11, -12, 13, 14, -6, -7, 8, -8, 9, 10, -10, 11, -11, 12, -12};
        int n=a.length;
        int b[]=new int[n];
        int m=0,max=0;
        b[0]=a[0];
        int s=a[0],i1=0,s1=a[0],max2=a[0];
        for(int i=1;i<n;i++){
            s+=a[i];
            b[i]=Integer.max(b[i-1],s);
            s1+=a[i];
            if(s1<a[i]){
                i1=i;
                s1=a[i1];
            }
            max2=Integer.max(max2,s1);
        }
        // print(a);
        System.out.println(max2);
        max=s;
        for(int i=1;i<n;i++){
            s-=a[i-1];
            int max1=Integer.max(s,s+b[i-1]);
            max=Integer.max(max,max1);
        }
        max=Integer.max(max, max2);
        System.out.println(max);
    }
    static void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
