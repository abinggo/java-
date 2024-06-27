public class tree450 {
    /*在Java中，当你修改一个引用类型的变量时，你实际上修改的是该变量所指向的对象。
    如果你只是修改引用本身，而不是该引用所指向的对象，那么这些修改不会影响到其他引用该对象的变量。
    一开始代码是这样
    if (root.right != null) {
    TreeNode temp = root.right;
    while (temp.left != null) {
        temp = temp.left;
    }
    root.val = temp.val;
    temp = null;
}
具体地说，当你执行 temp = null; 时，
你只是将 temp 本身置为 null，并没有修改 temp 原来指向的对象。
所以，root 和 temp 所指向的树节点并没有被删除。
所以比较好一点的方法就是，找到最小的节点之后，再次调用本身，再次去除节点
你需要通过修改 root.right 或 root.left 来真正删除节点。这就需要找到 temp 的父节点，并将其左或右子节点设为 null。

还有不同的删除方法，但是关键还是差不多，这个是直接把节点的左子树一大串直接接过来
class Solution {
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return root;
    if (root.val == key) {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else {
        TreeNode cur = root.right;
        while (cur.left != null) {
          cur = cur.left;
        }
        cur.left = root.left;
        root = root.right;
        return root;
      }
    }
    if (root.val > key) root.left = deleteNode(root.left, key);
    if (root.val < key) root.right = deleteNode(root.right, key);
    return root;
  }
}
    * */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        if (key == root.val) {
            if (root.right != null) {
                TreeNode temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                root.val = temp.val;
                root.right=deleteNode(root.right,temp.val);
            } else if (root.left != null) {
                root = root.left;
            } else {
                root = null;
            }
        }

        return root;

    }
}
