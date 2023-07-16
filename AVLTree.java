class AVLTree {
    Node root;
    int height(Node node)
    {
        if (node == null)
        {
            return 0;
        }
        return node.height;
    }
    int max(int a, int b)
    {
        return (a > b) ? a : b;
    }
    Node rightRotate(Node y) {
        Node x = y.lchild;
        Node temp = x.rchild;
        x.rchild = y;
        y.lchild = temp;
        y.height = max(height(y.lchild), height(y.rchild)) + 1;
        x.height = max(height(x.lchild), height(x.rchild)) + 1;
        return x;
    }
    Node leftRotate(Node x) {
        Node y = x.rchild;
        Node temp = y.lchild;
        y.lchild = x;
        x.rchild = temp;
        x.height = max(height(x.lchild), height(x.rchild)) + 1;
        y.height = max(height(y.lchild), height(y.rchild)) + 1;
        return y;
    }
    int getBalance(Node node)
    {
        if (node == null)
        {
            return 0;
        }
        return height(node.lchild) - height(node.rchild);
    }
    Node insert(Node node, int number) {
        if (node == null)
        {
            return (new Node(number));
        }
        if (number < node.data)
        {
            node.lchild = insert(node.lchild, number);
        }
        else if (number > node.data)
        {
            node.rchild = insert(node.rchild, number);
        }
        else
        {
            return node;
        }
        node.height = 1 + max(height(node.lchild),height(node.rchild));
        int balance = getBalance(node);
        if (balance > 1 && number < node.lchild.data)
        {
            return rightRotate(node);
        }
        if (balance < -1 && number > node.rchild.data)
        {
            return leftRotate(node);
        }
        if (balance > 1 && number > node.lchild.data)
        {
            node.lchild = leftRotate(node.lchild);
            return rightRotate(node);
        }
        if (balance < -1 && number < node.rchild.data) 
        {
            node.rchild = rightRotate(node.rchild);
            return leftRotate(node);
        }
        return node;
    }
    void printPaths(Node node) 
    {
        int paths[] = new int[1000];
        printPath(node, paths, 0);
    }
    void printPath(Node node, int paths[], int path) 
    {
        if (node == null)
        {
            return;
        }
        paths[path] = node.data;
        path++;
        if (node.lchild == null && node.rchild == null)
        {
            printArray(paths, path);
        }
        else
        { 
            printPath(node.lchild, paths, path);
            printPath(node.rchild, paths, path);
        }
    }
    void printArray(int paths[], int path) 
    {
        for (int i = 0; i < path; i++)
        {
                System.out.print(paths[i] + " ");
                System.out.println("");
        }
    }
}