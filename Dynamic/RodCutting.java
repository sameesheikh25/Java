package Dynamic;

public class RodCutting {
    public static void main(String[] args) {
        int n=8;
        int price[]={1,5,8,9,10,17,17,20};
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                price[j]=Integer.max(price[j],price[i]+price[j-i-1]);
            }
        }
        System.out.println(price[n-1]);
    }
}
