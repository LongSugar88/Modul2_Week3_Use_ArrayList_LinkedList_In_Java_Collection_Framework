public class MainTestLinked {
    public static void main(String[] args) throws Exception {
        ProductManagerByLinkedList myProduct = new ProductManagerByLinkedList();
        Product product1 = new Product(1002, "SP1", 12000);
        Product product2 = new Product(1008, "SP2", 18000);
        Product product3 = new Product(1006, "SP3", 16000);
        Product product4 = new Product(2022, "SP4", 22000);
        Product product5 = new Product(3009, "SP5", 9000);
        Product product6 = new Product(3008, "SP6", 8000);


        myProduct.enqueue(product1);
        myProduct.enqueue(product2);
        myProduct.enqueue(product3);
        myProduct.enqueue(product4);
        myProduct.enqueue(product5);
        System.out.println("----------------------------");
        myProduct.showProduct();

        myProduct.dequeue();
        myProduct.dequeue();
        myProduct.removeProductByID(2022);
        System.out.println("----------------------------");
//        System.out.println("size :"+ myProduct.size());
        myProduct.showProduct();
    }
}
