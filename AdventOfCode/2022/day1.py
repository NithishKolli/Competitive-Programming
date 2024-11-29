
def findMaximumCalories(inputDataList):
    iterationSum = 0
    maxSum = 0
    for element in inputDataList:
        if(element==""):
            maxSum = max(maxSum, iterationSum)
            iterationSum = 0
        else:
            iterationSum += int(element)
    print(maxSum)

def findTopThree(inputDataList):
    maxSumMin = 0
    maxSumMid = 0
    maxSumMax = 0
    iterationSum = 0

    for count, element in enumerate(inputDataList):
        if(element=="" or count == len(inputDataList)-1):
            if count == len(inputDataList)-1:
                iterationSum = int(element)
            if iterationSum>maxSumMin:
                if iterationSum>maxSumMid:
                    if iterationSum>maxSumMax:
                        maxSumMin = maxSumMid
                        maxSumMid = maxSumMax
                        maxSumMax = iterationSum
                    else:
                        maxSumMin = maxSumMid
                        maxSumMid = iterationSum
                else:
                    maxSumMin = iterationSum
            iterationSum = 0
        else:
            iterationSum += int(element)
    print(maxSumMin+maxSumMid+maxSumMax)


if __name__ == '__main__':
    data_test = open("day1_input_test.txt", "r").read().split('\n')
    data = open("day1_input.txt", "r").read().split('\n')

    # findMaximumCalories(data)
    findTopThree(data)
