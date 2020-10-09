	.data
str:	.asciiz "\nGive me a number: "
	.align 2

one:	.word 1
n:	.word
res: 	.word
	
	.text
main:	
	# print_string str
	li $v0, 4
	la $a0, str
	syscall
	
	# read_int and save it to n
	li $v0, 5
	syscall
	
	move $t0, $v0
	sw $t0, n
	
	# already saves fib( 1 ) and fib( 2 )
	li $t1, 1
	li $t2, 2
	
	# if fib( 1 ) or fib( 2 ) branch to print_1
	lw $s0, n
	beq $s0, $t1, print_1
	beq $s0, $t2, print_1
	
	# execute fib( n ) = fib( n - 1 ) + fib( n - 2 )
	li $t7, 3
	li $t2, 1
	loop:
		add $t3, $t1, $t2
		
		move $t1, $t2
		move $t2, $t3
		
		addi $t7, $t7, 1
		ble $t7, $s0, loop
	
	sw $t3, res
	j print_2
	
print_1:
	li $v0, 1
	lw $a0, one
	syscall
	
	j end

print_2:
	li $v0, 1
	lw $a0, res
	syscall
	
	j end
	
end:	
	li $v0, 10
	syscall
	