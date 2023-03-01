package cpu.instr;

import cpu.CPU_State;
import cpu.alu.ALU;
import cpu.mmu.MMU;

public class Add implements Instruction {

    private final MMU mmu = MMU.getMMU();
    private final ALU alu=new ALU();
    private int len = 0;
    private String instr;
  public  int exec(int opcode){
        if(opcode==0x05){
            len = 1 + 4;
            instr = String.valueOf(mmu.read(CPU_State.cs.read() + CPU_State.eip.read(), len));
            String offset = MMU.ToBitStream(instr.substring(1, 5));
            String dest=String.valueOf(CPU_State.eax.read());
            dest=alu.adder(dest,offset,'0',32);
            CPU_State.eax.write(dest);
        }

        return len;
    }
}
