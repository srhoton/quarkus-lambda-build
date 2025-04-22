package com.steverhoton.poc;

import jakarta.inject.Named;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

/**
 * A stream-based AWS Lambda handler that processes raw input/output streams.
 * This handler demonstrates working with binary data in Lambda functions.
 * 
 * <p>This implementation converts all incoming text to uppercase and writes
 * it directly to the output stream, demonstrating low-level stream processing.</p>
 */
@Named("stream")
public class StreamLambda implements RequestStreamHandler {

    /**
     * Handles the Lambda function request using streams.
     * 
     * @param inputStream The raw input stream from the Lambda invocation
     * @param outputStream The output stream to write the response
     * @param context The Lambda execution context
     * @throws IOException If an I/O error occurs during stream processing
     */
    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        int letter;
        while ((letter = inputStream.read()) != -1) {
            int character = Character.toUpperCase(letter);
            outputStream.write(character);
        }
    }
}
