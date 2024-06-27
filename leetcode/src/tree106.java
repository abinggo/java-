import java.util.Arrays;
/*
* 采用递归建树
* 先找到根结点！！！
* 然后就可以确定左子树和右子树
* 关键要注意数组拷贝的问题！！！
* 数组拷贝左闭右开区间Arrays.copyOfRange（）
* 代码随想录方法一：不用循环多次拷贝数组，直接用一个哈希表存储中序遍历
* 然后还可以多方便查找，不用每一次都查找
* 总结就是少使用数组拷贝，可以是用值记录位置就可以
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
    }
* */
public class tree106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int post=0;
        TreeNode root = new TreeNode();
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==postorder[postorder.length-1])
            {post=i;break;}
        }
        //数组拷贝,左闭右开
        root.val=inorder[post];
        if(post!=0){root.left=buildTree(Arrays.copyOfRange(inorder,0,post),Arrays.copyOfRange(postorder,0,post));}
        else{root.left=null;}
        if((inorder.length-1-post)!=0){root.right=buildTree(Arrays.copyOfRange(inorder,post+1,inorder.length),Arrays.copyOfRange(postorder,post,postorder.length-1));}
        else{root.right=null;}
        return root;
    }
}
