# Random Bet App

### How to run app

- Ensure you have java installed
- Ensure you have maven installed
- Run the commands below

```dtd
mvn clean install
mvn spring-boot:run
```

NOTE: Alternatively, you can open the app in an IDE (e.g intellij) and start the app using the run button

### Testing the endpoint locally
Request
```dtd
POST http://localhost:8080/api/v1/bet
Body {
    "number": 99,
    "bet": 889
}
```

The endpoint handles validation and returns an error message if invalid data is passed to it.

### How to run test suites, including the RTP Test
```dtd
mvn test
```