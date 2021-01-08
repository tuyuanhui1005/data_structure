package tree.BinarySortTree;

public class main {
    public static void main(String[] args) {

        int[] arr = {7, 3, 10, 12, 5, 1, 9};

        BinarySortTree tree = new BinarySortTree();
        for(int i = 0;i<arr.length;i++){
            tree.add(new Node(arr[i]));
        }
        tree.infixOrder();

    }


    static class BinarySortTree {

        private Node head;


        public void add(Node n) {
            if (head == null) {
                head = n;
            } else {
                head.add(n);
            }

        }

        public void infixOrder() {
            if (head != null) {
                head.infixOrder();
            } else {
                System.out.println("当前树为空");
            }
        }
    }


    static class Node {
        private int value;
        private Node left;
        private Node right;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
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

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        public void add(Node n) {
            if (n == null) return;
            if (n.value > this.value) {
                if (this.right == null) {
                    this.setRight(n);
                } else {
                    this.right.add(n);
                }

            }
            if (n.value <= this.value) {
                if (this.left == null) {
                    this.setLeft(n);
                } else {
                    this.left.add(n);
                }

            }
        }

        public void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.println(this.value);
            if (this.right != null) {
                this.right.infixOrder();
            }
        }
    }
}
