package test;

import java.util.Comparator;


public class Test33 {

    /**
     * �Զ��������Ƚ�����ʵ���㷨˵��������ԭ��
     */
    private static class MComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {

            if (o1 == null || o2 == null) {
                throw new IllegalArgumentException("Arg should not be null");
            }

            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s1.compareTo(s2);
        }
    }

    /**
     * ���������㷨
     *
     * @param array      ����������
     * @param start      Ҫ�������ʼλ��
     * @param end        Ҫ����Ľ���λ��
     * @param comparator �Զ���ıȽ���
     */
    private static void quickSort(String[] array, int start, int end, Comparator<String> comparator) {

        if (start < end) {
            String pivot = array[start];
            int left = start;
            int right = end;
            while (start < end) {
                while (start < end && comparator.compare(array[end], pivot) >= 0) {
                    end--;
                }

                array[start] = array[end];

                while (start < end && comparator.compare(array[start], pivot) <= 0) {
                    start++;
                }
                array[end] = array[start];

            }

            array[start] = pivot;

            quickSort(array, left, start - 1, comparator);
            quickSort(array, start + 1, end, comparator);
        }
    }

    /**
     * ��Ŀ������һ�����������飬����������������ƴ�������ų�һ������
     * ��ӡ��ƴ�ӳ���������������С��һ����
     * @param array ���������
     * @return ������
     */
    public static String printMinNumber(String[] array) {

        if (array == null || array.length < 1) {
            throw new IllegalArgumentException("Array must contain value");
        }

        MComparator comparator = new MComparator();
        quickSort(array, 0, array.length - 1, comparator);

        StringBuilder builder = new StringBuilder(256);
        for (String s : array) {
            builder.append(s);
        }

        return builder.toString();
    }

    public static void main(String[] args) {

        String[] data = {"3", "5", "1", "4", "2"};
        System.out.println(printMinNumber(data));

        String[] data2 = {"3", "32", "321"};
        System.out.println(printMinNumber(data2));

        String[] data3 = {"3", "323", "32123"};
        System.out.println(printMinNumber(data3));

        String[] data4 = {"1", "11", "111"};
        System.out.println(printMinNumber(data4));

        String[] data5 = {"321"};
        System.out.println(printMinNumber(data5));
    }
}
