def solution(task_memory, task_type, max_memory):
    r = 0
    have = {}
    
    for i in range(len(task_type)):
        if task_type[i] not in have:
            have[task_type[i]] = []
        have[task_type[i]].append(task_memory[i])
    
    for key, value in have.items():
        value.sort()
        i, j = 0, len(value) - 1
        while i < j:
            if value[i] + value[j] <= max_memory:
                i += 1
            r += 1
            j -= 1
        if i == j:
            r += 1
    
    return r
