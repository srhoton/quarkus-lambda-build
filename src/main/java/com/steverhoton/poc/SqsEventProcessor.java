package com.steverhoton.poc;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;

import jakarta.inject.Named;
import java.util.Map;

/**
 * Lambda handler that processes SQS events and dumps their content to standard output.
 */
@Named("sqs-processor")
public class SqsEventProcessor implements RequestHandler<SQSEvent, Void> {

    @Override
    public Void handleRequest(SQSEvent event, Context context) {
        System.out.println("SQS Event received with " + event.getRecords().size() + " records");
        
        for (SQSMessage message : event.getRecords()) {
            System.out.println("-------- SQS Message --------");
            System.out.println("Message ID: " + message.getMessageId());
            System.out.println("Receipt Handle: " + message.getReceiptHandle());
            System.out.println("Queue Source: " + message.getEventSource() + " - " + message.getEventSourceArn());
            System.out.println("Message Body: " + message.getBody());
            
            // Print message attributes if any
            if (message.getMessageAttributes() != null && !message.getMessageAttributes().isEmpty()) {
                System.out.println("Message Attributes:");
                message.getMessageAttributes().forEach((key, attr) -> {
                    System.out.println("  " + key + ": " + attr);
                });
            }
            
            System.out.println("----------------------------");
        }
        
        return null;
    }
}
