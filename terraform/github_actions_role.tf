# Policy for GitHub Actions to deploy infrastructure and Lambda
resource "aws_iam_policy" "github_actions_policy" {
  name        = "github-actions-policy"
  description = "IAM policy for GitHub Actions to deploy infrastructure and Lambda"

  policy = jsonencode({
    Version = "2012-10-17"
    Statement = [
      # S3 permissions for Terraform state
      {
        Action = [
          "s3:GetObject",
          "s3:PutObject",
          "s3:ListBucket"
        ]
        Effect = "Allow"
        Resource = [
          "arn:aws:s3:::srhoton-tfstate",
          "arn:aws:s3:::srhoton-tfstate/quarkus-lambda-build/*"
        ]
      },
      # DynamoDB permissions for Terraform state locking
      {
        Action = [
          "dynamodb:GetItem",
          "dynamodb:PutItem",
          "dynamodb:DeleteItem"
        ]
        Effect   = "Allow"
        Resource = "arn:aws:dynamodb:us-east-1:${var.aws_account_id}:table/terraform-lock"
      },
      # SQS permissions
      {
        Action = [
          "sqs:CreateQueue",
          "sqs:GetQueueUrl",
          "sqs:GetQueueAttributes",
          "sqs:SetQueueAttributes",
          "sqs:ListQueues",
          "sqs:DeleteQueue",
          "sqs:TagQueue"
        ]
        Effect   = "Allow"
        Resource = "*"
      },
      # Lambda permissions
      {
        Action = [
          "lambda:GetFunction",
          "lambda:CreateFunction",
          "lambda:DeleteFunction",
          "lambda:UpdateFunctionCode",
          "lambda:UpdateFunctionConfiguration",
          "lambda:ListEventSourceMappings",
          "lambda:CreateEventSourceMapping",
          "lambda:DeleteEventSourceMapping",
          "lambda:TagResource"
        ]
        Effect   = "Allow"
        Resource = "*"
      },
      # IAM permissions
      {
        Action = [
          "iam:GetRole",
          "iam:PassRole"
        ]
        Effect   = "Allow"
        Resource = aws_iam_role.lambda_execution_role.arn
      }
    ]
  })
}

resource "aws_iam_role_policy_attachment" "github_actions_policy_attachment" {
  role       = "github-actions-role"
  policy_arn = aws_iam_policy.github_actions_policy.arn
}
