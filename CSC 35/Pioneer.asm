#Youssef Boujebha
#CSC 35 Fall Project
#Oregon trail
#12/8/2023
#Keep track of 6 running totals

#EXTRA CREDIT: Bound the Percentages - 5pts
#	       Color - 5pts
#              4 random events - 20pts
#	       2 pieces of ascii art - 10pts
#Total = 40pts	
.intel_syntax noprefix
.data

Title:
	.ascii "\n"
	.ascii " _______ _________ _______  _        _______  _______  _______ \n"
	.ascii "(  ____ )\\__   __/(  ___  )( (    /|(  ____ \\(  ____ \\(  ____ )\n"
	.ascii "| (    )|   ) (   | (   ) ||  \\  ( || (    \\/| (    \\/| (    )|\n"
	.ascii "| (____)|   | |   | |   | ||   \\ | || (__    | (__    | (____)|\n"
	.ascii "|  _____)   | |   | |   | || (\\ \\) ||  __)   |  __)   |     __)\n"
	.ascii "| (         | |   | |   | || | \\   || (      | (      | (\\ (   \n"
	.ascii "| )      ___) (___| (___) || )  \\  || (____/\\| (____/\\| ) \\ \\__\n"
	.ascii "|/       \\_______/(_______)|/    )_)(_______/(_______/|/   \\__/\n"
	.ascii "                                                               \n"
	.ascii "\n\0"	
Credits:
	.ascii "A small game by Youssef Boujebha\n\0"

Rules1:
	.ascii "\nRules:\n\0"
Rules2:
	.ascii "* You have to travel 1000 miles in 30 days\n\0"
Rules3:
	.ascii "* Your Resources:\n\0"
HorseRule:
	.ascii "	* If your horse's endurance reaches 0 it'll get too tired and will have to rest for a day.\n\0"
FoodUse:
	.ascii "	* You will eat 1-2 pounds of food per day, your horse will graze at it goes.\n\0"
HealthRule:
	.ascii "	* Your health will drop 5-10% each day, and 10-20% if you are starving.\n\0"
ChoiceRule:
	.ascii "* Your Choices:\n\0"
RestRule:
	.ascii "	1. Rest: This increases your horse's endurance by 10-50% and your health by 30-60%.\n\0"
RestRule2:
	.ascii "	   This delays you for 1-2 days.\n\0"
FoodRule:
	.ascii "	2. Find food: You can find 7-8  pounds of food per day. This takes an extra day.\n\0"
TravelRule:
	.ascii "	3. Keep Traveling: You can travel 50-70 miles per day, but your Horse's endurance drops by 10-20%.\n\0"
LoseRule:
	.ascii "*You lose if time runs out or your health drops to 0%\n\0"

DistanceLeft:
	.ascii "\nDistanceLeft	    :\0"
EnduranceLeft:
	.ascii "\nHorse Endurance     :\0"
HealthLeft:
	.ascii "Your Health         :\0"
FoodLeft:
	.ascii "Food Left	    :\0"
Percent:
	.ascii "%\n\0"
Pounds:
	.ascii " pounds\n\0"

Choices:
	.ascii "Do you want to 1. Rest, 2. Find food, or 3. Keep traveling?\n\0"
AdvanceMiles:
	.ascii "You advanced: \0"
AdvanceMiles2:
	.ascii " miles.\n\0"
EnduranceCost:
	.ascii "But, it cost your horse \0"
EnduranceCost2:
	.ascii " Endurance.\n\0"
EnduranceGain:
	.ascii "Your horse gained \0"
EnduranceGain2:
	.ascii " endurance\n\0"
HealthGain:
	.ascii "You gained \0"
HealthGain2:
	.ascii " health\n\0"
JourneyDay:
	.ascii "\nJOURNEY DAY \0"
FoodCost:
	.ascii "\nYou ate \0"
FoodCost2:
	.ascii " pounds of food.\n\0"
HealthCost:
	.ascii "You lost: \0"
HealthCost2:
	.ascii " health\n\0"
FoodGain1:
	.ascii "You gathered \0"
FoodGain2:
	.ascii " pounds of food\n\0"

TiredText:
	.ascii "Your horse is too tired to run!\n\0"
StarvingText:
	.ascii "\nYOU ARE STARVING! You lost \0"
StarvingText2:
	.ascii " health.\n\0"
DayCost:
	.ascii "But, it took you \0"
DayCost2:
	.ascii " extra day(s)\n\0"
WinText:
	.ascii "\nYou made it!!!! CONGRATULATIONS!!\n\0"
LoseText:
	.ascii "\nLooks like your journey ends here...\n\0"

