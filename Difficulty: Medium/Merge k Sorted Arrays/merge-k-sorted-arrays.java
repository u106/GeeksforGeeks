class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        int k = mat.length;
        ArrayList<Integer> output = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < k; ++i){
            if (mat[i].length > 0){
                minHeap.add(new int[]{mat[i][0], i, 0});
            }
        }
        while (!minHeap.isEmpty()){
            int[] top = minHeap.poll();
            int val = top[0];
            int i = top[1];
            int j = top[2];
            output.add(val);

            // Push next element from same array
            if (j + 1 < mat[i].length){
                minHeap.add(new int[]{mat[i][j + 1], i, j + 1});
            }
        }

        return output;
    }
}