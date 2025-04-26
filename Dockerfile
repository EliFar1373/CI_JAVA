# Use the official Jenkins LTS image as a base
FROM jenkins/jenkins:lts

# Switch to the root user to install packages
USER root

# Update package lists and install Maven
RUN apt-get update && apt-get install -y maven

# Switch back to the Jenkins user
USER jenkins
