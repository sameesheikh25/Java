package Greedy;

public class Jumpgame {
    public static void main(String[] args) {
        int arr[]={1,2,0,3,0,0};
        boolean reach[]=new boolean[arr.length];
        int steps=arr[0];
        reach[0]=true;
        for(int i=0;i<arr.length;i++){
            if(!reach[i]){
                steps=Integer.max(steps, arr[i-1]);
                if(reach[i-1] && steps>0) {
                    System.out.println(steps);
                    reach[i]=true;
                    steps--;
                }
                if(!reach[i]){
                    break;
                }
            }
        }
        System.out.println(reach[arr.length-1]);
    }
}
