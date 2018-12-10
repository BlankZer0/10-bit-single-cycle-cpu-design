package com.assembler.tenbit;

class ConvertToBin
{
    /**
     * Constructor with empty parameters
     */
    ConvertToBin()
    {
    }

    /**
     * Method used for turning the assembly instruction into binary
     */
    String getBinary(String assemblyInstruction)
    {
        StringBuilder output = new StringBuilder();

        String opCode;
        String trailingOperands;
        String firstOperand;
        String secondOperand;

        // Spit the instruction string into opcode and operands
        // parts will be an array of Strings with the length of 2
        String[] parts = assemblyInstruction.split(" ", 2);

        // get the opcode and covert it into lowercase after trimming extra spaces
        opCode = parts[0];
        opCode = opCode.trim();
        opCode = opCode.toLowerCase();

        // get the operands and covert it into lowercase after trimming extra spaces
        trailingOperands = parts[1];
        trailingOperands = trailingOperands.trim();
        trailingOperands = trailingOperands.toLowerCase();

        // Create an instance of Opcodes
        OpCodes opCodes = new OpCodes(opCode);

        // Check the opCode
        if (opCodes.getOpCode().equals("invalid"))
            return "invalid";
        else
            output.append(opCodes.getOpCode());


        //Splits the trailing Content
        parts = trailingOperands.split(",", 2);

        // Get the first operand and covert it into lowercase after trimming extra spaces
        firstOperand = parts[0];
        firstOperand = firstOperand.toLowerCase();
        firstOperand = firstOperand.trim();

        // Perform this for RA-Type Operations
        if (opCodes.getType() == 'R')
        {
            // Create an instance of operands
            Operands operands = new Operands(firstOperand);

            // Check the first operand
            if (operands.getOperand().equals("invalid"))
                return "invalid";
            else
                output.append(operands.getOperand());

            // Check for the existence of a second operand
            if (parts.length > 1)
            {
                // Get the second operand and covert it into lowercase after trimming extra spaces
                secondOperand = parts[1];
                secondOperand = secondOperand.toLowerCase();
                secondOperand = secondOperand.trim();

                operands = new Operands(secondOperand);

                // Check the second operand
                if (operands.getOperand().equals("invalid"))
                    return "invalid";
                else
                    output.append(operands.getOperand());
            }

            // If the operation is a single operand RA-Type
            else
            {
                secondOperand = "$io";

                operands = new Operands(secondOperand);
                output.append(operands.getOperand());
            }
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

            if (parts.length < 2)
                return "invalid";
            // Get the second operand and covert it into lowercase after trimming extra spaces
            secondOperand = parts[1];
            secondOperand = secondOperand.toLowerCase();
            secondOperand = secondOperand.trim();


            // Check if the second operand starts with the constant sign (#)
            if (secondOperand.charAt(0) != '#')
                return "invalid";

            // discard the hash sign from the operand
            else
                secondOperand = secondOperand.substring(1);

            // Convert the string into an integer to check
            int immediate = Integer.parseInt(secondOperand);

            // Check if the immediate value is within the range
            if (immediate < 0 || immediate > 7)
                return "invalid";

            else
            {
                //  Convert the integer into binary
                String binString = Integer.toBinaryString(immediate);

                // If the binary number is less than three bits long place a zero before the number
                while (binString.length() <3)
                    binString = "0".concat(binString);

                output.append(binString);
            }
        }

        // Perform this for J-Type Operations
        if (opCodes.getType() == 'J')
        {
            // Check if the second operand starts with the constant sign (#)
            if (firstOperand.charAt(0) != '#')
                return "invalid";

            // discard the hash sign from the operand and get the first operand
            else
                firstOperand = firstOperand.substring(1);

            // Convert the string into an integer to check
            int immediate = Integer.parseInt(firstOperand);

            // Check if the immediate value is within the range
            if (immediate < 0 || immediate > 63)
                return "invalid";
            else
            {
                //  Convert the integer into binary
                String binString = Integer.toBinaryString(immediate);

                // If the binary number is less than six bits long place a zero before the number
                while (binString.length() <6)
                    binString = "0".concat(binString);

                output.append(binString);
            }
        }

        return output.toString();
    }
}
