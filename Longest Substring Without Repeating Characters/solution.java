class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 0){
            return 0;
        }
        else{
            Map<Character, Integer> m = new HashMap();
            int[] len = new int[s.length()];
            int front = 0;
            m.put(s.charAt(front), front);
            len[front] = 1;
            for(int rear=1;rear<s.length();rear++){
                if(m.get(s.charAt(rear))==null){
                    m.put(s.charAt(rear), rear);
                    len[rear] = len[rear - 1] + 1;
                }
                else{
                    int cnt = 0;
                    int v = m.get(s.charAt(rear));
                    for(;front<=v;front++){
                        m.remove(s.charAt(front));
                        cnt ++;
                    }
                    m.put(s.charAt(rear), rear);
                    len[rear] = len[rear -1] - cnt + 1;
                }
            }
            int max = 1;
            for(int i=0;i<s.length();i++){
                if(len[i] > max)
                    max = len[i];
            }

            return max;
        }
        
    }
}
