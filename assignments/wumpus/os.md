# Operating Systems

    1. Manages resources
    2. Makes the computer "useable"
    3. Executes programs

To do these things the OS must maintain security, manage memory, and manage
CPU usage. 

## Interrupt driven

 CPUs work mostly by "interrupts" which are signals sent to the CPU by multiple
different sources (device controllers, peripherals, OS itself). When a CPU is
interrupted, it executes a context switch, in which it stores its current
state and attends to the interrupt, then returns to it's previous job. In a way
this may be difficult to comprehend, however the speed of the CPU is so fast
that context switching is naturally abstracted.
