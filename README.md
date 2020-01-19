# Mixed Martial Arts Management application

In fulfillment of the solo project assignment due at QA consulting.

## Index
Brief

  * My solution

Architecture

  * Entity relationship diagram

  * Multi Tier Architecture Diagram

Testing

  * Coverage

  * Surefire-report

Deployment

  * Technologies used

Front End Design

Improvements for the Future

Authors

Acknowledgements

## The Brief

To create an OOP-based application with utilisation of supporting tools, methodologies and technologies to create a functioning application that utilises full CRUD functionality.

### My solution

I decided to create a mixed martial arts management application that would allow the user to login, add fighters to the club and attributes (height and weight), remove fighters from the club, update fighters weights and also sign out. This is so the manager can assign fighters fairer fights within the club.

The one to many relationship from manager to fighters is working, where fighters can be added and removed from a specific manager.

## Architecture

### Entity Relationship Diagram

![alt text](https://github.com/LukeCharles555/bae-MMAManagement/blob/development/Documentation/EntityRelationshipDiagram.png)

The ERD consists of just two tables in a one to many relationship. One manager can have many fighters, so each fighter is assigned to a specific manager. I linked the two tables by using the managerID as a foreign key in the fighters table.

## Testing

JUnit, Mockito and Selenium tests have been used for automated testing.

### Report

[Link to surefire report](https://github.com/LukeCharles555/bae-MMAManagement/blob/development/Documentation/Surefire%20Report.pdf)

Test coverage for the backend is at 81.3%, there are as of yet no working Selenium tests but I hope to get these running soon. 

## Deployment

The build, test and deployment process was automated using Jenkins, this allowed a new build every time content is pushed to GitHub.

This application can be deployed locally and externally through a virtual machine. This VM is hosted by Amazon Web Services.

### Technologies Used

![alt text](https://github.com/LukeCharles555/bae-MMAManagement/blob/development/Documentation/CI_Pipeline.png)

  * Eclipse, Visual Studio Code - IDE's
  * H2 Database - Database
  * Java - Back-end
  * HTML, CSS, Javascript - Front-end
  * Git - VCS
  * Trello - Project Management Tool
  * Jenkins - CI Server
  * Maven - Build Tool
  * JUnit, Mockito, Selenium - Testing
  * AWS - Live Environment

## Front End Design

### Wireframes

Login

![alt text](https://github.com/LukeCharles555/bae-MMAManagement/blob/development/Documentation/loginWireframe.png)

Fighter App

![alt text](https://github.com/LukeCharles555/bae-MMAManagement/blob/development/Documentation/FighterAppWireframe.png)

Fighter Statistics

![alt text](https://github.com/LukeCharles555/bae-MMAManagement/blob/development/Documentation/FighterStatsWireframe.png)

## Improvements for the Future

Currently, this app can only add two attributes to a fighter, height and weight. In my next sprint, I would like to add more attributes that contribute to fairer fights.

In later sprints, I would like to have a log in function not only for managers of one club, but different club logins. This is so the app could hold inter-club tournaments. This would also mean more statistics would be added, such as win/loss ratios for each fighter. After this, the app could be made functional for different types of sports.

## Authors
Luke Pugh

## Acknowledgements
  * QA consulting and all of the trainers
  * The rest of our talented cohort on the programme
