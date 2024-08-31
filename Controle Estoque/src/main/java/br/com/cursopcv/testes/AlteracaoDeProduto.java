package br.com.cursopcv.testes;

import br.com.cursopcv.modelo.Produto;
import br.com.cursopcv.util.AbstractTest;

public class AlteracaoDeProduto extends AbstractTest {

    @Override
    public void runTest() {
        Produto produto = transactionManager.getEntityManager().find(Produto.class, 2L);
        if (produto != null) {
            produto.setPreco(345.00);
            transactionManager.getEntityManager().merge(produto);
            System.out.println("Produto alterado com sucesso!");
        } else {
            System.out.println("Produto com ID 2 não encontrado.");
        }
    }

    public static void main(String[] args) {
        new AlteracaoDeProduto().execute();
    }
}
