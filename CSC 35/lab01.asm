# 2023 Lab #1
# Youssef Boujebha

.intel_syntax noprefix
.data

Greeting:
	.ascii "Hello, world!\n\0"
Name:
	.ascii "My name is Youssef Boujebha!\n\0"
Quote:
	.ascii "Be the change you want to see in the world - Ghandi \n\0"
History:
	.ascii "I was born in 2001! \n\0"

.text
.global _start

_start:
	lea rbx, Greeting
	call PrintStr
	
	lea rbx, Name
	call PrintStr
	
	lea rbx, Quote
	call PrintStr

	lea rbx, History
	call PrintStr

	call ExitProgram
