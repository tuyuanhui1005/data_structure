public class tree {


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
        tree.midSort();

    }




    static  class  NodeTree{

        private  Node  head;

        public NodeTree(Node head) {
            this.head = head;
        }


        public  void  midSort(){
            this.head.midSort();
        }
    }


    static  class   Node{
        private int id;
        private  Node left;
        private  Node right;

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

        public  void  midSort(){
            if(this.left!=null){
                this.left.midSort();
            }
            System.out.println(this.id);
            if(this.right!=null){
                this.right.midSort();
            }

        }
    }
}
