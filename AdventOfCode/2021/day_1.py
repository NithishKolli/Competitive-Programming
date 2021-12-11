def sonarScan(data):
    count = 0
    for i in range(len(data)):
        if(data[i]>data[i-1]):
            count += 1        
        # print(i, data[i], data[i-1], data[i]>data[i-1], count)
    return count

def sonarScanWindow(data):
    count = 0
    for i in range(len(data)-3):
        if (data[i+3]>data[i]):
            count += 1
    return count

if __name__ == '__main__':
    data_test = open("day_1_input_test.txt", "r").read().split('\n')
    data = open("day_1_input.txt", "r").read().split('\n')

    print(sonarScan(data))
    print(sonarScanWindow(data_test))
    print(sonarScanWindow(data))

    with open("day_1_input.txt", "r") as input:
        input_values = [int(x) for x in input.read().split()]

    
    print(sonarScanWindow(input_values))
    print(sonarScan(input_values))

