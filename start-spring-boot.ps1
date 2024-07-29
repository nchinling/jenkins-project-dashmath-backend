Start-Process "mvn" -ArgumentList "spring-boot:run" -NoNewWindow -RedirectStandardOutput "spring-boot.log" -RedirectStandardError "spring-boot-error.log"
