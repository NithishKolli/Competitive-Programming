
from collections import defaultdict


def number_overlap(input):
    coordinates_dict = defaultdict(int)
    for line in input:
        coordinates = line.split(" -> ")
        x1,y1 =  coordinates[0].split(',')
        x1,y1 = int(x1), int(y1)
        x2,y2 = coordinates[1].split(',')
        x2,y2 = int(x2), int(y2)
        if x1==x2:
            for i in range(min(y1,y2), max(y1,y2)+1):
                coordinates_dict[(x1, i)] += 1
        if y1==y2:
            for i in range(min(x1,x2), max(x1,x2)+1):
                coordinates_dict[(i, y1)] += 1
    overlapped_coordinates = [key for key in coordinates_dict if coordinates_dict[key]>1]
    return len(overlapped_coordinates)
    
def number_overlap_diagonals(input):
    coordinates_dict = defaultdict(int)
    for line in input:
        coordinates = line.split(" -> ")
        x1,y1 =  coordinates[0].split(',')
        x1,y1 = int(x1), int(y1)
        x2,y2 = coordinates[1].split(',')
        x2,y2 = int(x2), int(y2)
        if x1==x2:
            for i in range(min(y1,y2), max(y1,y2)+1):
                coordinates_dict[(x1, i)] += 1
        if y1==y2:
            for i in range(min(x1,x2), max(x1,x2)+1):
                coordinates_dict[(i, y1)] += 1
        if (x1-y1) == (x2-y2):
            for i in range(max(x1,x2)-min(x1,x2)+1):
                coordinates_dict[(min(x1,x2)+i, min(y1,y2)+i)] += 1
        if (x1+y1) == (x2+y2):
            for i in range(max(x1,x2)-min(x1,x2)+1):
                coordinates_dict[(min(x1,x2)+i , max(y1,y2)-i)] += 1
    overlapped_coordinates = [key for key in coordinates_dict if coordinates_dict[key]>1]
    return len(overlapped_coordinates)


if __name__ == '__main__':
    with open('day_5_input_test.txt', 'r') as input_file:
        input_values_test = [str(x) for x in input_file.read().split('\n')]
    print(number_overlap(input_values_test))
    with open('day_5_input.txt', 'r') as input_file:
        input_values = [str(x) for x in input_file.read().split('\n')]
    print(number_overlap(input_values))
    print(number_overlap_diagonals(input_values_test))
    print(number_overlap_diagonals(input_values))