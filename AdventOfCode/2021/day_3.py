from copy import deepcopy

def gamma_epsilon(input):
    n_bin_numbers = len(input)
    n_bits = len(input[0])
    gamma = [0]*n_bits
    epsilon = [0] * n_bits
    for bin_number in input:
        for i in range(n_bits):
            if int(bin_number[i]) == 0:
                gamma[i] -= 1
            else:
                gamma[i] += 1
    for i in range(n_bits):
        if gamma[i] >=0:
            gamma[i] = 1
        else:
            gamma[i] = 0
            epsilon[i] = 1
    return gamma, epsilon

def power_consumption(input):
    gamma, epsilon = gamma_epsilon(input)
    gamma_dec = convert_decimal(gamma)
    epsilon_dec = convert_decimal(epsilon)
    return gamma_dec * epsilon_dec

def convert_decimal(binary_list):
    decimal_value = 0
    for i in range(len(binary_list)):
        decimal_value += int(binary_list[i])*(2**(len(binary_list)-i-1))
    return decimal_value

def eval_criteria(input, index, flag):
    parity = [1 if int(input[i][index])==1 else -1 for i in range(len(input))]
    if sum(parity)>=0: # most - 1
        bit_to_keep = flag
    else:
        bit_to_keep = 1 - flag
    new_input = [input[i] for i in range(len(input)) if int(input[i][index]) == bit_to_keep]
    return new_input

def gas_rating(input, flag):
    index = 0
    while len(input)>1:
        input = eval_criteria(input, index, flag)    
        index +=1
    return convert_decimal(input[0])

def life_support_rating(input):
    input_copy = deepcopy(input)
    oxygen_rating = gas_rating(input_copy, 1)
    input_copy = deepcopy(input)
    co2_rating = gas_rating(input_copy, 0)
    return oxygen_rating*co2_rating

if __name__ == '__main__' :
    with open("day_3_input_test.txt", "r") as input:
        input_values_test = [str(x) for x in input.read().split('\n')]
    print(power_consumption(input_values_test))
    with open("day_3_input.txt", "r") as input:
        input_values = [str(x) for x in input.read().split('\n')]
    print(power_consumption(input_values))
    print(life_support_rating(input_values_test))
    print(life_support_rating(input_values))