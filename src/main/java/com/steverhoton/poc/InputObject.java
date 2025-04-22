package com.steverhoton.poc;

/**
 * Represents the input data structure for Lambda functions.
 * This class serves as the request model for the Lambda handlers.
 * 
 * <p>Contains fields for name and greeting that will be used to generate
 * a personalized greeting message.</p>
 */
public class InputObject {

    /**
     * The name of the person to greet.
     */
    private String name;
    
    /**
     * The greeting to use (e.g., "Hello", "Hi").
     */
    private String greeting;

    /**
     * Gets the name of the person to greet.
     * 
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person to greet.
     * 
     * @param name The name to set
     * @return This InputObject instance for method chaining
     */
    public InputObject setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets the greeting to use.
     * 
     * @return The greeting
     */
    public String getGreeting() {
        return greeting;
    }

    /**
     * Sets the greeting to use.
     * 
     * @param greeting The greeting to set
     * @return This InputObject instance for method chaining
     */
    public InputObject setGreeting(String greeting) {
        this.greeting = greeting;
        return this;
    }
}
