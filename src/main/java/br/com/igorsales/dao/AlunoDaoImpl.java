/**
 *
 */
package br.com.igorsales.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.bank.util.JPAUtil;
import br.com.igorsales.dao.AlunoDao;
import br.com.igorsales.model.Aluno;

/**
 * @author Igor Sales
 *
 */
public class AlunoDaoImpl implements AlunoDao {

    @Override
    public Aluno getById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {

            Aluno aluno = entityManager.find(Aluno.class, id);

            return aluno;

        }catch (NoResultException e) {
            e.getMessage();
            entityManager.close();
        }

        return null;
    }

    @Override
    public List<Aluno> getAll() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {


            List<Aluno> clients = entityManager.createNamedQuery("Aluno.getAll", Aluno.class)
                    .getResultList();

            return clients;

        } catch (Exception e) {
            e.getMessage();
        }

        return null;
    }

    @Override
    public void save(Aluno aluno) {

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {

            entityManager.persist(aluno);
            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Override
    public void update(Long id, Aluno newAluno) {

        Aluno aluno = getById(id);
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {

            aluno.setNome(newAluno.getNome());
            aluno.setEmail(newAluno.getEmail());

            entityManager.merge(aluno);
            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Override
    public void deleteById(Long id) {

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {
            Aluno aluno =  entityManager.createNamedQuery("Aluno.getById",Aluno.class)
                    .setParameter("id", id)
                    .getSingleResult();
            entityManager.remove(aluno);
            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            e.getMessage();
        }

    }

}
