// Implements circular linked list with head pointer.
public class LinkedList<T> {
  Node<T> head; // Pointer to head element
  Node<T> lastNode; // Pointer to last element in LinkedList

  // Add value to end of linked list
  void addToEnd(T value) {
    // Create node with value
    Node<T> node = new Node<>(value);

    // If there are no elements, make the new node the head node,
    // point the last node to the one and only node in the list.
    if (head == null) {
      head = node;
      node.nextNode = head;
    } else {
      // Otherwise, make the last node point to the new node,
      // hence making the new node the last node.
      // Have the new node's next node point to the first node.
      lastNode.nextNode = node;
      node.nextNode = head;
    }
    // Have lastNode point to the new last node
    lastNode = node;
  }

  // Remove node from linked list
  void remove(Node<T> node) {
    if (node == head) {
      // If we are removing the head, alter the head pointer to point to the next element
      // and modify the last node to point to the new first node.
      head = head.nextNode;
      lastNode.nextNode = head;
    } else {
      // Otherwise, find the node that points to the node we are removing
      // and modify its pointer to point to the node after the node we are removing.
      var ptr = head;
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
