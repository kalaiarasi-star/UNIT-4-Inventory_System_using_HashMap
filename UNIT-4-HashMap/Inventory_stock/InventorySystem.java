import java.util.*;

class Item {
    int id;
    String name;
    int qty;

    Item(int id, String name, int qty) {
        this.id = id;
        this.name = name;
        this.qty = qty;
    }

    void addStock(int q) {
        qty += q;
    }

    void removeStock(int q) {
        if (q > qty) {
            System.out.println("Not enough stock!");
        } else {
            qty -= q;
        }
    }

    void show() {
        System.out.println("ID: " + id + ", Name: " + name + ", Qty: " + qty);
    }
}

class Inventory {
    HashMap<Integer, Item> map = new HashMap<>();

    void addItem(Item i) {
        map.put(i.id, i);
    }

    void updateAdd(int id, int q) {
        if (map.containsKey(id)) {
            map.get(id).addStock(q);
        }
    }

    void updateRemove(int id, int q) {
        if (map.containsKey(id)) {
            map.get(id).removeStock(q);
        }
    }

    void showAll() {
        for (Item i : map.values()) {
            i.show();
        }
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        Inventory inv = new Inventory();

        inv.addItem(new Item(1, "Pen", 50));
        inv.addItem(new Item(2, "Book", 30));

        inv.updateAdd(1, 20);     
        inv.updateRemove(2, 10);  

        inv.showAll();
    }
}