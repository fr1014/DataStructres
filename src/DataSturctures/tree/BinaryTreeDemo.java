package DataSturctures.tree;

public class BinaryTreeDemo {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);

        System.out.println("前序遍历：");
        binaryTree.preOrder();  //1,2,3,5,4
        System.out.println("前序遍历查找：");
        System.out.println(binaryTree.preOrderFind(5));

        System.out.println("中序遍历：");
        binaryTree.infixOrder(); //2,1,5,3,4
        System.out.println("中序遍历查找：");
        System.out.println(binaryTree.infixOrderFind(5));
        System.out.println("后序遍历");
        binaryTree.postOrder(); //2,5,4,3,1
        System.out.println("后序遍历查找：");
        System.out.println(binaryTree.postOrderFind(5));

        System.out.println("===========");
        binaryTree.delNode(5);   //删除id为5的结点
        binaryTree.preOrder();
    }
}

class BinaryTree {
    private HeroNode root;  //根节点

    public BinaryTree() {
    }

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("此二叉树为空，无法遍历！");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("此二叉树为空，无法遍历！");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("此二叉树为空，无法遍历！");
        }
    }

    /**
     * 前序遍历查找
     *
     * @param id 需要查找的id
     * @return
     */
    public HeroNode preOrderFind(int id) {
        if (this.root != null) {
            return this.root.preOrderFind(id);
        }
        return null;
    }

    /**
     * 中序遍历查找
     *
     * @param id 需要查找的id
     * @return
     */
    public HeroNode infixOrderFind(int id) {
        if (this.root != null) {
            return this.root.infixOrderFind(id);
        }
        return null;
    }

    /**
     * 后序遍历查找
     *
     * @param id 需要查找的id
     * @return
     */
    public HeroNode postOrderFind(int id) {
        if (this.root != null) {
            return this.root.postOrderFind(id);
        }
        return null;
    }

    /**
     * 根据id删除结点
     *
     * @param id
     */
    public void delNode(int id) {

        if (this.root != null) {
            //判断根节点是否为要删除的结点
            if (this.root.getId() == id) {
                this.root = null;
                return;
            }
            //root不是的话，递归删除
            this.root.delNode(id);
        } else {
            System.out.println("此二叉树为空，无法删除结点！");
        }

    }
}

class HeroNode {
    private int id;
    private String name;
    private HeroNode left;
    private HeroNode right;

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

    /**
     * 递归删除结点
     * 1.如果删除的结点是叶子结点，则删除该结点
     * 2.如果删除的结点是非叶子结点，则删除该子树
     *
     * @param id 要删除结点的id
     */
    public void delNode(int id) {
        /*
         * 1.由于该二叉树是单向的，所以我们要判断的是 当前结点的子结点 是否为须删除的结点
         * 2.如果当前结点的左子结点不为空，并且左子结点就是你要删除的结点就将this.left = null,并且返回（结束递归删除）
         * 3.如果当前结点的右子结点不为空，并且右子结点就是你要删除的结点就将this.right = null,并且返回（结束递归删除）
         * 4.如果第2、3步没有删除结点，那么就需要向左子树递归删除
         * 5.如果第4步也没有删除结点，就需要向右子树递归删除
         */
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return;
        }

        if (this.right != null && this.right.id == id) {
            this.right = null;
            return;
        }

        if (this.left != null) {
            this.left.delNode(id);
        }

        if (this.right != null) {
            this.right.delNode(id);
        }
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);  //输出父节点
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        //递归向左子节点中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        //递归向右子节点中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        //递归向左子节点后序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归向右子节点后序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }

    /**
     * 前序遍历查找
     *
     * @param id 需要查找的id
     * @return
     */
    public HeroNode preOrderFind(int id) {
        //判断当前节点是否为要查找的id
        if (this.id == id) {
            return this;
        }
        //1.判断当前节点的左子节点是否为空，如果非空，则递归前序遍历
        //2.如果左递归前序查找，找到节点，则返回
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderFind(id);
        }

        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.preOrderFind(id);
        }
        return resNode;
    }

    /**
     * 中序遍历查找
     *
     * @param id
     * @return
     */
    public HeroNode infixOrderFind(int id) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderFind(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.id == id) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderFind(id);
        }
        return resNode;
    }

    /**
     * 后序遍历查找
     *
     * @param id
     * @return
     */
    public HeroNode postOrderFind(int id) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderFind(id);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.infixOrderFind(id);
        }

        if (this.id == id) {
            return this;
        }
        return resNode;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
