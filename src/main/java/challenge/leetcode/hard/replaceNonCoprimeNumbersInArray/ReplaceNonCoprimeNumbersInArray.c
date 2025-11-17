//#include <stdio.h>
//#include <stdlib.h>
//
//int gcd(int a, int b)
//{
//    while (b != 0)
//    {
//        int temp = b;
//        b = a % b;
//        a = temp;
//    }
//    return a;
//}
//
//int* replaceNonCoprimes(int* nums, int numsSize, int* returnSize)
//{
//    int* stack = (int*)malloc(numsSize * sizeof(int));
//    int stackSize = 0;
//
//    for (int i = 0; i < numsSize; ++i)
//    {
//        int n = nums[i];
//
//        while (stackSize > 0)
//        {
//            int a = stack[stackSize - 1];
//            int b = gcd(a, n);
//
//            if (b == 1)
//            {
//                break;
//            }
//
//            n = n * (a / b);
//            stackSize--;
//        }
//
//        stack[stackSize++] = n;
//    }
//
//    *returnSize = stackSize;
//    stack = (int*)realloc(stack, stackSize * sizeof(int));
//
//    return stack;
//}

#pragma GCC optimize("O3, unroll-loops")
static inline int gcd(int x, int y)
{
    int bz = fmin(__builtin_ctz(x), __builtin_ctz(y));
    if (bz > 0)
    {
        return gcd(x >> bz, y >> bz) << bz;
    }
    int r = x % y;
    return r ? gcd(y, r) : y;
}

static int* replaceNonCoprimes(int* nums, int n, int* returnSize)
{
    int a = -1;
    for(int i = 0; i < n; i++)
    {
        int b = nums[i];
        while(a != -1)
        {
            int g = gcd(nums[a], b);
            if (g == 1)
            {
                break;
            }
            b *= nums[a] / g;
            a--;
        }
        nums[++a] = b;
    }
    *returnSize = a + 1;
    return nums;
}