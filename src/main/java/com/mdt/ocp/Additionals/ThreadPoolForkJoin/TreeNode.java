package com.mdt.ocp.Additionals.ThreadPoolForkJoin;

import java.util.Set;

public class TreeNode {

    int value;

    Set<TreeNode> children;

    TreeNode(int value, TreeNode... children) {
        this.value = value;
//        this.children = Sets.newHashSet(children);
    }
}
