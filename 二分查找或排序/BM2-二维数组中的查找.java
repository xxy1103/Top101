import java.util.*;


public class Solution {
    

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param target int整型 
     * @param array int整型二维数组 
     * @return bool布尔型
     */
    public boolean Find (int target, int[][] array) {
        // write code here
        int iMax = array.length;
        int jMax = array[0].length;
        for(int i = 0; i < iMax; i++){
            for(int j = 0; j < jMax; j++){
                if(target == array[i][j]){
                    return true;
                }
                if(target < array[i][j]){
                    if(j < jMax) jMax = j;
                }
            }
        }
        return false;
    }
}