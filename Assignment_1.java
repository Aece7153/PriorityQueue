import java.util.LinkedList;


class PriorityQueue {
    // Make arraylist of elements
    // Element will have (int value, int priority)
    private LinkedList<Element> queue;

    // Constructor to setup queue
    public PriorityQueue() {
        queue = new LinkedList<>();
    }

    // Class to represent each element with its value and priority
    private static class Element {
        int value;
        int priority;

        public Element(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }



    // Add new element to queue with its value and priority
    public void insert(int value, int priority) {
        queue.add(new Element(value, priority));
    }

    // Remove method, returns the value of maxPriorityIndex
    public int remove() {
        // If the queue is empty
        if (queue.isEmpty()) {
            // throw exception
            throw new IllegalStateException("Queue is empty");
        }
        //maxPriorityIndex is initialized to 0 (the first element)
        int maxPriorityIndex = 0;
        // While "i" is less than the queue size
        for (int i = 1; i < queue.size(); i++) {
            /* If the priority of current "i" is higher than the maxPriorityIndex
                then make the new maxPriorityIndex = "i"
               If they have equal priority then
                compare their values and return the element with a greater value
             */
            if (queue.get(i).priority > queue.get(maxPriorityIndex).priority || //or
                    (queue.get(i).priority == queue.get(maxPriorityIndex).priority && //and
                            queue.get(i).value > queue.get(maxPriorityIndex).value)) {
                maxPriorityIndex = i;
            }
        }

        // Remove and return the element with the highest priority and value
        int value = queue.get(maxPriorityIndex).value;
        queue.remove(maxPriorityIndex);
        return value;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Method to print the queue with priority and value in mind (highest priority and greater value first)
    public void printPQ() {
        // Create a copy of the queue to avoid altering the original queue
        LinkedList<Element> sortedQueue = new LinkedList<>();
        sortedQueue = queue;

        // Implementing bubble sort to sort the list by priority and value
        // For every element compare it to every other element
        for (int i = 0; i < sortedQueue.size() - 1; i++) {
            for (int j = 0; j < sortedQueue.size() - 1 - i; j++) {
                Element current = sortedQueue.get(j);
                Element next = sortedQueue.get(j + 1);

                // Compare by priority, then by value if priorities are equal
                if (current.priority < next.priority ||
                        (current.priority == next.priority && current.value < next.value)) {
                    // Swap elements
                    sortedQueue.set(j, next);
                    sortedQueue.set(j + 1, current);
                }
            }
        }

        // Print the sorted elements
        System.out.println("Queue elements (value, priority) in priority order:");
        for (Element e : sortedQueue) {
            System.out.println("Value: " + e.value + ", Priority: " + e.priority);
        }
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.insert(10, 2);
        pq.insert(5, 1);
        pq.insert(20, 3);
        pq.insert(25, 3);
        pq.insert(11, 3);
        pq.printPQ();


        System.out.println();
        pq.remove();
        pq.printPQ();






    }
}

