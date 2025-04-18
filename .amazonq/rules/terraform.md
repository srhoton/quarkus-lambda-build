# AI Rules for Terraform Management
## Linting Best Practices
- Use TFLint to catch errors and enforce best practices
- Implement tfsec for security-focused static analysis
- Configure pre-commit hooks to run linters automatically
- Run `terraform fmt` before committing code changes
- Ensure consistent indentation (2 spaces)
- Use snake_case for naming resources and variables
- Validate with `terraform validate` before applying changes
- Establish a .tflint.hcl configuration file for project-specific rules
- Integrate linting checks in CI/CD pipelines

## Directory Structure
- All Terraform code must be stored in the `terraform` directory at the root of the project
- Maintain a logical module structure within this directory

## State Management
- Terraform state must be managed remotely in AWS S3
- Use the `srhoton-tfstate` bucket for all state files
- Store state files in the `quarkus-lambda-build` folder within the bucket
- Implement state locking using DynamoDB when working in teams

## Region Requirements
- All AWS resources must be provisioned in the `us-east-1` region
- Always specify the region explicitly in provider configurations

## Best Practices
- Use variables for reusable values
- Implement proper tagging for all resources
- Leverage modules for reusable components
- Use workspaces for environment separation
- Document all modules with README files
- Follow a consistent naming convention for resources

## Configuration Example

```hcl
provider "aws" {
  region = "us-east-1"
}

terraform {
  backend "s3" {
    bucket = "srhoton-tfstate"
    key    = "quarkus-lambda-build/terraform.tfstate"
    region = "us-east-1"
  }
}
```
