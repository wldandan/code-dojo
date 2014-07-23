#### How to run the application
./gradlew run

#### How to run all the test
./gradlew test

#### Design and implementation
The application includes several parts:

  * com.domain.register.model
  	- It defines the basic business model from OO perspective.
  	- Bill & BillItem are the Objects which provides register cost to consumers
  	- Domain and DomainType are the Objects representing the Zone and Premium domain.
  	
  * com.domain.register.service
    - It defines the API to help consumer check the domain information and calculate total cost, as well as the cost for each entry.
    

  * com.domain.register.parameter
      - It defines the vo to help services get the user input value from console.
    
  * com.domain.register.console
      - It defines the Objects to run console application.  
 

