package DataSturctures.linkedlist;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //直接加入
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);

        //加入按编号
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.list();

//        System.out.println("修改后的节点");

        //修改链表节点
//        HeroNode newHero3 = new HeroNode(3, "吴用~", "智多星");
//        singleLinkedList.update(newHero3);

        //删除链表节点
//        int no = 4;
//        singleLinkedList.delete(no);

//        singleLinkedList.list();

        //打印链表中有效节点的个数
//        System.out.printf("链表的节点个数：%d", SingleLinkedList.getLength(singleLinkedList.getHead()));

        //测试打印单链表的倒数第k个节点
//        int index = 1;
//        System.out.printf("链表中倒数第 %d 个节点为: %s",index, SingleLinkedList.findLastIndexNode(singleLinkedList.getHead(),index));

        //测试打印反转链表
        SingleLinkedList.reverseList(singleLinkedList.getHead());
        System.out.println("反转后的链表");
        singleLinkedList.list();
    }
}

//定义单链表对HeroNode进行管理
class SingleLinkedList {
    //先初始化一个头节点，头节点不允许更改，不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

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

    //修改链表节点，根据no
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空，无法修改！");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false; //是否找到该节点
        while (true) {
            //已到达链表最后
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                //表示已经找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.println("此链表中没有此no");
        }
    }

    //删除节点
    //temp.next.no 和 需要删除的节点的no 进行比较
    //删除节点 temp.next = temp.next.next，无引用的会被GC
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            //已经到链表的最后
            if (temp.next == null) {
                break;
            }
            //找到待删除节点的前一个节点temp
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;  //temp后移，遍历
        }
        //如果找到该节点
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("此链表中未找到要删除的节点！");
        }
    }

    //获取链表的节点个数（如果是带头节点的链表，不统计头节点）
    public static int getLength(HeroNode head) {
        //空链表
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //将单链表反转
    public static void reverseList(HeroNode head){
        //如果当前链表为空或者此链表只有一个节点的时候无需反转，直接返回
        if (head.next == null || head.next.next == null){
            return;
        }
        //辅助变量，遍历链表
        HeroNode cur = head.next;
        HeroNode next = null; //指向当前节点[cur]的下一节点
        HeroNode reverseHead = new HeroNode(0,"","");
        //遍历原链表，每遍历一个节点就将其取出并放在新的链表reverseHead的最前方
        while (cur != null){
            next = cur.next; //暂时保存当前节点的下一节点
            cur.next = reverseHead.next; //将cur的下一节点指向新的链表的最前端
            reverseHead.next = cur;//将cur连接到新的链表上
            cur = next; //cur后移
        }
        head.next = reverseHead.next;
    }

    //查找单链表中倒数第k个节点
    /**
     * @param head  链表头节点
     * @param index 表示倒数第index个节点
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //该链表为空
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        //对index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        //辅助变量
        HeroNode cur = head.next;
        for (int i = 0;i<size-index;i++){
            cur = cur.next;
        }
        return cur;
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
