import java.util.LinkedList;
import java.util.Queue;
//相同的问题就是不断在变幻
/*
* 关键问题在于了解层序遍历的两种方法
* 广度搜索用队列！！！这是比较适合层序遍历的种种变体
* 例外一种用递归的方法，深度优先搜索，适合做与深度相关的问题
* 代码随想录的解法2，这个时候不用额外创建队列
* 不断迭代就行，就是左->右，右->下一个左
* class Solution {
	public Node connect(Node root) {
		if(root==null) {
			return root;
		}
		Node pre = root;
		//循环条件是当前节点的left不为空，当只有根节点
		//或所有叶子节点都出串联完后循环就退出了
		while(pre.left!=null) {
			Node tmp = pre;
			while(tmp!=null) {
				//将tmp的左右节点都串联起来
				//注:外层循环已经判断了当前节点的left不为空
				tmp.left.next = tmp.right;
				//下一个不为空说明上一层已经帮我们完成串联了
				if(tmp.next!=null) {
					tmp.right.next = tmp.next.left;
				}
				//继续右边遍历
				tmp = tmp.next;
			}
			//从下一层的最左边开始遍历
			pre = pre.left;
		}
		return root;
	}
}
它的第三种解法，采用深度优先搜索递归，这个比较考验逻辑行，先把中间的链接完，在链接两边的
* class Solution {
	public Node connect(Node root) {
		dfs(root);
		return root;
	}

	void dfs(Node root) {
		if(root==null) {
			return;
		}
		Node left = root.left;
		Node right = root.right;
		//配合动画演示理解这段，以root为起点，将整个纵深这段串联起来
		while(left!=null) {
			left.next = right;
			left = left.right;
			right = right.left;
		}
		//递归的调用左右节点，完成同样的纵深串联
		dfs(root.left);
		dfs(root.right);
	}
}

*/
public class tree116 {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if(root == null){return root;}
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int lenlevel = que.size();
            while(lenlevel>0){
                Node fre = que.remove();
                Node beh = null;
                if(lenlevel!=1){
                    beh = que.peek();}
                fre.next = beh;
                if(fre.left!=null){que.add(fre.left);}
                if(fre.right!=null){que.add(fre.right);}
                lenlevel--;
            }
        }
        return root;
    }
}
