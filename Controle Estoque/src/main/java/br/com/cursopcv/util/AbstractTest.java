package br.com.cursopcv.util;

public abstract class AbstractTest {

    protected TransactionManager transactionManager;

    public AbstractTest() {
        this.transactionManager = new TransactionManagerImpl();
    }

    public abstract void runTest();

    public void execute() {
        try {
            transactionManager.startTransaction();
            runTest();
            transactionManager.commitTransaction();
        } catch (Exception e) {
            transactionManager.rollbackTransaction();
            e.printStackTrace();
        } finally {
            transactionManager.close();
        }
    }
}
