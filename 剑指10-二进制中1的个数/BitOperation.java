package test;
/**
 * ��ָoffer������10����������1�ĸ���
 * ��Ŀ����ʵ��һ������������һ����������������������Ʊ�ʾ��1�ĸ�����
 * ���磬��9��ʾ�ɶ�������1001����2λ��1���ú������2
 * �ⷨ����������һ��ԭ�������������㣬��Ѹ����������Ʊ�ʾ�е����λ��1���0,��������ж��ٴξ��ж��ٸ�1
 * @author GL
 *
 */
public class BitOperation {

    public static void main(String[] args) {
        int number1=11;
        System.out.println("����11�Ķ�������1�ĸ���Ϊ:"+numberOfOne(number1));
        //Java�е�int����������4�ֽ�32λ���
        int number2=-12;
        System.out.println("����-12�Ķ�������1�ĸ���Ϊ:"+numberOfOne(number2));
        //�����Ķ�������Ϊ����ֵ�Ĳ���,Ҳ������ֵ�ķ���+1


    }
    public static int numberOfOne(int number){
        int count=0;
        
        while(number!=0){
            count++;
            number=number&(number-1);
        }
        return count;
    }

}