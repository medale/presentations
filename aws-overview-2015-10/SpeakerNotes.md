Lambda
Simian army
Evolutionary architectures
Operating expense instead of capital expense
Scale horizontally

Pricing:
On Demand
Reserved
Spot Instances


# Re:Invent 2015: Internet of Things

* From AWS IoT Tutorial right on AWS Management Console -> IoT
* Control Unit, light bulb (and mobile app)
* IoT Gateway/Message broker: X509 certs or Amazon Cognito IDs, MQTT/HTTPS
* Rules engine - transform to AWS endpoints (Kinesis Stream, S3, Lambda)
* Device shadow - keep state if device offline
* Device registry - unique ID to each thing, metadata (capabilities, attributes)

# Re:Invent 2015: QuickSight

* Business Intelligence Service
* Visualizations, ad-hoc analysis
* Super-fast, Parallel, In-Memory Calculation Engine (SPICE)
* Data sources: Redshift, RDS, EMR, DynamoDB, Kinesis Streams, S3, MySQL, Oracle

# Re:Invent 2015: Amazon Kinesis Firehose

* Managed service - automatically scale
* Compression, encryption to designated S3 bucket
* Run Lambda as objects arrive or EMR over bucket
* Redshift: CVS, JSON, AVRO etc. only selected columns, data type conversion

# Re:Invent 2015: AWS Import/Export Snowball
* 50lbs, self-contained, tamper resistant, up to 50TB
* 100TB on 100MB/s dedicated > 100 days
* AES 256-bit encryption at host, stored encrypted
* Decrypt when loaded into S3 bukcet
* Sanitize after use using NIST standard
* Send email to SNS when in bucket
* $200 per job, plus shipping, $15 per extra day

# Re:Invent 2015: Security
* Inspector: 100s of rules mapped to common security compliance standards (e.g
  Payment Card Industry Data Security Standard PCI DSS), regular updates by AWS
  Security researchers
* WAF: Web Application Firewall - protect against SQL injection, cross-site scripting
* AWS Config Rules: cloud governance, define standards, monitor for compliance.
Pre-built best practices or custom (e.g. proper tagging, use of elastic IPs etc.)
* AWS Config: All AWS resources with configurations over time

# Re:Invent 2015: Other Services

* Amazon Elasticsearch Service: Document indexing (Lucene), log analytics, time series
queries, works with visualization like Kibana
* Amazon Kinesis Streams Extended Retention - from 24hrs to 7 days
* AWS Database Migration Service (Preview): Oracle to Oracle, RDS etc. Data, SQL,
functions, stored procedures, warn about things that cannot be auto-converted
* Amazon RDS for MariaDB - MySQL clone by creator of MySQL
* Amazon Cloudwatch Dashboards: reusable graphs of AWS CloudWatch and custom metrics
* AWS Lambda
    * Python, Versioning, Scheduled Jobs, and 5 Minute Functions


https://d0.awsstatic.com/whitepapers/architecture/AWS_Well-Architected_Framework.pdf
http://en.clouddesignpattern.org/index.php/Main_Page

http://blogs.aws.amazon.com/security/post/Tx2XKTVE4JWD0F9/New-Security-Services-Launched-at-AWS-re-Invent-2015-Amazon-Inspector-AWS-WAF-an

https://aws.amazon.com/resources/gartner-2015-mq-learn-more/?trkCampaign=global_2015_ar_gartner_mq&trk=ha_ar_gartner_mq_1041
