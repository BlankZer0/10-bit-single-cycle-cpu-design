package com.assembler.tenbit;

import java.io.*;
import java.util.ArrayList;
import static com.assembler.tenbit.ReadFile.*;
import static com.assembler.tenbit.WriteToFile.*;

public class Main
{
    public static void main(String[] args)
    {
        // Defines the text file paths
        final String IN_PATH = "io//input.txt";
        final String OUT_PATH = "io//output.txt";
        final String OUT_PATH_BIN = "io//output_bin.txt";
        final String OUT_PATH_HEX = "io//output_hex.txt";

        // Create an ArrayList for each form of the instruction
        ArrayList<String> inputInstruction = new ArrayList<>();
        ArrayList<String> binaryInstruction = new ArrayList<>();
        ArrayList<String> hexInstruction = new ArrayList<>();

        // Create an instance of ConvertToBin
        ConvertToBin convertToBin = new ConvertToBin();

        // Read from the input file
        try
        {
            inputInstruction = readFromStream(IN_PATH);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        if (inputInstruction != null)
        {
            // Check each instruction separately
            for (String s : inputInstruction)
            {
                try
                {
                    if (convertToBin.getBinary(s).equals("invalid"))
                    {
                        binaryInstruction.add("Invalid Instruction");
                        hexInstruction.add("Invalid Instruction");
                    }
                    else
                    {
                        // Get the binary form of the instruction
                        String binary = convertToBin.getBinary(s);

                        // Get the decimal form of the instruction
                        int decimal = Integer.parseInt(binary, 2);

                        // Get the hexaDecimal form of the instruction
                        String hexaDecimal = Integer.toHexString(decimal).toUpperCase();

                        // If the hexaDecimal number is less than three bits long place a zero before the number
                        while (hexaDecimal.length() < 3)
                            hexaDecimal = "0".concat(hexaDecimal);

                        binaryInstruction.add(binary);
                        hexInstruction.add(hexaDecimal);
                    }
                }
                catch (NullPointerException e)
                {
                    e.printStackTrace();
                }
            }

            // Write to the output files
            try
            {
                writeToStream(inputInstruction, OUT_PATH);
                writeToStream(binaryInstruction, OUT_PATH_BIN);
                writeToStream(hexInstruction, OUT_PATH_HEX);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
