package DataSturctures.linkedlist;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //直接加入
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        //加入按编号
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.list();
    }
}

//定义单链表对HeroNode进行管理
class SingleLinkedList {
    //先初始化一个头节点，头节点不允许更改，不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点到单链表，不考虑编号顺序
    //1.找到当前链表的最后节点
    //2.将最后节点的next指向新的节点
    public void add(HeroNode heroNode) {

        HeroNode temp = head;      //定义一个中间变量指向头节点

        //找到链表的最后
        while (temp.next != null) {
            //如果没有找到，就将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        temp.next = heroNode;
    }

    //按照编号添加，若已有此编号，则提示添加失败
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;     //编号是否已经存在的标志
        while (true) {
            //已到达链表最后
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {//需要添加的边表已存在
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("编号: " + temp.no + "已经存在");
        } else {
            //插入到链表中
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //显示链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，所以需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (temp != null) {
            //输出节点信息
            System.out.println(temp.toString());
            //将temp后移
            temp = temp.next;
        }
    }
}

//定义HeroNode，每个HeroNode就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName; //昵称
    public HeroNode next; //指向下一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
