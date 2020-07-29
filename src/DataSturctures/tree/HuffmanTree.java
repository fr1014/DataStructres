package DataSturctures.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 哈夫曼树
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        preOrder(root);
    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("树为空！无法遍历");
        }
    }

    /**
     * 创建哈夫曼树的方法
     *
     * @param arr 需要创建成哈夫曼树的数组
     * @return 创建好后的赫夫曼树的root结点
     */
    public static Node createHuffmanTree(int[] arr) {
        //1.遍历arr数组
        //2.将arr的每一个元素构成一个Node
        //3.将Node放入到ArrayList中
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            //从小到大 排序
            Collections.sort(nodes);
            System.out.println(nodes);

            //取出根节点权值最小的两颗二叉树
            //(1) 取出权值最小的结点（二叉树）
            Node leftNode = nodes.get(0);
            //(2) 取出权值第二小的结点（二叉树）

            Node rightNode = nodes.get(1);
            //(3)构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.setLeft(leftNode);
            parent.setRight(rightNode);

            //(4)从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            //(5)将parent加入到nodes
            nodes.add(parent);
        }

        //返回哈夫曼树的root结点
        return nodes.get(0);
    }
}

/**
 * 创建结点类
 * 为了让 Node 对象支持排序 Collections集合排序
 * 让Node 实现Comparable接口
 */
class Node implements Comparable<Node> {
    int value;  //节点的权值
    Node left;  //指向左子节点
    Node right; //指向右子节点

    public Node(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node node) {
        //表示从小到大排序
        return this.value - node.value;
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
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
}