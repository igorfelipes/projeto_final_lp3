package br.com.igorsales.dao;

import br.com.igorsales.model.Aluno;
import br.com.igorsales.model.Turma;

import java.util.List;



public interface TurmaDao {

    public Turma getById(Long idTurma);

    public List<Turma> getAll();

    public void addAluno(Long id, Aluno aluno);

    public void update(Long id, Turma turma);

    public void save(Turma turma);

    public void deleteById(Long idTurma);
}
