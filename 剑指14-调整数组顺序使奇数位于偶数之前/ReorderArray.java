package test;

/**
 * ��ָoffer������14����������˳��������λ��ż��ǰ��
 * ��Ŀ������һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ��ż����ǰ�벿�֣�����ż��λ������ĺ�벿��
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
//        	�ҵ�ż��
            while(begin<end&&(array[begin]&1)!=0){
                begin++;
            }
//          �ҵ�����
            while(begin<end&&(array[end]&1)==0){
                end--;
            }
//          ����
            if(begin<end){
                int temp=array[end];
                array[end]=array[begin];
                array[begin]=temp;
            }
        }
    }

}