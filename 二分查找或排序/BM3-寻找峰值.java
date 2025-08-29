import java.util.*;


public class Solution {
    static int[] arry;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组 
     * @return int整型
     */
    public int findPeakElement (int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int front = 0;
        int tail = nums.length-1;
        arry = nums;
        return binaeryfindPeak(front,tail);
    }

    public int binaeryfindPeak(int front, int tail){
        if(front > tail) return -1;
        int middle = (front + tail)/2;
        if(isPeak(middle)){
            return middle;
        }
        else{
            int a = binaeryfindPeak(front,middle-1);
            if( a > -1) return a;
            int b = binaeryfindPeak(middle+1,tail);
            return b;
        }
    }
    public boolean isPeak(int index){
        if(index == 0){
            if(arry[index] > arry[index+1]){
                return true;
            }
        }
        else if(index == arry.length-1){
            if(arry[index] > arry[index -1]){
                return true;
            }
        }
        else{
            if(arry[index] > arry[index+1] && arry[index] > arry[index-1]){
                return true;
            }
        }
        return false;
    }
}