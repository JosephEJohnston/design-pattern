package ch5_Singleton;

public class TicketMaker {
    private int ticket = 1000;
    private static TicketMaker ticketMaker = new TicketMaker();
    private TicketMaker() {

    }
    public int getNextTicketNumber() {
        return ticket++;
    }

    public static TicketMaker getTicketMaker() {
        return ticketMaker;
    }

    public static void main(String[] args) {
        TicketMaker ticketMaker2 = getTicketMaker();
        TicketMaker ticketMaker1 = getTicketMaker();
        System.out.println(ticketMaker1.getNextTicketNumber());
        System.out.println(ticketMaker2.getNextTicketNumber());
        System.out.println(ticketMaker1.getNextTicketNumber());
        System.out.println(ticketMaker2.getNextTicketNumber());
    }
}
