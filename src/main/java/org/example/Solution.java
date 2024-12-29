package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Solution {
    public void findMinMax() {
        List<Integer> list = Arrays.asList(2, 4, 2, 1, 5, 8, 3, 5, 12, 93, 56, 32);

        // Find min max
        Optional<Integer> valueMin = list.stream().min(Integer::compareTo);
        Optional<Integer> valueMax = list.stream().max(Integer::compareTo);
        valueMin.ifPresent(value -> System.out.println("Value>>>>" + value));
        valueMax.ifPresent(value -> System.out.println("Value>>>>" + value));

        // Sum
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        // Average
        double average = list.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println(average);

        // sorted
        List<Integer> sortList = list.stream().distinct().sorted().toList();
        System.out.println(sortList);

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "A");
        hashMap.put(2, "B");
        hashMap.put(3, "C");
        hashMap.put(4, "D");
        hashMap.put(5, "E");
        hashMap.put(6, "F");

        for (Map.Entry<Integer, String> newMap : hashMap.entrySet()) {

            System.out.println("Key:" + newMap.getKey() + " Value:" + newMap.getValue());
        }

        // Get the key with value greater than 3
        Map<Integer, String> filterMap = hashMap.entrySet().stream().filter(entry -> entry.getKey() > 3).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(filterMap);
    }

    public void productCompare() {
        ArrayList<Product> productsList = new ArrayList<>();
        productsList.add(new Product(1, "Laptop", 80000, "Electronics"));
        productsList.add(new Product(1, "Laptop", 20000, "Electronics"));
        productsList.add(new Product(1, "Laptop", 60000, "Electronics"));
        productsList.add(new Product(1, "Laptop", 70000, "Electronics"));
        productsList.add(new Product(1, "Laptop", 40000, "Electronics"));
        productsList.add(new Product(1, "Laptop", 30000, "Electronics"));

        List<Product> prod = productsList.stream().sorted(Comparator.comparingInt(Product::getPrice).reversed()).collect(Collectors.toList());
        System.out.println(prod);

    }

    public void statementReverse() {
        String str = "This is first reverse";
        String str2 = Arrays.stream(str.split(" ")).collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
            Collections.reverse(list);
            return list;
        })).stream().collect(Collectors.joining(" "));

        System.out.println(str2);
    }

    public void occuranceCharacter() {
        String str = "Reverse";
        Map<Character, Long> charCount = str.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        charCount.forEach((k, v) -> System.out.println("K>>>>>" + k + " Value>>>>>" + v));
    }

    public int indexOfTheFirstOccurrenceOfStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public List<String> getDataStartWith(String a) {
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("America");
        arrayList.add("Ahemdabad");
        arrayList.add("Mumbai");
        arrayList.add("Amrutsar");
        arrayList.add("Manipur");

        Predicate<String> predicate = n -> n.startsWith(a);

        return arrayList.stream().filter(predicate).collect(Collectors.toList());
    }

    public int sumOfList() {
        List<Integer> arraInt = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                22, 23, 24, 25, 26, 27, 28, 29, 30);
        return arraInt.stream().mapToInt(Integer::intValue).sum();
    }

    public Character occuranceOfUsingForLoop(String str) {
        Map<Character, Integer> strMap = new HashMap();
        int tempValue = -1;
        Character longStr = null;
        for (char a : str.toCharArray()) {
            int value = strMap.getOrDefault(a, 0);
            if (value > tempValue) {
                longStr = a;
                tempValue = value;
            }
            strMap.put(a, strMap.getOrDefault(a, 0) + 1);
        }
        strMap.forEach((key, value) -> System.out.println("K>>>>>" + key + " value>>>" + value));
        return longStr;
    }

    public void occuranceOfTheStringStream(String str) {
        Map<Character, Long> charCount = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        charCount.forEach((key, value) -> System.out.println("K>>>>>" + key + " value>>>" + value));
    }

    public void stringsStartWithOvel() {
        List<String> arrList = Arrays.asList("Amar", "Girish", "Akshay", "Naman", "Omkar", "Uttam");
        Predicate<String> predicate = n -> n.matches("^[AEIOUaeiou].*");
        List<String> newArr = arrList.stream().filter(predicate).collect(Collectors.toList());
        newArr.forEach(c -> System.out.println(c));
    }

    public void reverseSentence() {
        String str = "This is my first reverse string with Stream API";

        /*
         * String newStr = Arrays.stream(str.split(" "))
         * .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
         * Collections.reverse(list); return list;
         * })).stream().collect(Collectors.joining(" "));
         */
        String newStr = Arrays.stream(str.split(" "))
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.reverse(list);
                    return list;
                })).stream().collect(Collectors.joining(" "));
        System.out.println(newStr);
    }

    public void countOfWordsInSentence() {
        String str = "I am a java developer";
        Map<String, Integer> newStr = Arrays.stream(str.split(" ")).collect(Collectors.toMap(c -> c, String::length));
        System.out.println(newStr);
    }

    // Find Common Elements:
    // Given two lists of integers, find the common elements using streams.
    public void commonElementsFromTwoArray() {
        List<Integer> list1 = Arrays.asList(3, 6, 4, 9, 2, 7);
        List<Integer> list2 = Arrays.asList(0, 3, 1, 9, 2, 5);

        List<Integer> list3 = list1.stream().filter(list2::contains).distinct().toList();
        System.out.println("List>>>>>>" + list3);
    }

    // Top N Elements:
    // Find the top 3 largest numbers in a list using sorted() and limit()
    public void nLargestNumber() {
        List<Integer> list1 = Arrays.asList(1, 3, 6, 4, 9, 2, 7);
        List<Integer> list2 = list1.stream().sorted((a, b) -> b - a).limit(3).collect(Collectors.toList());
        System.out.println("List>>>>>>" + list2);
    }

    // add array and calculate avarage
    public void calculateAvg() {
        List<Integer> list1 = Arrays.asList(3, 6, 4, 9, 2, 7);
        double sumNum = list1.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average>>>>>>" + sumNum);
    }

    // even number, odd number
    public void evenOrOddNum() {
        List<Integer> list1 = Arrays.asList(3, 6, 4, 9, 2, 7);
        List<Integer> list2 = list1.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        List<Integer> list3 = list1.stream().filter(n -> n % 2 == 1).collect(Collectors.toList());
        System.out.println("Even>>>>>>" + list2);
        System.out.println("Odd>>>>>>" + list3);
    }

    // remove duplicate elements
    public void duplicateElements() {
        List<Integer> list1 = Arrays.asList(3, 6, 4, 9, 2, 7, 3, 9, 4);
        List<Integer> list2 = list1.stream().distinct().collect(Collectors.toList());
        System.out.println("Duplicate>>>>>>" + list2);
    }

    // Count String Which Starts With Specific Letter
    public void startsWithSpecificCharCount() {
        List<String> arrList = Arrays.asList("Amar", "Girish", "Akshay", "Naman", "Omkar", "Uttam");
        Long count = arrList.stream().filter(n -> n.toLowerCase().startsWith("a")).collect(Collectors.counting());
        System.out.println("Count>>>>>>" + count);
    }

    // min max from list
    public void minMaxOfList() {
        List<Integer> list1 = Arrays.asList(3, 6, 4, 9, 2, 7);
        Optional<Integer> min = list1.stream().min(Integer::compareTo);
        Optional<Integer> max = list1.stream().max(Integer::compareTo);

        // If a value is present, isPresent() returns true and get() returns the value.
        // Additional methods that depend on the presence or absence of a contained
        // value are provided,
        // such as orElse() (returns a default value if no value is present)
        // and ifPresent() (performs an action if a value is present).
        min.ifPresent(value -> System.out.println("Minimum: " + value));
        max.ifPresent(value -> System.out.println("Maximum: " + value));
    }

    // square given number array
    public void squareOfArray() {
        List<Integer> list1 = Arrays.asList(3, 6, 4, 9, 2, 7, 3, 9, 4);
        List<Integer> list2 = list1.stream().map(n -> n * n).sorted().distinct().collect(Collectors.toList());
        System.out.println("Square List>>>>>>" + list2);
    }

    // Filter by Property:
    // Given a list of Employee objects (name, age, salary), filter out employees
    // with a salary greater than a given amount.
    public void filterEmployeeBySalaryGreater() {
        List<Employee> empList = Arrays.asList(new Employee(1, "A", 12), new Employee(2, "C", 11),
                new Employee(3, "G", 15), new Employee(4, "T", 19), new Employee(5, "H", 14), new Employee(6, "O", 12),
                new Employee(7, "G", 17));

        List<Employee> salaryList = empList.stream().filter(emp -> emp.getSalary() >= 15).collect(Collectors.toList());
        System.out.println(salaryList);
    }

    // Sort by Multiple Fields:
    // Sort a list of Product objects (id, name, price) first by price in ascending
    // order and then by name in alphabetical order.
    public void sortBySalaryAndName() {
        List<Employee> empList = Arrays.asList(new Employee(1, "A", 12), new Employee(2, "C", 11),
                new Employee(3, "G", 15), new Employee(4, "T", 19), new Employee(5, "H", 14), new Employee(6, "O", 12),
                new Employee(7, "G", 17));
        List<Employee> salaryList = empList.stream().sorted((e1, e2) -> {
            int salary = Integer.compare(e1.getSalary(), e2.getSalary());
            if (salary == 0) {
                return e1.getName().compareTo(e2.getName());
            }
            return salary;
        }).collect(Collectors.toList());

        // Or

        List<Employee> salaryList2 = empList.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed().thenComparing(Employee::getName))
                .collect(Collectors.toList());

        List<Employee> nameList = empList.stream()
                .sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary))
                .collect(Collectors.toList());

        System.out.println(salaryList);

        System.out.println(salaryList2);

        System.out.println(nameList);
    }

    // Find max salary
    public void getHighestSalarisedEmployee() {
        List<Employee> empList = Arrays.asList(new Employee(1, "A", 12), new Employee(2, "C", 11),
                new Employee(3, "G", 15), new Employee(4, "T", 19), new Employee(5, "H", 14), new Employee(6, "O", 12),
                new Employee(7, "G", 17));

        Optional<Employee> salaryList = empList.stream()
                .max((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
        salaryList.ifPresent(System.out::println);
    }

    // How do you find frequency of each element in an array or a list?
    public void countFrequencyOfEachElement() {
        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler",
                "Note Book", "Pencil");

        Map<String, Long> stationeryCountMap = stationeryList.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        System.out.println(stationeryCountMap);
    }

    // flat map
    public void flatMapExample() {
        List<String> sentences = Arrays.asList("Hello world", "Java Stream API", "flatMap example");
        List<String> words = sentences.stream().flatMap(sen -> Arrays.stream(sen.split(" ")))
                .collect(Collectors.toList());
        System.out.println(words);
    }

    // reverse String
    public void reverseString() {
        String str1 = "Girish";
        String str2 = "";
        int i = str1.toCharArray().length - 1;
        for (char c : str1.toCharArray()) {
            str2 = str2 + str1.charAt(i);
            i--;
        }
        System.out.println(str2);
    }

    int temp = 0;

    public int leetCode(int x) {
        int remainder = x % 10;
        x = x / 10;
        if (temp > Integer.MAX_VALUE / 10 || (temp == Integer.MAX_VALUE / 10 && remainder > 7)
                || temp < Integer.MIN_VALUE / 10 || (temp == Integer.MIN_VALUE / 10 && remainder < -8)) {
            return 0;
        }

        temp = temp * 10 + remainder;

        if (x != 0)
            leetCode(x);
        return temp;
    }

    public boolean isValid() {

        String s = "(])";
        if (s.startsWith(")") || s.startsWith("]") || s.startsWith("}")) {
            return false;
        }
        Map<Character, Character> matchingPairs = Map.of('(', ')', '[', ']', '{', '}');

        Stack<Character> stack = new Stack<Character>();
        for (char chr : s.toCharArray()) {
            if (chr == '(' || chr == '[' || chr == '{') {
                stack.push(chr);
            } else {
                if (stack.isEmpty() || chr != matchingPairs.get(stack.peek())) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public void removeDuplicateFromList() {

        int[] num = {3, 6, 4, 9, 2, 7, 3};

        List<int[]> list3 = Arrays.asList(num).stream().collect(Collectors.toList());
        System.out.println("List>>>>>>" + list3.size());
    }
}
