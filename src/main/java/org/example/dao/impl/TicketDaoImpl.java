package org.example.dao.impl;

import org.example.dao.AbstractDao;
import org.example.dao.TicketDao;
import org.example.model.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory factory) {
        super(factory, Ticket.class);
    }
}
