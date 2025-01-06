public class Main {
  public static void main(String[] args) {
    int N = 3; // Specifies the Nth number is repeatedly removed until a single number remains
    LinkedList<Integer> list = new LinkedList<>();

    // Populate linked list with 1....6
    for (int i = 1; i <= 6; i++) {
      list.addToEnd(i);
    }

    // Print representation of full linked list
    list.print();

    Node<Integer> ptr = null;
    while (list.head.nextNode != list.head) {
      // While there still is more than 1 node, remove every Nth node sequentially
      for (int i = 0; i < N - 1; i++) {
        ptr = list.getNext(ptr);
      }
      list.remove(ptr.nextNode);

      // Print modified list result
      list.print();
    }
  }
}