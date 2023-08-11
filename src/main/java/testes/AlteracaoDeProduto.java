package testes;

import br.com.cursopcv.modelo.Produto;
import util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;

public class AlteracaoDeProduto {
    public static void main(String[] args) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Produto produto = em.find(Produto.class, 2L);

            if (produto != null) {
                produto.setPreco(345.00);

                em.getTransaction().commit();
                System.out.println("Preço do produto alterado com sucesso!");
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao alterar o preço do produto: " + e.getMessage());
        } finally {
            em.close();
            EntityManagerFactoryUtil.closeEntityManagerFactory();
        }
    }
}

