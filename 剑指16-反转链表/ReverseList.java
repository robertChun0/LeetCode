package test;



//��Ŀ������һ������������һ�������ͷ��㣬��ת�����������ת��������ͷ��㡣
//����˼·����������ֻ��ʵ�ֵ���������ı����������Ҫ�ѵ�ǰ����Ľڵ�ָ������ǰһ���ڵ㣬
//һ����ǰ����ָ�����˱仯���Ͳ��ܸ��ݴ˽ڵ��ȡ��������Ľڵ㣬�����ڸı䷽��ǰҪ���浱ǰ�ڵ����һ�ڵ㣬��ֹ����Ͽ���
//�����Ҫ����ָ�������浱ǰ�ڵ㣬��ǰ�ڵ��ǰ�ڵ㣬��ǰ�ڵ���½ڵ㡣
//
//ע�⣺�����ǰ�ڵ�û����һ�ڵ㣬��˽ڵ���Ƿ�ת��������ͷ��㡣
//
//
//����һ�ֽ���취��ʹ��һ��ջ�ṹ��˳�����������ÿ���ڵ�������ջ����ȫ���ڵ���ջ�����ΰѽڵ��ջ��ȡ�������ӣ������õ�������Ҳ�Ƿ�ת�������

public class ReverseList {

    public static class ListNode {
        int data;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int value, ListNode next) {
            this.data = value;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null)
            throw new RuntimeException("invalid List,can't be null");
        if (head.next == null)
            return head;
        ListNode reversedHead = null;
        ListNode node = head;
        ListNode preNode = null;
        while (node != null) {
            ListNode nextNode = node.next;
            if (nextNode == null)
                reversedHead = node;
            // ��ֵ˳���ܱ�
            node.next = preNode;
            preNode = node;
            node = nextNode;
        }
        return reversedHead;
    }

    public static void print(ListNode head) {
        if (head == null)
            System.out.println("��ǰ����Ϊ��");
        while (head != null) {
            System.out.print(head.data + ",");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4, null);
        ListNode node2 = new ListNode(3, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(1, node3);

        print(reverseList(node4));
        System.out.println();
        print(reverseList(new ListNode(5, null)));
        System.out.println();
        print(reverseList(new ListNode()));
        System.out.println();
    }

}