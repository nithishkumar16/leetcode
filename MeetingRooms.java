import java.util.Arrays;

public class MeetingRooms {
    class Solution {
    static boolean canAttend(int[][] arr) {
        // Your code here
        Arrays.sort(arr, (a,b)->Integer.compare(a[0],b[0]));
        int prevend = arr[0][1];
        
        for(int i=1;i<arr.length;i++) {
            int start = arr[i][0];
            if(start<prevend) return false;
            prevend=arr[i][1];
        }
        
        return true;
    }
}
}
