package SlidingWindow;

public class CountProductArrays {
    public static void main(String[] args) {
        // int a[]={10,19,29,82,65,14,32,23,61,11,191,20,8,623,4,300,2,120};
        int a[]={1,19,2,8,6,4,3,2,1,1,19,2,8,6,4,3,2,1};
        // int a[]={1,2,3,4,1};
        int k=100,m=0,e=0,s=0,n=a.length,sum=0;
        boolean v[]=new boolean[n];
        while(e<n){
            if(a[e]<k && !v[e]){
                // m++;
                v[e]=true;
            }
            if(sum==0){
                sum=a[e];
            } else {
                sum*=a[e];
            }
            // while(s<e && (e==n-1 || sum>=k)){
                // if(sum>=k){
                //     System.out.println(s+" "+e+" "+sum);
                //     e--;
                //     if(s<e){
                //         int t=(e-s+1);
                //         m+=t*(t-1)/2;
                //         System.out.println(s+" "+e+" "+sum+" "+m);
                //         sum=a[e];
                //         s=e; 
                //     } else {
                //         e++;
                //         s=e;
                //         sum=a[e];
                //     }
                   
                // } else if (sum <k && e==n-1){
                //     int t=(e-s+1);
                //     m+=t*(t-1)/2;
                //     System.out.println(s+" "+e+" "+sum+" "+m);
                // }
                // m+=e-s+1;
            // }
            while(s<e && (sum>=k || e==n-1)){
                int e1=e;
                if(sum>=k){
                    e1=e-1;
                } else {
                    e1=e;
                }
                if(sum/a[e]<k){
                    m+=e1-s+1;
                }
                sum/=a[s];
                System.out.println(s+" "+e1+" "+sum+" "+m);
                s++;
            }
            e++;
            if(e==n-1 && a[e]<k){
                m++;
            }
        }
        System.out.println(m);
    }
}
