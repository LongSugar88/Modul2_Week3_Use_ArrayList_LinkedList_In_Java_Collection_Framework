
public class ProductManagerByArrayList {
    private int capacity;
    private Object[] productList;
    private int currentSize;

    public ProductManagerByArrayList(int size){
        productList =  new Object[size];
        this.capacity = size;
    }

    public boolean isEmpty(){
        return currentSize == capacity;
    }
    public void ensureCapacity(){
        if(currentSize == capacity){
            int newCapacity = capacity*2;
           Object[] newList = new Object[newCapacity];
            for(int i=0; i<currentSize; i++){
                newList[i] = productList[i];
            }
            productList = newList;
        }
    }
    public void push(Product element) {
        ensureCapacity();
        productList[currentSize] = element;
        currentSize++;
    }
    public Product pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Product is empty");
        }
        Object token = productList[currentSize-1];
        productList[currentSize-1] = null;
        currentSize--;
        return (Product)token;
    }
    public Product peek(int index) throws Exception {
        if(isEmpty()){
            throw new Exception("Product is empty");
        } else if( index >= currentSize || index<0){
            throw new Exception("Product unavailable");
        }
        return (Product) productList[index];
    }
    public int getIndex(Product element){
        for(int i=0; i<currentSize; i++){
            if(element == productList[i]){
                return i;
            }
        }
        return -1;
    }
    public void setProductByID(int id, String newName, double newPrice) throws Exception {
        for(int i=0; i<currentSize; i++){
            if(peek(i).getID() == id){
                peek(i).setName(newName);
                peek(i).setPrice(newPrice);
                break;
            }
        }
    }
    public void removeProductByID(int id) throws Exception {
        for(int i=0; i<currentSize; i++){
            if(peek(i).getID() == id){
                remove(i);
                currentSize--;
                break;
            }
        }
    }
    public void showProduct() throws Exception {
        for(int i=0; i<currentSize; i++){
            System.out.println(peek(i).ID + " "+ peek(i).name+ " "+ peek(i).price + "\n");
        }
    }
    public String findProductByNameD(String name) throws Exception {
        for(int i=0; i<currentSize; i++){
            if(peek(i).getName().equalsIgnoreCase(name)){
                String m = peek(i).getName();
                return peek(i).ID + " "+ peek(i).name+ " "+ peek(i).price + "\n";
            }
        }
        throw new Exception("Cant find product");
    }
    public void sortByPriceLowToHight() throws Exception {
        for(int i=0; i<currentSize-1; i++){
            for(int j=0; j< currentSize-1; j++){
                if(peek(j).getPrice() > peek(j+1).getPrice()){
                    Object token;
                    token = productList[j];
                    productList[j] = productList[j+1];
                    productList[j+1] = token;
                }
            }
        }
    }
    public void sortByPriceHightToLow() throws Exception {
        for(int i=0; i<currentSize-1; i++){
            for(int j=0; j< currentSize-1; j++){
                if(peek(j).getPrice() < peek(j+1).getPrice()){
                    Object token;
                    token = productList[j];
                    productList[j] = productList[j+1];
                    productList[j+1] = token;
                }
            }
        }
    }
    public int size(){
        return currentSize;
    }
    public void remove(int index) throws Exception {
        if(isEmpty()){
            throw new Exception("Product is empty");
        } else if( index >= currentSize){
            throw new Exception("Product unavailable");
        }
        if (currentSize - index >= 0) System.arraycopy(productList, index - 1, productList, index, currentSize - index);
        productList[currentSize-1] = null;
    }
}
