/**
 * 不同的遍历方式 会有不同的线索二叉树
 */
public class ThreadTree {


    public static void main(String[] args) {

        Node node = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(6);
        Node node3 = new Node(8);
        Node node4 = new Node(10);
        Node node5 = new Node(14);
        node.setLeft(node1);
        node.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);

        NodeTree tree = new NodeTree(node);
        tree.preOrder();
        // tree.midThreadTree(node);
        tree.preThreadTree(node);
        System.out.println("=================================");
        //System.out.println(node4.getLeft().id);
        //System.out.println(node4.getRight().id);
        //tree.midThreadOrder();


    }


    static class NodeTree {

        private Node head;
        //为了实现线索二叉树，定义前驱节点
        private Node pre = null;

        public NodeTree(Node head) {
            this.head = head;
        }


        public void midSort() {
            this.head.midSort();
        }

        public void preOrder() {
            this.head.preOrder();
        }

        public void midThreadOrder() {
            Node node = this.head;
            while (node != null) {
                while (node.getLeftType() == 0) {

                    node = node.getLeft();
                }
                System.out.println(node.id);

                while (node.getRightType() == 1) {

                    node = node.getRight();
                    System.out.println(node.id);

                }
                node = node.getRight();

            }
        }

        public void midThreadTree(Node node) {

            if (node == null) return;
            midThreadTree(node.getLeft());
            if (node.getLeft() == null) {
                node.setLeft(pre);
                node.setLeftType(1);
            }
            if (pre != null && pre.getRight() == null) {
                pre.setRight(node);
                pre.setRightType(1);
            }
            pre = node;
            midThreadTree(node.getRight());

        }

        public void preThreadTree(Node node) {
            if (node == null) return;
            if(node.getLeft()==null){
                node.setLeft(pre);
                node.setLeftType(1);
            }
            if(pre!=null&&pre.getRight()==null&&pre.getLeft()!=node){
                pre.setRightType(1);
                pre.setRight(node);
            }

            pre = node;
            if (node.getLeftType()==0){
                preThreadTree(node.getLeft());
            }
            //线索化右子树
            preThreadTree(node.getRight());

        }

    }


    static class Node {
        private int id;
        private Node left;
        private Node right;
        //如果等于0 指向子树  如果等于1 指向前驱或者后继
        private int leftType;
        private int rightType;

        public Node(int id) {
            this.id = id;

        }

        public void setId(int id) {
            this.id = id;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getId() {
            return id;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getLeftType() {
            return leftType;
        }

        public void setLeftType(int leftType) {
            this.leftType = leftType;
        }

        public int getRightType() {
            return rightType;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", leftType=" + leftType +
                    ", rightType=" + rightType +
                    '}';
        }

        public void setRightType(int rightType) {
            this.rightType = rightType;
        }

        public void midSort() {
            if (this.left != null) {
                this.left.midSort();
            }
            System.out.println(this.id);
            if (this.right != null) {
                this.right.midSort();
            }

        }

        public void preOrder() {
            System.out.println(this.id);
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }

        }
    }
}
