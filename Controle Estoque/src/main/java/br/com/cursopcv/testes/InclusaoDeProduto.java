package br.com.cursopcv.testes;

import br.com.cursopcv.modelo.Produto;
import br.com.cursopcv.util.AbstractTest;

public class InclusaoDeProduto extends AbstractTest {

    @Override
    public void runTest() {
        Produto panela = new Produto("Panela", "Panela de Pressão 10 Litros", 56.80);
        Produto cama = new Produto("Cama", "Cama de casal Big", 450.68);
        Produto caixaSom = new Produto("Caixa Som", "Caixa de Som JBL", 160.00);
        transactionManager.getEntityManager().persist(panela);
        transactionManager.getEntityManager().persist(cama);
        transactionManager.getEntityManager().persist(caixaSom);
        System.out.println("Produtos cadastrados com sucesso!");
    }
    public static void main(String[] args) {
        new InclusaoDeProduto().execute();
    }
}