# lab2.asm
# Youssef Boujebha
#
# Wizarding Bank

 .intel_syntax noprefix
 .data
 
 Name: #My Name
 	.byte 'Y'
	.byte 'o'
	.byte 'u'
	.byte 's'
	.byte 's'
        .byte 'e'
        .byte 'f'
	.byte ' '

	.byte 'B'
	.byte 'o'
        .byte 'u'
        .byte 'j'
        .byte 'e'
        .byte 'b'
        .byte 'h'
        .byte 'a'
	.byte '\n'
	.byte 0

 Prompt1: #Asks for earnings
	.ascii "How much do you earn each month?\n\0"
		

 Prompt2: #Asks for expenses
	.ascii "How much do you spend on food, rent, etc...?\n\0"

 Total:
	.ascii "So, your cash flow is \n\0" 

 Earnings:
	.quad 0

 Expenses: 
	.quad 0

 .text 
 .global _start
 _start:
 	lea rdx, Name
	call PrintZString
	
	lea rdx, Prompt1
	call PrintZString

	call ScanInt
	mov Earnings, rdx

	lea rdx,  Prompt2
	call PrintZString
	
	call ScanInt
	mov Expenses, rdx

	lea rdx, Total
	call PrintZString

	sub rdx, Earnings
	call PrintInt

	call Exit





