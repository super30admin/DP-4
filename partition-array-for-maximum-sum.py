# tc O(n*k), sc O(n).
def rec(i):
    if i == len(arr):
        return 0
    
    currmax = 0
    isum = 0
    for j in range(i, min(i+k, len(arr))):
        currmax = max(currmax, arr[j])
        sumn = currmax * (j-i+1)
        if j+1 in seen:
            mysum = seen[j+1]
        else:
            mysum = rec(j+1)
        isum = max(isum, mysum + sumn)
    
    seen[i] = isum
    
    return isum

seen = {}
return rec(0)