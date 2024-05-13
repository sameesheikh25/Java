package Recursion;

public class TOH {
    public static void main(String[] args) {
        int d=4;
        toh(d,'A','B','C');
    }
    static void toh(int d, char S,char E, char D){
        if(d==1){
            System.out.println("Move disk 1 from "+S+" to "+D);
            return;
        }
        toh(d-1,S,D,E);
        System.out.println("Move disk 1 from "+S+" to "+D);
        toh(d-1,E,S,D); 
    }
}
