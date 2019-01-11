package test;

/**
 * ��ָoffer������6���ع�������
 * ��Ŀ������ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ������������������ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ�����ͼ�Ķ�������������ĸ��ڵ㡣
 *                     1
 *                   /   \
 *                  2     3
 *                 /     / \
 *                4     5   6
 *                 \        /
 *                 7        8
 * @author GL
 *
 */
public class ReConstructBinaryTree {

    public static void main(String[] args) {
        int[] preOrder={1,2,4,7,3,5,6,8};
        int[] inOrder={4,7,2,1,5,3,8,6};
        BinaryTreeNode node=reConstruct(preOrder,inOrder);
        printTree(node);
    }
    //�������ڵ�
    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
    
    /**
     * �ж�����Ϸ���
     * @param preOrder
     * @param inOrder
     * @return
     */
    public static BinaryTreeNode reConstruct(int[] preOrder,int[] inOrder){
        if(preOrder==null||inOrder==null||preOrder.length!=inOrder.length||preOrder.length<1)
            return null;
        return construct(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
    }
    
    /**
     * ����ǰ������������������������
     * @param preOrder    ǰ���������
     * @param ps        ǰ�������ʼλ��
     * @param pe        ǰ���������λ��
     * @param inOrder    �����������
     * @param is        ���������ʼλ��
     * @param ie        �����������λ��
     * @return            ���������ĸ��ڵ�
     */
    public static BinaryTreeNode construct(int[] preOrder,int ps,int pe,int[] inOrder,int is,int ie){
        //��ʼλ�ô��ڽ���λ��˵���Ѿ�����Ҷ�ڵ���
        if(ps>pe)
            return null;
        ///ǰ�������һ������Ϊ��ǰ�ĸ��ڵ�
        int value=preOrder[ps];
        //indexΪ���ڵ���������������е�����
        int index=is;
        while(index<=ie&&inOrder[index]!=value){
            index++;
        }
        System.out.println("��ǰ����������ֵΪ->ps:"+ps+" pe:"+pe+" is��"+is+" ie��"+ie+" index��"+index+" rootValue��"+value);
        //������������������û���ҵ����ڵ�˵������������ǲ��Ϸ���
        if(index>ie){
            throw new RuntimeException("invalid input"+index);
        }
        BinaryTreeNode node=new BinaryTreeNode();
        node.value=value;
        //��ǰ�ڵ���������ĸ���Ϊindex-is
        //��������Ӧ��ǰ�������λ����preOrder[ps+1,ps+index-is]
        //��������Ӧ�����������λ����inOrder[is,index-1]
        node.left=construct(preOrder,ps+1,ps+index-is,inOrder,is,index-1);
        //��ǰ�ڵ���������ĸ���Ϊie-index
        //��������Ӧ��ǰ�����λ����preOrder[ps+index-is+1,pe]
        //��������Ӧ���������λ����inOrder[index+1,ie]
        node.right=construct(preOrder,ps+index-is+1,pe,inOrder,index+1,ie);
        return node;
    }
    //��������ݹ��ӡ
    public static void printTree(BinaryTreeNode node){
        if(node!=null){
            printTree(node.left);
            System.out.print(node.value+" ");
            printTree(node.right);
        }
    }
    
}