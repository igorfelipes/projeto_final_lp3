package br.com.igorsales.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="turmas")
@NamedQuery(name="Turma.getAll", query = "select t from Turma t")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String descricao;


    @OneToMany(
            targetEntity = Aluno.class,
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    private Set<Aluno> alunos = new HashSet<Aluno>();


    public Turma() {
    }

    public Turma(Long id, String descricao, Set<Aluno> alunos) {
        this.id = id;
        this.descricao = descricao;
        this.alunos = alunos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", alunos=" + alunos +
                '}';
    }
}
