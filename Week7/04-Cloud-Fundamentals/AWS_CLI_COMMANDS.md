# AWS CLI Practice Commands

These commands are examples. Replace names and region before use.

```bash
aws sts get-caller-identity
aws ec2 describe-instances
aws ec2 describe-vpcs
aws s3api list-buckets
aws s3api create-bucket --bucket <globally-unique-name> --region ap-south-1 --create-bucket-configuration LocationConstraint=ap-south-1
aws rds describe-db-instances
aws dynamodb list-tables
aws lambda list-functions
aws apigateway get-rest-apis
aws ecs list-clusters
```

Never commit access keys. Prefer IAM roles, AWS SSO or short-lived credentials.
