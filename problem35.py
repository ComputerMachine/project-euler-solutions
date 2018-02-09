"""
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?
"""

from collections import deque
from primes import generate, check as isprime


def is_circular_prime(p):
    rotations = len(str(p))
    prime = deque(str(p))
    for x in range(rotations):
        prime_int = int("".join(prime))
        if not isprime(prime_int):
            return False
        prime.rotate(1)
    return True

primes = generate(1000000)
count = 0

for i, prime in enumerate(primes):
    if prime and is_circular_prime(i):
        count += 1
        
print (count)
