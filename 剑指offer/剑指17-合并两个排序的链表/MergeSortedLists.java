package test;

//
//��Ŀ������������������������ϲ�����������ʹ�������еĽڵ����ǰ��յ�������ġ�
//����˼·����������ֱ��Ѿ���������ˣ����������ʱ��ֻҪ�Ƚ���������ǰλ�ô�С��ȡ����С����ӵ��������С�
//
//�����еݹ顢ѭ�����ַ�ʽ�������
public class MergeSortedLists {

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

    public static void print(ListNode head) {
        if (head == null)
            System.out.println("��ǰ����Ϊ��");
        while (head != null) {
            System.out.print(head.data + ",");
            head = head.next;
        }
        System.out.println();
    }
    //�ݹ鷽ʽ�ϲ��������������
    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        ListNode mergedHead = null;
        if (head1.data < head2.data) {
            mergedHead = head1;
            mergedHead.next = merge(head1.next, head2);
        } else {
            // ��������ڵ��ֵ��ͬ�����صڶ���
            mergedHead = head2;
            mergedHead.next = merge(head1, head2.next);
        }
        return mergedHead;
    }
    //���αȽ���������ĵ�ǰ��㣬��ӵ���������
    public static ListNode mergeSortedList(ListNode head1, ListNode head2) {
        if (head1 == null)
            return head2;
        if (head2 == null) {
            return head1;
        }
        ListNode newHead = null;
        ListNode newNode = null;
        ListNode list1 = head1;
        ListNode list2 = head2;
        // �ҵ��µ�ͷ���
        if (list1.data < list2.data) {
            newHead = list1;
            list1 = list1.next;
        } else {
            newHead = list2;
            list2 = list2.next;
        }
        newNode = newHead;
        // �ϲ������ڵ�
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                newNode.next = list1;
                list1 = list1.next;
            } else {
                newNode.next = list2;
                list2 = list2.next;
            }
            newNode = newNode.next;
        }
        // ��һ������ϲ��꣬���ʣ�µ���һ������ֱ�Ӻϲ���������ĩβ
        if (list1 == null) {
            newNode.next = list2;
        } else {
            newNode.next = list1;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(7, null);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode head1 = new ListNode(1, node3);

        ListNode node5 = new ListNode(8, null);
        ListNode node6 = new ListNode(6, node5);
        ListNode node7 = new ListNode(4, node6);
        ListNode head2 = new ListNode(2, node7);
        // ���Ժ�����ֵͬ�������Ը��ڵ������ĺϲ����ϲ���head1��merged1��ָ��ϲ�����������ͷ���
        // ListNode merged1 = merge(head1, head2);
        // print(merged1);
        // // ���Ժ���һ��nullͷָ�������ĺϲ�������head2ָ����һ���ϲ����������ĵڶ����ڵ㣬��������Ľڵ����Ϊ�ܸ���-1
        // print(merge(head2, null));
        // // ��������������ֻ��һ���ڵ�
        // print(merge(null, new ListNode(10, null)));
        ListNode merged1 = mergeSortedList(head1, head2);
        print(merged1);
        // ���Ժ���һ��nullͷָ�������ĺϲ�������head2ָ����һ���ϲ����������ĵڶ����ڵ㣬��������Ľڵ����Ϊ�ܸ���-1
        print(mergeSortedList(head2, null));
        // ��������������ֻ��һ���ڵ�
        print(mergeSortedList(null, new ListNode(10, null)));
    }

}