package cui.shibing;

public class MaxArea {
    public static void main(String[] args) {
        System.out.println(new MaxArea().maxArea(new int[]{1,1}));
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int len = height.length;
        for (int i = 0, j = len - 1; i < len && i < j;) {
            int area = (j-i) * Math.min(height[i],height[j]);
            if(area > maxArea)
                maxArea = area;
            if(height[i] < height[j])
                i++;
            else j--;
        }
        return maxArea;
    }
}
