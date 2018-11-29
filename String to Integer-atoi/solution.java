class Solution {
    public int myAtoi(String str) {
        Boolean whitespace = true;
        Boolean sign = true;
        Boolean start = true;
        String numstr = "";
        for(int i=0;i<str.length();i++){
            if(whitespace && str.charAt(i) == ' ')
                continue;
            if(whitespace && str.charAt(i) != ' ')
                whitespace = false;
            if(whitespace==false){
                if(str.charAt(i)!='-' && str.charAt(i)!='+' && (str.charAt(i)<'0' || str.charAt(i)>'9'))
                    break;
                if((sign==false || start==false) && (str.charAt(i)=='-' || str.charAt(i)=='+'))
                    break;
                if(sign && start && (str.charAt(i)=='-' || str.charAt(i)=='+')){
                    sign = false;
                    numstr += str.charAt(i);
                }
                if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                    start = false;
                    numstr += str.charAt(i);
                }
            }
        }
        Boolean negative = false;
        int num = 0;
        int res = 0;
        for(int i=0;i<numstr.length();i++){
            if(numstr.charAt(i)=='-'){
                negative = true;
                continue;
            }
            else if(numstr.charAt(i)=='+')
                continue;
            else{
                if(negative){
                    if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && numstr.charAt(i)> '8'))
                        return Integer.MIN_VALUE;
                    else{
                        num = ((int) numstr.charAt(i) - 48);
                        res *= 10;
                        res += num;
                    }
                }
                else{
                    if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && numstr.charAt(i)> '7'))
                        return Integer.MAX_VALUE;
                    else{
                        num = ((int) numstr.charAt(i) - 48);
                        res *= 10;
                        res += num;
                    }
                }
            }
        }
        if(negative)
            res = res * -1;
        return res;
    }
}
