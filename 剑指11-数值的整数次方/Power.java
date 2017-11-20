package test;
/**
 * ��ָoffer������11����ֵ�������η�
 * ��Ŀ��ʵ�ֺ���double power(double base,int exponent),��base��exponent�η���
 * ����ʹ�ÿ⺯����ͬʱ����Ҫ���Ǵ������⡣
 * ����˼·��ʵ����ֵ��n�η����ǽ�һ������������n��
 * ����Ҫ���ǵ�������������������
 * ָ��Ҫ���ǵ���������������������������˿��ܵ�����о��֣���������Ҫע�����Ϊ0��ָ��Ϊ�������������������ģ����Ҫ�����⴦��
 * ָ��Ϊ�����ĳ˷����㣬���Ȱ���ָ��Ϊ����ã�Ȼ�������õ��������
 * �ⷨһ��ȫ�治��Ч�����ǵ����б߽������͸������
 * �ⷨ����ȫ���Ч�������㷨��ʹ�ù�ʽa^n=a^(n/2)*a^(n/2)    n��ż��
 *                                   a^(n/2)*a^(n/2)&a    n������    
 * @author GL
 *
 */
public class Power {

    public static void main(String[] args) {
        System.out.println("����Ϊ2��ָ��Ϊ2������Ϊ��"+power(2,2));
        System.out.println("����Ϊ2��ָ��Ϊ-2������Ϊ��"+power(2,-2));
        System.out.println("����Ϊ2��ָ��Ϊ0������Ϊ��"+power(2,0));
        System.out.println("����Ϊ-2��ָ��Ϊ2������Ϊ��"+power(-2,2));
        System.out.println("����Ϊ-2��ָ��Ϊ-2������Ϊ��"+power(-2,-2));
        System.out.println("����Ϊ-2��ָ��Ϊ0������Ϊ��"+power(-2,0));
        System.out.println("����Ϊ0��ָ��Ϊ2������Ϊ��"+power(0,2));
        System.out.println("����Ϊ0��ָ��Ϊ0������Ϊ��"+power(0,0));
        System.out.println("����Ϊ2��ָ��Ϊ1������Ϊ��"+power(2,1));
        System.out.println("����Ϊ0��ָ��Ϊ-2������Ϊ��"+power(0,-2));
    }

    public static double power(double base,int exponent){
        if(equal(base,0.0)&&exponent<0)
            throw new RuntimeException("while exponent is minus,the base can't be zero");
        int absExponent=exponent;
        if(exponent<0)
            absExponent=~exponent+1;//������λȡ��+1�õ������෴��
        //double result=powerWithUnsignedExponent(base,absExponent);
        double result= powerWithUnsignedExponentByRecursion( base, absExponent);
        if(exponent<0)
            result=1.0/result;
        return result;
    }
    //�ⷨһ����ָ��Ϊ�Ǹ���ʱ��ĳ˷�����,����
    private static double powerWithUnsignedExponent(double base, int absExponent) {
        double result=1.0;
        for(int i=1;i<=absExponent;i++){
            result=result*base;
        }
        return result;
    }

    //�ⷨ��������һ�����ĳ˷���ʱ��ͨ������ָ����һ��Σ��õ��Ľ����˼��ɵõ��������������������
    private static double powerWithUnsignedExponentByRecursion(double base,int exponent){
        if(exponent==0)
            return 1.0;
        if(exponent==1)
            return base;
        double result= powerWithUnsignedExponentByRecursion(base,exponent>>1);
        result=result*result;
//        �ж�ָ���Ƿ�Ϊ����
        if((exponent&0x1)==1)
            result=result*base;
        return result;
    }
    

    //���������ھ������ⲻ����==�ж��Ƿ���ȣ������������һ���������ȣ����Կ������
    private static boolean equal(double number1,double number2){
        if(number1-number2>-0.0000001&&(number1-number2)<0.0000001)
            return true;
        return false;
    }
}