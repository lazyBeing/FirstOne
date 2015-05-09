package com.my.checkBalancedTree;

public class Main {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree(50);
		binaryTree.addNode(25);
		binaryTree.addNode(75);
		binaryTree.addNode(12);
		binaryTree.addNode(38);
		binaryTree.addNode(6);
//		binaryTree.addNode(18);
		binaryTree.display();
		binaryTree.isBinaryTree();
	}

}

class BinaryTree{
	private Node root;

	public Node getRoot() {
		return root;
	}
	public BinaryTree(int value) {
		root = new Node(value);
	}
	
	public void setRoot(Node root) {
		this.root = root;
	}
	public void addNode(int value){
		if(root == null){
		root = new Node(value);
		}
		else{
			innerAddNode(root, value);
		}
	}
	
	public void innerAddNode(Node node,int value){
		
		if(value < node.getValue()){
			if(node.getLeft() == null){
				node.setLeft(new Node(value));
			}else{
				innerAddNode(node.getLeft(),value);
			}
		}
		else{
			if(node.getRight() == null){
				node.setRight(new Node(value));
			}else{
				innerAddNode(node.getRight(), value);
			}
		}
	}
	
	public void display(){
		innerDisplay(root);
	}
	private void innerDisplay(Node node){
		if(node.getLeft() != null){
			innerDisplay(node.getLeft());
		}
		System.out.println(node.getValue());
		if(node.getRight() != null){
			innerDisplay(node.getRight());
		}
	} 
	public void isBinaryTree(){
		if(root != null)
			isBinaryTreeInner(root);
		else
			System.out.println("Empty tree");
	}
	private int isBinaryTreeInner(Node node){
		int leftHeight = 0;
		int rightHeight = 0;
		if(node.getLeft()!=null){
			leftHeight = isBinaryTreeInner(node.getLeft()); 
		}
		if(node.getRight()!=null){
			rightHeight = isBinaryTreeInner(node.getRight());
		}
		int heightDiff = leftHeight-rightHeight;
		if(!(heightDiff>=-1 && heightDiff<=1)){
			System.out.println("Not Balanced");
		}
		return 1+Math.max(leftHeight, rightHeight);
	}
}

class Node{
	private int value;
	private Node left;
	private Node right;
	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
}