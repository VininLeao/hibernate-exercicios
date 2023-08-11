package testes;

import br.com.cursopcv.modelo.Produto;
import util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;

public class InclusaoDeProduto {
    public static void main(String[] args) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Produto prop1 = new Produto();
            prop1.setNome("Panela");
            prop1.setDescricao("Panela de Pressão 10 Litros");
            prop1.setPreco(56.80);
            em.persist(prop1);

            Produto prop2 = new Produto();
            prop2.setNome("Cama");
            prop2.setDescricao("Cama de casal Big");
            prop2.setPreco(450.68);
            em.persist(prop2);

            Produto prop3 = new Produto();
            prop3.setNome("Caixa Som");
            prop3.setDescricao("Caixa de Som JBL");
            prop3.setPreco(160.00);
            em.persist(prop3);

            em.getTransaction().commit();
            System.out.println("Produtos cadastrados com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao cadastrar os produtos: " + e.getMessage());
        } finally {
            em.close();
            EntityManagerFactoryUtil.closeEntityManagerFactory();
        }
    }
}
