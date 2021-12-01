package br.com.igorsales.dao;

import br.com.igorsales.model.Aluno;

import java.util.List;



public interface AlunoDao {

    public Aluno getById(Long idAluno);

    public List<Aluno> getAll();

    public void update(Long id, Aluno aluno);

    public void save(Aluno aluno);

    public void deleteById(Long idAluno);
}
