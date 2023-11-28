package atividade02;

public class Aluno extends Pessoa{

    private String disciplina;
    private int[] notas = new int[3];
    private int faltas=0;


    public int calculaMedia(){
        //TODO
        return 0;
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

    public int[] getNotas() {
        return notas;
    }

    public void setNotas(int[] notas) {
        this.notas = notas;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }
}
