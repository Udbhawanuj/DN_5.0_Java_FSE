# AWS Reference Architecture

```mermaid
flowchart LR
    U[Users] --> R53[Route 53]
    R53 --> ALB[Application Load Balancer]
    ALB --> ECS1[ECS Task - AZ A]
    ALB --> ECS2[ECS Task - AZ B]
    ECS1 --> RDS[(RDS Multi-AZ)]
    ECS2 --> RDS
    ECS1 --> S3[(S3)]
    ECS2 --> S3
    ECS1 --> CW[CloudWatch]
    ECS2 --> CW
```

## Network Layout

- public subnets: ALB and NAT Gateway
- private application subnets: ECS tasks
- private database subnets: RDS
- security groups permit only necessary traffic between tiers
- secrets are stored in Secrets Manager or Parameter Store, not in source code

## Reliability Improvements

- at least two Availability Zones
- ECS desired count greater than one
- health checks and automatic replacement
- RDS Multi-AZ
- S3 versioning and encryption
- alarms for latency, errors and unhealthy targets