RestArt:
	.ascii "           (                 ,&&&.\n"
	.ascii "            )                .,.&&\n"
	.ascii "           (  (              \=__/\n"
	.ascii "               )             ,'-'.\n"
	.ascii "         (    (  ,,      _.__|/ /|\n"
	.ascii "          ) /\ -((------((_|___/ |\n"
	.ascii "        (  // | (`'      ((  `'--|\n"
	.ascii "      _ -.;_/ \\--._      \\ \-._/.\n"
	.ascii "     (_;-// | \ \-'.\    <_,\_\`--'|\n"
	.ascii "     ( `.__ _  ___,')      <_,-'__,'\n"
	.ascii "      `'(_ )_)(_)_)'\n\0"

StarvingEventText:
	.ascii "\nYou run into a fellow traveler. 'Garsh, you look real hungry!'\n"
	.ascii "'Here's some food to hold you over till your next meal!'\n\0"
TravelEventText:
	.ascii "\nYou run into a fellow traveler. 'Looks like your map is outdated!'\n"
	.ascii "'I know a route that'll get you there a lot faster!', he says.\n\0"
TiredEventText:
	.ascii "\nYour horse barely finishes the next leg of your journey. Looks like he needs some rest!\n\0"
FoodEventText:
	.ascii "\nYou weren't able to find anything to eat.\n\0"

.text
.global _start
_start:
	mov rax, 1000		#rax = distance left
	mov rcx, 100		#rcx = health left
	mov rsi, 100		#rsi = horse endurance left
	mov rdi, 10		#rdi = food left
	mov rdx, 1		#rdx = current day
	mov r8, 0		#r8 = delays

	mov rbx, 6
	call SetColorText
	lea rbx, Title
	call PrintStr
	mov rbx, 7
	call SetColorText
	lea rbx, Credits
	call PrintStr

	lea rbx, Rules1
	call PrintStr
	lea rbx, Rules2
	call PrintStr
	lea rbx, Rules3
	call PrintStr
	lea rbx, HorseRule
	call PrintStr
	lea rbx, FoodUse
	call PrintStr
	lea rbx, HealthRule
	call PrintStr

	lea rbx, ChoiceRule
	call PrintStr
	lea rbx, RestRule
	call PrintStr
	lea rbx, RestRule2
	call PrintStr
	lea rbx, FoodRule
	call PrintStr
	lea rbx, TravelRule
	call PrintStr
	lea rbx, LoseRule
	call PrintStr
		

DayStart:
	cmp rax, 1
	jl Finish
	cmp rdx, 30		#Win/lose conditions for day, distance, and health
	jg Lose
	cmp rcx, 1
	jl Lose

	cmp rsi, 0
	jl EnduranceBoundL	#Boundaries for the percentages
	cmp rsi, 100
	jg EnduranceBoundH
	cmp rdi, 0
	jl FoodBound
	cmp rcx, 100
	jg HealthBound

	lea rbx, DistanceLeft
	call PrintStr
	mov rbx, rax
	call PrintDec
	
 	lea rbx, EnduranceLeft
	call PrintStr
	mov rbx, rsi
	call PrintDec
	lea rbx, Percent
	call PrintStr
	
	lea rbx, HealthLeft
	call PrintStr

	mov rbx, 1
	call SetColorText
	mov rbx, rcx
	call PrintDec
	mov rbx, 7
	call SetColorText

	lea rbx, Percent
	call PrintStr

	lea rbx, FoodLeft
	call PrintStr
	mov rbx, rdi
	call PrintDec
	lea rbx, Pounds
	call PrintStr

ChoiceStart:
	lea rbx, Choices
	call PrintStr
	call ScanDec

	cmp rbx, 1
	jl Choices
	je Rest
	cmp rbx, 2		#Makes sure the input is valid
	je Food	
	cmp rbx, 3
	je Travel
	jg ChoiceStart

Rest:				#add 10-50 endurance (rsi), 30-60 health (rcx), 1-2 days delayed (r8)

	lea rbx, RestArt
	call PrintStr

	lea rbx, EnduranceGain
	call PrintStr
	
	mov rbx, 2
	call SetColorText
	mov rbx, 41
	call GetRandom
	add rbx, 10		#Add random endurance
	call PrintDec
	add rsi, rbx
	mov rbx, 7
	call SetColorText	

	lea rbx, EnduranceGain2
	call PrintStr

	lea rbx, HealthGain
	call PrintStr
	
	mov rbx, 2
	call SetColorText	
	mov rbx, 31
	call GetRandom
	add rbx, 30		#Add random health
	call PrintDec
	add rcx, rbx
	mov rbx, 7
	call SetColorText

	lea rbx, HealthGain2
	call PrintStr
	
	lea rbx, DayCost
	call PrintStr
	
	mov rbx, 1
	call SetColorText
	mov rbx, 2
	call GetRandom
	add rbx, 1		#Add random delay days
	call PrintDec
	add r8, rbx	
	mov rbx, 7
	call SetColorText

	lea rbx, DayCost2
	call PrintStr
	jmp TimePassing

