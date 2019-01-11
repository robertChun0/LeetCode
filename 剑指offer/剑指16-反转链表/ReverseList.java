package test;



//题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后的链表的头结点。
//解题思路：单向链表只能实现单向遍历，改变链表方向就是要把当前链表的节点指向它的前一个节点，
//一旦当前链表指向发生了变化，就不能根据此节点获取到它后面的节点，所以在改变方向前要保存当前节点的下一节点，防止链表断开，
//因此需要三个指针来保存当前节点，当前节点的前节点，当前节点的下节点。
//
//注意：如果当前节点没有下一节点，则此节点就是反转后的链表的头结点。
//
//
//另外一种解决办法是使用一个栈结构，顺序遍历链表，把每个节点依次入栈。待全部节点入栈后，依次把节点从栈中取出并连接，这样得到的链表也是反转后的链表。

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
            // 赋值顺序不能变
            node.next = preNode;
            preNode = node;
            node = nextNode;
        }
        return reversedHead;
    }

    public static void print(ListNode head) {
        if (head == null)
            System.out.println("当前链表为空");
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