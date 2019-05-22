public class ContainerMaxArea {
    static class Solution {
        public int maxArea;
        public int startIdx, endIdx;
    }

    public static void getContainerWithMaxArea(Solution s, int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = -1;
        while(left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if(area > maxArea) {
                maxArea = area;
                s.maxArea = maxArea;
                s.startIdx = left;
                s.endIdx = right;
            }

            if(height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }
    }

    public static int getMaxArea(int[] height) {
        int maxArea = -1;
        int i, j;

        for(i = 0; i < height.length - 1; ++i) {
            for(j = i + 1; j < height.length; ++j) {
                int area = Math.min(height[i], height[j]) * (j - i);
                if(area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    public static void test(int[] height) {
        Solution s = new Solution();
        int maxArea;

        maxArea = getMaxArea(height);
        getContainerWithMaxArea(s, height);

        if(maxArea != s.maxArea) {
            System.err.println("Wrong solution");
            System.exit(1);
        }

        int realArea = Math.min(height[s.startIdx], height[s.endIdx]) * (s.endIdx - s.startIdx);
        if(maxArea != realArea) {
            System.err.println("Real area doesn't match max area");
            System.exit(1);
        }

        System.out.println("start=" + s.startIdx + " end=" + s.endIdx + " maxArea=" + s.maxArea);
    }

    public static void main(String[] args) {
        int[] h1 = {1, 2};
        test(h1);

        int[] h2 = {3, 4, 7, 9, 11, 2, 19, 20, 10, 15};
        test(h2);
    }
}