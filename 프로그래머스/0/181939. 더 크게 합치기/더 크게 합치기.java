class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String stringA = Integer.toString(a);
        String stringB = Integer.toString(b);
        
        int aPlusB = Integer.parseInt(stringA.concat(stringB));
        int bPlusA = Integer.parseInt(stringB.concat(stringA));

        if (aPlusB >= bPlusA) {
            answer = aPlusB;
        } else {
            answer = bPlusA;
        }
        return answer;
    }
}