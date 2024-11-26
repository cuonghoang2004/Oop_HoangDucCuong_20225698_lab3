package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final DigitalVideoDisc[] dvds;
    private int qtyOrdered;
  
    public Cart() {
        dvds = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
        qtyOrdered = 0;
    }
  
    // Add a DVD to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            dvds[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("NTH-The DVD \"" + disc.getTitle() + "\" has been successfully added to the cart.");
        } else {
            System.out.println("NTH-The cart is full.");
        }
    }
    public int addDigitalVideoDisc(DigitalVideoDisc... dvdArray) {
        int addCount = 0;
        for (DigitalVideoDisc disc : dvdArray) {
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is almost full. Can't add more discs");
                break;
            } else {
                dvds[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("The DVD " + '\"' + disc.getTitle() + '\"' + " has been added!");
                addCount++;
            }
        }
        return addCount;
    }
    //Ham them 2 dia DVD
    public int addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 1 >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full. Can't add more discs");
            return 0;
        } else {
            dvds[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("The DVD " + '\"' + dvd1.getTitle() + '\"' + " has been added!");

            dvds[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("The DVD " + '\"' + dvd2.getTitle() + '\"' + " has been added!");

            return 2; //Tra ve so dia DVD da them duoc
        }
    }
    // Remove a DVD from the cart
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (dvds[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    dvds[j] = dvds[j + 1];
                }
                dvds[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("NTH-The disc \"" + disc.getTitle() + "\" has been removed from the cart.");
                return;
            }
        }
        System.out.println("NTH-DVD not found in the cart.");
    }
  
    // Calculate the total cost of DVDs in the cart
    public float totalCost() {
        float totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            totalCost += dvds[i].getCost();
        }
        return totalCost;
    }
  
    public void print() {
        StringBuilder output = new StringBuilder("*********************CART************************** \nOrdered items: \n");
        for (int i = 0; i < qtyOrdered; i++) {
            output.append(i + 1)
                  .append(". [")
                  .append(dvds[i].getTitle())
                  .append("] - [")
                  .append(dvds[i].getCategory())
                  .append("] - [")
                  .append(dvds[i].getDirector())
                  .append("] - [")
                  .append(dvds[i].getLength())
                  .append("]: ")
                  .append(dvds[i].getCost())
                  .append(" $\n");
        }
        output.append("total: ").append(totalCost()).append(" $\n");
        output.append("***************************************************\n");
        System.out.println(output);
    }
    
    public void searchById(int i) {
        if(i > qtyOrdered) {
            System.out.println("No match found !");
        } else {
            System.out.println("Result: " +  "[" + dvds[i-1].getTitle() +
                    "] - [" + dvds[i-1].getCategory() + "] - ["
                    + dvds[i-1].getDirector() + "] - ["
                    + dvds[i-1].getLength() + "]: " +dvds[i-1].getCost() + " $\n");
        }

    }

    public void searchByTitle(String title) {
        for(int i = 0;i < qtyOrdered; i++) {
            if(dvds[i].getTitle().equals(title)) {
                System.out.println("Result: " +  "[" + dvds[i].getTitle() +
                        "] - [" + dvds[i].getCategory() + "] - ["
                        + dvds[i].getDirector() + "] - ["
                        + dvds[i].getLength() + "]: " +dvds[i].getCost() + " $\n");
                return;
            }
        }
        System.out.println("No match found !");
    }
}
