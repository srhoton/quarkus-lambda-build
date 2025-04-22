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
- Enforce pre-commit validation with git hooks to require `terraform fmt` and `terraform validate` to pass before committing

```bash
# In .git/hooks/pre-commit (make executable with chmod +x)
#!/bin/sh

# Find all Terraform files that are staged for commit
files=$(git diff --cached --name-only --diff-filter=ACM | grep '\.tf$')

if [ -n "$files" ]; then
  echo "Running Terraform format check..."
  
  # Format check
  terraform fmt -check -recursive ./terraform
  if [ $? -ne 0 ]; then
    echo "Terraform format check failed. Run 'terraform fmt -recursive ./terraform' to fix formatting issues."
    exit 1
  fi
  
  # Validation check
  echo "Running Terraform validation..."
  cd ./terraform
  terraform validate
  if [ $? -ne 0 ]; then
    echo "Terraform validation failed. Please fix the validation errors before committing."
    exit 1
  fi
  cd ..
fi

exit 0
```
