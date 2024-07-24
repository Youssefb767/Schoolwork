#Youssef Boujebha
#Lab 6
#High or Low

.intel_syntax noprefix
.data

Greetings:		#The greeting prompt
	.ascii "Greetings Ravenclaw Student!\n"
	.ascii "Before you may proceed... within 1 and 100, a number I need.\n\0"

Guess:			#Asks for a guess
	.ascii "Guess: \0"

High:			#Guess was too high
	.ascii "\nAlas, that was too large\n\0"

Low:			#Guess was too low
	.ascii "\nRegrettably, that was too small\n\0"

Correct:		#Guess was correct
	.ascii "\nThat was correct! Well done!\n\0"

.text
.global _start
_start:
	 mov rdx,101 
	 call Random		#Generates the random number
	 mov rcx,rdx		#Stores the number in rcx

	 lea rdx, Greetings	#Starts the program
	 call PrintZString

Compare:
	lea rdx, Guess		#Asks for the guess
	call PrintZString
	call ScanInt
	mov rsi,rdx		#Stores the guess

	cmp rsi,rcx		#Compares the two numbers
	jl Lesser
	je Equal
	jg Higher 

Lesser:				#If it's too low
	lea rdx, Low
	call PrintZString
	
	jmp Compare		#Jumps back so you can guess again

Higher:				#If it's too high
	lea rdx, High
	call PrintZString

	jmp Compare	

Equal:				#If it's the right number
	lea rdx, Correct
	call PrintZString

End:
 	call Exit
