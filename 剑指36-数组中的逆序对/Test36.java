package test;

public class Test36 {

//	public static void main(String[] args) {
//		int[] data = {1, 2, 3, 4, 7, 6, 5};
//        System.out.println(method1(data)); // 3
//        int[] data2 = {6, 5, 4, 3, 2, 1};
//        System.out.println(method1(data2)); //  15
//        int[] data3 = {1, 2, 3, 4, 5, 6};
//        System.out.println(method1(data3)); // 0
//        int[] data4 = {1};
//        System.out.println(method1(data4)); // 0
//        int[] data5 = {1, 2};
//        System.out.println(method1(data5)); // 0
//        int[] data6 = {2, 1};
//        System.out.println(method1(data6)); // 1
//        int[] data7 = {1, 2, 1, 2, 1};
//        System.out.println(method1(data7)); // 3
//	}
	
	//O(n^2)
//	private static int method1(int[] data) {
//		int result=0;
//		for(int i=0;i<data.length;i++){
//			for(int j=i+1;j<data.length;j++){
//				if (data[i]>data[j]) {
//					result++;
//				}
//			}
//		}
//		
//		
//		return result;
//		
//	}
	
	
	public static int inversePairs(int[] data) {
        if (data == null || data.length < 1) {
            throw new IllegalArgumentException("Array arg should contain at least a value");
        }

        int[] copy = new int[data.length];
        System.arraycopy(data, 0, copy, 0, data.length);

        return inversePairsCore(data, copy, 0, data.length - 1);
    }

    private static int inversePairsCore(int[] data, int[] copy, int start, int end) {

        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        int length = (end - start) / 2;
        int left = inversePairsCore(copy, data, start, start + length);
        int right = inversePairsCore(copy, data, start + length + 1, end);

        // ǰ��ε����һ�����ֵ��±�
        int i = start + length;
        // �������һ�����ֵ��±�
        int j = end;
        // ��ʼ������λ��
        int indexCopy = end;
        // ������
        int count = 0;

        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                copy[indexCopy] = data[i];
                indexCopy--;
                i--;
                count += j - (start + length); // ��Ӧ��������
            } else {
                copy[indexCopy] = data[j];
                indexCopy--;
                j--;
            }
        }

        for (; i >= start;) {
            copy[indexCopy] = data[i];
            indexCopy--;
            i--;
        }

        for (; j >= start + length + 1;) {
            copy[indexCopy] = data[j];
            indexCopy--;
            j--;
        }
        return count + left + right;
    }
    
    
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 7, 6, 5};
        System.out.println(inversePairs(data)); // 3
        int[] data2 = {6, 5, 4, 3, 2, 1};
        System.out.println(inversePairs(data2)); //  15
        int[] data3 = {1, 2, 3, 4, 5, 6};
        System.out.println(inversePairs(data3)); // 0
        int[] data4 = {1};
        System.out.println(inversePairs(data4)); // 0
        int[] data5 = {1, 2};
        System.out.println(inversePairs(data5)); // 0
        int[] data6 = {2, 1};
        System.out.println(inversePairs(data6)); // 1
        int[] data7 = {1, 2, 1, 2, 1};
        System.out.println(inversePairs(data7)); // 3
    }
}
