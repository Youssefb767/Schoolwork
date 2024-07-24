#Youssef Boujebha
#Division Lab

.intel_Syntax noprefix
.data

HowMuch:
	.ascii "How many knuts was the bill?\n\0"

Split:
	.ascii "How many people are splitting the bill?\n\0"

Total:
	.ascii "Each person will be paying: \0"

Validation:
	.ascii "Can't be less than one!\n\0"


.text
.global _start
_start:

	lea rdx, HowMuch
	call PrintZString
 
	call ScanInt
	mov rcx, rdx

SplitCheck:
	lea rdx, Split
	call PrintZString
	call ScanInt

	cmp rdx, 1
	jl ValidationQ

	mov rax, rdx 
	idiv rcx
	mov rbx, rdx

	lea rdx, Total
	call PrintZString

	mov rdx, rbx
	call PrintInt
	jmp End

ValidationQ:
	lea rdx, Validation
	call PrintZString
	jmp SplitCheck

End:
	call Exit
