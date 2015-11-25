% Amazon Web Services - Beyond EC2 and S3
% DynamoDB, Redshift, Kinesis and Lambda
% Markus Dale, November 2015

# Managed Services With Rich Environment
* EC2 - Elastic Load Balancer service, Auto-Scaling, Security groups...
* S3 - Server-Side Encryption, Versioning, Notification...
* RDS - Relational Database Service...

Developer Productivity

# Right Tool for the Right Job
![When you need that corkscrew...](graphics/RightTool.png) \


# AWS DynamoDB
* Managed NoSQL database since 2012
     * Dynamo key-value paper 2007
* Cost: Provisioned read/write throughput and actual storage
* Scalable (up and down)
* Fault-tolerant
* SSD storage

# DynamoDB Tables
![DynamoDB Management Console](graphics/DynamoDB-Tables.png) \


# DynamoDB Provisioned Capacity
![DynamoDB Capacity](graphics/DynamoDB-ProvisionedCapacity.png) \


# DynamoDB Sample Table - Reply
![DynamoDB Reply Table Scan](graphics/DynamoDB-Reply-Table.png) \


# DynamoDB Query
![DynamoDB Query](graphics/DynamoDB-Query.png) \


# Amazon Redshift
* Fully managed, petabyte-scale data warehouse
* Online Analytic Processing (OLAP) and Business Intelligence at scale
* Single or multi-node cluster in a single AZ

# Redshift Architecture
![Redshift Architecture](graphics/Redshift-Architecture.png) \


# Redshift Integration
* Load/store in S3
* DynamoDB
* Elastic MapReduce
* Kinesis
