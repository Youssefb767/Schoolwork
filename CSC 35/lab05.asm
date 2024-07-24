#Youssef Boujebha
#Lab 5, 10/26/2023

.intel_syntax noprefix
.data

Q1:
	.ascii "Did you brush your teeth this morning? (1 = yes, 2 = no)\n\0"
Q2:
	.ascii "Did you cheat on your exam? (1 = yes, 2 = no)\n\0"
Q3:
	.ascii "Did you say a bad word? (1 = yes, 2 = no)\n\0"
Q4:
	.ascii "Did you get in a fight? (1 = yes, 2 = no)\n\0"
Q5:
	.ascii "Did you help an elderly person cross the street? (1 = yes, 2 = no)\n\0"

NicePoints:
	.ascii "You have \0"
NaughtyPoints:
	.ascii " nice points and \0"
PointEnd:
	.ascii " naughty points!\n\0"

GoodResult:
	.ascii "Congratulations! You did very well!\n\0"
BadResult:
	.ascii "Ok. Go to your room NOW and think about what you did!\n\0"

.text
.global _start
_start:	

	lea rbx, Q1	#rbx is the default
	call PrintStr
	call ScanDec

	cmp rbx, 1	#jump if it's bad
	jg Bad1
	add rax, 15	#rax = good, rsi = bad

Prompt2:
	lea rbx, Q2
	call PrintStr
	call ScanDec

	cmp rbx, 2	#1 = bad
	jl Bad2
	add rax, 15	#15 for good, 10 for bad

Prompt3:
	lea rbx, Q3
	call PrintStr
	call ScanDec

	cmp rbx, 2	#1 = bad
	jl Bad3
	add rax, 15

Prompt4:
	lea rbx, Q4
	call PrintStr
	call ScanDec

	cmp rbx, 2	#1 = bad
	jl Bad4
	add rax, 15

Prompt5:
	lea rbx, Q5
	call PrintStr
	call ScanDec

	cmp rbx, 1	#2 = bad
	jg Bad5
	add rax, 15

Tally:		#Last bit of text that shows how many good/bad points you have
	lea rbx, NicePoints
	call PrintStr
	mov rbx, rax
	call PrintDec

	lea rbx, NaughtyPoints
	call PrintStr

	mov rbx, rsi
	call PrintDec

	cmp rax, rsi
	jg BadEnd
	jl GoodEnd

Bad1:	#Adding the bad points for each prompt
	add rsi, 10
	jmp Prompt2
Bad2:
	add rsi, 10
	jmp Prompt3
Bad3:
	add rsi, 10
	jmp Prompt4
Bad4:
	add rsi, 10
	jmp Prompt5

Bad5:
	add rsi, 10
	jmp Tally


GoodEnd:	#What displays if good points > bad points
	lea rbx, GoodResult
	call PrintStr
	jmp Exit
BadEnd:		#Bad points > good
	lea rbx, BadResult
	call PrintStr
Exit:
	call Exit
