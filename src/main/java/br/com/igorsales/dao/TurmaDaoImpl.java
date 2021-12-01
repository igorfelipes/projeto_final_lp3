/**
 *
 */
package br.com.igorsales.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.bank.util.JPAUtil;
import br.com.igorsales.model.Aluno;
import br.com.igorsales.model.Turma;

/**
 * @author Igor Sales
 *
 */
public class TurmaDaoImpl implements TurmaDao {

    @Override
    public Turma getById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {

            Turma turma = entityManager.find(Turma.class, id);

            return turma;

        }catch (NoResultException e) {
            e.getMessage();
            entityManager.close();
        }

        return null;
    }

    @Override
    public List<Turma> getAll() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {


            List<Turma> turmas = entityManager.createNamedQuery("Turma.getAll", Turma.class)
                    .getResultList();

            return turmas;

        } catch (Exception e) {
            e.getMessage();
        }

        return null;
    }

    @Override
    public void save(Turma turma) {

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {

            entityManager.persist(turma);
            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Override
    public void update(Long id, Turma newTurma) {

        Turma turma = getById(id);
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {

            turma.setDescricao(newTurma.getDescricao());
            turma.setAlunos(newTurma.getAlunos());

            entityManager.merge(turma);
            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            e.getMessage();
        }

    }


    @Override
    public void addAluno(Long id, Aluno aluno) {

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {
            Turma turma = getById(id);
            turma.getAlunos().add(aluno);
            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Override
    public void deleteById(Long id) {
        Turma turma = getById(id);

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {

            entityManager.remove(turma);
            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            e.getMessage();
        }

    }

}
