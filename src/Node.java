// Implements node data type, which contains pointer to next node
// and data value for current node. Wildcard allows class usage
// with programmer-specified type.
public class Node<T> {
  Node<T> nextNode;
  T value;

  // Initialize node based on given value
  public Node(T value) {
    this.nextNode = null;
    this.value = value;
  }
}
