public class MainTestArray {
    public static void main(String[] args) throws Exception {
        ProductManagerByArrayList myProduct = new ProductManagerByArrayList(10);
        Product product1 = new Product(1002, "SP1", 12000);
        Product product2 = new Product(1008, "SP2", 18000);
        Product product3 = new Product(1006, "SP3", 16000);
        Product product4 = new Product(2022, "SP4", 22000);
        Product product5 = new Product(3009, "SP5", 9000);
        Product product6 = new Product(3008, "SP6", 8000);

        myProduct.push(product1);
        myProduct.push(product2);
        myProduct.push(product3);
        myProduct.push(product4);
        myProduct.push(product5);

        myProduct.showProduct();
        myProduct.setProductByID(1006, "Sản phẩm 3", 30000);
        myProduct.setProductByID(3009,"Sản phẩm 5", 27000);
        myProduct.push(product6);
        myProduct.showProduct();
        myProduct.removeProductByID(3008);
        myProduct.showProduct();
        System.out.println(        myProduct.findProductByNameD("SP4"));
        System.out.println("----------------------------");
        myProduct.sortByPriceLowToHight();
        myProduct.showProduct();
        System.out.println("----------------------------");
        myProduct.sortByPriceHightToLow();
        myProduct.showProduct();


    }
}
