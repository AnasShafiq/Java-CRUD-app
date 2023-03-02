import java.util.*;

class Employees implements Employee {
    private int eno;
    private String ename;
    private int esalary;
    Employees(int eno, String ename, int esalary ){
        this.ename=ename;
        this.eno=eno;
        this.esalary=esalary;
    }
    public int getEno(int eno) {
        return this.eno;
    }
    private int getEsalary() {
        return esalary;
    }
    public String getename() {
        return ename;
    }
    public String toString() {
        return eno+" "+ename+" "+esalary;
    }
}
public class Main {
    public static void main(String[] args) {
        List<Employee> c = new ArrayList<Employee>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1 for inserting new value");
            System.out.println("2 for displaying any value");
            System.out.println("3 for searching");
            System.out.println("4 for Deleting");
            System.out.println("5 for Updating");
            System.out.println("Enter your choice = ");
            choice = s.nextInt();
            int eno;
            Iterator<Employee> i;
            switch (choice) {
                case 1:
                    System.out.print("Enter Employees Number : ");
                    eno = s.nextInt();
                    System.out.print("Enter Employees Name : ");
                    String ename = s1.nextLine();
                    System.out.print("Enter Employees Salary : ");
                    int esalary = s.nextInt();
                    c.add(new Employees(eno, ename, esalary));
                    break;

                case 2:
                    System.out.println("-----------------------------");
                    i = c.iterator();
                    while (i.hasNext()) {
                        Employee e = i.next();
                        System.out.println(e);
                    }
                    System.out.println("+++++++++++++++++++++++++++++");
                    break;
                case 3:
                    boolean found = false;
                    System.out.println("Enter the Employees Number to search the records:");
                    eno = s.nextInt();
                    System.out.println("-----------------------------");
                    i = c.iterator();
                    while (i.hasNext()) {
                        Employee e = i.next();
                        if (e.getEno(eno) == eno) {
                            System.out.println(e);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("The record does not exists");
                    }
                    System.out.println("+++++++++++++++++++++++++++++");
                    break;
                case 4:
                    found = false;
                    System.out.println("Enter the Employees Number to Delete the records:");
                    eno = s.nextInt();
                    System.out.println("-----------------------------");
                    i = c.iterator();
                    while (i.hasNext()) {
                        Employee e = i.next();
                        if (e.getEno(eno) == eno) {
                            i.remove();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("The record does not exists");
                    }else {
                        System.out.println("The record was deleted successfully");
                    }
                    System.out.println("+++++++++++++++++++++++++++++");
                    break;
                case 5:
                    found = false;
                    System.out.println("Enter the Employees Number to Update the records:");
                    eno = s.nextInt();
                    System.out.println("-----------------------------");
                    ListIterator<Employee>li = c.listIterator();
                    while (li.hasNext()) {
                        Employee e = li.next();
                        if (e.getEno(eno) == eno) {
                            System.out.println("Enter the new name:");
                            ename = s1.nextLine();
                            System.out.println("Enter the new Salary :");
                            esalary = s.nextInt();
                            li.set(new Employees(eno,ename,esalary));
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("The record does not exists");
                    }else {
                        System.out.println("The record was Updated successfully");
                    }
                    System.out.println("+++++++++++++++++++++++++++++");
                    break;
            }
        }while(choice!=0);
    }
}