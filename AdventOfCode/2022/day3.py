def getPrioritySum(inputData):
    prioritySum = 0
    for rucksack in inputData:
        rucksack1 = rucksack[:int(len(rucksack)/2)]
        rucksack2 =rucksack[int(len(rucksack)/2):]
        charList = [0] * 53
        for char in rucksack1:
            charList[getIndex(char)] += 1
        for char in rucksack2:
            if charList[getIndex(char)] != 0:
                prioritySum += getIndex(char)
                break
    print(prioritySum)

def getPrioritySum2(inputData):
    prioritySum = 0
    charList1 = [0] * 53
    charList2 = [0] * 53
    for count, rucksack in enumerate(inputData):
        if (count+1)%3 == 1:
            charList1 = [0] * 53
            charList2 = [0] * 53
            for char in rucksack:
                charList1[getIndex(char)] += 1
        elif (count+1)%3 == 2:
            for char in rucksack:
                if charList1[getIndex(char)] != 0:
                    charList2[getIndex(char)] += 1
        elif (count+1)%3 == 0:
            for char in rucksack:
                if charList2[getIndex(char)] != 0:
                    prioritySum += getIndex(char)
                    break
    print(prioritySum)

def getIndex(c):
    if ord(c)>64 and ord(c) < 91:
        return ord(c)-64+26
    if ord(c)>96 and ord(c)<123:
        return ord(c)-96

if __name__ == '__main__':
    data_test = open("day3_input_test.txt", "r").read().split('\n')
    data = open("day3_input.txt", "r").read().split('\n')

    # print(data_test)
    getPrioritySum(data)
    getPrioritySum2(data)