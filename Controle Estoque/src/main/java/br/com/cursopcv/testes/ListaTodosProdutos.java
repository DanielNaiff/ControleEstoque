package br.com.cursopcv.testes;

import br.com.cursopcv.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ListaTodosProdutos {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ControleEstoque");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
            List<Produto> produtos = query.getResultList();

            System.out.println("Lista de produtos:");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }

            Produto produtoParaRemover = em.find(Produto.class, 3L);
            if (produtoParaRemover != null) {
                em.remove(produtoParaRemover);
                System.out.println("Produto com ID 3 removido com sucesso!");
            } else {
                System.out.println("Produto com ID 3 não encontrado.");
            }

            transaction.commit();

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
