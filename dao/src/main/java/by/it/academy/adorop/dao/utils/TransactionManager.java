package by.it.academy.adorop.dao.utils;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransactionManager {
    private Session session;
    private Transaction transaction;

    public void beginTransaction() {
        transaction = session.beginTransaction();
        transaction.begin();
    }

    public void commitTransaction() {
        session.flush();
        transaction.commit();
    }

    public void rollBackTransaction() {
        transaction.rollback();
    }

    public void setSession(Session session) {
        this.session = session;
        this.session.setFlushMode(FlushMode.MANUAL);
    }
}
