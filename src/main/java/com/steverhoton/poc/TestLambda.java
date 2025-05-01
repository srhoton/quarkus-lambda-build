package com.steverhoton.poc;

import jakarta.inject.Named;

/**
 * A basic AWS Lambda handler that processes input objects and returns output objects. This handler
 * is the primary entry point for the Quarkus Lambda application.
 *
 * <p>This implementation extends the AbstractLambdaHandler to leverage common Lambda processing
 * logic.
 *
 * @see AbstractLambdaHandler
 * @see ProcessingService
 * @see InputObject
 * @see OutputObject
 */
@Named("test")
public class TestLambda extends AbstractLambdaHandler {

  /**
   * Processes the input object by delegating to the injected service.
   *
   * @param input The input object containing name and greeting
   * @return An output object with the processing result
   */
  @Override
  protected OutputObject processInput(InputObject input) {
    return service.process(input);
  }
}
