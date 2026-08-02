class Mobile {
    String brand;
    int price;

    Mobile() {
        brand = "Google Pixel 9A";
        price = 45000;
    }

    Mobile(String b, int p) {
        brand = b;
        price = p;
    }

    Mobile(Mobile m) {
        brand = m.brand;
        price = m.price;
    }

    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
    }

    public static void main(String args[]) {
        Mobile m1 = new Mobile();
        Mobile m2 = new Mobile("OnePlus", 35000);
        Mobile m3 = new Mobile(m2);

        m1.display();
        m2.display();
        m3.display();
    }
}