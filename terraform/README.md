# Terraform Configuration for Quarkus Lambda Build

This directory contains Terraform configuration for the AWS infrastructure required by the Quarkus Lambda Build project.

## Resources

- **SQS Queue**: A standard queue named `quarkus-lambda-build` for message processing
- **IAM Roles**:
  - `lambda-execution-role`: Role for Lambda function execution with SQS access
  - `github-actions-role`: Role for GitHub Actions with OIDC authentication

## Setup

1. Create a `terraform.tfvars` file based on the example:

```bash
cp terraform.tfvars.example terraform.tfvars
```

2. Edit the `terraform.tfvars` file with your AWS account ID and GitHub repository name.

## Usage

Initialize the Terraform configuration:

```bash
terraform init
```

Plan the deployment:

```bash
terraform plan
```

Apply the changes:

```bash
terraform apply
```

## State Management

The Terraform state is stored in the S3 bucket `srhoton-tfstate` with the key `quarkus-lambda-build/terraform.tfstate` in the `us-east-1` region.

## Outputs

- `sqs_queue_url`: The URL of the created SQS queue
- `sqs_queue_arn`: The ARN of the created SQS queue
- `lambda_execution_role_arn`: The ARN of the Lambda execution role
