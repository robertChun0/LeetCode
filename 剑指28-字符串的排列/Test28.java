package test;

public class Test28 {
    /**
     * ��Ŀ������һ���ַ�������ӡ�����ַ������ַ����������С����������ַ���abc��
     * ���ӡ�����ַ�a��b��c �������г����������ַ���abc��acb��bac��bca��cab��cba��
     *
     * @param chars ��������ַ�����
     */
    public static void permutation(char[] chars) {
        // �������
        if (chars == null || chars.length < 1) {
            return;
        }
        // �������в���
        permutation(chars, 0);
    }

    /**
     * ���ַ����������
     *
     * @param chars �����е��ַ���
     * @param begin ��ǰ�����λ��
     */
    public static void permutation(char[] chars, int begin) {
        // ��������һ��Ԫ���ˣ���������н��
        if (chars.length - 1 == begin) {
            System.out.print(new String(chars) + " ");
        } else {
            char tmp;
            // �Ե�ǰ��δ������ַ������д���ÿ���ַ���������Ϊ��ǰ����λ�õ�Ԫ��
            //ȫ���о��Ǵӵ�һ��������ÿ�����ֱ�������������ֽ���
            //ȫ���о��Ǵӵ�һ��������ÿ�����ֱ�������������ֽ���
            //ȫ���о��Ǵӵ�һ��������ÿ�����ֱ�������������ֽ���
            //��Ҫ������˵����!!!!
            for (int i = begin; i < chars.length; i++) {
                // �����ǽ���Ԫ�ص�λ��
                tmp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = tmp;

                // ������һ��λ��
                permutation(chars, begin + 1);

                //������ȥ
                tmp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        char[] c1 = {'a', 'b', 'c'};
        permutation(c1);
        System.out.println();

        char[] c2 = {'a', 'b', 'c', 'd'};
        permutation(c2);
    }
}