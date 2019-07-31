import util.StringToDataStructureConverter;

public class StringToDataStructureConverterApp {

    public static void main(String[] args) {
        String inputStr = "Есть строка состоящая из слов Все слова в ней разделены одним пробелом Нужно преобразовать строку в такую структуру данных которая группирует слова по первой букве в слове " +
                "Затем вывести только группы содержащие более одного элемента Группы должны быть отсортированы в алфавитном быквам порядке по всем буквам в слове " +
                "Слова внутри группы нужно привет сортировать сaртировать по убыванию если число символов равное то сортировать в алфавитном порядке ";

        var structure = StringToDataStructureConverter.convertStringToSpecificStructure(inputStr);
        System.out.println(structure.toString());

    }
}
