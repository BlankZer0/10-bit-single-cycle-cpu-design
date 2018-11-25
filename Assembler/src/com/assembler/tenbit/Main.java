package com.assembler.tenbit;

import java.io.*;
import java.util.ArrayList;
import static com.assembler.tenbit.ReadFile.*;
import static com.assembler.tenbit.WriteToFile.*;

public class Main
{
    public static void main(String[] args)
    {
        final String IN_PATH = "io//input.txt";
        final String OUT_PATH = "io//output.txt";
        final String OUT_PATH_BIN = "io//output_bin.txt";
        final String OUT_PATH_HEX = "io//output_hex.txt";

        ArrayList<String> inputInstruction = new ArrayList<>();
        ArrayList<String> binaryInstruction = new ArrayList<>();
        ArrayList<String> hexInstruction = new ArrayList<>();

        ConvertToBin convertToBin = new ConvertToBin();

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
                        String binary = convertToBin.getBinary(s);
                        int decimal = Integer.parseInt(binary, 2);
                        String hexaDecimal = Integer.toHexString(decimal).toUpperCase();

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
