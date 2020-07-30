package DataSturctures.huffmancode;

import java.util.*;

public class HuffmanCode {

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println("contentBytes.length: " + contentBytes.length);

        List<Node> nodes = getNodes(contentBytes);
        System.out.println("nodes: " + nodes);

        Node root = createHuffmanTree(nodes);
        preOrder(root);
    }

    private static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("此树为空！！！");
        }
    }

    /**
     * @param bytes 接受字节数组
     * @return 返回Node集合
     */
    private static List<Node> getNodes(byte[] bytes) {

        List<Node> nodes = new ArrayList<>();

        //遍历byte数组，统计每一个人byte出现的次数 --> map[key,value]
        Map<Byte, Integer> counts = new HashMap<>();

        for (Byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {  //map中没有该字符数据
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        //把每一个键值转成一个Node对象，并加入到nodes集合
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    public static Node createHuffmanTree(List<Node> nodes) {

        while (nodes.size() > 1) {
            //排序，从小到大
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //创建一棵新的二叉树，其根节点没有data，只有权值(weight)
            Node parent = new Node(null, leftNode.getWeight() + rightNode.getWeight());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);

            //将已经处理的两颗二叉树从nodes删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的二叉树，加入到nodes
            nodes.add(parent);
        }

        //HuffmanTree的根节点
        return nodes.get(0);
    }
}

//创建Node,数据和权值
class Node implements Comparable<Node> {
    private Byte data;  //存放数本身，eg: 'a' => 97 ' ' => 32
    private int weight; //权值，表示字符出现的次数
    private Node left;
    private Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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
    public int compareTo(Node node) {
        //从小到大排序
        return this.weight - node.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
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
}
