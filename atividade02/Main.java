package atividade02;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Aluno> listaAlunos = new ArrayList<Aluno>();
    static List<Professor> listaProfessores = new ArrayList<Professor>();
    static String[] disciplinas = {"Matematica", "Português", "Geografia", "Quimica", "Historia"};

    public static void main(String[] args) {
        criarNovoAluno("Joazinho", "Matematica");
        criarNovoAluno("Fulano", "Matematica");
        criarNovoAluno("Maria", "Português");

        criarNovoProfessor("Alfredo Lisboa", "A123", "001.002.003-11");
        criarNovoProfessor("Monica Maria", "A303", "004.005.006-12");
        criarNovoProfessor("Tadeu Paulista", "A203", "007.008.009-13");


        listarAlunos();
        listarProfessores();
        
        //TODO



    }

    public static void criarNovoAluno(String nomeAluno, String disciplina){
        Aluno aluno = new Aluno(nomeAluno, disciplina);
        listaAlunos.add(aluno);
        System.out.println("Aluno adcionando !");
    }

    public static void criarNovoProfessor(String nome, String matricula, String cpf){
        Professor professor = new Professor(nome, matricula, cpf);
        listaProfessores.add(professor);
    }

    public static void listarAlunos(){
        for(Aluno aluno: listaAlunos){
            System.out.println(aluno);
        }
    }

    public static void listarProfessores(){
        for(Professor professor: listaProfessores){
            System.out.println(professor);
        }
    }

}
