# Youssef Boujebha
# lab 2 9/30/23

.intel_syntax noprefix
.data

Title:
	.ascii "Louise Weekly Profit Calculator\n\0"
Q1:
	.ascii "How much did you get from scamming idiots?\n\0"
Q2:
	.ascii "How much did you get from extortion?\n\0"
Q3:
	.ascii "How much allowance did you get?\n\0"
Total:
	.ascii "Congrats, you earned $ \0"

.text
.global _start

_start:
	lea rbx, Title
	call PrintStr
	
	lea rbx, Q1
	call PrintStr
	call ScanDec
	Add rax, rbx

	lea rbx, Q2
	call PrintStr
	call ScanDec
	add rax, rbx

	lea rbx, Q3
	call PrintStr
	call ScanDec
	Add rax, rbx

	lea rbx, Total
	call PrintStr
	mov  rbx, rax
	call PrintDec

call ExitProgram
