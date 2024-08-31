package br.com.cursopcv.testes;

import br.com.cursopcv.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AlteracaoDeProduto {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ControleEstoque");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            Produto produto = em.find(Produto.class, 2L); // O ID do produto é 2
            if (produto != null) {
                produto.setPreco(345.00);
                em.merge(produto);
            }

            transaction.commit();
            System.out.println("Produto alterado com sucesso!");

        } catch (Exception e) {
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
