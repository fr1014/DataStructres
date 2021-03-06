package DataSturctures.huffmancode;

import java.util.*;

public class HuffmanCode {

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println("压缩前长度: " + contentBytes.length);
//
//        List<Node> nodes = getNodes(contentBytes);
//        System.out.println("nodes: " + nodes);
//
//        Node root = createHuffmanTree(nodes);
//        preOrder(root);
//
////        getCodes(root, "", stringBuilder);
//        getCodes(root);
//        System.out.println("生成的哈夫曼编码表：" + huffmanCodes);
//        byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
//        System.out.println("huffmanCodeBytes = " + Arrays.toString(huffmanCodeBytes));
        byte[] huffmanCodeBytes = huffmanZip(contentBytes);
        System.out.println(Arrays.toString(huffmanCodeBytes));
        System.out.println("压缩后长度：" + huffmanCodeBytes.length);
    }

    /**
     * 使用一个方法，将前面的方法封装起来，便于调用
     *
     * @param bytes 原始的字符串对应的字节数组
     * @return 经过哈夫曼编码处理后的字节数组（压缩后的数组）
     */
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        //根据nodes创建huffmanTree
        Node root = createHuffmanTree(nodes);
        //对应的哈夫曼编码（根据哈夫曼树）
        Map<Byte, String> huffmanCodes = getCodes(root);
        //根据生成的哈夫曼编码，得到压缩后的哈夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);

        return huffmanCodeBytes;
    }

    //编写一个方法，将字符串对应的byte[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码压缩后的byte[]

    /**
     * @param bytes        这时原始的字符串对应的 byte[]
     * @param huffmanCodes 生成的赫夫曼编码map
     * @return 返回赫夫曼编码处理后的 byte[]
     * 举例： String content = "i like like like java do you like a java"; -> byte[] contentBytes = content.getBytes();
     * 返回的是 字符串 "1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100"
     * => 对应的 byte[] huffmanCodeBytes  ，即 8位对应一个 byte,放入到 huffmanCodeBytes
     * huffmanCodeBytes[0] =  10101000(补码) => byte  [推导  10101000=> 10101000 - 1 => 10100111(反码)=> 11011000= -88 ]
     * huffmanCodeBytes[1] = -88
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //1.利用 huffmanCodes 将  bytes 转成  赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes 数组
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        //统计返回  byte[] huffmanCodeBytes 长度
        //一句话 int len = (stringBuilder.length() + 7) / 8;
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) { //不够8位
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
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
