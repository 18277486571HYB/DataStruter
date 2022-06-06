package com.hyb.ds.红黑树;

public class RedBlackTree<Key extends Comparable<Key>,Value> {

    private Node root;
    private int n;
    private static final boolean  Red = true;
    private static final boolean Black = false;

    class Node{
         Key key;
         Value value;
         Node left;
         Node right;
         boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    //
    public int size(){
        return n;
    }

    //
    public boolean isRed(Node node){
        if (node==null){
            return false;
        }
        return node.color==Red;
    }

    //左旋
    private Node reLeft(Node h){
        //得到h的右节点x
        Node x=h.right;
        //让x的左节点成为h的右节点
        h.right=x.left;
        //让h成为x的左节点
        x.left=h;
        //让x的节点的颜色成为h的颜色
        x.color= h.color;
        //让h的颜色为红
        h.color=Red;
        //返回x节点
        return x;
    }

    //右旋 完全相反
    private Node reRight(Node h){
        //得到h的左节点x
        Node x=h.left;
        //让x的右节点成为h的左节点
        h.left=x.right;
        //让h成为x的右节点
        x.right=h;
        //让x的节点的颜色成为h的颜色
        x.color=h.color;
        //让h的颜色为红
        h.color=Red;
        //返回x的节点
        return x;
    }

    //颜色变化
    private void reColor(Node h){
        h.color=Red;
        h.left.color=Black;
        h.right.color=Black;
    }

    // 在整个树上完成插入操作
    public void put(Key key,Value value){
        root=put(root,key,value);
        //永远让根节点为黑色
        root.color=Black;
    }

    //在某个节点上完成插入操作
    private Node put(Node h,Key key,Value value){
        //如果所传节点为空,则创建一个红节点
        if (h==null){
            n++;
            return new Node(key,value,null,null,Red);
        }
        //比较h节点的key与当前key大小
        int i = key.compareTo(h.key);
        if (i>0){
            //往右边
            h.right=put(h.right,key,value);
        }else if (i<0){
            //往左边
            h.left=put(h.left,key,value);
        }else {
            //相等替换节点值
            h.value=value;
        }

        //当右节点为红色,左节点为黑色,进行左旋
        if (isRed(h.right) && !isRed(h.left)){
            h=reLeft(h);
        }
        //进行右旋,当左节点为红色,左节点的左节点也为红色要右旋
        if (isRed(h.left) && isRed(h.left.left)) {
            h=reRight(h);
        }
        //当左右为红色时需要颜色翻转
        if (isRed(h.left) && isRed(h.right)){
            reColor(h);
        }
        return h;
    }

    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node root,Key key){
        if (root==null){
            return null;
        }
        //比较节点大小
        int i = key.compareTo(root.key);
        if (i>0){
            return get(root.right,key);
        }else if (i<0){
            return get(root.left,key);
        }else return root.value;
    }

}
class Test{
    public static void main(String[] args) {
        RedBlackTree<Integer, String> integerStringRedBlackTree = new RedBlackTree<>();
        integerStringRedBlackTree.put(67,"a");
        integerStringRedBlackTree.put(11,"b");
        integerStringRedBlackTree.put(3,"c");
        integerStringRedBlackTree.put(13,"d");
        integerStringRedBlackTree.put(5,"k");
        integerStringRedBlackTree.put(6,"r");
        integerStringRedBlackTree.put(456,"b");
        integerStringRedBlackTree.put(536,"b");
        integerStringRedBlackTree.put(50,"b");
        integerStringRedBlackTree.put(36,"b");
        integerStringRedBlackTree.put(6786,"b");
        integerStringRedBlackTree.put(12,"b");

        String s = integerStringRedBlackTree.get(1);
        System.out.println(s);
        String s1 = integerStringRedBlackTree.get(3);
        System.out.println(s1);
        String s2 = integerStringRedBlackTree.get(2);
        System.out.println(s2);

    }
}
