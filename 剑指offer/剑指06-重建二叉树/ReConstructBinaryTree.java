package test;

/**
 * 剑指offer面试题6：重构二叉树
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建出下图的二叉树并输出他的根节点。
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
    //二叉树节点
    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
    
    /**
     * 判断输入合法性
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
     * 根据前序遍历和中序遍历构建二叉树
     * @param preOrder    前序遍历序列
     * @param ps        前序遍历开始位置
     * @param pe        前序遍历结束位置
     * @param inOrder    中序遍历序列
     * @param is        中序遍历开始位置
     * @param ie        中序遍历结束位置
     * @return            构建的树的根节点
     */
    public static BinaryTreeNode construct(int[] preOrder,int ps,int pe,int[] inOrder,int is,int ie){
        //开始位置大于结束位置说明已经处理到叶节点了
        if(ps>pe)
            return null;
        ///前序遍历第一个数字为当前的根节点
        int value=preOrder[ps];
        //index为根节点在中序遍历序列中的索引
        int index=is;
        while(index<=ie&&inOrder[index]!=value){
            index++;
        }
        System.out.println("当前各参数的数值为->ps:"+ps+" pe:"+pe+" is："+is+" ie："+ie+" index："+index+" rootValue："+value);
        //如果在整个中序遍历中没有找到根节点说明输入的数据是不合法的
        if(index>ie){
            throw new RuntimeException("invalid input"+index);
        }
        BinaryTreeNode node=new BinaryTreeNode();
        node.value=value;
        //当前节点的左子树的个数为index-is
        //左子树对应的前序遍历的位置在preOrder[ps+1,ps+index-is]
        //左子树对应的中序遍历的位置在inOrder[is,index-1]
        node.left=construct(preOrder,ps+1,ps+index-is,inOrder,is,index-1);
        //当前节点的右子树的个数为ie-index
        //右子树对应的前序遍历位置在preOrder[ps+index-is+1,pe]
        //右子树对应的中序遍历位置在inOrder[index+1,ie]
        node.right=construct(preOrder,ps+index-is+1,pe,inOrder,index+1,ie);
        return node;
    }
    //中序遍历递归打印
    public static void printTree(BinaryTreeNode node){
        if(node!=null){
            printTree(node.left);
            System.out.print(node.value+" ");
            printTree(node.right);
        }
    }
    
}