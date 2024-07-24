#Youssef Boujebha
#Lab 4
#Loops

.intel_Syntax noprefix
.data

Animal:
	.ascii "Did you get an animal pet? (1=yes 2=no)\n\0"		 #10 points

House:
	.ascii "Are you afraid of what house you will be sorted into? (1=yes 2=no)\n\0"		 #10 points

Muggle:
	.ascii "Are you a muggle born? (1=yes 2=no)\n\0"	 #15 points

Wand:
	.ascii "Have you gotten your wand yet? (1=yes 2=no)\n\0" 	#15 points

Stress:
	.ascii "Your total stress level is at \0" 	#total stress level

Low:
	.ascii "\n You're gonna do fine! Keep your chin up!!\n\0"	 #less than or equal to 35 points

High: 
	.ascii "\n Oh dear! You are so stressed! Here! Have some magical calming hot cocoa!\n\0"	 #Greater than 35 points


.text
.global _start
 _start:

AnimalQ:		 #Asks whether or not they've gotten their animal
 lea rdx, Animal
 call PrintZString

 call ScanInt
 cmp rdx, 2 #Compares the answer to see if it needs to add points
 jl HouseQ #Jumps to the next question if they said yes 
 add rsi, 10 

HouseQ:			#Asks the user if they're nervous about what house they will get
 lea rdx, House
 call PrintZString

 call ScanInt
 cmp rdx, 1
 jg MuggleQ
 add rsi,10

MuggleQ: 		#Asks the user if they're muggle born
 lea rdx, Muggle
 call PrintZString

 call ScanInt
 cmp rdx, 1
 jg WandQ
 add rsi, 15

WandQ: 			#Asks the user about their wand
 lea rdx, Wand
 call PrintZString

 call ScanInt
 cmp rdx, 2
 jl StressP
 add rsi, 15

StressP: 		#The prompt to print the stress level
 lea rdx, Stress
 call PrintZString 

 mov rdx,rsi
 call PrintInt

 cmp rsi, 35
 jg HighP

 lea rdx, Low
 call PrintZString
 jmp End 		#Skips over the part that prints the high stress string

HighP:
 lea rdx, High
 call PrintZString
 
End:
 call Exit
