
def check_parentheses(input):
    error_map = {')': 3, ']': 57, '}': 1197, '>' : 25137}
    error_score = 0
    opening_chars = {'(', '[', '{', '<'}
    closing_chars = {')':'(', ']':'[', '}':'{', '>':'<'}
    for line in input:
        stack = []
        for char in line:
            if char in opening_chars:
                stack.append(char)
            else:
                if stack[-1] == closing_chars[char]:
                    stack.pop()
                else:
                    error_score += error_map[char]
                    break
    return error_score

def complete_parentheses(input):
    completion_map = {'(': 1, '[': 2, '{': 3, '<' : 4}
    opening_chars = {'(', '[', '{', '<'}
    closing_chars = {')':'(', ']':'[', '}':'{', '>':'<'}
    completion_scores = []
    
    for line in input:
        stack = []
        for char in line:
            if char in opening_chars:
                stack.append(char)
            else:
                if stack[-1] == closing_chars[char]:
                    stack.pop()
                else:
                    stack = []
                    break
        if len(stack) != 0:
            completion_score = 0
            while len(stack)>0:
                char = stack.pop()
                completion_score *= 5
                completion_score += completion_map[char]
            completion_scores.append(completion_score)
    completion_scores.sort()
    return completion_scores[len(completion_scores)//2]


if __name__ == '__main__':
    with open("day_10_input_test.txt", 'r') as input_file:
        input_values_test = [str(x) for x in input_file.read().split('\n')]
    print(check_parentheses(input_values_test))
    with open("day_10_input.txt", 'r') as input_file:
        input_values = [str(x) for x in input_file.read().split('\n')]
    print(check_parentheses(input_values))

    print(complete_parentheses(input_values_test))
    print(complete_parentheses(input_values))