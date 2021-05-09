/*
Design a system that manages the reservation state of n seats that are numbered from 1 to n.

Implement the SeatManager class:

SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n. All seats are initially available.
int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.
void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.
*/

class SeatManager {
    Queue<Integer> aux = new PriorityQueue<>();     //contains unreserved seats

    public SeatManager(int n) {
        for(int i = 1;i<=n;i++)
            aux.add(i);
    }
    
    public int reserve() {
        return aux.poll();
    }
    
    public void unreserve(int seatNumber) {
        aux.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
