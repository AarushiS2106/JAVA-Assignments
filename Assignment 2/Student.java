class Student {
    int rollNo;
    String name;

    Student() {
        rollNo = 0;
        name = "Unknown";
    }

    Student(int r, String n) {
        rollNo = r;
        name = n;
    }

    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
    }

    public static void main(String args[]) {
        Student s1 = new Student();
        Student s2 = new Student(101, "Aarushi");

        s1.display();
        s2.display();
    }
}