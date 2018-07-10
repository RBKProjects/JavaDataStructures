public class Tree {
        Node root;

        // some basic test code
        public static void main(String[] args) {
            Tree tree = new Tree();
            int[] items = {5, 8, 7, 1, 9, 3, 0, 4, 6, 2};
            for (int i : items)
                tree.addChild(i);


            System.out.println("Is it contain 3: " + tree.contains(3));
            tree.order();
        }

        public boolean addChild(int val) {
            if (root == null) {
                root = new Node(val);
                return true;
            }
            else
                return root.addChild(val);
        }

        public boolean contains(int val) {
            if (root == null)
                return false;
            else
                return root.contains(val);
        }

        public void order() {
            if (root != null) {
                System.out.println("order:");
                root.order();
            }
        }

        private class Node {
            private Node Child;
            private int value;

            private Node(int val) {
                value = val;
                Child = null;
            }

            private boolean addChild(int val) {
                boolean added = false;
                if (this == null) {
                    this.value = val;
                    return true;
                }
                        if (this.Child == null) {
                            this.Child = new Node(val);
                            return true;
                        }
                        else
                            added = this.Child.addChild(val);


                return added;
            }

            private boolean contains(int val) {
                boolean found = false;
                if (this == null)
                    return false;
                else {
                    if (val == this.value)
                        return true;
                    else if (this.Child != null)
                        found = this.Child.contains(val);
                }
                return found;
            }

            private void order() {
                if (this != null) {
                    if (this.Child != null)
                        this.Child.order();
                    System.out.println(this.value);
                }
            }
        }
    }

