class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid: asteroids) {
            if(asteroid<0 && !stack.isEmpty() && stack.peek()>0) {
                boolean keepPopping = true;
                while(keepPopping) {
                    if(stack.isEmpty()){
                        stack.add(asteroid);
                        keepPopping=false;
                    } else {
                        int top = stack.pop();
                        if(top>0 && top==Math.abs(asteroid)) {
                            keepPopping=false;
                        }
                        if(top>0 && top>Math.abs(asteroid)){
                            stack.add(top);
                            keepPopping=false;
                        } 
                        if(top<0) {
                            stack.add(top);
                            stack.add(asteroid);
                            keepPopping=false;
                        }
                    }
                }
            } else {
                stack.add(asteroid);
            }
        }


        int[] array = new int[stack.size()]; 
        int index = 0;

        
        for (Integer element : stack) {
            array[index++] = element; 
        }
        return array;
    }
}