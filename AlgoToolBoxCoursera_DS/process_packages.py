# python3

from collections import namedtuple

Time = namedtuple("Time", ["time", "type", "index"])
Request = namedtuple("Request", ["arrival", "departure"])

class Buffer:
    def __init__(self, size):
        self.size = size
        self.finish_time = []

    def process(self, request):
        # write your code here
        return Response(False, -1)


def process_requests(requests, times, buffer_size):
    times = sorted(times, key=lambda x:x.time)
    #print(requests)
    responses = [0]*len(requests)
    currSize = 0
    for index, time in enumerate(times):                                
        if time.type == 'a':
            currSize+=1
        else:
            currSize-=1

        if currSize>buffer_size:
            #Drop
            currSize-=1
            responses[time.index] = -1
 
    last_departure = 0
    for i in range(len(requests)):
        if responses[i] == -1: #Dropped?
            continue
        elif i==0:
            last_departure = requests[0].departure
            responses[i] = times[0].time
        else:            
            if last_departure < requests[i].arrival:
                responses[i] = requests[i].arrival
                last_departure = requests[i].departure
            else:                
                responses[i] = last_departure
                last_departure = requests[i].departure
    return responses


def main():
    buffer_size, n_requests = map(int, input().split())
    if (n_requests == 0):
        return
    times = []
    requests = []  
    currentTime = 0;    
    for index in range(0, n_requests):
        arrived_at, time_to_process = map(int, input().split())
        if(arrived_at > currentTime):            
            times.append(Time(arrived_at, 'a', index))
            times.append(Time(arrived_at+time_to_process, 'd', index))
            requests.append(Request(arrived_at, arrived_at+time_to_process))
            currentTime = arrived_at+time_to_process
        else:
            times.append(Time(arrived_at, 'a', index))
            times.append(Time(currentTime+time_to_process, 'd', index))
            requests.append(Request(arrived_at, currentTime+time_to_process))
            currentTime += time_to_process      
    
    responses = process_requests(requests, times, buffer_size)

    for response in responses:
        print(response)


if __name__ == "__main__":
    main()