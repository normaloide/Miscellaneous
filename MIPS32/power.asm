	.data
str1:	.asciiz "\nGive me the base:\n"
        .align 2
str2:	.asciiz "\nGive me the power:\n"
        .align 2

base:	.word
	
	.text
main:	
	# print_string for str1
	la $a0, str1
	li $v0, 4
	syscall
	
	# read_int for $t1, move it to $t1 and store it to base
	li $v0, 5
	syscall
	
	move $t1, $v0
	sw $t1, base
	
	# print_string for str2
    	la $a0, str2
    	li $v0, 4
    	syscall
	
	# read_int for $t2 and move it to $t2
	li $v0, 5
	syscall
	
	move $t2, $v0
	
	# the power is a repetition of mul
	li $t0, 0
	lw $a0, base
	
	addi $t0, $t0, 1
	loop:
		mul $a0, $a0, $t1
		addi $t0, $t0, 1
		blt $t0, $t2, loop
	
	# print_int
	li $v0, 1
	syscall
	
	# exit
	li $v0, 10
	syscall
