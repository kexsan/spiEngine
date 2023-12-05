# docker-compose -f docker-compose.yml -p ccrm up
# to run java -jar spiEngine-0.0.1-SNAPSHOT.jar  --spring.config.additional-location=./src/main/resources/application_local.yaml
# for run from gradlew bootRun --args='--spring.config.additional-location=./src/main/resources/application_local.yaml' 
#
#
#
# use --spring.config.additional-location=./src/main/resources/application_local.yaml




# spring.config.name, spring.config.location, and spring.config.additional-location are used very early to 
# determine which files have to be loaded. They must be defined as an environment property 
# (typically an OS environment variable, a system property, or a command-line argument).