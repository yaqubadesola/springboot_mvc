package com.formValidation.model;

import com.formValidation.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;

    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String lastName = "";

    @NotNull(message="is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message="Only 5 chars/digits")
    private String postalCode;

    @NotNull(message="is required")
    @Min(value=0, message="must be greater or equal to 0")
    @Max(value=10, message="must be greater or equal to 0")
    private Integer freePasses;

    @CourseCode
    private String courseCode;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

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
}
