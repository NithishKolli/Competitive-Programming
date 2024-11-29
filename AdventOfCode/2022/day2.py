lookup_dict = {"A" : {"X":4, "Y":8, "Z":3}, "B": {"X":1, "Y":5, "Z":9}, "C": {"X":7, "Y":2, "Z":6}}
lookup_dict_new = {"A" : {"X":3, "Y":4, "Z":8}, "B": {"X":1, "Y":5, "Z":9}, "C": {"X":2, "Y":6, "Z":7}}

def findScore(inputData):
    score = 0
    for move in inputData:
        score += lookup_dict[move[0]][move[2]]
    print(score)

def findScoreNew(inputData):
    score = 0
    for move in inputData:
        score += lookup_dict_new[move[0]][move[2]]
    print(score)

if __name__ == '__main__':
    data_test = open("day2_input_test.txt", "r").read().split('\n')
    data = open("day2_input.txt", "r").read().split('\n')

    findScore(data)
    
    findScoreNew(data)