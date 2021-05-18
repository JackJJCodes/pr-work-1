class Queue:
    '''Queue Follows FIFO, Here we use Lists for Implementing Queue
        Front of the queue is the first element and back of the queue is the last element'''

    def __init__(self):
        self.items = []
    
    def __str__(self) -> str:
        return f"front --> {self.items} <-- rear"  #clever use of formatted strings
    
    def __len__(self):
        return len(self.items)

    def get_front(self):    #getter for front element
        return self.items[0]

    def get_rear(self):     #getter for rear element
        return self.items[-1]

    def is_empty(self):     #gives bool output
        return len(self.items) == 0

    #operation on list for queue implementation

    def enqueue(self, item):    #add element to rear of queue
        self.items.append(item)

    def dequeue(self):          #remove the front element
        if self.is_empty():
            print("The queue is empty")
        else:
            return self.items.pop(0)

#driving function
if __name__ == "__main__":
    q = Queue()
    print(f"initialised queue: {q}")

    #demo enqueue
    for i in range(5):
        q.enqueue(i)
        print(f"Enqueueed state {i} : {q}")

    #demo dequeue
    for i in range(3):
        q.dequeue()
        print(f"Dequeued state {i} : {q}")
