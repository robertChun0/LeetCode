package test;

/**
 * 剑指offer面试题9：斐波那契数列
 * 题目：写一个函数，输入n，求斐波那契数列的第n项。
 * 　　　　　　　　　　　　　　　　　　　　0,                n=1
 *     斐波那契数列定义如下：f(n)=      1,                n=2
 *                              　　 f(n-1)+f(n-2),    n>2
 * @author GL
 *
 */
public class Fibonacci {

    public static void main(String[] args) {
    	System.out.println("第4项斐波那契数列的值为："+generateFibonacci(4));
        System.out.println("第4项斐波那契数列的值为："+fibonacci(4));
    }

    /*
     * 采用递归实现斐波那契数列生成函数，效率低
     */
    public static int generateFibonacci(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return generateFibonacci(n-1)+generateFibonacci(n-2);
    }
    
    /*
     * 采用循环实现斐波那契数列
     * 存储数列中间项，求得结果
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