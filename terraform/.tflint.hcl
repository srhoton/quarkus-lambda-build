config {
  module = true
  force = false
  disabled_by_default = false

  # AWS plugin settings
  plugin "aws" {
    enabled = true
    version = "0.30.0"
    source = "github.com/terraform-linters/tflint-ruleset-aws"
  }
}

# Basic linting rules
rule "terraform_deprecated_interpolation" {
  enabled = true
}

rule "terraform_documented_outputs" {
  enabled = true
}

rule "terraform_documented_variables" {
  enabled = true
}

rule "terraform_typed_variables" {
  enabled = true
}

rule "terraform_required_version" {
  enabled = true
}

rule "terraform_required_providers" {
  enabled = true
}

rule "terraform_unused_required_providers" {
  enabled = true
}

rule "terraform_naming_convention" {
  enabled = true
  format = "snake_case"
}

# AWS related rules
rule "aws_resource_missing_tags" {
  enabled = true
  tags = ["Environment", "Project", "Terraform"]
}