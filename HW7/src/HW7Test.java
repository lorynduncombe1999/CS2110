import org.junit.Test;

import static org.junit.Assert.*;

public class HW7Test {

    @org.junit.Test
    public void equals() {

        BinaryTreeNode<String> node1 = new BinaryTreeNode();

        BinaryTreeNode<String> node2 = new BinaryTreeNode();

        assertTrue(node1.equals(node2));

        node1 = new BinaryTreeNode("WhatsUP");

        node2 = new BinaryTreeNode("WhatsUP");

        //assertTrue(node2.equals(node1));

    }

    @org.junit.Test
    public void equals2() {

        BinaryTreeNode node3 = new BinaryTreeNode("test");

        BinaryTreeNode node1 = new BinaryTreeNode("WhatsUP", new BinaryTreeNode(), node3);

        BinaryTreeNode node2 = new BinaryTreeNode("WhatsUP", new BinaryTreeNode(), new BinaryTreeNode("test"));

        assertTrue(node2.equals(node1));

    }

    @org.junit.Test
    public void equalsTree() {


        BinaryTreeNode node1 = new BinaryTreeNode("head", new BinaryTreeNode("parent 1"), new BinaryTreeNode("parent 2"));

        BinaryTree tree = new BinaryTree();

        tree.setRoot(node1);

        BinaryTree tree2 = new BinaryTree(new BinaryTreeNode("head", new BinaryTreeNode("parent 1"), new BinaryTreeNode("parent 2")));

        assertTrue(tree.equals(tree2));

    }

    @org.junit.Test
    public void equalsTree2() {

        BinaryTreeNode node5 = new BinaryTreeNode("asdf", new BinaryTreeNode(), new BinaryTreeNode());

        BinaryTreeNode node1 = new BinaryTreeNode("head", new BinaryTreeNode("parent 1", node5 ,new BinaryTreeNode()), new BinaryTreeNode("parent 2"));

        BinaryTree tree = new BinaryTree();

        tree.setRoot(node1);

        BinaryTree tree2 = new BinaryTree(new BinaryTreeNode("head", new BinaryTreeNode("parent 1"), new BinaryTreeNode("parent 2")));

        assertFalse(tree.equals(tree2));


    }

    @org.junit.Test
    public void deepCopy() {

        BinaryTreeNode node1 = new BinaryTreeNode("head", new BinaryTreeNode("parent 1", new BinaryTreeNode() ,new BinaryTreeNode()), new BinaryTreeNode("parent 2"));

        BinaryTreeNode node2 = node1.deepCopy();

        assertTrue(node1.equals(node2) && node1 != node2);
    }

    @org.junit.Test
    public void deepCopy2() {


        BinaryTreeNode node1 = new BinaryTreeNode("head", new BinaryTreeNode("parent 1"), new BinaryTreeNode("parent 2"));

        BinaryTree tree = new BinaryTree();

        tree.setRoot(node1);

        BinaryTree tree2 = tree.deepCopy();

        assertTrue(tree.equals(tree2) && tree != tree2);

    }

    @org.junit.Test
    public void combine() {

        BinaryTreeNode node1 = new BinaryTreeNode("head", new BinaryTreeNode("parent 1"), new BinaryTreeNode("parent 2"));

        BinaryTree tree = new BinaryTree();

        tree.setRoot(node1);

        BinaryTree tree2 = new BinaryTree(new BinaryTreeNode("head2", new BinaryTreeNode("parent 1"), new BinaryTreeNode("parent 2")));

        BinaryTree tree3 = tree.combine(new BinaryTreeNode("realhead"), tree2, true );

        assertTrue(tree3.getRoot().getRight().getData() == "head2");

    }

    @org.junit.Test
    public void combine2() {


        BinaryTreeNode node1 = new BinaryTreeNode("head", new BinaryTreeNode("parent 1"), new BinaryTreeNode("parent 2"));

        BinaryTree tree = new BinaryTree();

        tree.setRoot(node1);

        BinaryTree tree2 = new BinaryTree(new BinaryTreeNode("head2", new BinaryTreeNode("parent 1"), new BinaryTreeNode("parent 2")));

        BinaryTree tree3 = tree.combine(new BinaryTreeNode("realhead"), tree2, false );

        assertTrue(tree3.getRoot().getRight().getData() == "head");

    }

    @org.junit.Test
    public void size() {

        BinaryTreeNode node1 = new BinaryTreeNode("head", new BinaryTreeNode("parent 1"), new BinaryTreeNode("parent 2"));

        BinaryTree tree = new BinaryTree();

        tree.setRoot(node1);

        assertTrue(tree.size() == 3);
    }

