class Solution {
    public int reverse(int x) {
        Boolean negative = false;
        if(x < 0){
            x = -1 * x;
            negative = true;
        }
        int y = 0;
        while(x > 0){
            if(y> 214748364)
                return 0;
            y = (x % 10) + y * 10;
            x = x / 10;
        }
        if(negative)
            y = -1 * y;
        return y;
    }
}
