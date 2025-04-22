package com.steverhoton.poc;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class SqsEventProcessorTest {

  private SqsEventProcessor processor;
  private Context context;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    processor = new SqsEventProcessor();
    context = Mockito.mock(Context.class);

    // Capture System.out for testing
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  public void testHandleRequest() {
    // Create test SQS event
    SQSEvent event = new SQSEvent();
    SQSMessage message = new SQSMessage();
    message.setMessageId("test-message-id");
    message.setReceiptHandle("test-receipt-handle");
    message.setBody("This is a test message body");
    message.setEventSource("aws:sqs");
    message.setEventSourceArn("arn:aws:sqs:us-east-1:123456789012:test-queue");

    event.setRecords(Collections.singletonList(message));

    // Process the event
    processor.handleRequest(event, context);

    // Verify output contains expected content
    String output = outputStreamCaptor.toString();
    assertTrue(output.contains("SQS Event received with 1 records"));
    assertTrue(output.contains("Message ID: test-message-id"));
    assertTrue(output.contains("Receipt Handle: test-receipt-handle"));
    assertTrue(output.contains("Message Body: This is a test message body"));
  }
}
