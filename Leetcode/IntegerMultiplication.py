"""This Program is written for Assingment 1 of Divide and Conquer Course on Coursera"""

import sys
import math


def product_integer(in1, in2):
    n = len(str(in1))
    a = int(str(in1)[:n/2])
    b = int(str(in1)[n/2:])
    c = int(str(in2)[:n/2])
    d = int(str(in2)[n / 2:])
    ac = product_integer(a, c)
    bd = product_integer(b, d)
    ad = product_integer(a, b)
    bc = product_integer(b, c)

    return 0


if __name__ == '__main__':
    int1 = sys.argv[1]
    int2 = sys.argv[2]
    mul = product_integer(int1, int2)
    print(mul)
