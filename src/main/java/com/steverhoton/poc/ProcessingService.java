package com.steverhoton.poc;

import jakarta.enterprise.context.ApplicationScoped;

/**
 * Service responsible for processing input objects and generating output objects. This service
 * demonstrates CDI usage in a Quarkus Lambda application.
 *
 * <p>The service applies business logic to transform input data into output results, including
 * validation rules for input names.
 */
@ApplicationScoped
public class ProcessingService {

  /** Error message constant for name validation. */
  public static final String CAN_ONLY_GREET_NICKNAMES = "Can only greet nicknames";

  /**
   * Processes an input object to create an output object with a greeting message.
   *
   * @param input The input object containing name and greeting
   * @return An output object with the combined greeting result
   * @throws IllegalArgumentException If the name is "Stuart" which is not considered a nickname
   */
  public OutputObject process(InputObject input) {
    if (input.getName().equals("Stuart")) {
      throw new IllegalArgumentException(CAN_ONLY_GREET_NICKNAMES);
    }
    String result = input.getGreeting() + " " + input.getName();
    OutputObject out = new OutputObject();
    out.setResult(result);
    return out;
  }
}
