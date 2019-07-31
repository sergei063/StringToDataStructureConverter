package util;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class StringToDataStructureConverterTest {


    private static final String INPUT_STRING = "сапог сарай арбуз болт бокс биржа сорай";

    @Test
    public void convertStringToSpecificStructure() {

        Map structure = StringToDataStructureConverter.convertStringToSpecificStructure(INPUT_STRING);
        Assert.assertNotNull("Structure is null",structure);

        Assert.assertEquals(structure.size(),2);

    }

    @Test
    public void convertTest() {

        var structure = StringToDataStructureConverter.convert(
                Arrays.asList(INPUT_STRING.split(" "))
                , Comparator.reverseOrder()
                , null
        );

        Assert.assertNotNull("Structure is null",structure);
        Assert.assertEquals(structure.size(),3);


    }

    @Test
    public void testSizeChildren() {
        Map structure = StringToDataStructureConverter.convertStringToSpecificStructure(INPUT_STRING);

        Iterator<Map.Entry<Character, TreeSet<String>>> entries = structure.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Character, TreeSet<String>> entry = entries.next();
            Assert.assertTrue(entry.getValue().size()>1);
        }
    }
}
