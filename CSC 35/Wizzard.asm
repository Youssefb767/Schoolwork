#Youssef Boujebha
#CSC 35 Project
#SpellSlinger

#EXTRA CREDIT THINGS:
#Input validation (+5)
#Use of color (+5)
#Ascii art x3 (+15)
#Attack can miss (+10)
#Displays the winner (+5)
#		=40pts


.intel_syntax noprefix
.data

AsciiTitle:
	.ascii " _________             .__  .__      _________.__  .__\n"
	.ascii "/   _____/_____   ____ |  | |  |    /   _____/|  | |__| ____    ____   ___________\n"
	.ascii "\\_____  \\\\____ \\_/ __ \\|  | |  |    \\_____  \\ |  | |  |/    \\  / ___\\_/ __ \\_  __ \\ \n"
	.ascii "/       \\   |_> >  ___/|  |_|  |__  /        \\|  |_|  |   |  \\/ /_/  >  ___/|  | \\/\n"
	.ascii "/_______  /   __/ \\___  >____/____/ /_______ /|____/__|___|  /\\___  / \\___  >__|\n"
	.ascii "        \\/|__|        \\/                    \\/             \\//_____/      \\/       \n\0"

Author:
	.ascii "Written by Youssef Boujebha\n\0"

AsciiWizzard:
	.ascii "    '\n"
	.ascii "∞ _/(_\n"
	.ascii "| {\\\\\n"
	.ascii "|-,  )\n"
	.ascii "|/__\\\n"
	.ascii " ^   ^\n\0 " 

AsciiWand:
	.ascii "\n            *\n"
	.ascii "       *  *\n"
	.ascii "      *  *  *\n"
	.ascii "      <>  *\n"
	.ascii "     //\n"
	.ascii "    //\n"
	.ascii "   //\n"
	.ascii "  //\n\0"

Players:
	.ascii "How many players? (2-10)\n\0" 		#Asks how many players

CurrentPlayer:
	.ascii "\nPlayer# \0"

HealthN:
	.ascii "\nHealth: \0"

Winner:
	.ascii " is the Winner!!!!\n\0"

Damage:							#Start of displaying damage
	.ascii "Your spell blasts them for: \0"

SpellFail:
	.ascii "The spell missed!\n\0"

Health:							#.quads for each potential player
	.quad 50
	.quad 50
	.quad 50
	.quad 50
	.quad 50
	.quad 50
	.quad 50
	.quad 50
	.quad 50
	.quad 50	

Target:							
	.ascii "\nYour target (starts at 0):\0"
	
Validation:						#Invalid input
	.ascii "Enter a valid input\n\0"

BattleStart:
	.ascii "Let the battle commence!\n\0"

.text
.global _start
_start:

	mov rdx, 5
	call SetForeColor

	lea rdx, AsciiTitle
	call PrintZString

	mov rdx, 9
	call SetForeColor

	lea rdx, Author
	call PrintZString

	lea rdx, AsciiWizzard
	call PrintZString

PlayersQ:					#Asks the number of players
	lea rdx, Players
	call PrintZString

	call ScanInt
	mov rsi,rdx

	cmp rsi, 2 				#Checks if the player count is valid
	jl Validation1
	cmp rsi, 10
	jg Validation1

	lea rdx, BattleStart
	call PrintZString
	
	sub rsi, 1
	mov rax, 0
	jmp BattleLoop

Validation1: 					#Jumps to this if number of players is 2>x or x>10
	lea rdx, Validation
	call PrintZString
	jmp PlayersQ	

Validation2:					#Jumps to this if the player enters an invalid input for the target
	lea rdx, Validation
	call PrintZString
	jmp TargetQ

TurnCounter:					#Resets if the player# is bigger than the player count
	cmp rax, rsi
	jl Plus				        #rsi = total players 
	je Minus

Minus:
	sub rax,rsi
	jmp BattleLoop

Plus:
	add rax, 1

BattleLoop:					#Starts the turn and the battle	
	lea rdx, AsciiWand
	call PrintZString

	lea rdx, CurrentPlayer 
	call PrintZString
		
	mov rdx, rax				#rax = current player
	call PrintInt
	
	lea rdx, HealthN
	call PrintZString
	
	movq rbx, [Health + rax * 2]		#IMPORTANT NOTE: I don't know why, but the health seems to only properly work for
	mov rdx, rbx				#player #0 and 4, and will properly change when taking damage and detecting when it runs out.
	call PrintInt

TargetQ:					#Asks who your target is
	lea rdx,Target
	call PrintZString

	call ScanInt
	mov rcx, rdx				#rcx = target
	
	cmp rcx, 0
	jl Validation2
	cmp rcx, rsi				#Checks if the target is valid
	jg Validation2

	jmp HitRoll

HitRoll:					#Rolls to see if it hits (1-6)
	mov rdx, 7
	call Random

	cmp rdx, 2				#Spells have an approximate 33% chance to fail
	jg DamageRoll

	mov rdx, 1
	call SetForeColor	
	lea rdx, SpellFail			#Shows a message in red if the spell fails			
	call PrintZString
	mov rdx, 9 
	call SetForeColor

	jmp TurnCounter

DamageRoll:					#Rolls for damage
	lea rdx, Damage
	call PrintZString	

	mov rdx, 11
	call Random
	call PrintInt

	
	sub [Health + rcx * 2], rdx		#Subtracts the damage rolled from that players health
	mov rdx, [Health + rcx * 2]

	cmp rdx, 1
	jl HealthCheck
	jmp TurnCounter

HealthCheck:					#Checks the player's health to see if they should still count
	sub rsi, 1
	cmp rsi, 1
	jg TurnCounter				#Goes back to the turn counter if there's more than one player left
	
	lea rdx, CurrentPlayer
	call PrintZString
	
	mov rdx, rax
	call PrintInt

	mov rdx, 2
	call SetForeColor
	lea rdx, Winner
	call PrintZString					#Displays a winning message and ends the program
	mov rdx, 9
	call SetForeColor
	
End:
	call Exit
