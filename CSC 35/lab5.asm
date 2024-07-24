#Youssef Boujebha
#lab 5, section 8
#Sorting hat
#Nested if loops

.intel_syntax noprefix
.data


Welcome:
	.ascii "Welcome to Hogwarts!\nThe Sorting Hat is being placed upon your head. \n\0"

Power:
	.ascii "Do you seek power? (y/n)\n\0"

Intellectual:
	.ascii "Do you strive for knowlegdge in and of itself? (y/n)\n\0"

Selfish:
	.ascii "Is it better to help yourself more than others? (y/n)\n\0"

Hufflepuff:
	.ascii "Hufflepuff!\0"

Gryffindor:
	.ascii "Griffindor!\0"

Slytherin:
	.ascii "Slytherin!\0"

Ravenclaw:
	.ascii "Ravenclaw!\0"

 
.text
.global _start
 _start:

 lea rdx, Welcome
 call PrintZString

 lea rdx, Power
 call PrintZString

 call ScanChar
 cmp DL, 121  		#121 = y
 je SelfishQ		#Jumps to selfish if yes
 jmp IntellectualQ	#Jumps to intellectual if no

IntellectualQ:		#Yes for Ravenclaw, no for Hufflepuff
 lea rdx, Intellectual
 call PrintZString
 
 call ScanChar
 cmp DL, 121		
 je  RavenclawQ
 jmp HufflepuffQ

SelfishQ:		#Yes for Slytherin, no for Griffindor
 lea rdx, Selfish
 call PrintZString

 call ScanChar
 cmp DL, 121
 je SlytherinQ
 jmp GryffindorQ


RavenclawQ:		#If the end result is Ravenclaw
 lea rdx, Ravenclaw
 call PrintZString 
 jmp End

HufflepuffQ:		#If the end result is Hufflepuff
 lea rdx, Hufflepuff
 call PrintZString
 jmp End

SlytherinQ:		#If the end result is Slytherin
 lea rdx, Slytherin
 call PrintZString
 jmp End

GryffindorQ:		#If the end result is Gryffindor
 lea rdx, Gryffindor
 call PrintZString
 jmp End

End: 			#A label that can be jumped to to end the program
 call Exit

