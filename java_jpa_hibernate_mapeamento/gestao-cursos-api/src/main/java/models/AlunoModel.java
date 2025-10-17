package models;

import entities.Aluno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class AlunoModel {

    public void create(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    //Esse mrtodo retorna um aluno pelo seu ID usando o metodo find do EntityManager
    public Aluno findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        Aluno aluno = null;
        try {
            aluno = em.find(Aluno.class, id);
        } finally {
            em.close();
        }
        return aluno;
    }

    //Buscar todos os alunos -> usamos uma consulta JPQL para retornar todos os alunos.
    public  List<Aluno> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        List<Aluno> alunos = null;
        try {
            alunos = em.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();
        } finally {
            em.close();
        }
        return alunos;
    }

    //Atualizar um aluno -> usamos o metodo merge dentro de uma transação
    public void update(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno atualizado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar aluno: " + e.getMessage());
        } finally {
            em.close();
        }

    }

    //Deletar um aluno -> primeiro buscamos o aluno e depois removemos dentro de uma transação.
    public void delete(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Aluno alunoParaRemover = em.find(Aluno.class, aluno.getId());
            if (alunoParaRemover != null) {
                em.remove(alunoParaRemover);
                System.out.println("Aluno removido com sucesso!");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erro ao remover aluno: " + e.getMessage());
        } finally {
            em.close();
        }
    }

}
