public class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // step 1
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        //step 2
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int key : freqMap.keySet()) {

            int frequency = freqMap.get(key);

            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(key);
        }

        // step 3
        int[] result = new int[k];
        int index = 0;

        
        for (int i = bucket.length - 1; i >= 0; i--) {

            if (bucket[i] != null) {

                for (int num : bucket[i]) {

                    result[index] = num;
                    index++;

                    
                    if (index == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
