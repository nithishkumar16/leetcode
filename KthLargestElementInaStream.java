import java.util.PriorityQueue;

public class KthLargestElementInaStream {
    PriorityQueue<Integer> minheap;
    int K;
    public KthLargest(int k, int[] nums) {
        this.K=k;
        this.minheap = new PriorityQueue<>();
        
        for(int n:nums) {
            minheap.offer(n);
            if(minheap.size()>k) {
                minheap.poll();
            }
        }
    }
    
    public int add(int val) {
        minheap.offer(val);
        if(minheap.size()>this.K) {
            minheap.poll();
        }

        return minheap.peek();
    }
}
