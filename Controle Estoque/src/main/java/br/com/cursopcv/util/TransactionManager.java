package br.com.cursopcv.util;

import javax.persistence.EntityManager;

public interface TransactionManager {

    void startTransaction();

    void commitTransaction();

    void rollbackTransaction();

    void close();

    EntityManager getEntityManager();
}
