
from collections import Counter


def get_equidistant_point(input):
    input.sort()
    counter_input = Counter(input)
    curr_distance = sum(input)
    curr_distance -= input[0]*len(input)
    least_distance = curr_distance
    i = counter_input[input[0]]
    diff = input[counter_input[input[0]]] - input[0]
    less_values = counter_input[input[0]]
    while i < len(input):
        current_value = input[i]
        curr_distance -= diff*(len(input)-less_values)
        curr_distance += diff*less_values
        least_distance = min(least_distance, curr_distance)
        less_values += counter_input[input[i]]
        i += counter_input[input[i]]
        if i < len(input):
            diff = input[i] - current_value
    return least_distance

def get_equidistant_point_II(input):
    input.sort()
    counter_input = Counter(input)
    curr_distance = sum(input)
    curr_distance -= input[0]*len(input)
    least_distance = curr_distance
    i = counter_input[input[0]]
    diff = input[counter_input[input[0]]] - input[0]
    less_values = counter_input[input[0]]
    while i < len(input):
        current_value = input[i]
        curr_distance -= diff*(len(input)-less_values)
        curr_distance += diff*less_values
        least_distance = min(least_distance, curr_distance)
        less_values += counter_input[input[i]]
        i += counter_input[input[i]]
        if i < len(input):
            diff = input[i] - current_value
    return least_distance

if __name__ == '__main__':
    with open("day_7_input_test.txt", "r") as input_file:
        input_values_test = [int(x) for x in input_file.read().split(',')]
    print(get_equidistant_point(input_values_test))
    with open("day_7_input.txt", "r") as input_file:
        input_values = [int(x) for x in input_file.read().split(',')]
    print(get_equidistant_point(input_values))
    