package com.steverhoton.poc;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;

/**
 * Abstract base class for Lambda handlers that process SQS events.
 *
 * <p>This class implements the common structure for SQS message processing, allowing subclasses to
 * focus on the specific logic for each message.
 */
public abstract class AbstractSqsEventHandler implements RequestHandler<SQSEvent, Void> {

  /**
   * Handles SQS event messages by processing each record.
   *
   * @param event The SQS event containing one or more messages
   * @param context The Lambda execution context
   * @return null as these handlers typically don't produce a return value
   */
  @Override
  public Void handleRequest(SQSEvent event, Context context) {
    logEventReceived(event);

    for (SQSMessage message : event.getRecords()) {
      processMessage(message, context);
    }

    return null;
  }

  /**
   * Logs information about the received event.
   *
   * @param event The SQS event containing messages
   */
  protected void logEventReceived(SQSEvent event) {
    System.out.println("SQS Event received with " + event.getRecords().size() + " records");
  }

  /**
   * Process a single SQS message. Subclasses should implement this method to provide specific
   * message processing logic.
   *
   * @param message The SQS message to process
   * @param context The Lambda execution context
   */
  protected abstract void processMessage(SQSMessage message, Context context);
}
