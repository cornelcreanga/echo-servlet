package com.unitedinternet.recruit.echo.util;

import java.io.IOException;
import java.io.Reader;

/**
 * Utility class, contains a bunch I/O related methods
 */
public class IOUtil {

    /**
     * Reads stringSize chars from a Reader. If less characters are found throws IOException
     * @param reader cannot be null
     * @param stringSize greater than zero
     * @return a string
     * @throws IOException
     */
    public static String read(Reader reader, int stringSize) throws IOException {
        if (reader==null)
            throw new IllegalArgumentException("null reader");
        if (stringSize<0)
            throw new IllegalArgumentException("invalid size, should be a positive number");
        char[] c = new char[stringSize];
        int i = reader.read(c);
        if (i != stringSize)
            throw new IOException("cannot read:" + stringSize + " characters");
        return new String(c);
    }

}
