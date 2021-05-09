/*
A binary heap is a Binary Tree with the following properties:
1) It’s a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible). This property of 
Binary Heap makes them suitable to be stored in an array.

2) A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the key at the root must be minimum among all keys present in Binary Heap. The same property
must be recursively true for all nodes in Binary Tree. Max Binary Heap is similar to MinHeap.

You are given an empty Binary Min Heap and some queries and your task is to implement the three methods insertKey,  deleteKey,  and extractMin on the Binary Min
Heap and call them as per the query given below:
1) 1  x  (a query of this type means to insert an element in the min-heap with value x )
2) 2  x  (a query of this type means to remove an element at position x from the min-heap)
3) 3  (a query like this removes the min element from the min-heap and prints it ).
*/

class MinHeap {
    int[] harr;
    int capacity,size;
    MinHeap(int cap) {
        size = 0;
        capacity = cap;
        harr = new int[cap];
    }
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }

    //Function to extract minimum value in heap and then to store 
    //next minimum value at first index.
    int extractMin()
    {
        // Your code here.
        if(size == 0)
            return -1;
        int res = harr[0];
        harr[0] = harr[size-1];
        size--;
        MinHeapify(0);
        return res;
    }

    //Function to insert a value in Heap.
    void insertKey(int k) 
    {
        // Your code here.
        if(size == capacity)
            return;
        size++;
        decreaseKey(size-1, k);
    }

    //Function to delete a key at ith index.
    void deleteKey(int i) 
    {
        // Your code here.
        if(i >= size)
            return;
        if(i == size-1) {
            size--;
            return;
        }
        harr[i] = harr[size-1];
        int n = size;
        size--;
        if(2*i+1 < n)
            MinHeapify(i);
        else
            decreaseKey(i, harr[i]);
    }

    //Function to change value at ith index and store that value at first index.
    void decreaseKey(int i, int new_val) 
    {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    /* You may call below MinHeapify function in
      above codes. Please do not delete this code
      if you are not writing your own MinHeapify */
    //Top-to-bottom heapification
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < size && harr[l] < harr[i]) smallest = l;
        if (r < size && harr[r] < harr[smallest]) smallest = r;
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest);
        }
    }
}
