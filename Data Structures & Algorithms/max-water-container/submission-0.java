class Solution {
    public int maxArea(int[] heights) {

        int maxWater=0;
        int left=0;
        int right=heights.length-1;

        while(left<right){

            int h=Math.min(heights[left],heights[right]);
            int w=right-left;

            int water=h*w;

            if(water>maxWater){
                maxWater=water;
            }
            if(heights[left]<heights[right]){
                left++;
            }else{
                right--;
            }

        }

        return maxWater;
        
    }
}
