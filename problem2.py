from itertools import takewhile


def fib_gen():
    x, y = 0, 1
    while True:
        yield x
        x, y = y, x+y
        
def fib_sum():
    return sum(
        n for n in takewhile(lambda n: n<=4000000, fib_gen()) if n % 2 == 0
    )

even_sum = fib_sum()
print (even_sum)
