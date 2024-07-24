# Youssef Boujebha
# Lab 7 - multiplying/ dividing
# 11/18/2023

.intel_syntax noprefix
.data

Wish1:
	.ascii "1. Finish a Homework Assignment	: 10 points\n\0"
Wish2:
	.ascii "2. New Gaming Console		: 75 points\n\0"
Wish3:
	.ascii "3. No School This Week		: 50 points\n\0"
Wish4:
	.ascii "4. Get a Free Pizza		: 20 points\n\0"

Wish1Text:
	.ascii "I'll finish this assignment in no time!\n\0"
Wish2Text:
	.ascii "I've been hoping you'd wish for one of these!\n\0"
Wish3Text:
	.ascii "Finally! Some time to relax!\n\0"
Wish4Text:
	.ascii "Mmmmm pizza!\n\0"

PointTotal1:
	.ascii "\nYou have \0"
PointTotal2:
	.ascii " wish points\n\0"
AllOut:
	.ascii "No more points left! Lets try again tomorrow!\n\0"

WishPrompt:
	.ascii "What is your wish?\n\0"
WishGranted:
	.ascii "*Poof* There you go, Timmy!\n\0"

Cost1:
	.ascii "That'll cost \0"
Cost2:
	.ascii " wish points!\n\0"

CastTimes:
	.ascii "How many times do you want to cast that?\n\0"
CastLimit1:
	.ascii "Sorry, Timmy. You can only cast that \0"
CastLimit2:
	.ascii " times\n\0"
ErrorMsg:
	.ascii "Please choose from the list! (1-4)\n\0"


.text
.global _start
_start:

mov rsi, 100				#Rsi = total points

WishOptions:
	cmp rsi, 10
	jl NoPoints			#Finishes the loop if points < 10 (Not enough for any wishes = all out)

	lea rbx, Wish1
	call PrintStr
	lea rbx, Wish2
	call PrintStr
	lea rbx, Wish3
	call PrintStr
	lea rbx, Wish4
	call PrintStr


LoopStart:
	lea rbx, PointTotal1
	call PrintStr
	mov rbx, rsi
	call PrintDec
	lea rbx, PointTotal2
	call PrintStr

SwitchStart:	 
	lea rbx, WishPrompt
	call PrintStr
	call ScanDec
	
	cmp rbx, 1		#Compares to see what wish should be jumped to
	jl ErrorCase
	je Case1
	cmp rbx, 2
	je Case2
	cmp rbx, 3
	je Case3
	cmp rbx, 4
	Je Case4
	jg ErrorCase

Do:				#The part of the program that does the actual math
	lea rbx, CastTimes
	call PrintStr
	
	mov rax, rcx		#The first operand MUST be in rax
	Call ScanDec		#Chosen number gets put into rbx
	Imul rbx		#rax(COST)*rbx(TIMES) has to <=100		
	mov rbx, rax
	cmp rbx, rsi
	jg TooHigh
	
	lea rbx, Cost1
	call PrintStr
	mov rbx, rax
	call PrintDec
	lea rbx, Cost2
	call PrintStr

	lea rbx, WishGranted
	call PrintStr

	sub rsi, rax		#Subtracts the cost of the wish from your total points	
	
	jmp WishOptions

Case1:	#Cost = 10 points
	lea rbx, Wish1Text
	call PrintStr

	lea rbx, Cost1
	call PrintStr
	mov rcx, 10		#Rcx = cost
	mov rbx, rcx
	call PrintDec
	lea rbx, Cost2
        call PrintStr

	jmp Do
	
Case2:	# Cost = 75
	lea rbx, Wish2Text
	call PrintStr

	lea rbx, Cost1
	call PrintStr
	mov rcx, 75
	mov rbx, rcx
	call PrintDec
	lea rbx, Cost2
	call PrintStr

	jmp Do

Case3:	# Cost = 50
	lea rbx, Wish3Text
	call PrintStr

	lea rbx, Cost1
	call PrintStr
	mov rcx, 50
	mov rbx, rcx
	call PrintDec
	lea rbx, Cost2
	call PrintStr

	jmp Do

Case4: #Cost = 20
	lea rbx, Wish3Text
	call PrintStr
	
	lea rbx, Cost1
	call PrintStr
	mov rcx, 20
	mov rbx, rcx
	call PrintDec
	lea rbx, Cost2
	call PrintStr

	jmp Do
	
ErrorCase:
	lea rbx, ErrorMsg
	call PrintStr
	jmp WishOptions

TooHigh:			
	lea rbx, CastLimit1
	call PrintStr
	
	mov rax, rsi 		#Divides the remaining points by the cost of the wish (points = rsi cost= rcx)
	mov rbx, rcx
	Idiv rbx		
	mov rbx, rax		#The quotient gets put into rdx, so you have to move it to rbx to print it
	call PrintDec

	lea rbx, CastLimit2
	call PrintStr
	jmp Do 

NoPoints:
	lea rbx, AllOut
	call PrintStr

Exit:
	call ExitProgram

