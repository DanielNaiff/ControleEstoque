package br.com.cursopcv.testes;

import br.com.cursopcv.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InclusaoDeProduto {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ControleEstoque");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            Produto panela = new Produto("Panela", "Panela de Pressão 10 Litros", 56.80);
            Produto cama = new Produto("Cama", "Cama de casal Big", 450.68);
            Produto caixaSom = new Produto("Caixa Som", "Caixa de Som JBL", 160.00);

            em.persist(panela);
            em.persist(cama);
            em.persist(caixaSom);

            transaction.commit();

            System.out.println("Produtos cadastrados com sucesso!");

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
