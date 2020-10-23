package Classes;

public class Main_1 {

    public  static  void main(String[] args) {
        MyList myList = new MyList();
        myList.add(12);
        myList.add(1);
        myList.add(5);
        myList.add(7);
        myList.add(9);
        myList.add(10);
        System.out.println(myList);
        System.out.println(myList.indexAt(2).toString());
        myList.swap(2,5);
        System.out.println(myList);
        myList.sort();
        System.out.println(myList);
    }
}
