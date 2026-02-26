package com.parkinglot.fee;

import com.parkinglot.ticket.Ticket;

import java.time.LocalDateTime;

public interface FeeCalculator {
    double calculate(Ticket ticket, LocalDateTime exitTime);
}
