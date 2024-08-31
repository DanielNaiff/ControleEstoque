package br.com.cursopcv.testes;

import br.com.cursopcv.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RemocaoDeProduto {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ControleEstoque");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();
            Produto produto = em.find(Produto.class, 3L);
            if (produto != null) {
                em.remove(produto);
                System.out.println("Produto removido com sucesso!");
            } else {
                System.out.println("Produdo com id 3 nao encontrado");
            }
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {

            em.close();
            emf.close();
        }
    }
}
