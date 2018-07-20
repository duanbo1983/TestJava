import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toCollection;

public class HelloStream {

    private static final String PREFIX_FOR_ENCRYPTED_SLOTS_KEY = "AHD_ENCRYPTED_SLOTS_";

    public static void main(String[] args) {
        modifyMap();
    }

    public static void modifyMap() {
        Map<String, String> slotsMap = new HashMap<String, String>() {
            {
                put("HelpDetail", "bluetooth");
                put("ActionTrigger", "connect");
                put("AHD_ENCRYPTED_SLOTS_ActionTrigger", "xxx_connect");
                put("AHD_ENCRYPTED_SLOTS_HelpDetail", "zzz_bluetooth");
            }
        };

        Map<String, String> newSlotsMap = slotsMap
                .entrySet()
                .stream()
                .collect(Collectors.toMap(new Function<Map.Entry<String, String>, String>() {
                    @Override
                    public String apply(Map.Entry<String, String> entry) {
                        return entry.getKey().startsWith(PREFIX_FOR_ENCRYPTED_SLOTS_KEY) ?
                                entry.getKey().substring(PREFIX_FOR_ENCRYPTED_SLOTS_KEY.length()) :
                                entry.getKey();
                    }
                }, new Function<Map.Entry<String, String>, String>() {
                    @Override
                    public String apply(Map.Entry<String, String> stringStringEntry) {
                        return stringStringEntry.getValue();
                    }
                }, new BinaryOperator<String>() {
                    @Override
                    public String apply(String first, String second) {
                        return first;
                    }
                }));

        System.out.println(newSlotsMap);


        Map<String, ArrayList<Map.Entry<String, String>>> collect = slotsMap.entrySet().stream()
                .collect(Collectors.groupingBy((Function<Map.Entry<String, String>, String>) entry ->
                        entry.getKey().startsWith(PREFIX_FOR_ENCRYPTED_SLOTS_KEY) ?
                                entry.getKey().substring(PREFIX_FOR_ENCRYPTED_SLOTS_KEY.length()) :
                                entry.getKey(), toCollection(ArrayList::new)));


        System.out.println(collect);


        Map<String, Optional<Map.Entry<String, String>>> collect1 = slotsMap.entrySet().stream()
                .collect(Collectors.groupingBy((Function<Map.Entry<String, String>, String>) entry ->
                        entry.getKey().startsWith(PREFIX_FOR_ENCRYPTED_SLOTS_KEY) ?
                                entry.getKey().substring(PREFIX_FOR_ENCRYPTED_SLOTS_KEY.length()) :
                                entry.getKey(), reducing(new BinaryOperator<Map.Entry<String, String>>() {
                    @Override
                    public Map.Entry<String, String> apply(Map.Entry<String, String> o, Map.Entry<String, String> o2) {
                        if (o.getKey().startsWith(PREFIX_FOR_ENCRYPTED_SLOTS_KEY)) {
                            o2.setValue(o.getValue());
                            return o2;
                        } else {
                            o.setValue(o2.getValue());
                            return o;
                        }
                    }
                })));


        System.out.println(collect1);



/*
        Map<String, String> collect2 = slotsMap.entrySet()
                .stream()
                .collect(Collectors.groupingBy((Function<Map.Entry<String, String>, String>) entry ->
                        entry.getKey().startsWith(PREFIX_FOR_ENCRYPTED_SLOTS_KEY) ?
                                entry.getKey().substring(PREFIX_FOR_ENCRYPTED_SLOTS_KEY.length()) :
                                entry.getKey(), reducing(new BinaryOperator<Map.Entry<String, String>>() {
                    @Override
                    public Map.Entry<String, String> apply(Map.Entry<String, String> o, Map.Entry<String, String> o2) {
                        if (o.getKey().startsWith(PREFIX_FOR_ENCRYPTED_SLOTS_KEY)) {
                            o2.setValue(o.getValue());
                            return o2;
                        } else {
                            o.setValue(o2.getValue());
                            return o;
                        }
                    }
                })))
                .entrySet()
                .stream()
                .map(
                        new Function<Map.Entry<String, Optional<Map.Entry<String, String>>>, Map.Entry<String, String>>() {
                            @Override
                            public Map.Entry<String, String> apply(
                                    Map.Entry<String, Optional<Map.Entry<String, String>>>
                                            stringOptionalEntry) {
                                return
                                        new AbstractMap.SimpleEntry<String, String>(stringOptionalEntry.getKey(),
                                                stringOptionalEntry.getValue().get().getValue());
                            }
                        })
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue(), (first, second) -> first));

 */

        Map<String, String> collect2 = slotsMap.entrySet()
                .stream()
                .collect(Collectors.groupingBy(entry ->
                        entry.getKey().startsWith(PREFIX_FOR_ENCRYPTED_SLOTS_KEY) ?
                                entry.getKey().substring(PREFIX_FOR_ENCRYPTED_SLOTS_KEY.length()) :
                                entry.getKey(), reducing((o, o2) -> {
                                    if (o.getKey().startsWith(PREFIX_FOR_ENCRYPTED_SLOTS_KEY)) {
                                        o2.setValue(o.getValue());
                                        return o2;
                                    } else {
                                        o.setValue(o2.getValue());
                                        return o;
                                    }
                                })))
                .entrySet()
                .stream()
                .map(
                        (Function<Map.Entry<String, Optional<Map.Entry<String, String>>>, Map.Entry<String, String>>) stringOptionalEntry -> new AbstractMap.SimpleEntry<>(
                                stringOptionalEntry.getKey(),
                                stringOptionalEntry.getValue().get().getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (first, second) -> first));

        System.out.println(collect2);
    }


}
