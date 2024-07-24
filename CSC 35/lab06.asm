# Youssef Boujebha
# Lab 6, Random #'s and looping
# 11/6/2023

.intel_syntax noprefix
.data

Intro:
	.ascii "*Beep* This is Madame Foster's Cookie Jar Security System.\n\0"
Intro2:
	.ascii "Please enter the correct code.\n\0"
lowText:
	.ascii "\nThe jar emits a low-pitched beep!\n\0"
highText:
	.ascii "\nThe jar emits a high-pitched beep!\n\0"
guessText:
	.ascii "Guess: \0"
correctText:
	.ascii "The Jar beeps agreeably and the lid pops open! Chocolate Chip Cookies!\n\0"

.text
.global _start
_start:

	lea rbx, Intro
	call PrintStr
	lea rbx, Intro2
	call PrintStr

	mov rbx, 101
	call GetRandom	#Generates random number 0-100
	mov rax, rbx
Guess:			#Beginning of the guess loop
	lea rbx, guessText
	call PrintStr

	call ScanDec
	cmp rbx, rax	#rbx = input, rax = correct number
	jl Low
	je Correct
	jg High
Low:
	lea rbx, lowText
	Call PrintStr
	jmp Guess

High:
	lea rbx, highText
	Call PrintStr
	jmp Guess

Correct:
	lea rbx, correctText
	call PrintStr
	
Exit:
	call ExitProgram
