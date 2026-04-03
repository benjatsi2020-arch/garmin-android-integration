# Garmin Android Integration API Reference

## Overview
This document provides an overview of the Garmin Android Integration APIs. It outlines the RESTful endpoints, request parameters, response formats, and examples for each endpoint.

## Base URL
```
https://api.garmin.com/v1/
```

## Authentication
All API requests require authentication. Use the following method for authentication:

1. Obtain OAuth 2.0 credentials.
2. Include the access token in the request header as follows:
```plaintext
Authorization: Bearer {access_token}
```

## Endpoints

### 1. Get User Profile
- **Endpoint:** `/user/profile`
- **Method:** GET
- **Description:** Retrieves the profile information of the authenticated user.
- **Request Parameters:** None
- **Response Format:** JSON

#### Example Response:
```json
{
  "id": "12345",
  "name": "John Doe",
  "email": "john.doe@example.com"
}
```

### 2. Get Activity Data
- **Endpoint:** `/user/activities`
- **Method:** GET
- **Description:** Retrieves the activity data for the authenticated user.
- **Request Parameters:**
  - `start`: (Optional) Start date of activities.
  - `end`: (Optional) End date of activities.
- **Response Format:** JSON

#### Example Response:
```json
[
  {
    "activityId": "1",
    "date": "2026-04-01",
    "type": "running"
  }  
]
```

### 3. Create New Activity
- **Endpoint:** `/user/activities`
- **Method:** POST
- **Description:** Creates a new activity entry for the user.
- **Request Body:**
```json
{
  "type": "running",
  "duration": 3600,
  "distance": 10
}
```
- **Response Format:** JSON

#### Example Response:
```json
{
  "message": "Activity created successfully",
  "activityId": "2"
}
```

### 4. Delete Activity
- **Endpoint:** `/user/activities/{activityId}`
- **Method:** DELETE
- **Description:** Deletes an existing activity by its ID.
- **Request Parameters:**
  - `activityId`: ID of the activity to delete.
- **Response Format:** JSON

#### Example Response:
```json
{
  "message": "Activity deleted successfully"
}
```

## Error Handling
In case of an error, the API returns a standard error response:
```json
{
  "error": "Invalid request",
  "code": 400
}
```

## Conclusion
This document provides a comprehensive reference for interacting with the Garmin Android Integration API. Ensure to handle errors gracefully and validate user input for a better experience.
