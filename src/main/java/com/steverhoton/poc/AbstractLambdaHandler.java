package com.steverhoton.poc;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import jakarta.inject.Inject;

/**
 * Abstract base class for Lambda handlers that process InputObject and return OutputObject.
 *
 * <p>This class implements common functionality shared across multiple Lambda handlers, including
 * dependency injection of the ProcessingService and request ID handling. Concrete implementations
 * only need to implement the processInput method.
 *
 * @see ProcessingService
 * @see InputObject
 * @see OutputObject
 */
public abstract class AbstractLambdaHandler implements RequestHandler<InputObject, OutputObject> {

  /** The service responsible for processing the input. */
  @Inject protected ProcessingService service;

  /**
   * Handles the Lambda function request by delegating to the processInput method and setting the
   * AWS request ID on the result.
   *
   * @param input The input object containing name and greeting
   * @param context The Lambda execution context
   * @return An output object with the processing result and request ID
   */
  @Override
  public OutputObject handleRequest(InputObject input, Context context) {
    OutputObject result = processInput(input);
    if (context != null) {
      result.setRequestId(context.getAwsRequestId());
    }
    return result;
  }

  /**
   * Process the input object and return an output object without the request ID. Implementations
   * should override this method to provide specific processing logic.
   *
   * @param input The input object to process
   * @return The processed output object
   */
  protected abstract OutputObject processInput(InputObject input);
}
