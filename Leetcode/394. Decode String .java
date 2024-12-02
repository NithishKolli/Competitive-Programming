class Solution {
    public String decodeString(String s) {
        int pointerNextOpenBracket = 0;
        int currentIndex = 0 ;
        Stack<String> stack = new Stack<>();
        while(currentIndex<s.length()) {
            if(Character.isDigit(s.charAt(currentIndex))) {
                
                if(!stack.isEmpty() && stack.peek().matches("\\d+") && currentIndex>0 && s.charAt(currentIndex-1) != '['){
                    System.out.println(s.charAt(currentIndex));
                    System.out.println(s.charAt(currentIndex-1));
                    String temp = stack.pop();
                    temp += s.charAt(currentIndex);
                    stack.push(temp);
                } else{
                    stack.push(Character.toString(s.charAt(currentIndex)));
                }
                currentIndex++;
            } else if(s.charAt(currentIndex) == ']') {
                boolean pop = true;
                String temp = "";
                while(pop) {
                    if(!stack.isEmpty() && stack.peek().matches("\\d+")) {
                        int repeat = Integer.parseInt(stack.pop());
                        temp = temp.repeat(repeat);
                        stack.push(temp);
                        pop = false;
                    } else {
                        temp = stack.pop()+temp;
                    }
                }
                currentIndex++;
            } else if(s.charAt(currentIndex) == '[') {
                currentIndex++;
              continue;  
            } else {
                stack.push(Character.toString(s.charAt(currentIndex)));
                currentIndex++;
            }
        }
        String answer = "";
        while(!stack.isEmpty()) {
            answer = stack.pop() + answer;
        }
        return answer;
    }
}