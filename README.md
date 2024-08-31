# Jenkins Pipeline Project
This is a pipeline project implemented with Jenkins. The pipeline is created with a JenkinsFile (Jenkinsfile) using a declarative approach and implements the following:

![alt text](readme_images/jenkinslogo.png)

1. clean - 'mvn clean' command clears files from previous build. 
2. unit tests - with JUnit
3. static code anaysis - SonarQube. Includes code coverage analysis.
4. build - 'mvn install' command compiles and builds the application
5. containerisation - image is built and pushed to Docker Hub
6. notification - email is sent to the user to inform of build and containerisation status

![alt text](readme_images/pipeline.png)

The pipeline builds the Dash Math project, which can be found at https://github.com/nchinling/mental-math-game
Visit https://ngchinling.com/projects/jenkins.html for more information on the project. 
