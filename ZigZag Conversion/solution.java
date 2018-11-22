class Solution {
    public String convert(String s, int numRows) {
        String news = "";
        if(s.length() <= 0 || numRows == 1)
            return s;
        int index = 0;
        for(int i = 0;i<numRows;i++){
            index = i;
            Boolean flag = true;
            int fold = 1;
            if(i==numRows-1)
                fold = 2;
            while(index<s.length()){
                news += s.charAt(index);
                index = (fold * (numRows - 1) - index) * 2 + index;
                if(i==0 || i==numRows-1)
                    fold += 2;
                else
                    fold ++;
            }
        }
        return news;
    }
}
