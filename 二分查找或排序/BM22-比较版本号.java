import java.util.*;


public class Solution {
    int i;
    String[] version1Number;
    String[] version2Number;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 比较版本号
     * @param version1 string字符串 
     * @param version2 string字符串 
     * @return int整型
     */
    public int compare (String version1, String version2) {
        // write code here
        i = 0;
        version1Number = version1.split("\\.");
        System.out.println("version1长度："+ version1Number.length);
        version2Number = version2.split("\\.");
        System.out.println("version2长度："+ version2Number.length);
        return compareNumber(version1Number[i], version2Number[i]);

    }
    public int compareNumber(String num1, String num2){
        Optional<String> Opnum1 = Optional.ofNullable(num1);
        Optional<String> Opnum2 = Optional.ofNullable(num2);
        int num1Value = Integer.parseInt(Opnum1.orElse("0"));
        int num2Value = Integer.parseInt(Opnum2.orElse("0"));
        if(num1Value > num2Value){
            return 1;
        }
        else if(num1Value < num2Value){
            return -1;
        }
        i++;
        if(i >= version1Number.length && i >= version2Number.length){
            return 0;
        }
        String nextCompare1 = (i >= version1Number.length) ? null : version1Number[i];
        String nextCompare2 = (i >= version2Number.length) ? null : version2Number[i];
        return compareNumber(nextCompare1, nextCompare2);
    }
}