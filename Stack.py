class Node(object):
    def __init__(self, value):
        self.value = value
        self.next = None


class Stack:
    '''Stacks follow LIFO. Here we use Linked List for stack implementation
        The last element of the linked list is TOP OF STACK'''
    
    def __init__(self):
        self.head = None
        self.num_elements = 0

    def push(self, value):
        new_node = Node(value)

        if self.head == None:
            self.head = new_node

        else:
            new_node.next = self.head
            self.head = new_node

        self.num_elements += 1

    def size(self):
        return self.num_elements

    def is_empty(self):
        return self.num_elements == 0

    def pop(self):
        if self.is_empty():
            return None
        value = self.head.value
        self.head = self.head.next
        self.num_elements -= 1
        return value

#driver function
if __name__ == "__main__":
    s = Stack()
    
    #demo push
    for i in range(0,10):
        s.push(i)

    print(f"Size of Stack = {s.num_elements}")
    print(f"TOP OF STACK = {s.pop()}")
    print(f"Size of Stack = {s.num_elements}")