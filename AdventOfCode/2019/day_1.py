import os

def fuel_needed_2(module_data):
    fuel = 0
    total_fuel = 0
    for content in module_data:
        fuel = (int(content)//3)-2
        while fuel>0:
            total_fuel += fuel
            fuel = fuel//3
            fuel -= 2
    print(total_fuel)

def fuel_needed_1(module_data):
    fuel = 0
    for content in module_data:
        fuel += (int(content)//3)-2
    print(fuel)
if __name__ == '__main__':
    data = open("day_1_input.txt", "r").read().split('\n')
    fuel_needed_1(data)
    fuel_needed_2(data)