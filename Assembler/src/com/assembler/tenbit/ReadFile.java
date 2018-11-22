package com.assembler.tenbit;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

class ReadFile
{
    ReadFile()
    {}

    static ArrayList<String> readFromStream(String filePath) throws IOException
    {
        ArrayList<String> output = new ArrayList<>();
        File input = new File(filePath);
        InputStream inputStream;

        try
        {
            inputStream = new FileInputStream(input);

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String line = reader.readLine();

            while (line!=null)
            {
                output.add(line);
                line = reader.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return output;
    }
}
