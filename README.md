# Quarkus Lambda Build

This project demonstrates a Quarkus application designed to run as an AWS Lambda function. It leverages the Quarkus Amazon Lambda extension to provide a streamlined development experience for serverless applications.

## Project Structure

The project contains several Lambda handler implementations:

- `TestLambda`: A basic Lambda handler that processes input objects
- `StreamLambda`: A Lambda handler that works with stream-based input/output
- `UnusedLambda`: An example Lambda handler (not actively used)

## Development

### Prerequisites

- JDK 1.8+
- Gradle
- AWS CLI (for deployment)

### Building the Application

```bash
./gradlew build
```

For native compilation:

```bash
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

### Testing Locally

```bash
# Test with the provided payload.json
./gradlew quarkusDev
```

## Deployment

The application can be deployed to AWS Lambda using the Quarkus Amazon Lambda extension.

```bash
# Build and deploy
./gradlew build
aws lambda create-function --function-name quarkus-lambda-build \
  --zip-file fileb://build/function.zip \
  --handler io.quarkus.amazon.lambda.runtime.QuarkusStreamHandler::handleRequest \
  --runtime java11 \
  --role arn:aws:iam::YOUR_ACCOUNT_ID:role/lambda-role
```

## Configuration

Configuration is managed through Quarkus application properties in `src/main/resources/application.properties`.

## Additional Information

For more information on Quarkus Amazon Lambda, please visit:
https://quarkus.io/guides/amazon-lambda
