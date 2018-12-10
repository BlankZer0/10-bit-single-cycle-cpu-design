package com.assembler.tenbit;

final class OpCodes
{
    // RA-Type Defined
    private static final String AND  = "0000";
    private static final String OR   = "0001";
    private static final String ADD  = "0010";
    private static final String MOV  = "0011";
    private static final String NOR  = "0100";
    private static final String IN   = "0101";
    private static final String SUB  = "0110";
    private static final String OUT  = "0111";


    // IB-Type Defined
    private static final String ADDI = "1000";
    private static final String STA  = "1001";
    private static final String LDA  = "1010";
    private static final String MOVI = "1011";
    private static final String JEQ  = "1100";
    private static final String JNE  = "1101";
    private static final String JLT  = "1110";


    // J-Type Defined
    private static final String JMP  = "1111";

    private String opCode;
    private char type;

    OpCodes(String opCode)
    {
        // Check for RA-Type (10 operations)
        if (opCode.equals("and"))
        {
            this.opCode = AND;
            this.type = 'R';
        }
        else if (opCode.equals("or"))
        {
            this.opCode = OR;
            this.type = 'R';
        }
        else if (opCode.equals("add"))
        {
            this.opCode = ADD;
            this.type = 'R';
        }
        else if (opCode.equals("mov"))
        {
            this.opCode = MOV;
            this.type = 'R';
        }
        else if (opCode.equals("nor"))
        {
            this.opCode = NOR;
            this.type = 'R';
        }
        else if (opCode.equals("in"))
        {
            this.opCode = IN;
            this.type = 'R';
        }
        else if (opCode.equals("sub"))
        {
            this.opCode = SUB;
            this.type = 'R';
        }
        else if (opCode.equals("out"))
        {
            this.opCode = OUT;
            this.type = 'R';
        }


        //Check for IB-Type (5 operations)
        else if (opCode.equals("addi"))
        {
            this.opCode = ADDI;
            this.type = 'I';
        }
        else if (opCode.equals("sta"))
        {
            this.opCode = STA;
            this.type = 'I';
        }
        else if (opCode.equals("lda"))
        {
            this.opCode = LDA;
            this.type = 'I';
        }
        else if (opCode.equals("movi"))
        {
            this.opCode = MOVI;
            this.type = 'I';
        }
        else if (opCode.equals("jeq"))
        {
            this.opCode = JEQ;
            this.type = 'I';
        }
        else if (opCode.equals("jne"))
        {
            this.opCode = JNE;
            this.type = 'I';
        }
        else if (opCode.equals("jlt"))
        {
            this.opCode = JLT;
            this.type = 'I';
        }


        // Check for J-Type (1 operation)
        else if (opCode.equals("jmp"))
        {
            this.opCode = JMP;
            this.type = 'J';
        }

        else
        {
            this.opCode = "invalid";
        }
    }

    String getOpCode()
    {
        return opCode;
    }

    char getType()
    {
        return type;
    }
}
