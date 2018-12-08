package com.assembler.tenbit;

final class Operands
{
    private static final String ZERO = "000";
    private static final String S0   = "001";
    private static final String S1   = "010";
    private static final String S2   = "011";
    private static final String T0   = "100";
    private static final String T1   = "101";
    private static final String IO   = "110";
    private static final String ACC  = "111";

    private String operand;

    Operands(String operand)
    {
        if (operand.equals("$zero"))
            this.operand = ZERO;
        else if (operand.equals("$s0"))
            this.operand = S0;
        else if (operand.equals("$s1"))
            this.operand = S1;
        else if (operand.equals("$s2"))
            this.operand = S2;
        else if (operand.equals("$t0"))
            this.operand = T0;
        else if (operand.equals("$t1"))
            this.operand = T1;
        else if (operand.equals("$io"))
            this.operand = IO;
        else if (operand.equals("$acc"))
            this.operand = ACC;

        else
            this.operand = "invalid";
    }

    String getOperand()
    {
        return operand;
    }
}
