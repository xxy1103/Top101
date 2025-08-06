import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组 
     * @return int整型
     */
    public int InversePairs (int[] nums) {
        // write code here
        List<Integer> orderednums = new ArrayList<Integer>();
        int sumP = 0;
        for(int i = 0; i < nums.length; i++){
            int InsertIndex = binarySearch(orderednums,nums[i]);
            sumP = (sumP + (orderednums.size() - InsertIndex)) % 1000000007 ;
            orderednums.add(InsertIndex, nums[i]);
        }
        return sumP;
    }

    public int binarySearch(List<Integer> array, int value){
        int front = 0;
        int tail = array.size() - 1;
        while(front <= tail){
            int middle = (front + tail)/2;
            if(array.get(middle) > value){
                tail = middle - 1;
            }
            else if(array.get(middle) < value){
                front = middle + 1;
            }
            else{
                return middle;
            }
        }
        return front;
    }
}