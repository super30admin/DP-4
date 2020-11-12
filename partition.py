class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        def maxSumAfterPartitioning0(cls, arr: List[int], k: int) -> int:
    l = len(arr)
    if l == 1:
        return arr[0]

    s_max = None
    for i in range(1, min(k, l) + 1):
        arr_0_i = arr[0:i]
        arr_i_n = arr[i:]

        cur_max = max(arr_0_i) * i
        if len(arr_i_n) > 0:
            cur_max += Solution.maxSumAfterPartitioning(arr_i_n, k)

        if s_max is None or cur_max > s_max:
            s_max = cur_max
            
    return s_max