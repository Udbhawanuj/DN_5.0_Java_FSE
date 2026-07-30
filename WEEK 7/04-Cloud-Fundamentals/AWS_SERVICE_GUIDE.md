# AWS Service Guide

| Service | Purpose | Week 7 example |
|---|---|---|
| EC2 | Virtual server instances | Run the Java service on a VM |
| AMI | Reusable machine image | Standardize EC2 startup |
| Security Group | Stateful virtual firewall | Allow only required ports |
| Key Pair | SSH authentication | Administrative access to Linux EC2 |
| ECS | Managed container orchestration | Run the Docker image |
| S3 | Object storage | Store build artifacts and static files |
| EBS | Block storage for EC2 | Persistent disk attached to a VM |
| VPC | Isolated virtual network | Public/private subnets and routing |
| ELB/ALB | Distribute traffic | Route HTTP traffic to service replicas |
| RDS | Managed relational database | Persistent transactional task data |
| DynamoDB | Managed NoSQL database | Serverless key-value task storage |
| Lambda | Event-driven serverless compute | Process task events |
| API Gateway | Managed API front door | Secure and expose Lambda/HTTP APIs |

## ALB vs NLB

- ALB operates at Layer 7 and understands HTTP paths, hosts and headers.
- NLB operates at Layer 4 and is optimized for very high-performance TCP/UDP/TLS traffic.

## RDS Multi-AZ

Multi-AZ creates a synchronous standby in another Availability Zone for availability. It is different from read replicas, which are primarily used to scale reads.