    @org.junit.Test
    public void size2() {

        BinaryTreeNode node1 = new BinaryTreeNode("head", new BinaryTreeNode("parent 1"), new BinaryTreeNode("parent 2"));

        BinaryTree tree = new BinaryTree();

        tree.setRoot(node1);

        assertTrue(tree.getRoot().getRight().size() == 1);

    }

    @org.junit.Test
    public void height() {

        BinaryTreeNode node1 = new BinaryTreeNode("head", new BinaryTreeNode("parent 1"), new BinaryTreeNode("parent 2"));

        BinaryTree tree = new BinaryTree();

        tree.setRoot(node1);

        assertTrue(tree.height() == 2);
    }

    @org.junit.Test
    public void height2() {

        BinaryTreeNode node1 = new BinaryTreeNode("head", new BinaryTreeNode("parent 1"), new BinaryTreeNode("parent 2"));

        BinaryTree tree = new BinaryTree();

        tree.setRoot(node1);

        assertTrue(tree.getRoot().getRight().height() == 1);

    }

    @org.junit.Test
    public void full() {

        BinaryTreeNode node1 = new BinaryTreeNode("head", new BinaryTreeNode("parent 1",
                new BinaryTreeNode(""), new BinaryTreeNode("")), new BinaryTreeNode("parent 2", new BinaryTreeNode(), new BinaryTreeNode()));

        BinaryTree tree = new BinaryTree();

        tree.setRoot(node1);

        assertTrue(tree.full());


    }

    @org.junit.Test
    public void full2() {

        BinaryTreeNode node1 = new BinaryTreeNode("head", new BinaryTreeNode("parent 1",
                new BinaryTreeNode(""), new BinaryTreeNode("", new BinaryTreeNode(), new BinaryTreeNode())),
                new BinaryTreeNode("parent 2", new BinaryTreeNode(), new BinaryTreeNode()));

        BinaryTree tree = new BinaryTree();

        tree.setRoot(node1);

        assertFalse(tree.full());
    }

    @org.junit.Test
    public void mirror() {
        BinaryTreeNode node1 = new BinaryTreeNode("head", new BinaryTreeNode("parent 1",
                new BinaryTreeNode(""), new BinaryTreeNode("", new BinaryTreeNode(), new BinaryTreeNode())),
                new BinaryTreeNode("parent 2", new BinaryTreeNode(), new BinaryTreeNode()));

        BinaryTree tree = new BinaryTree();

        tree.setRoot(node1);

        BinaryTree tree2 =  tree.deepCopy();
        tree2.mirror();

        assertTrue(tree.getRoot().getRight().getData() == "parent 2" && tree2.getRoot().getLeft().getData() == "parent 2");
    }

    @org.junit.Test
    public void mirror2() {
        BinaryTreeNode node1 = new BinaryTreeNode("head", new BinaryTreeNode("parent 1",
                new BinaryTreeNode(""), new BinaryTreeNode("", new BinaryTreeNode("answer"), new BinaryTreeNode())),
                new BinaryTreeNode("parent 2", new BinaryTreeNode(), new BinaryTreeNode()));

        BinaryTree tree = new BinaryTree();

        tree.setRoot(node1);
        System.out.println(tree.inOrder());
        BinaryTree tree2 =  tree.deepCopy();
        tree2.mirror();
        assertTrue(tree.getRoot().getLeft().getRight().getLeft().getData() == "answer" && tree2.getRoot().getRight().getLeft().getRight().getData() == "answer");
    }

    @org.junit.Test
    public void inOrder() {
        BinaryTreeNode node1 = new BinaryTreeNode("1", new BinaryTreeNode("2",
                new BinaryTreeNode("3"), new BinaryTreeNode("4", new BinaryTreeNode("5"), new BinaryTreeNode("6"))),
                new BinaryTreeNode("7", new BinaryTreeNode("8"), new BinaryTreeNode("9")));

        BinaryTree tree = new BinaryTree();

        tree.setRoot(node1);

        System.out.println(tree.inOrder());
        assertTrue(true);
    }

    public void inOrder2() {
        BinaryTreeNode node1 = new BinaryTreeNode("1", new BinaryTreeNode("2",
                new BinaryTreeNode("3"), new BinaryTreeNode("4", new BinaryTreeNode("5"), new BinaryTreeNode("6"))),
                new BinaryTreeNode("7", new BinaryTreeNode("8"), new BinaryTreeNode("9")));

        BinaryTree tree = new BinaryTree();

        tree.setRoot(node1);

        System.out.println(tree.inOrder());
        assertTrue(true);

    }
}
