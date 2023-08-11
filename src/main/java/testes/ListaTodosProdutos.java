package testes;

import br.com.cursopcv.modelo.Produto;
import util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ListaTodosProdutos {
    public static void main(String[] args) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            List<Produto> produtos = em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();

            for (Produto produto : produtos) {
                System.out.println("Produto: " + produto.getNome() + " - Preço: " + produto.getPreco());
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao listar os produtos: " + e.getMessage());
        } finally {
            em.close();
            EntityManagerFactoryUtil.closeEntityManagerFactory();
        }
    }
}
