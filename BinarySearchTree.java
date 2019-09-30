import java.util.*;

/**
 * This class will demonstrates BinarySearchTree 
 * functions to add or remove nodes.
 * @author AlanHuang
 *
 * @param <T>
 */
public class BinarySearchTree
{

      private Node root;

      @SuppressWarnings("rawtypes")
   /**
    * Default constructor use to initial the root and comparator.
    */
	private Comparator comparator;

      public BinarySearchTree() 
      {

            root = null;
            comparator = null;
      }
      
      /**
       * This constructor is use to create my tree with new root.
	   * @param comp is the value I want to use with comparator. 
       */
      public BinarySearchTree(@SuppressWarnings("rawtypes") Comparator comp) 
      {
            root = null;
            comparator = comp;
      }
      
     /**
  	  * This method will return the root to user.
  	  * @return root
  	  */
      public Node getRoot() 
      {
            return root;
      }

      @SuppressWarnings("unchecked")
     /**
  	  * This method will help me compare value Y and value x, and
  	  * return the result to other method.
  	  * @param valueX the value I want to compare to Y
  	  * @param valueY the value I want to compare to X
  	  * @return return the compared result to other method
  	  */
      private int compare(int valueX, int valueY) 
      {
    	  
            if (comparator == null)

                  return valueX - valueY;

            else

                  return comparator.compare(valueX, valueY);
      }

     /**
  	  * This will add new node to the tree.
  	  */
      public void addEntry(int data) 
      {
            root = addEntry(root, data);
      }

   	 /**
  	  * This is a private recursive method to add new node to 
  	  * the right location.
  	  * @param rootNode every next root note from next sub-tree
  	  * @param newEntry The value we want to add.
  	  * @return root node from the subtree
      */
      private Node addEntry(Node rootNode, int newEntry) 
      {
            if (rootNode == null)

                  return new Node(newEntry);

            if (compare(newEntry, rootNode.data) == 0)

                  return rootNode;

            if (compare(newEntry, rootNode.data) < 0)

                  rootNode.leftChild = addEntry(rootNode.leftChild, newEntry);

            else

                  rootNode.rightChild = addEntry(rootNode.rightChild, newEntry);

            return rootNode;

      }

     /**
  	  * This method will delete node from the tree
  	  */
      public void remove(int toDelete)
      {
            root = remove(root, toDelete);
      }

  	 /**
  	  * This is a private recursive method to remove a node  
  	  * from the right location. 
  	  * @param rootNode every next root note from next sub-tree
  	  * @param toDelete The value we want to delete.
  	  * @return root node from the subtree
  	  */
      private Node remove(Node rootNode, int toDelete) 
      {
            if (rootNode == null)

                  throw new RuntimeException("can't delete.");

            else if (compare(toDelete, rootNode.data) < 0)

                  rootNode.leftChild = remove(rootNode.leftChild, toDelete);

            else if (compare(toDelete, rootNode.data) > 0)

                  rootNode.rightChild = remove(rootNode.rightChild, toDelete);

            else {

                  if (rootNode.leftChild == null) {

                        return rootNode.rightChild;

                  } else {

                        if (rootNode.rightChild == null) {

                              return rootNode.leftChild;

                        } else {

                              rootNode.data = retrieveData(rootNode.leftChild);

                              rootNode.leftChild = remove(rootNode.leftChild,

                                          rootNode.data);
                              
                        }
                        
                  }

            }

            return rootNode;

      }

     /**
  	  * This private method help remove method search the right 
  	  * most child and return the data.
  	  * @param rootNode the sub-tree root node we wish to search.
  	  * @return the right most node data.
  	  */
      private int retrieveData(Node rootNode) 
      {
            while (rootNode.rightChild != null)

                  rootNode = rootNode.rightChild;

            return rootNode.data;

      }

      /**
       * This method will call private preOrderTraversal to 
       * display the preOrder traversal of current tree.
       */
      public void preOrderTraversal() 
      {
            preOrderTraverse(root);
      }

      /**
       * This private method will display pre-order traverse
       * of the the current tree's nodes.
       * @param node every next subtree's root node.
       */
      private void preOrderTraverse(Node node) 
      {
            if (node != null) 
            {
                  System.out.print(node + " ");
                  preOrderTraverse(node.leftChild);
                  preOrderTraverse(node.rightChild);
            }
      }

      /**
       * This method will call private inOrderTraversal to 
       * display the inOrder traversal of current tree.
       */
      public void inOrderTraverse() 
      {
            inOrderTraverse(root);
      }

      /**
       * This private method will display in-order traverse
       * of the the current tree's nodes.
       * @param node every next subtree's root node.
       */
      private void inOrderTraverse(Node node)
      {
            if (node != null) 
            {
                  inOrderTraverse(node.leftChild);
                  System.out.print(node + " ");
                  inOrderTraverse(node.rightChild);
            }
      }

      /**
       * This method will call private postOrderTraversal to 
       * display the postOrder traversal of current tree.
       */
      public void postOrderTraverse() 
      {
            postOrderTraverse(root);
      }

      /**
       * This private method will display post-order traverse
       * of the the current tree's nodes.
       * @param node every next subtree's root node.
       */
      private void postOrderTraverse(Node node) 
      {
            if (node != null) 
            {
                  postOrderTraverse(node.leftChild);
                  postOrderTraverse(node.rightChild);
                  System.out.print(node + " ");
            }
      }

     /**
  	  *  This method help user search contains nodes 
  	  *  from the Binary Tree.    
  	  */
      public boolean search(int toSearch) 
      {
            return search(root, toSearch);
      }

     /**
  	  * This is a private recursive method that help search
  	  * method locate the right node.
  	  * @param rootNode root node of the sub-tree
  	  * @param toSearch the node that we are searching.
  	  * @return true or false if the node is found.
  	  */ 
      private boolean search(Node rootNode, int toSearch) 
      {
            if (rootNode == null)

                  return false;

            else if (compare(toSearch, rootNode.data) == 0)

                  return true;

            else if (compare(toSearch, rootNode.data) < 0)

                  return search(rootNode.leftChild, toSearch);

            else
                  return search(rootNode.rightChild, toSearch);

      }

     /** 
  	  *  a private inner class to created linked node for binary 
  	  *  search tree.
  	  */
      private class Node 
      {
           
    	  private int data;     
    	  private Node leftChild;          
    	  private Node rightChild;
  
    	  public Node(int data) 
          {               		
    		  this(data, null, null);   		  
          }

            
    	  public Node(int dataInput, Node left, Node right) 
    	  {                
    		  leftChild = left;                  
    		  rightChild = right;                  
    		  data = dataInput;         
    	  }
          
    	  public String toString() 
    	  {                
    		  return "" + data;          
    	  }

      }

}