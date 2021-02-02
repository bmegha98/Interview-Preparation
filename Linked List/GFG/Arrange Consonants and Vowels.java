/*
Given a singly linked list of size N containing only English Alphabets. Your task is to complete the function arrangeC&V(), that arranges the consonants and vowel
nodes of the list it in such a way that all the vowels nodes come before the consonants while maintaining the order of their arrival.
*/

class Solution {
    
    public Node arrangeCV(Node head)
    {
        //write code here and return the head of changed linked list
        if(head == null || head.next == null)
            return head;
        Node Vow = new Node('1'),Cons = new Node('1');
        Node vowHead = Vow,consHead = Cons;
        while(head != null)
        {
            if(head.data == 'a'||head.data == 'e'||head.data == 'i'||head.data == 'o'||head.data == 'u')
            {
                Vow.next = head;
                Vow = Vow.next;
            }
            else
            {
                Cons.next = head;
                Cons = Cons.next;
            }
            head = head.next;
        }
        Cons.next = null;
        Vow.next = consHead.next;
        return vowHead.next;
    }
}
