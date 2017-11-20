package test;

/**
 * ��ָoffer������8����ת�������С����
 * ��Ŀ����һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת������һ���������������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1
 * ��ת������ص㣺
 *         1����ת֮���������Է�Ϊ��������������飬��ǰ����������Ԫ�ض����ڻ���ں����������Ԫ�ء�
 *         2����С�������Ԫ��λ������������ķֽ�
 * ����˼·�������������У�����ʹ�ö��ֲ��ҷ����в���
 * ������������ָ����м�ָ��Ԫ�ش�С��ϵ�ж��м�Ԫ����λ��ǰ��������黹�Ǻ���������飬��С���ҷ�Χ
 * ��Ҫ���ǵ�������
 *         1���������鱾�����Ǹ������һ����ת
 *         2��������������ظ�Ԫ�أ���ô�п��ܳ���������ָ��Ԫ�����м�Ԫ����ͬ���޷��ж��м�Ԫ������ǰ�������黹�Ǻ��������飬��ʱ��˳�����
 * @author GL
 *
 */
public class FindMinInRotatedSortedArray {

    public static void main(String[] args) {
        int[] array1={3,4,5,1,2};
        System.out.println("�������������һ����ת���飬���ظ����֣�"+findMin(array1));
        int[] array2={1,2,3,4,5};
        System.out.println("�����������飺"+findMin(array2));
        int[] array3={1};
        System.out.println("ֻ����һ�����ֵ����飺"+findMin(array3));
        int[] array4={2,4,2,2,2,2,2};
        System.out.println("�����ظ�Ԫ�ص����飺"+findMin(array4));
        int[] array5=null;
        System.out.println("null���飺"+findMin(array5));

    }
    
    public static int findMin(int[] array){
        if(array==null||array.length<=0)
            throw new RuntimeException("invalid array");
        int indexLow=0;
        int indexHigh=array.length-1;
        //��ת����Ϊ�������鱾�������
        int indexMiddle=indexLow;
        while(array[indexLow]>=array[indexHigh]){
            if(indexHigh-indexLow==1){
                indexMiddle=indexHigh;
                break;
            }
            //�����������ֺ��м�������ͬ���������������˳������㷨������Сֵ
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
    //˳�����
    private static int findMinInOrder(int[] array,int indexLow,int indexHigh){
        int result=array[indexLow];
        for(int i=indexLow+1;i<indexHigh;i++){
            if(array[i]<result)
                result=array[i];
        }
        return result;
    }
}