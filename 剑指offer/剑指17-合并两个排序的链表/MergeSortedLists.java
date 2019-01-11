package test;

//
//题目：输入两个递增排序的链表，合并这两个链表并使新链表中的节点人是按照递增排序的。
//解题思路：两个链表分别都已经是有序的了，遍历链表的时候只要比较两个链表当前位置大小，取出最小的添加到新链表中。
//
//可以有递归、循环两种方式来解决。
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
            System.out.println("当前链表为空");
        while (head != null) {
            System.out.print(head.data + ",");
            head = head.next;
        }
        System.out.println();
    }
    //递归方式合并两个排序的链表
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
            // 如果两个节点的值相同，返回第二个
            mergedHead = head2;
            mergedHead.next = merge(head1, head2.next);
        }
        return mergedHead;
    }
    //依次比较两个链表的当前结点，添加到新链表中
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
        // 找到新的头结点
        if (list1.data < list2.data) {
            newHead = list1;
            list1 = list1.next;
        } else {
            newHead = list2;
            list2 = list2.next;
        }
        newNode = newHead;
        // 合并其他节点
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
        // 有一条链表合并完，则把剩下的另一条链表直接合并到新链条末尾
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
        // 测试含有相同值得两个对各节点的链表的合并，合并后head1和merged1都指向合并后的新链表的头结点
        // ListNode merged1 = merge(head1, head2);
        // print(merged1);
        // // 测试含有一个null头指针的链表的合并，由于head2指向上一步合并后的新链表的第二个节点，所以输出的节点个数为总个数-1
        // print(merge(head2, null));
        // // 测试两个链表中只有一个节点
        // print(merge(null, new ListNode(10, null)));
        ListNode merged1 = mergeSortedList(head1, head2);
        print(merged1);
        // 测试含有一个null头指针的链表的合并，由于head2指向上一步合并后的新链表的第二个节点，所以输出的节点个数为总个数-1
        print(mergeSortedList(head2, null));
        // 测试两个链表中只有一个节点
        print(mergeSortedList(null, new ListNode(10, null)));
    }

}