Food:				#add 7-8 food (rdi), 1 delay (rdx)
	mov rbx, 5
	call GetRandom
	cmp rbx, 1
	je FoodEvent

	lea rbx, FoodGain1
	call PrintStr

	mov rbx, 2
	call SetColorText	
	mov rbx, 3
	call GetRandom
	add rbx, 6		#Add random food
	call PrintDec
	add rdi, rbx
	mov rbx, 7
	call SetColorText

	lea rbx, FoodGain2
	call PrintStr

	lea rbx, DayCost
	call PrintStr
	
	mov rbx, 1
	call SetColorText
	add r8, 1	
	mov rbx, 1		#Adds 1 day to the delay
	call PrintDec
	mov rbx, 7
	call SetColorText	

	lea rbx, DayCost2
	call PrintStr
	jmp TimePassing

Travel:				#subtract 70-80 miles(rax), subtract 10-20 endurance (rsi)
	cmp rsi, 1
	jl TooTired 

	mov rbx, 5
	call GetRandom
	cmp rbx, 1		#Random event can happen while traveling
	je TravelEvent

TiredEventPass:
	lea rbx, AdvanceMiles
	call PrintStr
	
	mov rbx, 2
	call SetColorText
	mov rbx, 21
	call GetRandom
	add rbx, 50		#Sub random miles
	call PrintDec
	sub rax, rbx
	mov rbx, 7
	call SetColorText

	lea rbx, AdvanceMiles2
	call PrintStr
	lea rbx, EnduranceCost
	call PrintStr
	
	mov rbx, 1
	call SetColorText
	mov rbx, 11
	call GetRandom		#Sub random endurance
	add rbx, 10
	call PrintDec
	sub rsi, rbx
	mov rbx, 7
	call SetColorText

	lea rbx, EnduranceCost2
	call PrintStr
	jmp TimePassing

TimePassing:
	add rdx, 1
	cmp rdx, 30
	jge Lose

	lea rbx, JourneyDay
	call PrintStr
	mov rbx, rdx
	call PrintDec

	cmp rdi, 1		#rdi = food left
	jl Starving
	lea rbx, FoodCost
	call PrintStr

	mov rbx, 1
	call SetColorText	
	mov rbx, 2
	call GetRandom
	add rbx, 1		#Subtracts food
	call PrintDec
	sub rdi, rbx
	mov rbx, 7
	call SetColorText

	lea rbx, FoodCost2
	call PrintStr
	
	lea rbx, HealthCost
	call PrintStr

	mov rbx, 1
	call SetColorText
	mov rbx, 6
	call GetRandom
	add rbx, 5
	call PrintDec
	sub rcx, rbx
	mov rbx, 7
	call SetColorText

	lea rbx, HealthCost2
	call PrintStr
		
	cmp r8, 0
	jg Delay
	jmp DayStart

Starving:			#sub 10-20% health (rcx)
	mov rbx, 5
	call GetRandom
	cmp rbx, 1
	je StarvingEvent	#Random event 

	lea rbx, StarvingText
	call PrintStr
	
	mov rbx, 1
	call SetColorText
	mov rbx, 11
	call GetRandom
	add rbx, 10
	call PrintDec
	sub rcx, rbx		
	mov rbx, 7
	call SetColorText

	lea rbx, StarvingText2
	call PrintStr
	jmp DayStart

TooTired:
	mov rbx, 5
	call GetRandom		#Random Event that can trigger if horse runs out of energy
	cmp rbx, 1
	je TiredEvent

	lea rbx, TiredText
	call PrintStr
	jmp TimePassing

Delay:
	sub r8, 1
	jmp TimePassing

EnduranceBoundL:
	mov rsi, 0
	jmp DayStart

EnduranceBoundH:
	mov rsi, 100
	jmp DayStart

HealthBound:
	mov rcx, 100
	jmp DayStart

FoodBound:
	mov rdi, 0
	jmp DayStart

StarvingEvent:
	lea rbx, StarvingEventText
	call PrintStr
	mov rbx, 6
	call GetRandom			#Event gives a random amount of food. Can only be triggered while starving.
	add rdi, rbx
	jmp TimePassing

TravelEvent:
	sub rax, 150
	lea rbx, TravelEventText	#Event that saves you 150 miles. Only triggered while traveling
	call PrintStr
	lea rbx, AdvanceMiles
	call PrintStr
	mov rbx, 150
	call PrintDec
	lea rbx, AdvanceMiles2
	call PrintStr
	jmp TimePassing

TiredEvent:
	lea rbx, TiredEventText
	call PrintStr			#Event that ignores the too tired to travel rule
	jmp TiredEventPass

FoodEvent:
	lea rbx, FoodEventText
	call PrintStr			#Event that can happen if you choose to find food
	jmp TimePassing

Lose:
	lea rbx, LoseText
	call PrintStr
	jmp Exit

Finish:
	lea rbx, WinText
	call PrintStr

Exit:
	call ExitProgram
