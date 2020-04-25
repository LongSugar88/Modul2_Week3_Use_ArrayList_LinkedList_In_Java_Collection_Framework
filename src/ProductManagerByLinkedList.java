public class ProductManagerByLinkedList {
    private Node<Product> head;
    private Node<Product> tail;
    private int currentSize;

    public ProductManagerByLinkedList(){
        this.head = null;
        this.tail = null;
    }
    public class Node<Product>{
        Product data;
        Node<Product> next;
        public Node(Product data){
            this.data = data;
            this.next = null;
        }
    }
    public void enqueue(Product element){
        Node<Product> newNode = new Node<>(element);
        if(head == null){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
            String m;
                    m= tail.data.getName();
        }
        currentSize++;
    }
    public Product dequeue() throws Exception{
        if(head == null){
            throw new Exception("Product is empty");
        }else {
            Node<Product> token;
            token = head;
            head = head.next;
            if(head == null){
                tail = null;
            }
            currentSize--;
            return token.data;
        }
    }
    public boolean isEmpty(){
        return currentSize==0;
    }
    public Product peek(int index){
        Node<Product> current = head;
        if(index == 0){
            return current.data;
        }
        for(int i=0; i<index; i++){
            current = current.next;
        }
        return current.data;
    }
    public int size(){
        return currentSize;
    }
    public void setProductByID(int id, String newName, double newPrice){
        Node<Product> token;
        token = head;
        if(token.data.getID() != id){
            for(int i=0; i<currentSize-1; i++){
                token = token.next;
                if(token.data.getID() == id){
                    break;
                }
            }
        }
        token.data.setName(newName);
        token.data.setPrice(newPrice);
    }
    public void removeProductByID(int id){
        Node<Product> previous = null;
        Node<Product> current = head;
        if(current.data.getID() == id){
            head = current.next;
        }
        else{
            for(int i=0; i<currentSize; i++){
                previous = current;
                current = current.next;
                if(current.data.getID() == id){
                    break;
                }
            }
        }
        previous.next = current.next;
        currentSize--;
    }
    public void showProduct() throws Exception {
        for(int i=0; i<currentSize; i++){
            System.out.println(peek(i).ID + " "+ peek(i).name+ " "+ peek(i).price + "\n");
        }
    }

}
