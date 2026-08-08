/* Structure of a Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    private static int preIndex = 0;

    public static Node buildTree(int inorder[], int preorder[]) {
        preIndex = 0;
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inMap, 0, inorder.length - 1);
    }

    private static Node buildTreeHelper(int[] preorder, Map<Integer, Integer> inMap, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preIndex++];
        Node root = new Node(rootVal);
        int inIndex = inMap.get(rootVal);
        root.left = buildTreeHelper(preorder, inMap, inStart, inIndex - 1);
        root.right = buildTreeHelper(preorder, inMap, inIndex + 1, inEnd);
        return root;
    }
}