package recentlySum;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    class RecentCounter {

        // 计数
        int count;
        // 定义队列
        Deque<Integer> queue;
        // 3000毫秒
        static int MILL = 3000;

        public RecentCounter() {
            count = 0;
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            // 将头部小于t-3000的数出队
            while(!queue.isEmpty() && queue.peekFirst() < t - MILL){
                queue.pollFirst();
            }
            // 添加t
            queue.addLast(t);
            return queue.size();
        }
    }


}
