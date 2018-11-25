package com.assembler.tenbit;

class ConvertToBin
{
    ConvertToBin()
    {
    }

    String getBinary(String assemblyInstruction)
    {
        StringBuilder output = new StringBuilder();

        String opCode;
        String trailingOperands;
        String firstOperand;
        String secondOperand;

        String[] parts = assemblyInstruction.split(" ", 2);

        opCode = parts[0];
        opCode = opCode.trim();
        opCode = opCode.toLowerCase();

        trailingOperands = parts[1];
        trailingOperands = trailingOperands.trim();
        trailingOperands = trailingOperands.toLowerCase();

        OpCodes opCodes = new OpCodes(opCode);

        // Check the opCode
        if (opCodes.getOpCode().equals("invalid"))
            return "invalid";
        else
            output.append(opCodes.getOpCode());


        //Splits the trailing Content
        parts = trailingOperands.split(",", 2);
        firstOperand = parts[0];
        firstOperand = firstOperand.toLowerCase();
        firstOperand = firstOperand.trim();

        // Perform this for RM-Type Operations
        if (opCodes.getType() == 'R')
        {
            secondOperand = parts[1];
            secondOperand = secondOperand.toLowerCase();
            secondOperand = secondOperand.trim();

            Operands operands = new Operands(firstOperand);

            // Check the first operand
            if (operands.getOperand().equals("invalid"))
                return "invalid";
            else
                output.append(operands.getOperand());

            operands = new Operands(secondOperand);

            // Check the second operand
            if (operands.getOperand().equals("invalid"))
                return "invalid";
            else
                output.append(operands.getOperand());
        }

        // Perform this for IB-Type Operations
        if (opCodes.getType() == 'I')
        {
            // Check the first operand
            Operands operands = new Operands(firstOperand);

            if (operands.getOperand().equals("invalid"))
                return "invalid";
            else
                output.append(operands.getOperand());

            secondOperand = parts[1];
            secondOperand = secondOperand.toLowerCase();
            secondOperand = secondOperand.trim();


            if (secondOperand.charAt(0) != '#')
                return "invalid";

            else
                secondOperand = secondOperand.substring(1);

            int immediate = Integer.parseInt(secondOperand);

            if (immediate < 0 || immediate > 7)
                return "invalid";
            else
            {
                String binString = Integer.toBinaryString(immediate);

                while (binString.length() <3)
                    binString = "0".concat(binString);

                output.append(binString);
            }
        }

        // Perform this for JC-Type Operations
        if (opCodes.getType() == 'J')
        {
            if (firstOperand.charAt(0) != '#')
                return "invalid";

            else
                firstOperand = firstOperand.substring(1);

            int immediate = Integer.parseInt(firstOperand);

            if (immediate < 0 || immediate > 63)
                return "invalid";
            else
            {
                String binString = Integer.toBinaryString(immediate);

                while (binString.length() <6)
                    binString = "0".concat(binString);

                output.append(binString);
            }
        }

        return output.toString();
    }
}
