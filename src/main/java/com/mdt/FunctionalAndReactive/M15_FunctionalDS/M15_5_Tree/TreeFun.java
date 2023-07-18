package com.mdt.FunctionalAndReactive.M15_FunctionalDS.M15_5_Tree;

public class TreeFun<E extends Comparable<E>> {

    private static final TreeFun NIL = new TreeFun();
    private final E value;
    private final TreeFun<E> left;
    private final TreeFun<E> right;
    public int size;
    public int height;

    private TreeFun() {
        value = null;
        left = NIL;
        right = NIL;
        size = 0;
        height = -1;
    }

    private TreeFun(TreeFun<E> left, E value, TreeFun<E> right) {
        this.left = left;
        this.value = value;
        this.right = right;
        this.size = 1 + this.left.size + this.right.size;
        this.height = 1 + Math.max(this.left.height, this.right.height);
    }

    @SafeVarargs
    public static <E extends Comparable<E>> TreeFun<E> tree(E... es) {
        TreeFun<E> tree = NIL;
        for (int i = 0; i < es.length; i++) {
            tree = tree.insert(es[i]);
        }

        return tree;
    }

    private TreeFun<E> insert(E newValue) {
        return isEmpty() ? new TreeFun<E>(NIL, newValue, NIL)
                : newValue.compareTo(this.value) < 0 ? new TreeFun<E>(left.insert(newValue), this.value, this.right)
                : newValue.compareTo(this.value) > 0 ? new TreeFun<E>(this.left, this.value, right.insert(newValue))
                : new TreeFun<E>(this.left, newValue, this.right);
    }

    private boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public String toString() {
        return this.value != null ? String.format("( %s %s %s)", left, value, right) : "";
    }

    public TreeFun<E> remove(E element) {
        if (element.compareTo(this.value) < 0) {
            return new TreeFun<E>(this.left.remove(element), this.value, this.right);
        } else if (element.compareTo(this.value) > 0) {
            return new TreeFun<E>(this.left, this.value, this.right.remove(element));
        } else
            return left.merge(right);
    }

    private TreeFun<E> merge(TreeFun<E> right) {
        return null;
    }
}
