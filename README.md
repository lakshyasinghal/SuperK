# SuperK



MySQL - Any version will do but preferably 5.7.31

Running MySQL Scripts

1. First create a mysql user with username root and password root
2. Now go into the mentioned path in SuperK repo
   SuperK -> AppServer -> sql -> v1 -> script
3. You will find a run_sql.sh file here
4. Use command 'chmod +x run_sql.sh'. You can also use 'sudo chmod +x run_sql.sh' in case of permissions error.
5. Now run the file using './run_sql.sh'
6. Your db should be setup now.


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
1. localhost:9000/city-admin-dashboard
2. localhost:9000/store-admin-dashboard




** Please use a Linux system as some of the commands mentioned above may not work in Windows
