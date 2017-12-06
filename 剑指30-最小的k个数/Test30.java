package test;

import java.util.ArrayList;
import java.util.List;

public class Test30 {
    /**
     * �󶥶�
     *
     * @param <T> ����������
     */
    private final static class MaxHeap<T extends Comparable<T>> {
        // ����Ԫ�ش�ŵļ���
        private List<T> items;
        // ���ڼ���
        private int cursor;

        /**
         * ����һ��׵��ʼ��С��32
         */
        public MaxHeap() {
            this(32);
        }

        /**
         * ����һ��ָ����ʼ��С�Ķ�
         *
         * @param size ��ʼ��С
         */
        public MaxHeap(int size) {
            items = new ArrayList<>(size);
            cursor = -1;
        }

        /**
         * ���ϵ�����
         *
         * @param index ������Ԫ�ص���ʼλ��
         */
        public void siftUp(int index) {
            T intent = items.get(index); // ��ȡ��ʼ������Ԫ�ض���

            while (index > 0) { // ������Ǹ�Ԫ��
                int parentIndex = (index - 1) / 2; // �Ҹ�Ԫ�ض����λ��
                T parent = items.get(parentIndex);  // ��ȡ��Ԫ�ض���
                if (intent.compareTo(parent) > 0) { //���Ƶ��������ӽڵ�ȸ��ڵ��
                    items.set(index, parent); // �����ڵ����·�
                    index = parentIndex; // ��¼���ڵ��·ŵ�λ��
                } else { // �ӽڵ㲻�ȸ��ڵ��˵������·���Ѿ����Ӵ�С�ź�˳���ˣ�����Ҫ������
                    break;
                }
            }

            // index��ʱ��¼�ǵ����һ�����·ŵĸ��ڵ��λ�ã�Ҳ���������������Խ��ʼ�ĵ�����Ԫ��ֵ����indexλ�ü���
            items.set(index, intent);
        }

        /**
         * ���µ�����
         *
         * @param index �����Ƶ�Ԫ�ص���ʼλ��
         */
        public void siftDown(int index) {
            T intent = items.get(index);  // ��ȡ��ʼ������Ԫ�ض���
            int leftIndex = 2 * index + 1; // // ��ȡ��ʼ������Ԫ�ض�������ӽ���Ԫ��λ��

            while (leftIndex < items.size()) { // ��������ӽ��
                T maxChild = items.get(leftIndex); // ȡ���ӽ���Ԫ�ض��󣬲��Ҽٶ���Ϊ�����ӽ��������
                int maxIndex = leftIndex; // �����ӽڵ������ڵ�Ԫ�ص�λ�ã��ٶ���ʼʱΪ���ӽ���λ��

                int rightIndex = leftIndex + 1;  // ��ȡ���ӽ���λ��
                if (rightIndex < items.size()) {  // ��������ӽ��
                    T rightChild = items.get(rightIndex);  // ��ȡ���ӽ���Ԫ�ض���
                    if (rightChild.compareTo(maxChild) > 0) {  // �ҳ������ӽڵ��е�����ӽ��
                        maxChild = rightChild;
                        maxIndex = rightIndex;
                    }
                }

                // �������ӽڵ�ȸ��ڵ������Ҫ���µ���
                if (maxChild.compareTo(intent) > 0) {
                    items.set(index, maxChild); // ���ӽڵ�������
                    index = maxIndex; // ��¼���ƽڵ��λ��
                    leftIndex = index * 2 + 1; // �ҵ����ƽڵ�����ӽڵ��λ��
                } else { // ����ӽڵ㲻�ȸ��ڵ��˵������·���Ѿ����Ӵ�С�ź�˳���ˣ�����Ҫ������
                    break;
                }
            }

            // index��ʱ��¼�ǵ����һ�������Ƶ��ӽڵ��λ�ã�Ҳ���������������Խ��ʼ�ĵ�����Ԫ��ֵ����indexλ�ü���
            items.set(index, intent);
        }

        /**
         * ��������һ��Ԫ��
         *
         * @param item �ȴ���ӵ�Ԫ��
         */
        public void add(T item) {
            items.add(item); // ��Ԫ����ӵ����
            siftUp(items.size() - 1); // ѭ�����ƣ�������ع�
        }

        /**
         * ɾ���Ѷ�Ԫ��
         *
         * @return �Ѷ�����Ԫ��
         */
        public T deleteTop() {
            if (items.isEmpty()) { // ������Ѿ�Ϊ�գ��ͱ����쳣
                throw new RuntimeException("The heap is empty.");
            }

            T maxItem = items.get(0); // ��ȡ�Ѷ�Ԫ��
            T lastItem = items.remove(items.size() - 1); // ɾ�����һ��Ԫ��
            if (items.isEmpty()) { // ɾ��Ԫ�غ������Ϊ�յ������˵��ɾ����Ԫ��Ҳ�ǶѶ�Ԫ��
                return lastItem;
            }

            items.set(0, lastItem); // ��ɾ����Ԫ�ط���Ѷ�
            siftDown(0); // �������µ�����
            return maxItem; // ���ضѶ�Ԫ��
        }

