class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        if(x == reverse(x))
            return true;
        else
            return false;
    }
    
    public int reverse(int x){
        int rev = 0;
        int pop;
        while(x > 0){
            pop = x % 10;
            if (rev > Integer.MAX_VALUE / 10)
                return 0;
            rev = rev * 10 + pop;
            x = x / 10;
        }
        return rev;
    }
}