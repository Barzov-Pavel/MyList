package list;

public class Test {
    public static void main(String[] args) {
//        MyList<Integer> list = new MyLinkedList<>();
        MyList<Integer> list = new MyArrayList<>();

        for (int i = 10; i < 21; i++) {
            list.add(i);
        }
        System.out.println(list);
        System.out.println(list.size());
        list.delete(5);
        System.out.println(list.size());
        System.out.println(list);
    }
}
