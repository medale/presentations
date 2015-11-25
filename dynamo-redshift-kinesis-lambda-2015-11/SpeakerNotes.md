% Amazon Web Services
% DynamoDB, Redshift, Kinesis and Lambda
% Markus Dale, November 2015

# Managed Services With Rich Environment
* EC2 - Elastic Load Balancer service, Auto-Scaling, Security groups...
* S3 - Server-Side Encryption, Versioning, Notification (Object created/removed)...
* RDS - Relational Database Service - managed RDBMS
     * Supports Aurora, MySQL, PostgreSQL, Maria, Oracle, SQL Server
     * Multi-AZ, read replicas, backups

Developer productivity - mission/business over infrastructure

# Right Tool for the Right Job
* When you need that corkscrew...
* DynamoDB - NoSQL database
* Redshift - data warehouse
* Kinesis - Streaming lots of data
* Lambda - run code on event or timer

# AWS DynamoDB
* Managed NoSQL database since 2012
* 
* Reserved capacity

# Reply Table
* Hash Key: Amazon DynamoDB#DynamoDB Thread 1 (denormalized - reference Forum table)
* Range Key: ReplyDateTime
* Scan (with filter)
* Query - by hash (with optional range)

# Query
* On Hash Key
* On Hash Key, Range Key
* Can add filter
* Secondary Index - local/global

# Provisioned Capacity
* Read
* Write
* Need extra for secondary indices
* Plus storage
