
def findCourse(input):
    horizontal = 0
    depth = 0
    for command in input:
        instruction = command.split()[0]
        units = int(command.split()[1])
        if instruction == 'forward':
            horizontal += units
        elif instruction == 'down':
            depth += units
        elif instruction == 'up':
            depth -= units
    return depth*horizontal

def findCourseWithAim(input):
    horizontal = 0
    depth = 0
    aim = 0
    for command in input:
        instruction = command.split()[0]
        units = int(command.split()[1])
        if instruction == 'forward':
            horizontal += units
            depth += aim*units
        elif instruction == 'down':
            aim += units
        elif instruction == 'up':
            aim -= units
    return depth*horizontal

if __name__ == '__main__' :
    with open("day_2_input_test.txt", "r") as input:
        input_values_test = [str(x) for x in input.read().split('\n')]
    print(findCourse(input_values_test))
    with open("day_2_input.txt", "r") as input:
        input_values = [str(x) for x in input.read().split('\n')]
    print(findCourse(input_values))

    print(findCourseWithAim(input_values_test))
    print(findCourseWithAim(input_values))