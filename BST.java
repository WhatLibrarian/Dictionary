public class BST {
    class Node {
        int key;
        String firstName;
        String lastName;
        String streetAddress;
        String city;
        String state;
        String zip;
        String email;
        String phoneNumber;
        Node left, right;

        public Node(int key, String firstName, String lastName, String streetAddress, String city, String state, String zip, String email, String phoneNumber) {
            this.key = key;
            this.firstName = firstName;
            this.lastName = lastName;
            this.streetAddress = streetAddress;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.left = this.right = null;
        }
    }

    Node root;

    public BST() {
        root = null;
    }

    // Other BST methods (insert, delete, modify, lookup, etc.)
    public void insert(int key, String firstName, String lastName, String streetAddress, String city, String state, String zip, String email, String phoneNumber) {
        root = insertRec(root, key, firstName, lastName, streetAddress, city, state, zip, email, phoneNumber);
    }

    private Node insertRec(Node root, int key, String firstName, String lastName, String streetAddress, String city, String state, String zip, String email, String phoneNumber) {
        if (root == null) {
            root = new Node(key, firstName, lastName, streetAddress, city, state, zip, email, phoneNumber);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key, firstName, lastName, streetAddress, city, state, zip, email, phoneNumber);
        else if (key > root.key)
            root.right = insertRec(root.right, key, firstName, lastName, streetAddress, city, state, zip, email, phoneNumber);

        return root;
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }

        return root;
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



