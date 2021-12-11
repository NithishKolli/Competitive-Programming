class BingoSquare:
    def __init__(self):
        self.values = [[0 for i in range(5)] for i in range(5)]
        self.mark = [[0 for i in range(5)] for i in range(5)]
        self.finish = False

    def mark_value(self, draw):
        for row in self.values:
            if draw in row:
                row_index = self.values.index(row)
                column_index = row.index(draw)
                self.mark[row_index][column_index] = 1
                if (sum(self.mark[row_index]) == 5 ):
                    self.finish = True
                temp_sum = 0
                for i in range(5):
                    temp_sum += self.mark[i][column_index]
                if temp_sum == 5:
                    self.finish = True

    def boardComplete(self):
        return self.finish    
            

def read_input(input):
    random_draw = input[0].split(",")
    i = 1
    bingo_squares = []
    while i+5<len(input):
        i += 1
        new_square = BingoSquare()
        for j in range(5):
            new_square.values[j] = " ".join(input[i].split()).split(" ")
            i += 1
        bingo_squares.append(new_square)
        
    return random_draw, bingo_squares

def bingo(input):
    random_draw , bingo_squares = read_input(input)
    for draw in random_draw:
        for bingo_square in bingo_squares:
            bingo_square.mark_value(draw)
            if(bingo_square.boardComplete() == True):
                sum_unmarked = sum([int(bingo_square.values[i//5][i%5]) for i in range(25) if bingo_square.mark[i//5][i%5]== 0])                
                return int(draw)*sum_unmarked

def bingoII(input):
    random_draw , bingo_squares = read_input(input)
    pop_flag = False
    pop_index = []
    for draw in random_draw:
        for bingo_square in bingo_squares:
            bingo_square.mark_value(draw)
            if(bingo_square.boardComplete() == True):
                if len(bingo_squares)>1:
                    pop_flag = True
                    pop_index.append(bingo_squares.index(bingo_square))                    
                else:    
                    sum_unmarked = sum([int(bingo_square.values[i//5][i%5]) for i in range(25) if bingo_square.mark[i//5][i%5]== 0])                
                    return int(draw)*sum_unmarked
        if pop_flag:
            shift = 0
            for index in pop_index:
                bingo_squares.pop(index-shift)
                shift += 1
            pop_flag = False
            pop_index = []

if __name__ == '__main__':
    with open('day_4_input.txt', 'r') as input_file:
        input_values = [str(x) for x in input_file.read().split('\n')]
    with open('day_4_input_test.txt', 'r') as input_file:
        input_values_test = [str(x) for x in input_file.read().split('\n')]
    print(bingo(input_values_test))
    print(bingo(input_values))                
    print(bingoII(input_values_test))
    print(bingoII(input_values))