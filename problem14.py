import operator


def collatz_sequences():        
    sequence = {}
        
    def number_of_terms(n):
        total = 0
        while n != 1:
            total += 1
            if n % 2 == 0:
                n = n//2
            else:
                n = 3*n+1
            if n in sequence.keys():
                total += sequence[n]
                n = 1
        return total

    for x in range(1, 1000000):
        t = number_of_terms(x)
        sequence[x] = t

    return sequence.items()
    
print (max(collatz_sequences(), key=operator.itemgetter(1)))