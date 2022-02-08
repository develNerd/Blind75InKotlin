package trees


/**
*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.



Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false


Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104
*
* */

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */



/**
*Solution Summary :
 2 Binary Trees are said to be same if their identical and have the same number of nodes
 and have same values in those nodes.

 So what we do is basically compare the left's(left of both trees) of both trees and compare
 each of their rights too.

*
*
* */


class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
         var right: TreeNode? = null
    }

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    /**
     * 1.
     * We need a base condition for when the recursive function should
     * terminate.When both treesNodes are null we return a true
     * because that'll be the end of the tree
     *
     *
    * */
    if(p == null && q== null){
        return true
    }
    /**
     * Return a false if treeNodes instances aren't equal
    * */
    if(p != null && q==null){
        return false
    }
    /**
     * Return a false if treeNodes instances aren't equal
     * */
    if(q != null && p==null){
        return false
    }

    /**
     * Return a false if treeNodes values aren't equal
     * */
    if (p?.`val` != q?.`val`) {
        return false;
    }


    /**
     * Recur isSameTree on the left's and right's of both trees
     * */
    return isSameTree(p?.left,q?.left) && isSameTree(p?.right,q?.right)
}
