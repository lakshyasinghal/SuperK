# SuperK



MySQL - Any version will do but to preferably 5.7.31



Running Service Locally

1. Pull the repository from github.
2. Go to AppServer folder which will be inside SuperK main repo.
3. Run 'gradlew build' command. A build folder will be created which will have libs folder. In worst case if gradlew command isn't working, you can install 
   gradle(4.4.1) on your system and run 'gradle build' command from the same location.
4. Go inside libs where jar will be available for running.
5. You can copy the jar to your own preferred path or can run it from this path only.
6. Use the command 'java -jar jar-name.jar'
7. If you see a message 'Launched' it means server is up.



UI

1. There is not a separate service for UI.
2. The pages have been integrated in the main web service.

2 URLS which need to be used in browser
localhost:9000/city-admin-dashboard
localhost:9000/store-admin-dashboard
