import java.util.*;


public class Solution {
    int[] array;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组 
     * @return int整型
     */
    public int minNumberInRotateArray (int[] nums) {
        // write code here
        if(nums.length == 1){
            return nums[0];
        }
        array = nums;
        return array[findMin(0,nums.length-1)];
    }

    public int findMin(int front, int tail){
        if(front > tail){
            return -1;
        }
        int middle = (front + tail) / 2;
        if(isMin(middle)){
            return middle;
        }
        else{
            int ans1 = findMin(front,middle-1);
            if(ans1 > -1) return ans1;
            int ans2 = findMin(middle+1,tail);
            return ans2;
        }
    }

    public boolean isMin(int index){
        if(index == 0){
            return array[index] < array[array.length-1];
        }
        else{
            return array[index] < array[index-1];
        }
    }
}