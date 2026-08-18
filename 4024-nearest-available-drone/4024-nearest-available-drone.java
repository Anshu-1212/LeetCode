class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        int n = drones.length;
        for (int i = 0; i < n; i++) {
            int[] d = drones[i];
            if (Math.abs(target[0] - d[0]) + Math.abs(target[1] - d[1]) <= d[2]) {
                if (min > Math.abs(target[0] - d[0]) + Math.abs(target[1] - d[1])) {
                    min = Math.abs(target[0] - d[0]) + Math.abs(target[1] - d[1]);
                    minIdx = i;
                }
            }
        }
        return minIdx;
    }
}