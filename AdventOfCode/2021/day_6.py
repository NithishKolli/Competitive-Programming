import collections
from copy import deepcopy

def lanternfish(input, days):
    fishes = deepcopy(input)
    for day in range(days):
        hatches = 0
        for i in range(len(fishes)):
            if fishes[i] == 0:
                fishes[i] = 6 
                hatches += 1
            else:
                fishes[i] -= 1
        while hatches>0:
            fishes.append(8)
            hatches -= 1
    return len(fishes)

def lanternFishDP(input, days):
    fishes_dict = collections.defaultdict(int)
    for fish in input:
        fishes_dict[fish] += 1
    for i in range(days):
        new_fishes_dict = collections.defaultdict(int)
        for j in range(8):
            new_fishes_dict[j] = fishes_dict[j+1]
        new_fishes_dict[8] = fishes_dict[0]
        new_fishes_dict[6] += fishes_dict[0]
        fishes_dict = new_fishes_dict
        new_fishes_dict = {}
    number_of_fishes = 0
    for i in range(9):
        number_of_fishes += fishes_dict[i]
    return number_of_fishes

if __name__ == '__main__':
    with open("day_6_input_test.txt", 'r') as input_file:
        input_values_test = [int(x) for x in input_file.read().split(",")]
    print(lanternfish(input_values_test, 18))
    print(lanternfish(input_values_test, 80))
    print(lanternFishDP(input_values_test, 18))
    print(lanternFishDP(input_values_test, 80))
    print(lanternFishDP(input_values_test, 256))
    with open("day_6_input.txt", 'r') as input_file:
        input_values = [int(x) for x in input_file.read().split(",")]
    print(lanternfish(input_values, 18))
    print(lanternfish(input_values, 80))
    print(lanternFishDP(input_values, 18))
    print(lanternFishDP(input_values, 80))
    print(lanternFishDP(input_values, 256))
    