def solution(numbers):
    leng = len(numbers)
    answer = [-1] * leng
    stack = []
    
    for i in range(leng):
        while stack and numbers[i] > numbers[stack[-1]]:
            answer[stack.pop()] = numbers[i]
        
        stack.append(i)

    
    return answer