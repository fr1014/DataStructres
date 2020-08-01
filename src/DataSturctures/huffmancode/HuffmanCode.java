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

//        getCodes(root, "", stringBuilder);
        getCodes(root);
        System.out.println("生成的哈夫曼编码表：" + huffmanCodes);
    }

    //生成哈夫曼树对应的哈夫曼编码
    //1.将赫夫曼编码表放在Map<Byte,String>形式
    // eg : 32->01 97->100 100->11000 ...
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    private static Map<Byte, String> getCodes(Node root) {
        getCodes(root, "", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 将传入的node结点的所有叶子结点的哈夫曼编码得到，并放入到huffmanCodes集合
     *
     * @param node          传入结点
     * @param code          路径：左子结点是 0，右子结点是 1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node != null) { //如果node == null不处理
            //判断当前node 是叶子结点还是非叶子结点
            if (node.getData() == null) { //非叶子结点
                //递归处理
                //向左递归
                getCodes(node.getLeft(), "0", stringBuilder2);
                //向右递归
                getCodes(node.getRight(), "1", stringBuilder2);
            } else { //叶子结点
                //表示到达某个结点的最后-叶子结点
                huffmanCodes.put(node.getData(), stringBuilder2.toString());
            }
        }
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
//            if (count == null) {  //map中没有该字符数据
//                counts.put(b, 1);
//            } else {
//                counts.put(b, count + 1);
//            }
            counts.merge(b, 1, Integer::sum);
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
