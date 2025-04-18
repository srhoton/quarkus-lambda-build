variable "aws_account_id" {
  description = "AWS Account ID"
  type        = string
}

variable "github_repository" {
  description = "GitHub repository name in format 'owner/repo'"
  type        = string
  default     = "steverhoton/quarkus-lambda-build"
}
