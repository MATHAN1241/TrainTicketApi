package MainAPP;

import java.util.HashMap;
import java.util.Map;

 class TrainTicketApp {
    private static final double TICKET_PRICE = 20.0;
    private static final Map<String, Ticket> tickets = new HashMap<>();

    public static void main(String[] args) {
        // API to submit a purchase for a ticket
    	System.out.println("Purchase Details:");
        submitPurchase("London", "France", "John Doe", "john.doe@example.com", "A");
        System.out.println("--------------");
        System.out.println("View Receipt: ");
        // API to view receipt details
        viewReceipt("John Doe");
        System.out.println("--------------");

        System.out.println("View User Section: ");
        // API to view users and seats by section
        viewUsersBySection("A");
        System.out.println("--------------");
        System.out.println("Remove User Section: ");
        // API to remove a user from the train
        removeUser("John Doe");
        System.out.println("--------------");
        System.out.println("Modify Seat User Section: ");
        // API to modify a user's seat
        modifySeat("Jane Doe", "B");
    }

    public static void submitPurchase(String from, String to, String userName, String userEmail, String section) {
        Ticket ticket = new Ticket(from, to, userName, userEmail, TICKET_PRICE, section);
        tickets.put(userName, ticket);
        System.out.println("Purchase successful. Receipt details:");
        System.out.println(ticket);
    }

    public static void viewReceipt(String userName) {
        Ticket ticket = tickets.get(userName);
        if (ticket != null) {
            System.out.println("Receipt details:");
            System.out.println(ticket);
        } else {
            System.out.println("User not found.");
        }
    }

    public static void viewUsersBySection(String section) {
        System.out.println("Users in Section " + section + ":");
        for (Ticket ticket : tickets.values()) {
            if (ticket.getSection().equalsIgnoreCase(section)) {
                System.out.println(ticket.getUserName() + " - Seat: " + ticket.getSection());
            }
        }
    }

    public static void removeUser(String userName) {
        if (tickets.containsKey(userName)) {
            tickets.remove(userName);
            System.out.println("User " + userName + " removed from the train.");
        } else {
            System.out.println("User not found.");
        }
    }

    public static void modifySeat(String userName, String newSection) {
        Ticket ticket = tickets.get(userName);
        if (ticket != null) {
            ticket.setSection(newSection);
            System.out.println("Seat for user " + userName + " modified to Section " + newSection);
        } else {
            System.out.println("User not found.");
        }
    }
}

class Ticket {
    private String from;
    private String to;
    private String userName;
    private String userEmail;
    private double pricePaid;
    private String section;

    public Ticket(String from, String to, String userName, String userEmail, double pricePaid, String section) {
        this.from = from;
        this.to = to;
        this.userName = userName;
        this.userEmail = userEmail;
        this.pricePaid = pricePaid;
        this.section = section;
    }

    public String getUserName() {
        return userName;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "From: " + from +
                ", To: " + to +
                ", User: " + userName +
                ", Email: " + userEmail +
                ", Price Paid: $" + pricePaid +
                ", Section: " + section;
    }
}

