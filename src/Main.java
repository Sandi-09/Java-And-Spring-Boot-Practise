import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
;

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"jejjej");
        map.put(2,"jejjej");
        map.put(3,"jejjej");
        map.put(4,"jejjej");


        List<String> result2 = map.entrySet().stream()
                .filter(entry -> entry.getKey() % 2 == 0)
                .map(entry -> {
                    entry.setValue("hhh");
                    return entry.getValue();
                })
                .collect(Collectors.toList());


        List<String> result3 = map.entrySet().stream()
                .map(entry -> {
                    if (entry.getKey() % 2 == 0) {
                        entry.setValue("hhhhh");
                    }
                    return entry.getValue();
                })
                .collect(Collectors.toList());


        System.out.println(result2);

    }
}