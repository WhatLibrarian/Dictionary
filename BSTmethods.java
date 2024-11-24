public class BSTmethods {


//class BST {
    Node root;

    public BST() {
        root = null;
    }

    

    private int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    public void modify(int key, String field, String newValue) {
        modifyRec(root, key, field, newValue);
    }

    private void modifyRec(Node root, int key, String field, String newValue) {
        if (root == null) return;

        if (key < root.key)
            modifyRec(root.left, key, field, newValue);
        else if (key > root.key)
            modifyRec(root.right, key, field, newValue);
        else {
            switch (field) {
                case "firstName":
                    root.firstName = newValue;
                    break;
                case "lastName":
                    root.lastName = newValue;
                    break;
                case "streetAddress":
                    root.streetAddress = newValue;
                    break;
                case "city":
                    root.city = newValue;
                    break;
                case "state":
                    root.state = newValue;
                    break;
                case "zip":
                    root.zip = newValue;
                    break;
                case "email":
                    root.email = newValue;
                    break;
                case "phoneNumber":
                    root.phoneNumber = newValue;
                    break;
                default:
                    System.out.println("Invalid field");
            }
        }
    }

    public void lookup(int key, String order) {
        Node node = search(root, key);
        if (node != null) {
            switch (order) {
                case "preorder":
                    preOrder(node);
                    break;
                case "inorder":
                    inOrder(node);
                    break;
                case "postorder":
                    postOrder(node);
                    break;
                default:
                    System.out.println("Invalid order");
            }
        } else {
            System.out.println("Key not found");
        }
    }

    private Node search(Node root, int key) {
        if (root == null || root.key == key)
            return root;

        if (root.key > key)
            return search(root.left, key);

        return search(root.right, key);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.key + " " + node.firstName + " " + node.lastName + " " + node.streetAddress + " " + node.city + " " + node.state + " " + node.zip + " " + node.email + " " + node.phoneNumber);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key + " " + node.firstName + " " + node.lastName + " " + node.streetAddress + " " + node.city + " " + node.state + " " + node.zip + " " + node.email + " " + node.phoneNumber);
            inOrder(node.right);
        }
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key + " " + node.firstName + " " + node.lastName + " " + node.streetAddress + " " + node.city + " " + node.state + " " + node.zip + " " + node.email + " " + node.phoneNumber);
        }
    }

    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(Node root) {
        if (root == null)
            return 0;
        return 1 + countNodesRec(root.left) + countNodesRec(root.right);
    }
}

//}