package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
    public static void main(String[] args) {
        int arr[] = {};
        int target = 7;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        check(0,target,arr,res,new ArrayList<>());;
        System.out.println(res);
    }
    static void check(int s, int t, int arr[], ArrayList<ArrayList<Integer>> res, ArrayList<Integer> curr) {
        if(t==0){
            if(!res.contains(curr)){
                System.out.println(curr);
                res.add(new ArrayList<>(sort(curr)));
            }
            System.out.println(res);
            return;
        }
        for(int i=s;i<arr.length;i++) {
            if(t-arr[i]>=0){
                curr.add(arr[i]);
                check(i,t-arr[i], arr, res, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    static ArrayList<Integer> sort(ArrayList<Integer> res) {
        for(int i=0;i<res.size();i++){
            for(int j=i+1;j<res.size();j++){
                if(res.get(i)>res.get(j)){
                    int temp = res.get(i);
                    res.set(i,res.get(j));
                    res.set(j,temp);
                }
            }
        }
        return res;
    }
}
