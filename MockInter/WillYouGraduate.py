'''In-order to graduate from university you will have to complete N courses which are labeled from 0 to N-1.
There are requirements to some of the courses, for example to complete course x you need to complete course y first, which is shown in the form of: [x, y]
Determine whether it is possible for you to finish all the courses and graduate, given a list of course requirements as explained above and N courses.

Input Format
You need to complete the below function which receives an integer N as number of courses and a M x 2 matrix indicating course requirement where M is the length of the requirements list and each row is of the form [x, y] as explained above.
Boolean willYouGraduate(int N, List<List<Integer>> requirements){
}
Constraints
1. 1 <= N <= 10^5
2. The input requirements is a graph represented by a list of edges, not adjacency matrices. 
3. There will be no duplicates in the input.

Output Format
A boolean value indicating whether it is possible for you to finish all courses.'''

import os
from collections import defaultdict


def cycle(n,graph): 
    in_degree=[0]*n 
 
    for i in range(n): 
        for j in graph[i]: 
            in_degree[j]+=1
      
    queue=[] 
    for i in range(len(in_degree)): 
        if in_degree[i]==0: 
            queue.append(i) 

    cnt=0
    while(queue): 
 
        nu=queue.pop(0) 
 
        for v in graph[nu]: 
            in_degree[v]-=1
              
            if in_degree[v]==0: 
                queue.append(v) 
        cnt+=1
      
    if cnt==n: 
        return False
    else: 
        return True

graph = defaultdict(list)

def willYouGraduate(N, requirements):
    # Write your code here
    for l in requirements:
        graph[l[0]].append(l[1])
    
    if cycle(N, graph):
        return 0
    else:
        return 1

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