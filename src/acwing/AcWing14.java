package acwing;

class Solution {
    public boolean searchArray(int[][] array, int target) {
        if (array.length <= 0 || array[0].length <= 0)
            return false;
        int i = 0, j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            if (array[i][j] == target) return true;
            if (array[i][j] > target) j--;
            else i++;
        }
        return false;
    }
}