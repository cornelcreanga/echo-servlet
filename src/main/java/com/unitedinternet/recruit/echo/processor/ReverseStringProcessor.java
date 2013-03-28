package com.unitedinternet.recruit.echo.processor;

/**
 * Reverts a string, for example after calling the process method "123" will be "321"
 */
public class ReverseStringProcessor implements StringProcessor {

    /**
     * Reverts a string
     * @param text cannot be null
     * @return the reverted string
     */
    @Override
    public String process(String text) {
        if (text == null)
            throw new IllegalArgumentException("null text");
        if (text.length() == 0)
            return text;
        return new StringBuilder(text).reverse().toString();
    }

}
