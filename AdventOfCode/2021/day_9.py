def risk_low_points(input):
    row = len(input)
    column = len(input[0])
    padded_matrix = [[float('+inf') for j in range(column+2)] for i in range(row+2)]
    for i in range(1,row+1):
        for j in range(1,column+1):
            padded_matrix[i][j] = int(input[i-1][j-1])
    risk = 0
    for i in range(1,row+1):
        for j in range(1,column+1):
            if padded_matrix[i][j] < padded_matrix[i-1][j] and padded_matrix[i][j] < padded_matrix[i+1][j] and padded_matrix[i][j] < padded_matrix[i][j-1] and padded_matrix[i][j] < padded_matrix[i][j+1]:
                risk += padded_matrix[i][j] + 1
    return risk
if __name__ == '__main__':
    with open("day_9_input_test.txt", 'r') as input_file:
        input_values_test = [str(x) for x in input_file.read().split('\n')]
    print(risk_low_points(input_values_test))
    with open("day_9_input.txt", 'r') as input_file:
        input_values = [str(x) for x in input_file.read().split('\n')]
    print(risk_low_points(input_values))