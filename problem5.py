i = 20
while 1:
    if all(i % x == 0 for x in range(1, 21)):
        break
    i += 20
print (i)