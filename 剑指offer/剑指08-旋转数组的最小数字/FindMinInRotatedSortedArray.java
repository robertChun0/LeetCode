package test;

/**
 * 剑指offer面试题8：旋转数组的最小数字
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
 * 旋转数组的特点：
 *         1，旋转之后的数组可以分为两个排序的子数组，且前面的子数组的元素都大于或等于后面子数组的元素。
 *         2，最小或者最大元素位于两个子数组的分界
 * 解题思路：在排序数组中，可以使用二分查找法进行查找
 * 利用左右两个指针和中间指针元素大小关系判断中间元素是位于前面的子数组还是后面的子数组，缩小查找范围
 * 需要考虑的特例：
 *         1，排序数组本身仍是该数组的一个旋转
 *         2，如果数组内有重复元素，那么有可能出现左右两指针元素与中间元素相同，无法判断中间元素属于前面子数组还是后面子数组，此时用顺序查找
 * @author GL
 *
 */
public class FindMinInRotatedSortedArray {

    public static void main(String[] args) {
        int[] array1={3,4,5,1,2};
        System.out.println("升序排序数组的一个旋转数组，无重复数字："+findMin(array1));
        int[] array2={1,2,3,4,5};
        System.out.println("升序排序数组："+findMin(array2));
        int[] array3={1};
        System.out.println("只包含一个数字的数组："+findMin(array3));
        int[] array4={2,4,2,2,2,2,2};
        System.out.println("包含重复元素的数组："+findMin(array4));
        int[] array5=null;
        System.out.println("null数组："+findMin(array5));

    }
    
    public static int findMin(int[] array){
        if(array==null||array.length<=0)
            throw new RuntimeException("invalid array");
        int indexLow=0;
        int indexHigh=array.length-1;
        //旋转数组为排序数组本身的特例
        int indexMiddle=indexLow;
        while(array[indexLow]>=array[indexHigh]){
            if(indexHigh-indexLow==1){
                indexMiddle=indexHigh;
                break;
            }
            //考虑两侧数字和中间数字相同的特殊情况，采用顺序查找算法查找最小值
            indexMiddle=(indexLow+indexHigh)/2;
            if(array[indexMiddle]==array[indexLow]&&array[indexHigh]==array[indexLow])
                return findMinInOrder(array,indexLow,indexHigh);
            if(array[indexMiddle]>=array[indexLow])
                indexLow=indexMiddle;
            else
                indexHigh=indexMiddle;
        }
        return array[indexMiddle];
    }
    //顺序查找
    private static int findMinInOrder(int[] array,int indexLow,int indexHigh){
        int result=array[indexLow];
        for(int i=indexLow+1;i<indexHigh;i++){
            if(array[i]<result)
                result=array[i];
        }
        return result;
    }
}