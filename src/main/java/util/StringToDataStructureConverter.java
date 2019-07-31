package util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Сonverts a string to a specific data structure
 */
public class StringToDataStructureConverter {


    /**
     * The method is to combine words by the first letter.
     * Groups are sorted alphabetically. Words within a group are sorted in descending order of characters; if the number of characters is equal, then sorted alphabetically.
     *
     * @param inputStr*
     */
    public static Map convertStringToSpecificStructure(String inputStr)  {
        return convert(
                Arrays.asList(inputStr.split(" "))
                ,getComparatorForGropupChildren()
                ,getPredicate()
        );


    }

    public static Map convert(List<String> words, Comparator<String> comparatorForGropupChildren, Predicate filterPedicate){
        Map<Character, TreeSet<String>> result = words.stream()
                .collect(
                        Collectors.toMap(sx -> sx.substring(0, 1).toLowerCase().charAt(0),
                                s1 -> {
                                    var se = new TreeSet<>(comparatorForGropupChildren);
                                    se.addAll(Collections.singleton(s1));
                                    return se;
                                },
                                (l, l1) -> {
                                    l.addAll(l1);
                                    return l;
                                }
                                , TreeMap::new
                        ));

        if (null!=filterPedicate)
            result.entrySet().removeIf(filterPedicate);

        return result;
    }


    private static Comparator<String> getComparatorForGropupChildren(){
        return (o1, o2) -> (o2.length() - o1.length()==0?o2.compareToIgnoreCase(o1):o2.length() - o1.length());
    }


    /**
     * Predicate to remove elements <= 1
     * @return Predicate
     */
    private static Predicate<Map.Entry<String, TreeSet<String>>> getPredicate(){
        return x -> x.getValue().size()<=1;
    }


}
