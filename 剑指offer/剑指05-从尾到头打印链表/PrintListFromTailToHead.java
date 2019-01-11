package test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 剑指offer面试题5：从尾到头打印链表
 * 输入一个链表的头结点，从尾到头打印出每个结点的值
 * 解决方案一：首先遍历链表的节点后打印，典型的“后进先出”，可以使用栈来实现这种顺序。
 * 解决方案二：栈的本质就是递归，直接使用递归的方式，打印一个节点的时候先打印它后面的节点，再打印该节点自身，实现反向打印
 * 解决方案三：遍历链表，把链表中的元素复制到ArrayList中，然后逆序打印ArrayList中的元素
 * 解决方案四：前三种解决方案本身属于在打印链表的时候不修改链表本身结构，
 * 在允许修改链表结构的情况下可以把链表中的节点指针反转过来，改变链表方向，然后重新遍历打印改变方向后的链表
 * @author GL
 *
 */
public class PrintListFromTailToHead {

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=null;
        ListNode node6=new ListNode(6);
        ListNode node7=new ListNode();
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        printListFromTailToHead(node1);
        printListFromTailToHead(node5);
        printListFromTailToHead(node6);
        printListFromTailToHead(node7);
        
//        使用栈实现逆序打印链表
        printListFromTailToHeadByStack(node1);
//        使用递归实现逆序打印链表
        printListFromTailToHead(node1);
        //使用递归反转实现逆序打印
        printListFromTailToHeadByReverseList(node1);
        //使用ArrayList逆序打印链表
        printListFromTailToHeadByArrayList(node1);
    }
    
    /*
     * 方案一：通过使用栈结构，遍历链表，把先遍历的节点的值推入栈中，遍历结束后通过弹出栈内元素实现逆序打印 
     */
    public static void printListFromTailToHeadByStack(ListNode node){
        Stack<Integer> stack=new Stack<Integer>();
        while(node!=null){
            stack.push(node.val);
            node=node.next;
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+",");
        }
    }

    
    /*
     * 方案二：递归法逆序打印链表
     */
    public static void printListFromTailToHead(ListNode node){
        if(node!=null){
            if(node.next!=null){
                printListFromTailToHead(node.next);
            }
            System.out.print(node.val+",");
        }
        else
            System.out.println("输入的链表为空");
    }
    
    /*
     * 方案三：使用ArrayList逆序打印链表
     */
    public static void    printListFromTailToHeadByArrayList(ListNode node){
        if(node==null)
            System.out.print("输入链表为null");
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        while(node!=null){
            arrayList.add(node.val);
            node=node.next;
        }
        for(int i=arrayList.size()-1;i>=0;i--){
            System.out.print(arrayList.get(i)+",");
        }
    }
    
    
    /*
     * 方案四：递归反转链表，后遍历打印
     */
    public static void printListFromTailToHeadByReverseList(ListNode node){
        ListNode reversedNode=reverse(node);
        while(reversedNode!=null){
            System.out.print(reversedNode.val+",");
            reversedNode=reversedNode.next;
        }
        
    }
    //递归反转
    private static ListNode reverse(ListNode head){
        if(head.next==null)
            return head;
        ListNode reversedListNode=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return reversedListNode;
    }

}
class ListNode{
    int val;
    ListNode next=null;
    public ListNode(){
    
    }
    public ListNode(int value){
        this.val=value;
    }
}