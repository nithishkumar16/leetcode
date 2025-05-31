import java.util.*;

class lastStoneWeightClass {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i : stones) {
            minHeap.offer(-i);
        }

        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            minHeap.offer(first - second);
        }

        minHeap.offer(0);
        return Math.abs(minHeap.peek());
    }
}