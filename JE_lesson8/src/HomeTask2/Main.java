package HomeTask2;

public class Main {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(7);
        tree1.add(10);
        tree1.add(5);
        tree1.add(6);
        tree1.add(3);
        //tree1.add(8);
        //tree1.add(9);
        System.out.println(tree1);

        TreeNode tree2 = new TreeNode(5);
        tree2.add(7);
        tree2.add(4);
        tree2.add(6);
        tree2.add(3);
        //tree2.add(8);
        //tree2.add(9);
        System.out.println(tree2);
        System.out.println(tree1.mergeTrees(tree1,tree2));
    }
}
