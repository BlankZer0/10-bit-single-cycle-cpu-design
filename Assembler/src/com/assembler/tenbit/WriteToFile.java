package com.assembler.tenbit;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

class WriteToFile
{
    WriteToFile()
    {}

    static void writeToStream(ArrayList<String> output, String filePath) throws IOException
    {
        File outputFile = new File(filePath);
        Writer writer = null;

        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            writer = bufferedWriter;

            for (String s : output)
            {
                writer.write(s + System.getProperty("line.separator"));
            }
        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        finally
        {
            try
            {
                writer.close();
            }
            catch (NullPointerException e)
            {
                e.printStackTrace();
            }
        }
    }
}
