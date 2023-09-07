package com.AsyncOperationsMains;

import com.CompletableFuture.com.database.EmployeeDatabase;
import com.CompletableFuture.dto.SheetName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.*;

//In this demo we are trying to acheive the async nature of java
//using the Completable Future ascpect of java programming
public class EmployeeExtractor {

    public static String saveEmployeeDetailsUsingSupplyAsync(){
        ObjectMapper mapper = new ObjectMapper();
        Executor executor = Executors.newFixedThreadPool(2);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            System.out.println("Thread "+Thread.currentThread().getName());
            SheetName sheetName = EmployeeDatabase.getAllRecordsFromSheetName(new File("employees1.json"));
            String jsonStr = null;
            try {
                jsonStr = mapper.writeValueAsString(sheetName);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return jsonStr;
        },executor);
        return future.join();
    }

    public static Void saveEmployeeDetailsUsingRunAsync(File jsonFile) throws ExecutionException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        ExecutorService fixedPool = Executors.newFixedThreadPool(2);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            try {
                SheetName employees = mapper.readValue(jsonFile, new TypeReference<SheetName>(){});
                String jsonStr = mapper.writeValueAsString(employees);
                System.out.println("Thread " + Thread.currentThread().getName());
                System.out.println(jsonStr);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        },fixedPool);
        return voidCompletableFuture.join();
    }
    public void sendMail(String email) {
        System.out.println("the training email has been sent to : "+email);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        EmployeeExtractor.saveEmployeeDetailsUsingRunAsync(new File("employees1.json"));
//        System.err.println("could not add the async calls");
//        String sheetName = EmployeeExtractor.saveEmployeeDetailsUsingSupplyAsync();
//        System.out.println(sheetName);
        Actions a= new Actions();
        a.ActionsOnEmployees().get();
    }

}
