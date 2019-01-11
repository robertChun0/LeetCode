package test;
/**
 * 剑指offer面试题10：二进制中1的个数
 * 题目：请实现一个函数，输入一个整数，输出该整数二进制表示中1的个数。
 * 例如，把9表示成二进制是1001，有2位是1，该函数输出2
 * 解法：把整数减一和原来的数做与运算，会把该整数二进制表示中的最低位的1变成0,与运算进行多少次就有多少个1
 * @author GL
 *
 */
public class BitOperation {

    public static void main(String[] args) {
        int number1=11;
        System.out.println("整数11的二进制中1的个数为:"+numberOfOne(number1));
        //Java中的int类型整数由4字节32位组成
        int number2=-12;
        System.out.println("整数-12的二进制中1的个数为:"+numberOfOne(number2));
        //负数的二进制数为其正值的补码,也就是正值的反码+1


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