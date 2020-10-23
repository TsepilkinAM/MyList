package Classes;

public class MyList {
    class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String toString() {
            return Integer.toString(this.value);
        }

        public boolean hasNext() {
            return (this.next != null ? true : false);
        }
    }

    Node begin;
    long length;

    public MyList() { // Ссылка на первый элемент
        this.begin = null;
        this.length = 0;
    }

    public void add(int value) { //Добавление элемента в список
        if (this.begin == null) {
            this.begin = new Node(value);
        } else {
            this.end().setNext(new Node(value));
        }
        this.length++;
    }

    public Node end() { //Ссылка на последний элемент
        if (this.begin == null)
            return null;
        // в iter лежит первый элемент, с помощью iter идем по ссылкам, пока не дойдем до последнего

        Node iter = this.begin;
        while (iter.hasNext()) {
            iter = iter.getNext();//возвращает ссылку
        }
        return iter;
    }

    public String toString() {  //Превращение нашего списка в строку
        String result = "[ ";
        if (this.begin != null) {
            Node iter = this.begin;
            while (iter.hasNext()) {
                result += iter.toString() + ", ";
                iter = iter.getNext();
            }
            result += iter.toString() + " ";
        }
        result += "]";
        return result;
    }

    public void swap (int firstPoth, int secondPoth){
        Node preFirst = indexAt(firstPoth - 1);
        Node First = indexAt(firstPoth);
        Node aftFerst = indexAt(firstPoth + 1);
        Node preSecond = indexAt(secondPoth -1);
        Node Second = indexAt(secondPoth);
        Node aftSecond = indexAt(secondPoth + 1);

        if (preFirst != null) {
            preFirst.setNext(Second);
        }
        else {
            this.begin = Second;
        }
        First.setNext(aftSecond);
        if (preFirst == First) {
            Second.setNext(First);
        }
        else {
            Second.setNext(aftFerst);
            preSecond.setNext(First);
        }
    }

    public Node indexAt(int index) {
        Node iter = this.begin;
        if (0 <= index && index <= this.length) {

            for (int i = 0; i < index; ++i) {
                iter = iter.getNext();
            }
            return iter;
        } else {
            return null;
        }
    }

    public void sort() {
        long length = this.length;
        int i;
        int j;
        Node a;
        Node b;
        while (length > 0) {
            i = 0;
            j = 1;
            a = indexAt(i);
            b = indexAt(j);
            while (j < length) {
                if (a.getValue() > b.getValue()) {
                    swap(i,j);
                    i += 1;
                    j += 1;
                    a = indexAt(i);
                    b = indexAt(j);
                }
                else if (a.getValue() <= b.getValue()) {
                    ++i;
                    ++j;
                    a = a.getNext();
                    b = b.getNext();
                }
            }
        }
    }
}



