package com.steverhoton.poc;

/**
 * Represents the output data structure returned by Lambda functions.
 * This class serves as the response model for the Lambda handlers.
 * 
 * <p>Contains fields for the processing result and AWS request ID to provide
 * both business data and request tracing information.</p>
 */
public class OutputObject {

    /**
     * The result of processing the input.
     */
    private String result;

    /**
     * The AWS request ID for tracing and debugging.
     */
    private String requestId;

    /**
     * Gets the processing result.
     * 
     * @return The result string
     */
    public String getResult() {
        return result;
    }

    /**
     * Gets the AWS request ID.
     * 
     * @return The request ID
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the processing result.
     * 
     * @param result The result to set
     * @return This OutputObject instance for method chaining
     */
    public OutputObject setResult(String result) {
        this.result = result;
        return this;
    }

    /**
     * Sets the AWS request ID.
     * 
     * @param requestId The request ID to set
     * @return This OutputObject instance for method chaining
     */
    public OutputObject setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
}
