package atividade02;

import java.util.List;

public class Professor extends Pessoa{

    private String matricula;
    private List<String> disciplinas;
    private boolean situacao;


    public void alterarSituacao(){
        if(isSituacao()){
            setSituacao(false);
        } else {
            setSituacao(true);
        }
    }

    public void consultaDisciplina(){
        for(String disciplina : this.disciplinas){
            System.out.println(disciplina);
        }
    }

    public void cadastraDisciplina(String nome){
        this.disciplinas.add(nome);
        System.out.println("Disciplina adcionada");
    }

    public void mostraSituacao(){
        if(isSituacao()){
            System.out.println("Professor " + getNome() + " está [ ATIVO ]");
        } else {
            System.out.println("Professor " + getNome() + " está [ INATIVO ]");
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<String> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<String> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
}
