
// class "Store"

package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.util.ArrayList;

public class Store {
    private final ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<>();

    public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
        itemsInStore.add(dvd);
        System.out.println("The DVD \"" + dvd.getTitle() + "\" has been added.");
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
        if (itemsInStore.remove(dvd)) {
            System.out.println("The DVD \"" + dvd.getTitle() + "\" has been removed.");
        } else {
            System.out.println("DVD \"" + dvd.getTitle() + "\" is not in the store.");
        }
    }

    public void printStorelist() {
        System.out.println("\n--- Store ---");
        if (itemsInStore.isEmpty()) {
            System.out.println("No DVDs in store.");
        } else {
            itemsInStore.forEach(dvd -> System.out.println(dvd));
        }
        System.out.println("-------------");
    }
}
