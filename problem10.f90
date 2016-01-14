logical function isprime(n) result(response)
 
    implicit none
   
    integer :: i
    integer, intent(in) :: n
    integer :: upto
   
    if (n <= 1) then
        response = .false.
        return
    end if
   
    upto = int(n**.5)
 
    do i = 3, upto, 2
        if (mod(n, i) == 0) then
            response = .false.
            return
        end if
    end do
   
    response = .true.
 
end function isprime
 
program problem10
 
    implicit none
 
    integer :: n
    logical :: isprime
    integer, parameter :: int64 = selected_int_kind(16)
    integer(kind = int64) :: total
   
    total = 2
   
    do n = 3, 2000000, 2
        if (isprime(n)) then
            total = total + n
        end if
    end do
   
    print *, total
       
end program problem10