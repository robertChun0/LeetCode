package test;

public class Test40 {
    public static int[] findNumbersAppearanceOnce(int[] data) {
        int[] result = {0, 0};

        if (data == null || data.length < 2) {
            return result;
        }

        int xor = 0;
        for (int i : data) {
            xor ^= i;
        }
        //若符合条件,则得到的xor一定不为0

        //找到二进制中第一个为1的位置.
        int indexOf1 = findFirstBit1(xor);

        //将结果分为两组,一组为第indexOf1位置都为1,一组都为0.
        //再次异或 则可以得到两组中唯一一个值 组合起来便是答案.~
        for (int i : data) {
            if (isBit1(i, indexOf1)) {
                result[0] ^= i;
            } else {
                result[1] ^= i;
            }
        }

        return result;
    }

    private static int findFirstBit1(int num) {
        int index = 0;
        while ((num & 1) == 0 && index < 32) {
            num >>>= 1;
            index++;
        }

        return index;
    }

    private static boolean isBit1(int num, int indexBit) {
        num >>>= indexBit;
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        int[] data1 = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] result1 = findNumbersAppearanceOnce(data1);
        System.out.println(result1[0] + " " + result1[1]);

        int[] data2 = {4, 6};
        int[] result2 = findNumbersAppearanceOnce(data2);
        System.out.println(result2[0] + " " + result2[1]);

        int[] data3 = {4, 6, 1, 1, 1, 1};
        int[] result3 = findNumbersAppearanceOnce(data3);
        System.out.println(result3[0] + " " + result3[1]);
    }
}