package test;

import java.util.Stack;

/**
 * ��ָoffer������7��������ջʵ�ֶ���
 * ��Ŀ��������ջʵ��һ�����С����е��������£���ʵ��������������appendTail��deleteHead��
 * �ֱ�����ڶ���β������ڵ���ڶ���ͷ��ɾ���ڵ�Ĺ��ܡ�
 */
public class QueueWithTwoStacks {

    private static Stack<Object> stack1=new Stack<Object>();
    private static Stack<Object> stack2=new Stack<Object>();
    
    /*
     * ��������е�Ԫ��ֻ���뵽ջ1��
     */
    public static void appendTail(Object item){
        stack1.push(item);
        System.out.println("ѹ��ջԪ�أ�"+item);
    }
    /*
     * ɾ��һ��Ԫ��ʱ�����ջ2�Ƿ�Ϊ�գ�ջ2��Ϊ���򵯳�ջ2ջ��Ԫ��
     * ջ2Ϊ�գ����ջ1�е�Ԫ��ȫ��������ѹ�뵽ջ2�У�Ȼ���ջ2ջ������Ԫ��
     */
    public static void deleteHead(){
        if(!stack2.empty())
            System.out.println("����ջԪ�أ�"+stack2.pop());
        else{
            if(stack1.empty())
                throw new RuntimeException("����Ϊ��");
            while(!stack1.empty()){
                Object item=stack1.pop();
                stack2.push(item);
            }
            deleteHead();
        }
    }
    public static void main(String[] args) {
        //��յĶ��������Ԫ��
        appendTail(1);
        //��ǿյĶ��������Ԫ��
        appendTail(2);
        appendTail(3);
        //��ǿյĶ�����ɾ��Ԫ��
        deleteHead();
        deleteHead();
        appendTail(4);
        deleteHead();
        appendTail(5);
        deleteHead();
        deleteHead();
        deleteHead();

    }
}