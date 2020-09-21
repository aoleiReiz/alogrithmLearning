package recurse;

public class Solution {
    public int sumNums(int n) {
        if (n <= 0)
            return 0;
        return sumNums(n-1) + n;
    }
}
