# model.enums

This folder contains the `enum` classes used in the system, which define specific types of data that are used across the application. The enums provide predefined sets of constants for treatments and dermatologists, ensuring consistency and efficiency throughout the system.

## Contents

### 1. `Dermatologist.java`

The `Dermatologist` enum represents different dermatologists available in the system. Each dermatologist has a unique set of attributes, including their National Identity Card (NIC), name, email, and phone number.

#### Enum Constants

- **DR_SMITH**: Represents Dr. John Smith with NIC `123456789`, email `dr.smith@example.com`, and phone number `987654321`.
- **DR_JONES**: Represents Dr. Emily Jones with NIC `987654321`, email `dr.jones@example.com`, and phone number `123456789`.
- **DR_BROWN**: Represents Dr. Michael Brown with NIC `111223344`, email `dr.brown@example.com`, and phone number `333444555`.

#### Methods

- `getNIC()`: Retrieves the NIC of the dermatologist.
- `getName()`: Retrieves the name of the dermatologist.
- `getEmail()`: Retrieves the email address of the dermatologist.
- `getPhoneNumber()`: Retrieves the phone number of the dermatologist.
- `toString()`: Provides a custom string representation of the dermatologist, omitting sensitive information such as NIC and phone number.

---

### 2. `TreatmentType.java`

The `TreatmentType` enum represents different types of treatments available in the system. Each treatment has a unique ID, name, and associated price.

#### Enum Constants

- **ACNE_TREATMENT**: Represents the acne treatment with ID `1` and price `2750.0`.
- **SKIN_WHITENING**: Represents skin whitening treatment with ID `2` and price `7650.0`.
- **MOLE_REMOVAL**: Represents mole removal treatment with ID `3` and price `3850.0`.
- **LASER_TREATMENT**: Represents laser treatment with ID `4` and price `125000.0`.

#### Methods

- `getPrice()`: Retrieves the price of the treatment.
- `getName()`: Retrieves the name of the treatment.
- `getTreatmentID()`: Retrieves the unique treatment ID.
- `toString()`: Provides a custom string representation of the treatment details.
- `getByTreatmentID(int treatmentID)`: Retrieves the `TreatmentType` based on the provided treatment ID. If the treatment ID is invalid, it throws an `InvalidTreatmentIDException` and logs the error.

---

## Logging

Both `Dermatologist` and `TreatmentType` enums utilize logging for error handling and providing useful runtime information. The logging is handled by the `LoggerUtil` class, which is configured to write logs to a file as specified in the configuration settings.

#### Error Logging Example:
- In the `TreatmentType` enum, if an invalid treatment ID is requested, an error message is logged using the `severe` log level.

## Dependencies

- **LoggerUtil**: A utility class responsible for configuring and managing the application's logger.
- **InvalidTreatmentIDException**: A custom exception used in the `TreatmentType` enum to handle invalid treatment ID errors.

---

## Example Usage

```java
// Example: Get a treatment by ID
try {
    TreatmentType treatment = TreatmentType.getByTreatmentID(1);
    System.out.println("Treatment Name: " + treatment.getName());
} catch (InvalidTreatmentIDException e) {
    System.out.println(e.getMessage());
}

// Example: Get dermatologist information
Dermatologist dermatologist = Dermatologist.DR_SMITH;
System.out.println(dermatologist.getName() + " can be contacted at " + dermatologist.getEmail());
```