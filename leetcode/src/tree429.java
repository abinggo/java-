import java.util.ArrayList;
import java.util.List;
/*
* 与层序遍历二叉树类似，就添加一个循环就可以
* */
public class tree429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public void nlevel(Node root , int depth ,List<List<Integer>> outter){
        if(root==null){return;}
        depth++;
        if(outter.size()<depth){
            List<Integer> inner = new ArrayList<>();
            outter.add(inner);
        }
        outter.get(depth-1).add(root.val);
        List<Node> children = root.children;
        for(int i =0;i<children.size();i++){
            nlevel(children.get(i),depth,outter);
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> outter = new ArrayList<>();
        if(root==null){return outter;}
        nlevel(root,0,outter);
        return outter;
    }
}
