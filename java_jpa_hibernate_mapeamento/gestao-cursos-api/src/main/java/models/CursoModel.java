package models;

import entities.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class CursoModel {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public void create(Curso curso) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao criar um curso: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Curso findById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Curso.class, id);
        } finally {
            em.close();
        }
    }

    public List<Curso> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("FROM Curso", Curso.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(Curso curso) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao atualizar o curso: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void delete(Curso curso) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Curso cursoRemover = em.find(Curso.class, curso.getId());
            if (cursoRemover != null) {
                em.remove(cursoRemover);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao remover o curso: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
