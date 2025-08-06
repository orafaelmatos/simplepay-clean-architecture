# SimplePay - PicPay Backend Challenge

This project is a submission for the **PicPay Backend Technical Challenge**.  
It implements a simplified payment platform backend inspired by PicPay’s requirements, developed with **Java Spring Boot** following **Clean Architecture** principles.

## About the Challenge

The goal was to build a system where users and merchants can manage wallets and transfer money securely, respecting business rules such as:

- Unique CPF and email per user.
- Two user types: Regular Users and Merchants.
- Merchants can only receive transfers, not send.
- Transfers require balance validation and external authorization.
- Notifications sent through external mock service.
- Transactional consistency on transfers.

## Features

- User registration with validations.
- Wallet and balance management.
- Secure transfer flow with external authorization and notification mocks.
- Clean Architecture for maintainability and testability.
- RESTful API endpoints.

## Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring Data JPA (Hibernate)
- PostgreSQL (or any relational DB)
- Maven

## Architecture Overview

The project is structured into layers respecting Clean Architecture:

- **Domain**: Business entities and rules.
- **Application**: Use cases and service logic.
- **Infrastructure**: Database, external API clients.
- **Interface**: REST controllers exposing the API.
