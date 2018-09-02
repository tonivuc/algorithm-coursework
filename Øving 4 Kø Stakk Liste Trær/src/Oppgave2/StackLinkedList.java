package Oppgave2;

public class StackLinkedList {

    private int total;

    private Node first;

    private class Node {
        private char parantes;
        private Node next;
    }

    public StackLinkedList() { }

    public StackLinkedList push(char parantes)
    {
        Node current = first; //Lag ny node og la den referere til den øverste i stacken
        first = new Node(); //Sett første element i stacken til å være ny node
        first.parantes = parantes; //Sett den nye nodens parantes til å være parantesen vi sender inn med push
        first.next = current; //Link den nye noden opp med noden under
        total++;
        return this; //Returner den nye StackLinkedList som inneholder ny node.
    }

    public char pop()
    {
        if (first == null) new java.util.NoSuchElementException(); //Hvis første element ikke eksisterer gi error
        char parantes = first.parantes;
        first = first.next; //Sett noden under til å være øverst
        total--;
        return parantes; //Returner parantesen til noden vi poppet (fjernet)
    }

    public char peek() {
        if (first.parantes != ' ') {

        }
        return first.parantes;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Node tmp = first;
        while (tmp != null) {
            sb.append(tmp.parantes).append(", ");
            tmp = tmp.next;
        }
        return sb.toString();
    }

}
