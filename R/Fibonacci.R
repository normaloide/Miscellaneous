n = as.integer(readline(prompt="How many Fibonacci numbers do you want to display? "))
1476                              # already set to the max float R can show
n1 <- 1
n2 <- 1
fib <- 0
count <- 0
print(n1)
print(n2)
while(count < n - 2) {
	if(n <= 1) {
		print(n1)
	}
	
	else {
		fib = n1 + n2
		n1 = n2
		n2 = fib
		print(fib)
		count = count + 1
	}
}
