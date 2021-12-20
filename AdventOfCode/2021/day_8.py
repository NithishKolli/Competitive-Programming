def count_values(input):
    count = 0
    for line in input:
        output = line.split("|")[1]
        words = output.split(" ")
        for word in words:
            if len(word) == 7 or len(word) == 4 or len(word) == 3 or len(word) == 2:
                print(word)
                count += 1
    return count
if __name__ == '__main__':
    # with open("day_8_input_test.txt", 'r') as input_file:
    #     input_values_test = [str(x) for x in input_file.read().split('\n')]
    # print(count_values(input_values_test))
    with open("day_8_input.txt", 'r') as input_file:
        input_values = [str(x) for x in input_file.read().split('\n')]
    print(count_values(input_values))