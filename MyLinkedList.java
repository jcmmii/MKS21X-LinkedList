public class MyLinkedList{
  private int length;
  private Node start,end;

  //constructor
  public MyLinkedList() { //default MyLinkedList has no nodes
    start = null;         //starting and ending nodes are null
    end = null;
    length = 0;           //default size is zero
  }

  public int size() {
    return length;
  }

  public boolean add(int value) {
    Node N = new Node(value);     //creates a new Node based off value
    length = length + 1;
    if (length == 1) {         //if there are no existing nodes
      start = N;
    }
    if (length == 2) {           //if there is a previous node
      end = N;                   //sets the end to the new Node
      start.setNext(end);        //and has both nodes referencing each other
      end.setPrev(start);
    }
    if (length >= 3) {
      end.setNext(N);         //last node references the new node being added
      N.setPrev(end);         //new node being added references previous last node
      end = N;                //now the end node is the new node
    }
    return true;
  }

  public String toString() {
    String ret = "";
    Node current = start;
    while (current != null) {
      ret = ret + current.getData() + ", ";
      current = current.next();                   //swaps the current node to be the next node
    }
    if (ret.length() == 0) return "[]";
    return "[" + ret.substring(0,ret.length()-2) + "]"; //gets rid of the extra ", ", adds brackets to surround
  }

  //private getNthNode method
  private Node getNthNode(int index) {
    if (index < 0 || index >= size()) throw new IndexOutOfBoundsException(); //exception thrown when out of bounds
    Node current = start;
    for (int x = 0; x < index; x++) { //from 0 to the index -1
      current = current.next();       //the current node becomes the next (so at index -1, gets the next, the Nth, node)
    }
    return current;
  }

  public Integer get(int index) {
    return getNthNode(index).getData(); //returns the data/integer
  }

  public Integer set(int index, Integer value) {
    Node current = getNthNode(index);
    Node newNode = new Node(value);
    if (current == start) {
      current.next().setPrev(newNode);  //sets the previous node of the next to the newNode
      newNode.setNext(current.next());  //sets the next node of the newNode to the current Next node
      start = newNode;                  //replaces start with newNode, and the old node disappears
    } else if (current == end) {
      current.prev().setNext(newNode);  //sets the next node of previous to the newNode
      newNode.setPrev(current.prev());  //sets the previous node of the newNode to the current previous Node
      end = newNode;                    //replaces end with newNode, and the old node disappears
    } else {                            //essentially combines the if blocks above
      current.next().setPrev(newNode);  //sets the previous node of the next to the new
      newNode.setNext(current.next());  //sets the next node of the newNode to the current next node
      current.prev().setNext(newNode);  //sets the next node of the previous Node to the newNode
      newNode.setPrev(current.prev());  //sets the previous node of the newNode to the current previous Node
    }
    return get(index);                  //returns the integer/data that is replaced
  }

  public boolean contains(Integer value) {
    Node current = start;
    for (int x = 0; x < length; x++) {    //loops through the LinkedList
      if (current.getData().equals(value)) {
        return true;                      //returns true if the value is equal to the data of current node
      }
      current = current.next();
    }
    return false;                         //returns false if done looping and value is not found
  }

  public int indexOf(Integer value) {
    Node current = start;
    for (int x = 0; x < length; x++) {    //loops through the linked list
      if (current.getData().equals(value)) {
        return x;                         //stops loop and returns index if value is found
      }
      current = current.next();
    }
    return -1;                            //otherwise returns -1 as value is not found
  }

  public void add(int index, Integer value) {
      if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
      Node current, newNode, temp;
      newNode = new Node(value);                    //creates a new Node based off value
      if (index == length) {                        //if the index is the length of the LinkedList, essentially adds to the end
        end.setNext(newNode);                       //swaps and sets newNode to be the end node
        newNode.setPrev(end);
        end = newNode;
      } else {
        current = getNthNode(index);                //else gets the Nth node and sets it to be the current
        if (current == start) {                     //if the current Node is the start
          current.setPrev(newNode);                 //sets the previous node of the start node to the newNode
          newNode.setNext(current);                 //sets next node of the newNode to the current start node
          start = newNode;                          //the start node is now the newNode
        } else {
          temp = current.prev();                     //sets the temporary node the previous node of the current
          temp.setNext(newNode);                     //sets the next node of the temp to the new Node
          newNode.setPrev(temp);                     //sets previous node of newNode to temp
          newNode.setNext(current);                  //sets next node of newNode to current
          current.setPrev(newNode);                  //sets previous node of current to NewNode
        }
      }
      length++;     //adds length +1
}

  public Integer remove(int index) {
    Node current = getNthNode(index);
    if (current == start) {
      current.next().setPrev(null);               //if current is start, changes next node to have a null previous node
      start = current.next();                     //makes the next node the start
    } else if (current == end) {
      current.prev().setNext(null);               //if current is end, changes the previous node to have a null next node
      end = current.prev();                       //makes the previous node the end
    }
    else {
      current.prev().setNext(current.next());     //otherwise just changes references for past and previous node to reference each other
      current.next().setPrev(current.prev());
    }
    length--;
    return current.getData();
  }

  public boolean remove(Integer value) {
    if (contains(value)) {            //checks if value is present
      int I = indexOf(value);
      System.out.println(I);
      remove(I);
      return true;                   //finds the index, removes that index, and returns true
    }
    return false;                   //false is returned otherwise
  }

  //Connecting two linked lists
  public void extend(MyLinkedList other) {
    //in all cases: if other MLL has length of 0, nothing can/is done and this MLL stays the same
    if (this.length == 0) {
      if (other.length == 1) {
        this.length = 1;
        this.start = other.start; //MLLs with length of 1 only have start nodes
        other.length = 0;
      }
      if (other.length > 1) {
        this.length = other.length;
        this.start = other.start; //MLLs with length > 1 have end nodes, accounts for that
        this.end = other.end;
        other.length = 0;
      }
    }
  if (this.length == 1) {
      if (other.length == 1) {
        this.end = other.start;
        this.start.setNext(this.end); //has the two nodes (start, end) reference each other
        this.end.setPrev(this.start); //similar to the add method with length 2
        other.length = 0;
        this.length = 2;
      }
      if (other.length > 1) {
        this.end = other.end;
        this.start.setNext(other.start);          //has two beginning nodes reference each other
        other.start.setPrev(this.start);
        this.length = this.length + other.length;
        other.length = 0;
      }
    }
  if (this.length > 1) {
    if (other.length == 1) {
      this.end.setNext(other.start);
      other.start.setPrev(this.end);
      this.end = other.start;             //other MLL has only start node, this MLL references to that as end
      this.length = this.length + 1;
      other.length = 0;
    }
    if (other.length > 1) {
      this.end.setNext(other.start);
      other.start.setPrev(this.end);
      this.end = other.end;             //if other MLL has length >1, its end is now this MLL's end
      this.length = this.length + other.length;
      other.length = 0;
    }
  }
  //this method does not clear out the other MyLinkedList
  //as long as the other MyLinkedList has length of 0, whenever a method is done on it,
  //it will revert back to as if it was empty and as if it was cleared out
}
}
