package test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * ��ָoffer������5����β��ͷ��ӡ����
 * ����һ�������ͷ��㣬��β��ͷ��ӡ��ÿ������ֵ
 * �������һ�����ȱ�������Ľڵ���ӡ�����͵ġ�����ȳ���������ʹ��ջ��ʵ������˳��
 * �����������ջ�ı��ʾ��ǵݹ飬ֱ��ʹ�õݹ�ķ�ʽ����ӡһ���ڵ��ʱ���ȴ�ӡ������Ľڵ㣬�ٴ�ӡ�ýڵ�����ʵ�ַ����ӡ
 * ��������������������������е�Ԫ�ظ��Ƶ�ArrayList�У�Ȼ�������ӡArrayList�е�Ԫ��
 * ��������ģ�ǰ���ֽ���������������ڴ�ӡ�����ʱ���޸�������ṹ��
 * �������޸�����ṹ������¿��԰������еĽڵ�ָ�뷴ת�������ı�������Ȼ�����±�����ӡ�ı䷽��������
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
        
//        ʹ��ջʵ�������ӡ����
        printListFromTailToHeadByStack(node1);
//        ʹ�õݹ�ʵ�������ӡ����
        printListFromTailToHead(node1);
        //ʹ�õݹ鷴תʵ�������ӡ
        printListFromTailToHeadByReverseList(node1);
        //ʹ��ArrayList�����ӡ����
        printListFromTailToHeadByArrayList(node1);
    }
    
    /*
     * ����һ��ͨ��ʹ��ջ�ṹ�������������ȱ����Ľڵ��ֵ����ջ�У�����������ͨ������ջ��Ԫ��ʵ�������ӡ 
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
     * ���������ݹ鷨�����ӡ����
     */
    public static void printListFromTailToHead(ListNode node){
        if(node!=null){
            if(node.next!=null){
                printListFromTailToHead(node.next);
            }
            System.out.print(node.val+",");
        }
        else
            System.out.println("���������Ϊ��");
    }
    
    /*
     * ��������ʹ��ArrayList�����ӡ����
     */
    public static void    printListFromTailToHeadByArrayList(ListNode node){
        if(node==null)
            System.out.print("��������Ϊnull");
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
     * �����ģ��ݹ鷴ת�����������ӡ
     */
    public static void printListFromTailToHeadByReverseList(ListNode node){
        ListNode reversedNode=reverse(node);
        while(reversedNode!=null){
            System.out.print(reversedNode.val+",");
            reversedNode=reversedNode.next;
        }
        
    }
    //�ݹ鷴ת
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