//题目：输入一个链表，输出该链表的倒数第K个节点。为了符合大多数人的习惯，本题从1开始计数，即链表尾节点是倒数第一个节点。 
//解题思路：
//解法一：一般情况下，单向链表无法从后一个节点获取到它前面的节点，可以通过两次遍历，第一次遍历获取链表中节点的个数，第二次遍历找到链表中第n-k+1个节点，就是链表的倒数第k个节点。
//但是这种方法效率低，可以使用一次遍历得到倒数第K个节点
//解法二：一次遍历得到倒数第K个节点。维护两个指针，第一个指针从链表头结点向前走k-1步，第二个节点指向头结点，从第K步开始，如果走在前面的节点有下一个节点，那两个节点一起向前走，
//直到第一个节点走到尾节点，此时第二个节点指向倒数第K个节点 
//程序健壮性考虑：
//1.输入链表为null 2.输入k为0或小于0 3.链表节点总数小于k


package test;

public class FindKthNodeFromEnd {

    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int value, ListNode next) {
            this.data = value;
            this.next = next;
        }
    }

    public static ListNode findKthNodeFromEnd(ListNode head, int k) {
        if (head == null)
            throw new RuntimeException("待查找的链表不能为空");
        if (k <= 0)
            throw new RuntimeException("输入的位置数字不合法");
        ListNode ahead = head;
        ListNode behind = head;
        // 第一个指针先指向K-1，并检验链表中节点个数是否大于k
        int count = 1;
        for (int i = 0; i < k - 1; i++) {
            if (ahead.next != null) {
                ahead = ahead.next;
                count++;
            } else
                throw new RuntimeException("链表节点个数：" + count + " 小于输入K的个数：" + k);
        }
        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }
        return behind;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4, null);
        ListNode node2 = new ListNode(3, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node3);
        ListNode find = findKthNodeFromEnd(head, 3);
        System.out.println("找到的节点位" + find.data);
        ListNode find2 = findKthNodeFromEnd(head, 5);
        System.out.println("找到的节点位" + find2.data);
    }
}