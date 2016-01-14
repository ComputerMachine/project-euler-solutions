package main


import (
    "fmt";
    "math"
)

func sieve(limit int) []bool {
    primes := make([]bool, limit+1)    
    
    for x:=0; x<=limit; x++ {
        if x < 2 {
            primes[x] = false
        } else {
            primes[x] = true
        }
    }
    
    for i := 0; i <= int(math.Sqrt(float64(limit))); i++ {
        if primes[i] {
            for j:=i*i; j<limit; j+=i {
                primes[j] = false;
            }
        }
    }
    
    return primes;
}

func main() {
    upto := 2000000 // 2 million
    pmap := sieve(upto)
    var total uint64
    
    for i := 0; i < upto; i++ {
        if pmap[i] {
            total += uint64(i)
        }
    }
    
    fmt.Println(total);
}