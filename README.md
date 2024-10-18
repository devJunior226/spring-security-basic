## Introduction
This is a Spring security basic demo app. You will see below how to test my endpoint security.

## Security class
The security base class is the SecurityConfig.
- In this class, we define a ***filter method*** to filter the request coming on the endpoint and to return 
  the value according to the role of the user.
- A ***userDetailsService*** method to build two default users with their roles and passwords: ***user*** and ***admin***
- A ***passwordEncoder*** to encode the user password in memory.