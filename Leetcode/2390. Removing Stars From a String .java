class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) != '*') {
                sb.append(s.charAt(i));
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}

class Solution {
    public String removeStars(String s) {
        char[] ch = new char[s.length()];
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                j--;
            } else {
                ch[j++] = c;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < j; i++) {
            answer.append(ch[i]);
        }

        return answer.toString();
    }
}

class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!st.isEmpty()) {
            answer.append(st.pop());
        }

        return answer.reverse().toString();
    }
}

