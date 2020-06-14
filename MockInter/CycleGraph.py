#!/bin/python3

import math
import os
import random
import re
import sys
from collections import defaultdict

#
# Complete the 'willYouGraduate' function below.
#
# The function is expected to return a BOOLEAN.
# The function accepts following parameters:
#  1. INTEGER N
#  2. 2D_INTEGER_ARRAY requirements

graph = defaultdict(list)

def willYouGraduate(N, requirements):
    # Write your code here
    for l in requirements:
        graph[l[0]].append(l[1])
    
    
    

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    N = int(input().strip())

    M = int(input().strip())

    requirements = []

    for _ in range(M):
        requirements.append(list(map(int, input().rstrip().split())))

    result = willYouGraduate(N, requirements)

    fptr.write(str(int(result)) + '\n')

    fptr.close()
