package atividade02;

public class Aluno extends Pessoa{

    private String disciplina;
    private double[] notas = new double[3];
    private int faltas=0;


    public Aluno(String nome, String disciplina) {
        setNome(nome);
        this.disciplina = disciplina;
    }

    public double calculaMedia(){
        double media = 0;

        for(double nota: notas){
            media = media + nota;
        }

        return media/notas.length;
    }

    public void registraFalta(){
        setFaltas(getFaltas()+1);
        System.out.println("Falta registrada!");
    }

    public int totalFaltas(){
        return getFaltas();
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    @Override
    public String toString() {
        return "[ " + getNome() + " | " +
                 disciplina + " | " +  faltas + " faltas ]";
    }
}
