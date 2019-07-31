package HomeTask2;

public class TreeNode {
    int val;
    int size = 0;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }

    TreeNode(){
    }

    public void add(int value) {
        TreeNode tree = new TreeNode(value);
        if (this == null) {
            this.val = tree.val;
            size++;
        } else {
            addToTree(this,tree);
        }
    }

    public void addToTree(TreeNode source, TreeNode node) {
        if (node.val < source.val) {
            if (source.left == null) {
                source.left = node;
            } else {
                addToTree(source.left, node);
            }
        } else if (node.val > source.val) {
            if (source.right == null) {
                source.right = node;
            } else {
                addToTree(source.right, node);
            }
        }
        size++;
    }

    @Override
    public String toString() {
        return "T{" +
                "val =" + val +
                ", L =" + left +
                ", R =" + right +
                '}';
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //TreeNode mergedTree = this;
        if (t1 == null) {
            if (t2 != null) {
                t1.val = t2.val;
            } else if (t1.left == null){
                if (t2.left != null) {
                    mergeTrees(t1.left, t2.left);
                } else {
                    mergeTrees(t1.right, t2.right);
                }
            }
        } else {
            t1.val = t1.val + t2.val;
            mergeTrees(t1.left, t2.left);
            mergeTrees(t1.right, t2.right);
        }
        return this;
    }
}
