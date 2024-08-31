package br.com.cursopcv.testes;

import br.com.cursopcv.modelo.Produto;
import br.com.cursopcv.util.AbstractTest;

import javax.persistence.TypedQuery;
import java.util.List;

public class ListaTodosProdutos extends AbstractTest {

    @Override
    public void runTest() {
        TypedQuery<Produto> query = transactionManager.getEntityManager().createQuery("SELECT p FROM Produto p", Produto.class);
        List<Produto> produtos = query.getResultList();
        System.out.println("Lista de produtos:");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
        Produto produtoParaRemover = transactionManager.getEntityManager().find(Produto.class, 3L);
        if (produtoParaRemover != null) {
            transactionManager.getEntityManager().remove(produtoParaRemover);
            System.out.println("Produto com ID 3 removido com sucesso!");
        } else {
            System.out.println("Produto com ID 3 não encontrado.");
        }
    }
    public static void main(String[] args) {
        new ListaTodosProdutos().execute();
    }
}