package br.com.cursopcv.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TransactionManagerImpl implements TransactionManager {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;

    public TransactionManagerImpl() {
        emf = Persistence.createEntityManagerFactory("ControleEstoque");
        em = emf.createEntityManager();
    }

    @Override
    public void startTransaction() {
        transaction = em.getTransaction();
        transaction.begin();
    }

    @Override
    public void commitTransaction() {
        if (transaction != null && transaction.isActive()) {
            transaction.commit();
        }
    }

    @Override
    public void rollbackTransaction() {
        if (transaction != null && transaction.isActive()) {
            transaction.rollback();
        }
    }

    @Override
    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && !emf.isOpen()) {
            emf.close();
        }
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
