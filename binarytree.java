package com.mycompany.binarytree;

import static com.mycompany.binarytree.Node.insert;
import static com.mycompany.binarytree.Node.sonuc;

/**
 *
 * @author audit
 */
class Node{
    static int sayi = 0;
    static Node sonuc = null;
    int value;
    Node left, right;
    public Node(int value) {
        this.value=value;
        left = null;
        right = null;
    } 
    static void insert(Node node, int value){
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            }
            else{
                node.left = new Node(value);
            }
        }
        else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            }
            else{
                node.right = new Node(value);
            }
        }
        else{
            node.right = new Node(value);
        }
    }
    static void Tree_min_max(Node node, int k){
        if (node != null) {
            Tree_min_max(node.left, k);
            sayi++;
            if(sayi==k) sonuc = node;
            else if(k <= 0 || sayi<k) sonuc = null;
            Tree_min_max(node.right, k);
        }
    }
}
public class BinaryTree {
    public static void main(String[] args) {
       Node root = new Node(35);
       
        insert(root, 32);
        insert(root, 23);
        insert(root, 34);
        insert(root, 56);
        insert(root, 11);
        insert(root, 33);
        insert(root, 21);
        insert(root, 39);
        insert(root, 59);
        insert(root, 10);
        insert(root, 3);
        insert(root, 7);
        
        int k = 2;
        Node.Tree_min_max(root, k);
        if (sonuc == null) System.out.println("Index aşımı");
        else
            System.out.println("En küçük :" +k+ ". deger : "+sonuc.value);
    }
}
