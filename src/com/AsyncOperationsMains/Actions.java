package com.AsyncOperationsMains;

import com.CompletableFuture.com.database.EmployeeDatabase;
import com.CompletableFuture.dto.Employee;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Actions {

    public CompletableFuture<Void> ActionsOnEmployees(){

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    return EmployeeDatabase.getAllRecordsFromSheetName(new File("employees1.json"));
                }).thenApply((employee) -> {
                    return employee.getSheet1().stream()
                            .filter(employee1 -> "True".equalsIgnoreCase(employee1.getNewJoiner()))
                            .collect(Collectors.toList());
                }).thenApply((employees) -> employees.stream()
                        .filter(employee -> "True".equalsIgnoreCase(employee.getLearningPending()))
                        .collect(Collectors.toList()))
                .thenApplyAsync((employees) -> employees.stream()
                        .map(Employee::getEmail)
                        .collect(Collectors.toList()))
                .thenAccept((emails)->{
                    emails.forEach(new EmployeeExtractor()::sendMail);
                });
        return voidCompletableFuture;
    }

    private static void sendMail(String email) {
        System.out.println("the training email has been sent to : "+email);
    }


}
