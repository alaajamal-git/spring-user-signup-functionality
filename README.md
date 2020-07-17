# spring-user-signup-functionality
In this project we added the spring security framework to use BCryptPasswordEncoder which we used to decrypt password that used by users when they are signing up before insert it in h2 in memory database.
We also used ModelMapper this dependency uses to map two objects depends on field names.
To make Spring framework inject the BCryptPasswordEncoder object we should create a bean methon in the main class. The bean name whould be the same function name.
