from itertools import count


def propdiv(n):
    return sum(x for x in range(1, n//2+1) if n % x == 0)

amicables = []

for k in count(1):
    a = propdiv(k)
    b = propdiv(a)
    if b == k:
        if b in amicables or a in amicables:
            continue
        if a != b:
            if a > 10000 or b > 10000:
                break
            print (amicables)
            amicables.extend([a, b])
            
print (sum(amicables))
