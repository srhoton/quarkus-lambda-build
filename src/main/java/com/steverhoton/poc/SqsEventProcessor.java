package com.steverhoton.poc;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;

import jakarta.inject.Named;

/**
 * Lambda handler that processes SQS events and dumps their content to standard output. This handler
 * demonstrates integration with AWS SQS for event-driven architectures.
 *
 * <p>The processor extracts and logs details from each SQS message, including message ID, receipt
 * handle, source information, body content, and any message attributes.
 *
 * <p>This implementation extends AbstractSqsEventHandler for common SQS processing logic.
 */
@Named("sqs-processor")
public class SqsEventProcessor extends AbstractSqsEventHandler {

  /**
   * Processes a single SQS message by logging its details.
   *
   * @param message The SQS message to process
   * @param context The Lambda execution context
   */
  @Override
  protected void processMessage(SQSMessage message, Context context) {
    System.out.println("-------- SQS Message --------");
    System.out.println("Message ID: " + message.getMessageId());
    System.out.println("Receipt Handle: " + message.getReceiptHandle());
    System.out.println(
        "Queue Source: " + message.getEventSource() + " - " + message.getEventSourceArn());
    System.out.println("Message Body: " + message.getBody());

    // Print message attributes if any
    if (message.getMessageAttributes() != null && !message.getMessageAttributes().isEmpty()) {
      System.out.println("Message Attributes:");
      message
          .getMessageAttributes()
          .forEach(
              (key, attr) -> {
                System.out.println("  " + key + ": " + attr);
              });
    }

    System.out.println("----------------------------");
  }
}
