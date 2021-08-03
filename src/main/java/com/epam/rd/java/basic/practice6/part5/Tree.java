package com.epam.rd.java.basic.practice6.part5;

import java.util.Comparator;

public class Tree<E extends Comparable<E>> {

    private final Comparator<? super E> comparator;

    private Node<E> root;

    private int size = 0;
    private boolean done;

    public Tree() {
        comparator = null;
    }

    public Tree(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    public boolean add(E element) {
        done = false;
        root = addRecursive(root, element);
        return done;
    }

    private Node<E> addRecursive(Node<E> current, E element) {
        if (current == null) {
            done = true;
            size++;
            return new Node<>(element);
        }
        int cmp = element.compareTo(current.element);
        if (cmp < 0) {
            current.left = addRecursive(current.left, element);
        } else if (cmp > 0) {
            current.right = addRecursive(current.right, element);
        }
        return current;
    }

    public void add(E[] elements) {
        for (E e : elements) {
            add(e);
        }
    }

    public boolean remove(E element) {
        done = false;
        root = removeRecursive(root, element);
        return done;
    }

    private Node<E> removeRecursive(Node<E> current, E element) {
        if (current == null) {
            return null;
        }
        int cmp = element.compareTo(current.element);
        if (cmp == 0) {
            done = true;
            // node has no children
            if (current.left == null && current.right == null) {
                return null;
            }
            // node has 1 child
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            // node has 2 children
            E lowest = findLowest(current.right);
            current.element = lowest;
            current.right = removeRecursive(current.right, lowest);
            return current;
        }
        if (cmp < 0) {
            current.left = removeRecursive(current.left, element);
            return current;
        }
        current.right = removeRecursive(current.right, element);
        return current;
    }

    private E findLowest(Node<E> root) {
        return root.left == null ? root.element : findLowest(root.left);
    }

    public void traverseInOrder(Node<E> node, String spaces) {
        if (node == null) {
            return;
        }
        traverseInOrder(node.left, spaces + "  ");
        System.out.println(spaces + node.element);
        traverseInOrder(node.right, spaces + "  ");
    }

    public void print() {
        traverseInOrder(root, "");
    }

    private static final class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;

        Node(E element) {
            this.element = element;
            left = null;
            right = null;
        }

    }

}
