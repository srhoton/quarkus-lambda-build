package com.steverhoton.poc;

import jakarta.inject.Named;

/**
 * An example Lambda handler that is not actively used in the application. This class demonstrates
 * how to structure a Lambda handler but is not intended for actual deployment.
 *
 * <p>This handler will throw an exception if invoked, serving as a placeholder or template for
 * future Lambda implementations.
 *
 * @see TestLambda For the primary Lambda implementation
 */
@Named("unused")
public class UnusedLambda extends AbstractLambdaHandler {

  /**
   * Processes the input object by throwing an exception.
   *
   * @param input The input object containing name and greeting
   * @return This method does not return normally as it throws an exception
   * @throws RuntimeException Always thrown to indicate this Lambda is not meant to be used
   */
  @Override
  protected OutputObject processInput(InputObject input) {
    throw new RuntimeException("Should be unused");
  }
}
