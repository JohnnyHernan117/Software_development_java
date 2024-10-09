/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stimulatepark;

/**
 *
 * @author johnn
 */
class FastRider extends Rider implements TicketPrice {
    private static double totalGate = 0;
    private double ticketPrice;
    
    public FastRider(){}
    
    public FastRider(int startOnlineTime)
    {
        super(startOnlineTime);
        setTicketPrice();
        setTotalGate(); 
    }
    
    public static double getTotalGate() { return totalGate; }
    @Override
    public double getTicketPrice() { return ticketPrice; }
    @Override
    public void setTicketPrice() { this.ticketPrice = BASEPRICE * 1.4; }
    @Override
    public void setTotalGate() { totalGate += ticketPrice; }
}
