# CI pipeline

In fulfillment of the pair project assignment due at QA consulting.

## Index

Brief
* Our solution

Architecture
* Our plan for the CI pipeline
* Pipeline diagrams

Stages 

Testing
* Coverage
* Surefire-report

Deployment
* Technologies used
* Stages of pipeline

Improvements for the future

Authors

Acknowledgements

## The Brief
To create a fully-deployed version of a full-stack OOP application, utilising supporting tools and technologies.

### Our solution
We decided to pipeline both of our applications, using Jenkins as the CI server which uploaded our application to nexus, an artifact repository. The latest jar from nexus was then automatically pulled down into a virtual machine on startup, and built via a script. 

## Architecture

### Our plan for the CI pipeline
### Pipeline diagrams

![Architecture](https://github.com/LukeCharles555/bae-MMAManagement/blob/CI-pipeline/Documentation/OverallArchitecture.png)

This image shows our overall architecture for the project. We have an EC2 instance containing jenkins and nexus. We then have seperate EC2 instances for our front-end and back-end application which connect to an RDS database hosted by AWS.

![Pipeline](https://github.com/LukeCharles555/bae-MMAManagement/blob/CI-pipeline/Documentation/PipelineArchitecure.png)

This image shows our actual pipeline model. However, the idea has evolved from this so instead of using DockerHub, we are solely using nexus to pull from and build our app.

## Stages
1. Created a VPC with 3 subnets in each availability zone
2. Created IAM roles for back-end, front-end and RDS instances
3. Created RDS database with specific RDS IAM role that allows access to database
4. Created back-end, front-end test instances

Security groups on backend:

Back-end to RDS:
* Allows access to MYSQL database on your IP only
* Allows custom TCP request from anywhere, with a port specification of back-end port
* Be able to SSH in
Back-end to front-end:
* HTTP & HTTPS requests specified to front-end port from anywhere
* Custom TCP requests from anywhere
* be able to SSH in

Security groups on front-end:

Front-end to back-end:
* HTTP & HTTPS requests specified to front-end port from anywhere
* Custom TCP requests from anywhere
* be able to SSH in
5. SSH'd into back-end to create a script for jenkins automation
6. SSH'd into front-end to put up front-end into an nginx container (Docker)
7. Created Jenkins file to specify the stages of how the pipeline would run (See stages in 'Stages of pipeline')
8. Configured Jenkins to connect to our GitHub accounts via a webhook, and installed all the relevant plugins
9. Built the app in Jenkins
10. When every stage passes, go to front-end IP with specific port it is running on and use the app!
11. Make a change, Jenkins builds it again automatically updated and the change can be seen


## Testing

We have Jenkins which automates our build process when a push is made to GitHub. This goes through the relevant stages of deployment, including testing. Unit tests, integration tests and selenium testing all go through this process and passes with both of our projects. 


### Technologies used
* AWS for EC2 instances - Containerisation, testing and live environments.
* GitHub - Version control system
* Trello - Project management tool
* Jenkins - CI server
* Maven - Building tool
* Testing - Selenium, Junit, Mockito
* Artifact repository - Nexus
* AWS RDS - Database

### Stages of pipeline
1. Maven clean
2. Maven test
3. Maven package
4. Maven surefire-report
5. Maven deploy to test environment
6. Maven deploy to live environment

## Improvements for the future
* Use DockerHub and Nexus as opposed to just Nexus. This is so if nexus fails, DockerHub can be used as a backup.
* Use Autoscaling groups to account for heightened traffic
* Use load-balancers to balance the load over autoscaled instances
* Elastic IP's so we don't need to change IP's each time we shut an instance down
* S3 Bucket for AWS keys and possibly for the front-end documents

## Authors
Luke Pugh and Anthony Wilkinson

## Acknowledgements
Our trainers that helped throughout the project 

Some beautiful people in our cohort

