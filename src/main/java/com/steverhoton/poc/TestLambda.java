package com.steverhoton.poc;

import jakarta.inject.Inject;
import jakarta.inject.Named;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * A basic AWS Lambda handler that processes input objects and returns output objects.
 * This handler is the primary entry point for the Quarkus Lambda application.
 * 
 * <p>This implementation uses CDI for dependency injection of the processing service.</p>
 * 
 * @see ProcessingService
 * @see InputObject
 * @see OutputObject
 */
@Named("test")
public class TestLambda implements RequestHandler<InputObject, OutputObject> {

    /**
     * The service responsible for processing the input.
     */
    @Inject
    ProcessingService service;

    /**
     * Handles the Lambda function request.
     * 
     * @param input The input object containing name and greeting
     * @param context The Lambda execution context
     * @return An output object with the processing result and request ID
     */
    @Override
    public OutputObject handleRequest(InputObject input, Context context) {
        return service.process(input).setRequestId(context.getAwsRequestId());
    }
}
