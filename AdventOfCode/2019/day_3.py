#Crossed Wires
# Given a set of instructions(path) for two wires(bots). Find their closest dist.
# import prettify
def take_input():
    input_data = open('day_3_input.txt', 'r').read()
    instructions = input_data.split('\n')
    instructions.pop()
    # instructions = [ 'R75,D30,R83,U83,L12,D49,R71,U7,L72', 'U62,R66,U55,R34,D71,R55,D58,R83']
    # instructions = [ 'R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51', 'U98,R91,D20,R16,D67,R40,U7,R15,U6,R7']
    intersections = set()
    path = set()
    def parse_instruction(instruction, b): # b - 1 1st, 2 2nd
        posx = 0
        posy = 0
        # print(grid[pos[0]][pos[1]])
        try:
            for move in instruction.split(','):
                # print(move)
                movement = int(move[1:])
                x = y = 0
                if move[0]=='U':
                    y = 1
                elif move[0] == 'R':
                    x = 1
                elif move[0] == 'D':
                    y = -1
                elif move[0] == 'L':
                    x = -1
                for i in range(1, movement + 1):
                    path.add((posx+x, posy+y))
                    if b == 2:
                        if (posx+x, posy+y) in path:
                            intersections.append((posx+x, posy+y))
                    # grid[pos[0]][pos[1]] = b
                    

        except:
            print(move)
        

    parse_instruction(instructions[0], 1)
    parse_instruction(instructions[1], 2)
    print(intersections)
    min_length = 1000000
    for intersection in intersections:
        min_length = min(min_length, abs(intersection[0]-500000)+abs(intersection[1]-500000))
    # print('\n'.join(['\t'.join([str(cell) for cell in row]) for row in grid]))
    print(min_length)
    return instructions

if __name__ == "__main__":
    take_input()
