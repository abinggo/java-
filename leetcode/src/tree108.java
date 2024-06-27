public class tree108 {
    /*
    * 关键！！！
    * 平衡二叉树是每个节点都需要满足左右子树的高度差小于1！！！
    * 记住是所有
    * 首先取数组中间元素的位置，不难写出int mid = (left + right) / 2;，
    * 这么写其实有一个问题，就是数值越界，例如left和right都是最大int，这么操作就越界了，
    * 在二分法 (opens new window)中尤其需要注意！
       所以可以这么写：int mid = left + ((right - left) / 2);

*/
    public TreeNode helpbuild(int[] nums, int start, int end){
        if(start>=end){return null;}
        int mid = (end+start)/2; //左闭又开
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helpbuild(nums,start,mid);
        root.right = helpbuild(nums,mid+1,end);
        return root;

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return helpbuild(nums,0,nums.length);
    }

}
