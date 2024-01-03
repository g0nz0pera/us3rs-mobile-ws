package com.g0nz0.users.ws.controllers.HttpRequests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateUserRequest {
    @NotNull(message = "First Name cannot be null")
    @Size(min=2, message = "First Name Should be longer than 2")
    private String firstName;
    @NotNull(message = "Last Name cannot be null")
    @Size(min=2, message = "Last Name Should be longer than 2")
    private String lastName;
    @NotNull
    @Email
    private String email;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
