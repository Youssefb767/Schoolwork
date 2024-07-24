# lab1.am
# Youssef Boujebha

.intel_syntax noprefix
.data

 Greeting:
	.ascii "Hello, world!\n\0"

 Name:
	.ascii "My name is Youssef Boujebha.\n\0"

 Quote: 
	.ascii "The only thing that makes life possible is permanent, intolerable, uncertainty: not knowing what comes next - Ursula K. Le Guin\n\0"

 Year:
	.ascii "I was born on October 2nd, 2001\n\0"

.text
.global _start

_start:
	lea rdx, Greeting
	call PrintZString

	lea rdx, Name
	call PrintZString

	lea rdx, Quote
	call PrintZString

	lea rdx, Year
	call PrintZString
	
	call Exit




