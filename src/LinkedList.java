// Implements circular linked list with head pointer.
public class LinkedList<T> {
  Node<T> head; // Pointer to first element
  Node<T> lastNode; // Pointer to last element

  // Add value to end of linked list
  void addToEnd(T value) {
    // Create node with value
    Node<T> node = new Node<>(value);

    // If there are no elements, make the new node the first node,
    // assign the lastNode pointer to the one and only node in the list.
    if (head == null) {
      head = node;
      node.nextNode = head;
    } else {
      // Otherwise, make the last node's nextNode pointer assigned to the new node,
      // hence making the new node the last node.
      // Have the new node's nextNode pointer assigned to the first node.
      lastNode.nextNode = node;
      node.nextNode = head;
    }
    // Have lastNode assigned to new last node
    lastNode = node;
  }

  // Remove node from linked list
  void remove(Node<T> node) {
    if (node == head) {
      // If we are removing the first node, assign the head pointer to the next element
      // and assign the last node's nextNode pointer to the new first node.
      head = head.nextNode;
      lastNode.nextNode = head;
    } else {
      // Otherwise, find the node before the node we are removing
      // and assign its pointer to the node after the node we are removing.
      Node<T> ptr = head;
      while (ptr.nextNode != node) {
        ptr = ptr.nextNode;
      }
      ptr.nextNode = ptr.nextNode.nextNode;
    }
  }

  // Get next node of a given node (that may be null)
  // If the given node is null, return the first node.
  public Node<T> getNext(Node<T> node) {
    if (node == null) return head;
    return node.nextNode;
  }

  // Debugging and printing helper function
  // Sequentially prints the values in the linked list
  public void print() {
    Node<T> currentNode = head;
    System.out.print("{");
    do {
      System.out.print(currentNode.value);
      if (currentNode.nextNode != head) System.out.print(", ");
      else System.out.println("}");
      currentNode = currentNode.nextNode;
    } while (currentNode != head);
  }
}
