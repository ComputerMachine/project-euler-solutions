from itertools import count


def d(n):
	return sum(x for x in range(1, n) if n % x == 0)

amicables = []
addpair = lambda a, b: amicables.extend([a, b])

for n in count(1):
    a = d(n)
    b = d(a)
    if b == n:
        if a in amicables or b in amicables:
            continue
        if a != b:
            addpair(a, b)
    try:
        if max(amicables) >= 10000:
            break
    except ValueError:
        # amicables is empty
        pass

while 1:
    m = max(amicables)
    if m >= 10000:
        amicables.remove(m)
    else:
        break

print (sum(amicables))