package MonotonousStack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution42 {
    public int trap(int[] height) {
        int ans = 0,current = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }
        return ans;

    }

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = solution42.trap(height);
        System.out.println(trap);
    }
}
