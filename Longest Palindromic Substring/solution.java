class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 0)
            return "";
        int strlen = s.length();
        int left=0, right = 0, maxlen = 0;
        Boolean[][] palindromic = new Boolean[strlen][strlen];
        for(int i=0;i<strlen;i++){
            for(int j=0;j<=i;j++){
                if(i==j)
                    palindromic[i][j] = true;
                else if(i-j==1)
                    palindromic[i][j] = (s.charAt(i) == s.charAt(j));
                else
                    palindromic[i][j] = (s.charAt(i) == s.charAt(j)) && (palindromic[i-1][j+1]);
                if (palindromic[i][j] && maxlen<(i-j+1)){
                    maxlen = i-j+1;
                    left = j;
                    right = i+1;
                }
            }
        }
        return s.substring(left, right);
    }
}
