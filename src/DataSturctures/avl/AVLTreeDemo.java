package DataSturctures.avl;

/**
 * 平衡二叉树
 */
public class AVLTreeDemo {

    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
        int[] arr = {10,8,12,7,9,6};
        AVLTree avlTree = new AVLTree();

        for (int value : arr) {
            avlTree.add(new Node(value));
        }

        avlTree.infixOrder();
        System.out.println("平衡后~~");
        System.out.println("树的高度: " + avlTree.getRoot().height());
        System.out.println("树的左子树高度: " + avlTree.getRoot().leftHeight());
        System.out.println("树的右子树的高度: " + avlTree.getRoot().rightHeight());
        System.out.println("平衡后的Root节点: "+ avlTree.getRoot());
    }


}

class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //添加节点的方法
    public void add(Node node) {
        if (root == null) {
            root = node; //如果root为空则直接让root指向node
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("此树为空！！！");
        }
    }
}

class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //添加结点的方法
    //递归形式添加结点，注意需要满足二叉排序树的要求
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断传入的结点的值，和当前子树的根结点的值关系
        if (node.value < this.value) {
            //如果当前结点左子结点为null
            if (this.left == null) {
                this.left = node;
            } else {
                //递归的向左子树添加
                this.left.add(node);
            }
        } else {//添加的结点的值大于当前结点的值
            if (this.right == null) {
                this.right = node;
            } else {
                //递归的向右子树添加
                this.right.add(node);
            }
        }

        //当添加完一个节点后，如果：(右子树的高度 - 左子树的高度) > 1,左旋转
        if (rightHeight() - leftHeight() > 1) {
            leftRotate();
        }

        if (leftHeight() - rightHeight() > 1){
            rightRotate();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    //返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //返回以该节点为根节点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //左旋转
    public void leftRotate() {
        //创建新的节点，以当前节点根节点的值
        Node newNode = new Node(value);
        //把新的节点的左子树设置成当前节点的左子树
        newNode.left = left;
        //把新节点的右子树设置成当前节点的右子树的左子树
        newNode.right = right.left;
        //把当前节点的值替换成右子节点的值
        value = right.value;
        //把当前节点的右子树设置成当前节点的右子树的右子树
        right = right.right;
        //把当前的左子树设置成新的节点
        left = newNode;
    }

    //右旋转
    public void rightRotate(){
        Node newNode = new Node(value);
        newNode.left = left.right;
        newNode.right = right;
        value = left.value;
        left = left.left;
        right = newNode;
    }
}