#Youssef Boujebha
#CSC 35 Lab 8
#Linux/Unix kernal calls
#12/7/2023

.intel_syntax noprefix
.data

Hello:
	.ascii "Hello World\n"
Winter:
	.ascii "Hangout with friends and practice coding\n"
Class:
	.ascii "Game Design\n"
Name:
	.byte 89	#Y
	.byte 111	#o
	.byte 117	#u
	.byte 115	#s
	.byte 115	#s
	.byte 101	#e
	.byte 102	#f
	.byte 10	#/n

.text	
.global _start
_start:

#Start of printing Hello World
	mov rax, 1	#1 = write
	mov rdi, 1	#to screen
	
	lea rsi, Hello
	mov rdx, 12
	syscall

#Start of printing winter plans
	mov rax, 1
	mov rdi, 1
	
	lea rsi, Winter
	mov rdx, 41
	syscall

#Start of printing Game Design
	mov rax, 1
	mov rdi, 1

	lea rsi, Class
	mov rdx, 12
	syscall

#Start of printing name
	mov rax, 1
	mov rdi, 1

	lea rsi, Name
	mov rdx, 8
	syscall

mov rax, 60		#60 = exit
syscall
