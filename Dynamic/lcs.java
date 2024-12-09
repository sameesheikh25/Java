package Dynamic;

public class lcs {
    public static void main(String[] args) {
        String s1="ABCDGH";
        String s2="AEDFHR";
        char c1[]=s1.toCharArray();
        char c2[]=s2.toCharArray();
        char c3[]=c1.length>c2.length ? c1 : c2;
        char c4[]=c1.length>c2.length ? c2 : c1;
        int c[][]=new int[c4.length][c3.length];
        int m=0;
        for(int i=0;i<c4.length;i++){
            for(int j=0;j<c3.length;j++){
                int m1=0,m2=0,m3=0;
                if(i-1>=0){
                    m1=c[i-1][j];
                }
                if(i-1>=0 && j-1>=0){
                    m2=c[i-1][j-1];
                }
                if(j-1>=0){
                    m3=c[i][j-1];
                }
                c[i][j]=Integer.max(Integer.max(m1,m2),m3);
                // System.out.println(c4[i]+" "+c3[j]);
                if(c4[i]==c3[j]){
                    if(i-1<0 || j-1<0){
                        c[i][j]=1;
                    } else {
                        c[i][j]=c[i-1][j-1]+1;
                    }
                }
            }
        }
        for(int i=0;i<c4.length;i++){
            for(int j=0;j<c3.length;j++){
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(m);
    }
}
