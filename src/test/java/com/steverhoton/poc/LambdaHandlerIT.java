package com.steverhoton.poc;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.junit.jupiter.api.Disabled;

@Disabled("Integration tests require a running Lambda environment")
@QuarkusIntegrationTest
public class LambdaHandlerIT extends LambdaHandlerTest {
}
