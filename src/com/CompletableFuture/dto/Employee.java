package com.CompletableFuture.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {


   // @JsonIgnore
    //private String name;
    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;

 private String newJoiner;

 private String learningPending;
 private String salary;
 private String rating;

}
