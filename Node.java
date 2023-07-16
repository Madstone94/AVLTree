// Java program for insertion in AVL Tree
class Node {
    int data, height;
    Node lchild, rchild;
    Node(int number)
    {
        data = number;
        height = 1;
        this.lchild = null;
        this.rchild = null;
    }
}