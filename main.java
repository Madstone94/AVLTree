import java.util.*;
/**
 * Create a AVL tree, fill it with 100 numbers, and print.
 * @ Matthew Stone
 * @12/11/16
 */
public class main
{
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        for (int i = 1; i <= 100; i++)
        {
            tree.root = tree.insert(tree.root, i);
        }
        System.out.println("inorder traversal" + " of constructed tree is : ");
        tree.printPaths(tree.root);
    }
}


