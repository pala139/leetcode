import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int ind = 0;

        for (int j = 0; j < n; j++) {
            // 1. Remove indices that are out of the current window boundary
            if (!deque.isEmpty() && deque.peekFirst() < j - k + 1) {
                deque.pollFirst();
            }

            // 2. Remove smaller elements from the back as they won't be needed
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[j]) {
                deque.pollLast();
            }

            // 3. Push current index to the deque
            deque.offerLast(j);

            // 4. Record maximum when window reaches size k
            if (j >= k - 1) {
                res[ind++] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}