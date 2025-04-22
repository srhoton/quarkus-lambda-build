package com.steverhoton.poc;

import jakarta.inject.Inject;
import jakarta.inject.Named;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * An example Lambda handler that is not actively used in the application.
 * This class demonstrates how to structure a Lambda handler but is not
 * intended for actual deployment.
 * 
 * <p>This handler will throw an exception if invoked, serving as a placeholder
 * or template for future Lambda implementations.</p>
 * 
 * @see TestLambda For the primary Lambda implementation
 */
@Named("unused")
public class UnusedLambda implements RequestHandler<InputObject, OutputObject> {

    /**
     * The service responsible for processing the input.
     */
    @Inject
    ProcessingService service;

    /**
     * Handles the Lambda function request by throwing an exception.
     * 
     * @param input The input object containing name and greeting
     * @param context The Lambda execution context
     * @return This method does not return normally as it throws an exception
     * @throws RuntimeException Always thrown to indicate this Lambda is not meant to be used
     */
    @Override
    public OutputObject handleRequest(InputObject input, Context context) {
        throw new RuntimeException("Should be unused");
    }
}
