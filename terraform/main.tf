provider "aws" {
  region = "us-east-1"
}

terraform {
  required_version = ">= 1.5.0"

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = ">= 5.0.0"
    }
  }

  backend "s3" {
    bucket = "srhoton-tfstate"
    key    = "quarkus-lambda-build/terraform.tfstate"
    region = "us-east-1"
  }
}

resource "aws_sqs_queue" "quarkus_lambda_queue" {
  name                      = "quarkus-lambda-build"
  delay_seconds             = 0
  max_message_size          = 262144
  message_retention_seconds = 345600 # 4 days
  receive_wait_time_seconds = 0

  tags = {
    Name        = "quarkus-lambda-build"
    Environment = "dev"
    Project     = "quarkus-lambda-build"
    Terraform   = "true"
  }
}

output "sqs_queue_url" {
  description = "The URL of the SQS queue"
  value       = aws_sqs_queue.quarkus_lambda_queue.url
}

output "sqs_queue_arn" {
  description = "The ARN of the SQS queue"
  value       = aws_sqs_queue.quarkus_lambda_queue.arn
}
