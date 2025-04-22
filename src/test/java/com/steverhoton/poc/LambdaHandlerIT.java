package com.steverhoton.poc;

import org.junit.jupiter.api.Disabled;

import io.quarkus.test.junit.QuarkusIntegrationTest;

@Disabled("Integration tests require a running Lambda environment")
@QuarkusIntegrationTest
public class LambdaHandlerIT extends LambdaHandlerTest {}
