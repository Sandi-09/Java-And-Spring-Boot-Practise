package com.DemoApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    public static void main(String[] args) {
       List<Integer> ls = Arrays.asList(2,5,33,5);

        String names[]={"hari","Om","god","jdjjd","dinesh","dum"};
        List<String> fileteredList = Arrays.stream(names)
                .filter(x -> x.toLowerCase().startsWith("d"))
                .collect(Collectors.toList())
                .stream().filter(x->x.length()<5).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(fileteredList);
    }
}
