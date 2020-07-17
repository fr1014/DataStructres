package DataSturctures.tree.threadbinarytree;

public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(1, "1");
        HeroNode h3 = new HeroNode(2, "3");
        HeroNode h6 = new HeroNode(3, "6");
        HeroNode h8 = new HeroNode(4, "8");
        HeroNode h10 = new HeroNode(5, "10");
        HeroNode h14 = new HeroNode(6, "14");

        h1.setLeft(h3);
        h1.setRight(h6);
        h3.setLeft(h8);
        h3.setRight(h10);
        h6.setLeft(h14);

        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(h1);
//        threadedBinaryTree.infixOrder();   //中序遍历结果{ 8 , 3 , 10 , 1 , 14 , 6 }
        threadedBinaryTree.threadedNodes();

        //测试：以10号节点测试
        HeroNode leftNode = h10.getLeft();
        HeroNode rightNode = h10.getRight();
        System.out.println("10号结点的前驱结点 = " + leftNode);  //3
        System.out.println("10号结点的后继结点 = " + rightNode); //1
    }

}

class ThreadedBinaryTree {

    private HeroNode root; //根节点

    //为了实现线索化，需要创建指向当前结点的前驱结点的指针
    //在递归进行线索化，pre总是保留前一个结点
    private HeroNode pre = null;

    public ThreadedBinaryTree() {
    }

    public ThreadedBinaryTree(HeroNode root) {
        this.root = root;
    }

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //编写对二叉树中序线索化的方法
    public void threadedNodes() {
        threadedNodes(root);
    }

    /**
     * @param node 当前需要线索化的结点
     */
    public void threadedNodes(HeroNode node) {
        //如果node == null,不能线索化
        if (node == null) {
            return;
        }

        /* *************************** */

        //(一)先线索化左子树
        threadedNodes(node.getLeft());

        /* *************************** */

        //(二)线索化当前结点 (***)

        //处理当前结点的前驱结点
        if (node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型，指向前驱结点
            node.setLeftType(1);
        }

        //处理后继结点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }

        //每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

        /* *************************** */

        //(三)再线索化右子树
        threadedNodes(node.getRight());
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("此二叉树为空！无法遍历");
        }
    }
}

class HeroNode {
    private int id;
    private String name;

    private HeroNode left;
    private HeroNode right;

    //1.如果leftType == 0表示指向左子树，如果1则表示指向前驱结点
    //2.如果rightType == 0表示指向右子树，如果1则表示指向后继结点
    private int leftType = 0;
    private int rightType = 0;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
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

    @Override
    public String toString() {
        return "HeroNode{" +
                "name='" + name + '\'' +
                '}';
    }
}