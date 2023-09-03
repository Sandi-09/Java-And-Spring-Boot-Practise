package com.CompletableFuture.com.database;

import com.CompletableFuture.dto.SheetName;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class EmployeeDatabase {

    public static SheetName getAllRecordsFromSheetName(File jsonFile){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonFile, new TypeReference<SheetName>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //return null;
    }
}
