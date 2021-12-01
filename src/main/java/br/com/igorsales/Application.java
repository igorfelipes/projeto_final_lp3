package br.com.igorsales;

import br.com.igorsales.dao.AlunoDao;
import br.com.igorsales.dao.AlunoDaoImpl;
import br.com.igorsales.dao.TurmaDaoImpl;
import br.com.igorsales.model.Aluno;
import br.com.igorsales.model.Turma;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("Running...");

        AlunoDaoImpl alunoDao = new AlunoDaoImpl();

        Aluno aluno1 = new Aluno();

        aluno1.setEmail("aluno1@mail.com");
        aluno1.setNome("Aluno1");

        alunoDao.save(aluno1);

        Aluno aluno2 = new Aluno();

        aluno2.setEmail("aluno2@mail.com");
        aluno2.setNome("Aluno2");

        alunoDao.save(aluno2);

        List<Aluno> alunos =alunoDao.getAll();

        System.out.println("--------------ALUNOS------------");
        for(Aluno aluno : alunos){
            System.out.println(aluno);
        }

        TurmaDaoImpl turmaDao = new TurmaDaoImpl();

        Turma turma1 = new Turma();
        turma1.setDescricao("Turma de sistemas da informação");
        turma1.getAlunos().add(aluno1);
        turma1.getAlunos().add(aluno2);

        turmaDao.save(turma1);

        System.out.println("add turma" + turma1.toString());

        List<Turma> turmas = turmaDao.getAll();

        System.out.println("--------------TURMAS------------");
        for(Turma turma : turmas){
            System.out.println(turma);
        }

        alunoDao.deleteById(aluno1.getId());
        alunos =alunoDao.getAll();
        System.out.println("--------------ALUNOS------------");
        for(Aluno aluno : alunos){
            System.out.println(aluno);
        }

    }
}
