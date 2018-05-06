public class test {
    public static void main(String[] args){
        DoubleList<String> objectDoubleList = new DoubleList<>();
        objectDoubleList.add("hello");
        objectDoubleList.add("world");
        objectDoubleList.add("today");
        objectDoubleList.add("is");
        objectDoubleList.add("a");
        objectDoubleList.add("nice");
        objectDoubleList.add("day");
        System.out.println(objectDoubleList.getSize());
        objectDoubleList.insert(3,"first");
        System.out.println(objectDoubleList.toString());
        System.out.println(objectDoubleList.getSize());
        objectDoubleList.remove(2);
        System.out.println(objectDoubleList.toString());
        System.out.println(objectDoubleList.getSize());
        objectDoubleList.remove("world");
        System.out.println(objectDoubleList.toString());
        System.out.println(objectDoubleList.getSize());
    }
}

