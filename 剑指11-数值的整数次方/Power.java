package test;
/**
 * 剑指offer面试题11：数值的整数次方
 * 题目：实现函数double power(double base,int exponent),求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 * 解题思路：实现数值的n次方就是将一个数自身连乘n次
 * 底数要考虑到正数、负数和零的情况
 * 指数要考虑到正整数，负整数和零的情况。因此可能的情况有九种，其中尤其要注意底数为0，指数为负数的情况下是无意义的，因此要做特殊处理
 * 指数为负数的乘方运算，可先按照指数为正求得，然后求倒数得到真正结果
 * 解法一：全面不高效，考虑到所有边界条件和负面测试
 * 解法二：全面高效完美的算法，使用公式a^n=a^(n/2)*a^(n/2)    n是偶數
 *                                   a^(n/2)*a^(n/2)&a    n是奇数    
 * @author GL
 *
 */
public class Power {

    public static void main(String[] args) {
        System.out.println("底数为2，指数为2运算结果为："+power(2,2));
        System.out.println("底数为2，指数为-2运算结果为："+power(2,-2));
        System.out.println("底数为2，指数为0运算结果为："+power(2,0));
        System.out.println("底数为-2，指数为2运算结果为："+power(-2,2));
        System.out.println("底数为-2，指数为-2运算结果为："+power(-2,-2));
        System.out.println("底数为-2，指数为0运算结果为："+power(-2,0));
        System.out.println("底数为0，指数为2运算结果为："+power(0,2));
        System.out.println("底数为0，指数为0运算结果为："+power(0,0));
        System.out.println("底数为2，指数为1运算结果为："+power(2,1));
        System.out.println("底数为0，指数为-2运算结果为："+power(0,-2));
    }

    public static double power(double base,int exponent){
        if(equal(base,0.0)&&exponent<0)
            throw new RuntimeException("while exponent is minus,the base can't be zero");
        int absExponent=exponent;
        if(exponent<0)
            absExponent=~exponent+1;//整数按位取反+1得到他的相反数
        //double result=powerWithUnsignedExponent(base,absExponent);
        double result= powerWithUnsignedExponentByRecursion( base, absExponent);
        if(exponent<0)
            result=1.0/result;
        return result;
    }
    //解法一：求指数为非负数时候的乘方运算,连乘
    private static double powerWithUnsignedExponent(double base, int absExponent) {
        double result=1.0;
        for(int i=1;i<=absExponent;i++){
            result=result*base;
        }
        return result;
    }

    //解法二：计算一个数的乘方的时候，通过计算指数的一半次，得到的结果相乘即可得到，这样计算量会大大减少
    private static double powerWithUnsignedExponentByRecursion(double base,int exponent){
        if(exponent==0)
            return 1.0;
        if(exponent==1)
            return base;
        double result= powerWithUnsignedExponentByRecursion(base,exponent>>1);
        result=result*result;
//        判断指数是否为奇数
        if((exponent&0x1)==1)
            result=result*base;
        return result;
    }
    

    //浮点数由于精度问题不能用==判断是否想等，如果两数满足一定条件精度，可以看做相等
    private static boolean equal(double number1,double number2){
        if(number1-number2>-0.0000001&&(number1-number2)<0.0000001)
            return true;
        return false;
    }
}