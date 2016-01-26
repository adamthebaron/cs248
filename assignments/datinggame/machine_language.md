#Machine Language
In modern computing, programs/data are stored internally (99% of the
time by a device "recognized" by the computer itself).
This spawns the idea of the "fetch execute cycle" which is tailored
for machines of this type (Von Neumann?)
The cycle is as follows:
 1. Get the next instruction from memory
 2. decode the instruction
 3. execute instruction
 4. Possibly store answer
The CPU does this billions of times a second (more or less too 
quickly to comprehend, but it makes sense)
##Pipelining
Pipelining is a technology that allows the CPU to work on multiple
instructions at any given time (Each instruction per step).
##Instruction
In general, every single instruction has two components, the opcode
and the operand:
 - Opcode: Special keyword recognized by the machine language to perform
   an operation
 - Operand: Data/register which will be changed by the opcode (operation)
There are 3 types of instructions (generally speaking):
 1. Instructions that perform arithmetic and logic
 2. Move data to different locations
 3. Conditional statement (called control in class)
This architecture is implemented by RISC based instruction sets
RISC: Reduced Instruction Set Computing
