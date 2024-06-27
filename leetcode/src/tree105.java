import java.util.HashMap;
/*
* 与106类似
* 但是自己还是写的有点乱
* 关键在于，左闭右开判断什么时候为空的情况！
* 因为右边是开的 所以就会多一个出来，所以要减去1
* 那能不能左闭右闭呢？
* 理论来说可以，但是也很容易乱
* 代码随想录的方法，关键在于去看，如果不满足左闭右开，则说明没有元素
*  Map<Integer, Integer> map;  // 方便根据数值查找位置
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
            map.put(inorder[i], i);
        }

        return findNode(inorder,  0, inorder.length, postorder,0, postorder.length);  // 前闭后开
    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        // 参数里的范围都是前闭后开
        if (inBegin >= inEnd || postBegin >= postEnd) {  // 不满足左闭右开，说明没有元素，返回空树
            return null;
        }
        int rootIndex = map.get(postorder[postEnd - 1]);  // 找到后序遍历的最后一个元素在中序遍历中的位置
        TreeNode root = new TreeNode(inorder[rootIndex]);  // 构造结点
        int lenOfLeft = rootIndex - inBegin;  // 保存中序左子树个数，用来确定后序数列的个数
        root.left = findNode(inorder, inBegin, rootIndex,
                            postorder, postBegin, postBegin + lenOfLeft);
        root.right = findNode(inorder, rootIndex + 1, inEnd,
                            postorder, postBegin + lenOfLeft, postEnd - 1);

        return root;
    }*/
public class tree105 {
    public TreeNode helper(HashMap<Integer,Integer> map,int[] preorder, int prebign,int preend,int[] inorder,int inbeign,int inend){
    TreeNode root = new TreeNode();
    int temp = map.get(preorder[prebign]);//1
    root.val = preorder[prebign];
    int leftlong = temp-inbeign;//1
    int rightlong = inend - temp;//3
    if(leftlong!=0){root.left = helper(map,preorder,prebign+1,prebign+1+leftlong,inorder,inbeign,temp);}else{root.left=null;}
    if(rightlong-1==0){root.right=null;}else{root.right = helper(map,preorder,prebign+1+leftlong,preend,inorder,temp+1,inend);}
    return root;

}
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(map,preorder,0,preorder.length,inorder,0,inorder.length);

    }
}
