# Overview

The **Outbox Pattern** is a design pattern used in distributed systems to ensure data consistency and reliability, especially when dealing with asynchronous message processing. It involves the following steps:

- **Data Persistence:** When a message is received, it is first persisted to a durable storage medium (e.g., database). This ensures that the data is not lost if the system fails during processing.
- **Message Processing:** After the data is persisted, a separate process (e.g., a background task) is responsible for processing the message and sending it to its intended destination.
- **Status Update:** Once the message is processed successfully, its status is updated in the storage medium to indicate that it has been delivered.

## Outbox Pattern Implementation (Java)

This project implements the Outbox pattern for asynchronous message processing in a Java application. It utilizes a REST API, a MySQL database, and two services: Outbox Service and Message Relayer.

## Architecture

REST API: Clients interact with the application through the REST API.

### Outbox Service:

- Receives data from the REST API requests.
- Saves the data to the Outbox table in the MySQL database. This ensures persistence even if message delivery fails.

### Message Relayer:

- Periodically polls the Outbox table for unprocessed messages.
- Retrieves the message data and performs the intended action (e.g., sending messages to an external system, updating internal systems).
- Marks the message as processed in the Outbox table.

## Benefits

- **Asynchronous Processing**: Improves responsiveness of the REST API by offloading message processing to the Message Relayer.
- **Fault Tolerance:** Data is persisted in the Outbox table, ensuring delivery even if the Message Relayer fails initially.
- **Scalability:** The Outbox Service and Message Relayer can be scaled independently to handle increased load.

## Setup

### Prerequisites:

- Java Development Kit (JDK)
- MySQL database

```
docker run --name outbox-pattern -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -e MYSQL_DATABASE=outbox-pattern-db -d mysql:latest
```

## Database Setup:
- Create the Outbox table with appropriate columns for storing message data (e.g., message_id, payload, processed)

## Further Development
- Implement error handling mechanisms for message processing failures.
- Consider using a distributed messaging queue instead of database polling for improved performance and scalability.

