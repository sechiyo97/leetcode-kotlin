package solution;

import common.model.TreeNode;

public class Sol_1379_find_a_corresponding_node_of_a_binary_tree_in_a_clone_of_that_tree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == target) return cloned;
        if (original == null) return null;
        TreeNode leftResult = getTargetCopy(original.getLeft(), cloned.getLeft(), target);
        TreeNode rightResult = getTargetCopy(original.getRight(), cloned.getRight(), target);
        if (leftResult != null) return leftResult;
        else return rightResult;
    }
}
