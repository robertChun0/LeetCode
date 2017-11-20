package test;

/**
 * ��ָoffer������9��쳲���������
 * ��Ŀ��дһ������������n����쳲��������еĵ�n�
 * ����������������������������������������0,                n=1
 *     쳲��������ж������£�f(n)=      1,                n=2
 *                              ���� f(n-1)+f(n-2),    n>2
 * @author GL
 *
 */
public class Fibonacci {

    public static void main(String[] args) {
    	System.out.println("��4��쳲��������е�ֵΪ��"+generateFibonacci(4));
        System.out.println("��4��쳲��������е�ֵΪ��"+fibonacci(4));
    }

    /*
     * ���õݹ�ʵ��쳲������������ɺ�����Ч�ʵ�
     */
    public static int generateFibonacci(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return generateFibonacci(n-1)+generateFibonacci(n-2);
    }
    
    /*
     * ����ѭ��ʵ��쳲���������
     * �洢�����м����ý��
     */
    public static int fibonacci(int n){
        int[] result={0,1};
        if(n<2)
            return result[n];
        int fibNMinusOne=1;
        int fibNMinusTwo=0;
        int fibN=0;
        for(int i=2;i<=n;i++){
            fibN=fibNMinusOne+fibNMinusTwo;
            fibNMinusTwo=fibNMinusOne;
            fibNMinusOne=fibN;
        }
        return fibN;
    }
}