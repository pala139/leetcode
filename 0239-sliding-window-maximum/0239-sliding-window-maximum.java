import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // Stores indices of candidates

        for (int i = 0; i < n; i++) {

            // 1. EXPIRY: Has the front candidate expired (moved out of the window)?
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst(); // Remove expired candidate from front
            }//  remove from back useless one <-- _ _ _ _ _  <--adding from front

            // 2. KICK OUT: Remove older candidates that are weaker than current nums[i]
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast(); // Remove useless candidate from back
            }

            // 3. ADD: Current element enters as a potential future candidate
            dq.offerLast(i);

            // 4. RECORD: The strongest candidate is ALWAYS at the front
            if (i >= k - 1) { // same as j-i+1 >=k
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}