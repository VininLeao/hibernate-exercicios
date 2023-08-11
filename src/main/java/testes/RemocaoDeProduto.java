package testes;

import br.com.cursopcv.modelo.Produto;
import util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;

public class RemocaoDeProduto {
    public static void main(String[] args) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Produto produto = em.find(Produto.class, 3L);
            if (produto != null) {
                em.remove(produto);
                em.getTransaction().commit();
                System.out.println("O produto foi removido com sucesso!");
            } else {
                System.out.println("Produto não encontrado");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao remover o produto: " + e.getMessage());
        } finally {
            em.close();
            EntityManagerFactoryUtil.closeEntityManagerFactory();
        }
    }
}




