package com.steverhoton.poc;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;

import jakarta.inject.Named;

/**
 * Lambda handler that processes SQS events and dumps their content to standard output. This handler
 * demonstrates integration with AWS SQS for event-driven architectures.
 *
 * <p>The processor extracts and logs details from each SQS message, including message ID, receipt
 * handle, source information, body content, and any message attributes.
 *
 * <p>This implementation is optimized for Quarkus' fast startup and low memory footprint, making it
 * suitable for serverless environments.
 */
@Named("sqs-processor")
public class SqsEventProcessor implements RequestHandler<SQSEvent, Void> {

  /**
   * Handles SQS event messages by processing and logging their contents.
   *
   * @param event The SQS event containing one or more messages
   * @param context The Lambda execution context
   * @return null as this handler doesn't produce a meaningful return value
   */
  @Override
  public Void handleRequest(SQSEvent event, Context context) {
    System.out.println("SQS Event received with " + event.getRecords().size() + " records");

    for (SQSMessage message : event.getRecords()) {
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

    return null;
  }
}