        /**
         * ��ȡ��һ��Ԫ��
         *
         * @return ��һ��Ԫ�ض���
         */
        public T next() {

            if (cursor >= items.size()) {
                throw new RuntimeException("No more element");
            }
            return items.get(cursor);

        }

        /**
         * �ж϶����Ƿ�����һ��Ԫ��
         *
         * @return true���л�����һ��Ԫ�أ�false����������Ԫ��
         */
        public boolean hasNext() {
            cursor++;
            return cursor < items.size();
        }

        /**
         * ��ȡ���еĵ�һ��Ԫ��
         *
         * @return ���еĵ�һ��Ԫ��
         */
        public T first() {
            if (items.size() == 0) {
                throw new RuntimeException("The heap is empty.");
            }
            return items.get(0);
        }

        /**
         * �ж϶��Ƿ�Ϊ��
         *
         * @return true�ǣ�false��
         */
        public boolean isEmpty() {
            return items.isEmpty();
        }

        /**
         * ��ȡ�ѵĴ�С
         *
         * @return �ѵĴ�С
         */
        public int size() {
            return items.size();
        }

        /**
         * ��ն�
         */
        public void clear() {
            items.clear();
        }

        @Override
        public String toString() {
            return items.toString();
        }
    }

    /**
     * ��Ŀ�� ����n���������ҳ�������С��k������
     * ���ڶ��ֽⷨ��
     * @param input  ��������
     * @param output �������
     */
    public static void getLeastNumbers2(int[] input, int[] output) {
        if (input == null || output == null || output.length <= 0 || input.length < output.length) {
            throw new IllegalArgumentException("Invalid args");
        }

        MaxHeap<Integer> maxHeap = new MaxHeap<>(output.length);
        for (int i : input) {
            if (maxHeap.size() < output.length) {
                maxHeap.add(i);
            } else {
                int max = maxHeap.first();
                if (max > i) {
                    maxHeap.deleteTop();
                    maxHeap.add(i);
                }
            }
        }

        for (int i = 0; maxHeap.hasNext(); i++) {
            output[i] = maxHeap.next();
        }
    }


    /**
     * ��Ŀ�� ����n���������ҳ�������С��k������
     * ����һ�ֽⷨ��
     * @param input  ��������
     * @param output �������
     */
    public static void getLeastNumbers(int[] input, int[] output) {

        if (input == null || output == null || output.length <= 0 || input.length < output.length) {
            throw new IllegalArgumentException("Invalid args");
        }

        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        int target = output.length - 1;

        while (index != target) {
            if (index < target) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(input, start, end);
        }

        System.arraycopy(input, 0, output, 0, output.length);
    }

    /**
     * �����㷨
     *
     * @param input ��������
     * @param start ��ʼ�±�
     * @param end   �����±�
     * @return ����λ��
     */
    private static int partition(int[] input, int start, int end) {
        int tmp = input[start];

        while (start < end) {
            while (start < end && input[end] >= tmp) {
                end--;
            }
            input[start] = input[end];

            while (start < end && input[start] <= tmp) {
                start++;
            }
            input[end] = input[start];
        }

        input[start] = tmp;
        return start;
    }


    public static void main(String[] args) {
        System.out.println("��һ�ֽⷨ��");
        test1();
        System.out.println();
        System.out.println("�ڶ��ֽⷨ��");
        test2();    
    }

    private static void test1() {
        int[] data = {4, 5, 1, 6, 2, 7, 3, 8};

        int[] output = new int[4];
        getLeastNumbers(data, output);
        for (int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] output2 = new int[8];
        getLeastNumbers(data, output2);
        for (int i : output2) {
            System.out.print(i + " ");
        }
        System.out.println();


        int[] output3 = new int[1];
        getLeastNumbers(data, output3);
        for (int i : output3) {
            System.out.print(i + " ");
        }
        System.out.println();


        int[] data2 = {4, 5, 1, 6, 2, 7, 2, 8};
        int[] output4 = new int[2];
        getLeastNumbers(data2, output4);
        for (int i : output4) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void test2() {
        int[] data = {4, 5, 1, 6, 2, 7, 3, 8};

        int[] output = new int[4];
        getLeastNumbers2(data, output);
        for (int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] output2 = new int[8];
        getLeastNumbers2(data, output2);
        for (int i : output2) {
            System.out.print(i + " ");
        }
        System.out.println();


        int[] output3 = new int[1];
        getLeastNumbers2(data, output3);
        for (int i : output3) {
            System.out.print(i + " ");
        }
        System.out.println();


        int[] data2 = {4, 5, 1, 6, 2, 7, 2, 8};
        int[] output4 = new int[2];
        getLeastNumbers2(data2, output4);
        for (int i : output4) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}