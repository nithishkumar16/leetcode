import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        
        for(int[] point:points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            minHeap.offer(new int[]{dist, point[0], point[1]});
        }

        int[][] result = new int[k][2];
        for(int i=0; i<k; ++i) {
            int[] point = minHeap.poll();
            result[i] = new int[]{point[1], point[2]};
        }

        return result;

    }
}
