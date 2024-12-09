package Dynamic;

import java.util.ArrayList;
import java.util.List;

public class StringGenerator2 {
    static void generate(char c[], int n){
        List<String> comb=new ArrayList<>();
        generateAll(c,"",0,n,comb);
        for(String s:comb){
            System.out.println(s);
        }
    }
    static void generateAll(char c[],String s,int index,int n,List<String> comb){
        if(n==0){
            comb.add(s);
            return;
        }
        for(int i=index;i<c.length;i++){
            char c1=c[i];
            String ns=s+c1;
            generateAll(c,ns,i,n-1,comb);
        }
    }
    public static void main(String[] args) {
        char c[]={'a','b','a'};
        int n=3;
        generate(c,n);
    }
}
