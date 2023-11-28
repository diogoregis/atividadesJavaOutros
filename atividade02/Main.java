package atividade02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static int opcao;
    static List<Aluno> listaAlunos = new ArrayList<Aluno>();
    static List<Professor> listaProfessores = new ArrayList<Professor>();
    static List<String> disciplinas = new ArrayList<String>();

    public static void main(String[] args) {
        disciplinas.add("Matematica");
        disciplinas.add("Português");
        disciplinas.add("Geografia");

        criarNovoAluno("Joazinho", "Matematica");
        criarNovoAluno("Fulano", "Matematica");
        criarNovoAluno("Maria", "Português");

        criarNovoProfessor("Alfredo Lisboa", "A123", "001.002.003-11");
        criarNovoProfessor("Monica Maria", "A303", "004.005.006-12");
        criarNovoProfessor("Tadeu Paulista", "A203", "007.008.009-13");


        menuPrincipal();


    }

    public static void criarNovoAluno(String nomeAluno, String disciplina){
        Aluno aluno = new Aluno(nomeAluno, disciplina);
        listaAlunos.add(aluno);
        System.out.println("Aluno adcionando !");
    }

    public static void cadastrandoNovoAluno(){
        String nomeAluno;
        String disciplina;
        int op;

        System.out.println();
        System.out.print("Digite o nome do aluno: ");
        nomeAluno = input.nextLine();
        System.out.println();
        listarDisciplinas();
        System.out.println();
        System.out.print("Informe o COD da disciplina: ");
        op = Integer.parseInt(input.nextLine());
        disciplina = disciplinas.get(op);

        criarNovoAluno(nomeAluno, disciplina);

    }

    public static void criarNovoProfessor(String nome, String matricula, String cpf){
        Professor professor = new Professor(nome, matricula, cpf);
        listaProfessores.add(professor);
    }

    public static void listarAlunos(){
        int cod = 0;
        for(Aluno aluno: listaAlunos){
            System.out.print("COD: " + cod + " " + aluno);
            System.out.println();
            cod++;
        }
    }

    public static void listarProfessores(){
        int cod = 0;
        for(Professor professor: listaProfessores){
            System.out.print("COD ( " + cod + " ) " + professor);
            System.out.println();
            cod++;
        }
    }

    public static void menuPrincipal(){
        System.out.println(" ");
        System.out.println("Escolha uma opção: ");
        System.out.println("( 1 ) - Gerenciar Alunos");
        System.out.println("( 2 ) - Gerenciar Professor");
        System.out.println("( 0 ) - Sair");
        acoesMenuPrincipal();
    }

    public static void acoesMenuPrincipal(){
        opcao = Integer.parseInt(input.nextLine());
        if (opcao == 1){
            menuAluno();
        } else if (opcao == 2) {
            menuProfessor();
        } else if (opcao == 3){
            menuDisciplina();
        } else if (opcao == 0) {
            System.exit(0);
        } else menuPrincipal();
    }

    public static void menuAluno(){
        System.out.println();
        System.out.println(" .: ALUNOS :.");
        System.out.println("Escolha uma opção: ");
        System.out.println("( 1 ) - Cadastrar novo aluno");
        System.out.println("( 2 ) - Cadastrar notas");
        System.out.println("( 3 ) - Calcular media por aluno");
        System.out.println("( 4 ) - Calcular media por disciplina");
        System.out.println("( 5 ) - Registrar falta");
        System.out.println("( 6 ) - Consultar faltas");
        System.out.println("( 7 ) - Listar alunos");
        System.out.println("( 0 ) - Voltar");
        acoesMenuAluno();
    }

    public static void menuProfessor(){
        System.out.println("  ");
        System.out.println(" .: PROFESSORES :.");
        System.out.println("Escolha uma opção: ");
        System.out.println("( 1 ) - Cadastrar novo professor");
        System.out.println("( 2 ) - Alterar situação professor");
        System.out.println("( 3 ) - Listar professores");
        System.out.println("( 4 ) - Cadastrar uma disciplina ao professor");
        System.out.println("( 5 ) - Listar as disciplinas de um professor");
        System.out.println("( 6 ) - Buscar os professores que lecionam uma disciplina");
        System.out.println("( 0 ) - Voltar");
        acoesMenuProfessor();
    }

    public static void acoesMenuAluno(){

        opcao = Integer.parseInt(input.nextLine());
        switch (opcao){
            case 0:
                menuPrincipal();
            case 1:
                cadastrandoNovoAluno();
                menuAluno();
            case 2:
                cadastrarNotaAluno();
                menuAluno();
            case 3:
                calcularMediaPorAluno();
                menuAluno();
            case 4:
                calcularMediaPorDisciplina();
                menuAluno();
            case 5:
                registrarFaltaAluno();
                menuAluno();
            case 7:
                listarAlunos();
                menuAluno();
            case 6:
                consultarFaltasAluno();
                menuAluno();
            default:
                System.out.println("Digite uma opção valida");
                menuAluno();
        }

    }

    public static void acoesMenuProfessor(){
        int op = -1;
        System.out.print("Informe uma opção: ");
        op = Integer.parseInt(input.nextLine());

        switch (op){
            case 0:
                menuPrincipal();
            case 1:
                cadastrarNovoProfessor();
                menuProfessor();
            case 2:
                alterarSituacaoProfessor();
                menuProfessor();
            case 3:
                listarProfessores();
                menuProfessor();
            case 4:
                cadastrarDisciplinaAoProfessor();
                menuProfessor();
            case 5:
                listarDisciplinasPorProfessor();
                menuProfessor();
            case 6:
                listarProfessoresPorDisciplina();
                menuProfessor();
            default:
                System.out.println("Digite uma opção valida");
                menuProfessor();
        }

    }

    private static void listarProfessoresPorDisciplina() {
        int op;
        listarDisciplinas();
        System.out.print("Informe o COD: ");
        op = Integer.parseInt(input.nextLine());
        System.out.println(".: PROFESSORES DE " + disciplinas.get(op).toUpperCase() + " :.");
        for(Professor professor: listaProfessores){
            if(professor.getDisciplinas().contains(disciplinas.get(op))){
                System.out.println(professor.getNome() + (professor.isSituacao() ? " | ATIVO":" | INATIVO"));
            }
        }
    }

    private static void listarDisciplinasPorProfessor() {
        int op;
        listarProfessoresSituacao();
        System.out.print("Informe o COD: ");
        op = Integer.parseInt(input.nextLine());
        System.out.println(listaProfessores.get(op).getDisciplinas());
    }

    private static void cadastrarDisciplinaAoProfessor() {
        int op;
        String disciplina;
        listarDisciplinas();
        System.out.print("Informe o COD: ");
        op = Integer.parseInt(input.nextLine());
        disciplina = disciplinas.get(op);
        System.out.println();
        listarProfessoresSituacao();
        System.out.print("ADD " + disciplina + "para qual ? Informe o COD: ");
        op = Integer.parseInt(input.nextLine());
        listaProfessores.get(op).getDisciplinas().add(disciplina);
        System.out.println();
        System.out.println("Adcionado com sucesso");

    }

    private static void alterarSituacaoProfessor() {
        int op;
        listarProfessoresSituacao();
        System.out.print("Informe o COD: ");
        op = Integer.parseInt(input.nextLine());
        listaProfessores.get(op).alterarSituacao();
        System.out.println("Situação alterada !");

    }

    private static void listarProfessoresSituacao() {
        int cod = 0;
        System.out.println();
        for(Professor professor: listaProfessores){
            System.out.println("COD: " + cod + " - " + professor.getNome() + " | "
                    + (professor.isSituacao() ? "ATIVO |" : "INATIVO |"));
            System.out.println();
            cod++;
        }
    }

    private static void cadastrarNovoProfessor() {
        String nome;
        String matricula;
        String cpf;

        System.out.println();
        System.out.print("Digite o nome do professor: ");
        nome = input.nextLine();
        System.out.println();
        System.out.print("Digite a matricula: ");
        System.out.println();
        matricula = input.nextLine();
        System.out.print("Digite o CPF: ");
        cpf = input.nextLine();
        System.out.println();
        criarNovoProfessor(nome, matricula, cpf);
        System.out.println("Cadastrado com sucesso");


    }

    private static void consultarFaltasAluno() {
        int op;
        listarAlunos();
        System.out.print("Informa o COD do aluno: ");
        op = Integer.parseInt(input.nextLine());
        System.out.println();
        System.out.println(listaAlunos.get(op).getNome() + " tem, "
                + listaAlunos.get(op).getFaltas() + " falta(s).");


    }

    private static void registrarFaltaAluno() {
        int op;
        listarAlunos();
        System.out.print("Informa o COD do aluno: ");
        op = Integer.parseInt(input.nextLine());
        listaAlunos.get(op).registraFalta();
        System.out.println();
        System.out.println("Falta registrada ! - total: " + listaAlunos.get(op).getFaltas());

    }

    private static void calcularMediaPorDisciplina() {
        int op;
        listarDisciplinas();
        System.out.print("Digite o COD da disciplina: ");
        op = Integer.parseInt(input.nextLine());
        informarMediaPorDisciplina(op);

    }

    private static void informarMediaPorDisciplina(int op) {
        double media = 0;
        int contaAlunos = 0;
        String disciplina = disciplinas.get(op);

        for(Aluno aluno: listaAlunos){
            if(aluno.getDisciplina() == disciplina){
                media = media + aluno.calculaMedia();
                contaAlunos++;
            }
        }
        media = media/contaAlunos;
        System.out.println("A media de " + disciplina.toUpperCase() + " é: " + media);
    }

    private static void calcularMediaPorAluno() {

        int op;

        listarAlunos();
        System.out.print("Informa o COD do aluno: ");
        op = Integer.parseInt(input.nextLine());
        informarMediaPorAluno(op);

    }

    private static void informarMediaPorAluno(int op) {

        System.out.println("A media de " + listaAlunos.get(op).getNome() + " é: " + listaAlunos.get(op).calculaMedia());

    }

    private static void cadastrarNotaAluno() {
        int op;
        System.out.println();
        listarAlunos();
        System.out.println();
        System.out.print("Escolha o aluno (COD): ");
        op = Integer.parseInt(input.nextLine());
        lancamentoDeNotasPorAluno(op);
    }

    private static void lancamentoDeNotasPorAluno(int op) {
        double nota;
        for(int x = 0; x < 3; x++){
            System.out.print("Informe a nota " + (x+1) + ": ");
            nota = Double.parseDouble(input.nextLine());
            listaAlunos.get(op).getNotas()[x] = nota;
            System.out.println();
        }
        System.out.println("Notas cadastradas");
    }

    public static void listarDisciplinas(){
        int cod = 0;

        for(String disciplina: disciplinas){
            System.out.println("( " + cod + " )" + " | " + disciplina);
            System.out.println();
            cod++;
        }
    }

    public static void menuDisciplina(){
        System.out.println("  ");
        System.out.println(" .: DISCIPLINAS :.");
        System.out.println("Escolha uma opção: ");
        System.out.println("( 1 ) - Cadastrar nova disciplina");
        System.out.println("( 2 ) - Listar disciplinas");
        System.out.println("( 0 ) - Voltar");
        acoesMenuDisciplina();

    }

    private static void acoesMenuDisciplina() {
        int op;
        System.out.print("Informe uma opção: ");
        op = Integer.parseInt(input.nextLine());
        switch (op){
            case 1:
                cadastraDisciplina();
                menuDisciplina();
                break;
            case 2:
                listarDisciplinas();
                menuDisciplina();
                break;
            case 0:
                menuPrincipal();
                break;
            default:
                System.out.println("Digite uma opção valida");
                menuDisciplina();
                break;
        }
    }

    private static void cadastraDisciplina() {
        
    }

}
