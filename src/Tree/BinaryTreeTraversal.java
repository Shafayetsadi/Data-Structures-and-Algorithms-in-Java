package Tree;

public class BinaryTreeTraversal {
    void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }
    void preorder(Node root){
        if(root != null){
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }
    int height(Node root){
        if(root == null) return 0;
        else return Math.max(height(root.left), height(root.right)) + 1;
    }
    void printAtDistanceK(Node root, int k){
        if(root == null) return;
        else if(k == 0) System.out.println(root.key);
        else{
            printAtDistanceK(root.left, k-1);
            printAtDistanceK(root.right, k-1);
        }
    }
}
