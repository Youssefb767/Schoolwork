.intel_Syntax noprefix
.data

Name:
.ascii "Ash's Vending Machine\n\0"

Cheetos:
.ascii "1. Cheetos(70 cents)\n\0"

Aquafina:
.ascii "2. Aquafina(50 cents)\n\0"

Lays:
.ascii "3. Lays (60 cents)\n\0"

Mars:
.ascii "4. Mars(90 cents)\n\0"

Items:
	.quad Cheetos
	.quad Aquafina
	.quad Lays
	.quad Mars

Costs:
	.quad 70
	.quad 50
	.quad 60
	.quad 90

Money:
	.ascii "\nEnter money:\n\0"

MoneyE:
	.quad 0

Select:
	.ascii "your selection:\n\0"

Choice:
	.quad 0

newLine:
	.ascii "\n\0"

Final:
	.ascii "Your change(in cents) is \0"

.text
.global _start
_start:

mov $Name,%rcx
	call PrintCString
	mov $0,%rdi

	mov Items,(%rdi,8), %rcx
	call PrintCString

	mov $1,%rdi
	mov Items,(%rdi,8), %rcx
	call PrintCString

	mov $2,%rdi
	mov Items,(%rdi,8), %rcx
	call PrintCString

	mov $3,%rdi
	mov Items,(%rdi,8), %rcx
	call PrintCString

	mov $Money,%rcx
	call PrintCString
	call ScanInt
	mov %rcx,MoneyE

	mov $Select,%rcx
	call PrintCString
	call ScanInt
	mov %rcx,Choice

	mov $newLine,%rcx
	call PrintCString

	mov Choice,%rdi
	sub $1,%rdi
	mov Items,(%rdi,8), %rcx
	call PrintCString

	mov $Final,%rcx
	call PrintCString

	mov Costs,(%rdi,8), %rcx
	sub MoneyE,%rcx
	call PrintInt

	mov $newLine,%rcx
	call PrintCString

	call exit
