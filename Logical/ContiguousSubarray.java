package Logical;

public class ContiguousSubarray {
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        int n=arr.length;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                for(int k=j;k<j+i && k<n;k++)
                {
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }
    }
}
