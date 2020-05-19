package org.edgar.neo.flyweight.ticket;

public class Test {

    public static void main(String[] args) {
        ITicket ticket = TicketFactory.queryTicket("A", "B");
        ticket.showInfo("硬卧");
    }
}
