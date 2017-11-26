package test;

/**
 * 剑指offer面试题14：调整数组顺序是奇数位于偶数前面
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于偶数的前半部分，所有偶数位于数组的后半部分
 * @author GL
 *
 */
public class ReorderArray {

    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7,8,9};
        reorderOddEven(array);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+",");
        }

    }
    
    public static void reorderOddEven(int[] array){
        if(array==null||array.length<=0)
            throw new RuntimeException("invalid array");
        int begin=0;
        int end=array.length-1;
        while(begin<end){
//        	找到偶数
            while(begin<end&&(array[begin]&1)!=0){
                begin++;
            }
//          找到奇数
            while(begin<end&&(array[end]&1)==0){
                end--;
            }
//          交换
            if(begin<end){
                int temp=array[end];
                array[end]=array[begin];
                array[begin]=temp;
            }
        }
    }

}