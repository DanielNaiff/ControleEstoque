package br.com.cursopcv.testes;

import br.com.cursopcv.modelo.Produto;
import br.com.cursopcv.util.AbstractTest;

public class RemocaoDeProduto extends AbstractTest {

    @Override
    public void runTest() {
        Produto produto = transactionManager.getEntityManager().find(Produto.class, 3L);
        if (produto != null) {
            transactionManager.getEntityManager().remove(produto);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto com ID 3 não encontrado.");
        }
    }

    public static void main(String[] args) {
        new RemocaoDeProduto().execute();
    }
}