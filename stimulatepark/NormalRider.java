/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stimulatepark;

/**
 *
 * @author johnn
 */
class NormalRider extends Rider implements TicketPrice{
    private static double totalGate = 0;
    private double ticketPrice;
    
    public NormalRider(){}
    
    public NormalRider(int startOnlineTime)
    {
        super(startOnlineTime);
        setTicketPrice();
        setTotalGate();
    }
    
    public static double getTotalGate() { return totalGate; }
    @Override
    public double getTicketPrice() { return ticketPrice; }
    
    @Override
    public void setTicketPrice() { this.ticketPrice = BASEPRICE; }
    
    @Override
    public void setTotalGate() { totalGate += ticketPrice; }
}
