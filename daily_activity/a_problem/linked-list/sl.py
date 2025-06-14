class Node:
    def __init__(self):
        self.data = None
        self.next = None

class SinglyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def insert_at_first(self, data):
        new_node = Node()
        new_node.data = data
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            new_node.next = self.head
            self.head = new_node
    
    def insert_at_last(self, data):
        new_node = Node()
        new_node.data = data
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node

    def print_list(self):
        current = self.head
        while current:
            print(current.data, end=' ')
            current = current.next
        print()

if __name__ == "__main__":
    sll = SinglyLinkedList()
    sll.insert_at_first(10)
    sll.insert_at_first(20)
    sll.insert_at_last(30)
    sll.insert_at_last(40)
    
    print("Singly Linked List:")
    sll.print_list()  # Output: 20 10 30 40