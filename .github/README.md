# GitHub Actions Workflow

This directory contains GitHub Actions workflows for the Quarkus Lambda Build project.

## Production Deployment Workflow

The `deploy.yml` workflow handles the deployment of infrastructure and the Lambda function to AWS. This workflow:

1. Only runs in the `production` environment
2. Deploys Terraform infrastructure (SQS queue and IAM roles)
3. Builds and deploys the Quarkus Lambda function
4. Sets up event source mapping between SQS and Lambda

## Setup Instructions

Before using this workflow, you need to:

1. Create a GitHub environment named `production` in your repository settings
2. Add the following secrets to the `production` environment:
   - `AWS_ACCOUNT_ID`: Your AWS account ID

3. Set up OIDC authentication between GitHub and AWS:
   - Create an OIDC provider in AWS IAM for GitHub Actions
   - Configure the trust relationship for the `github-actions-role`

## Environment Protection Rules

Consider adding the following protection rules to your `production` environment:
- Required reviewers
- Deployment branch restrictions
- Wait timer

This ensures that deployments to production are properly reviewed and controlled.
