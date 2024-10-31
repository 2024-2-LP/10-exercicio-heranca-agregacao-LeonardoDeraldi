package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorWeb extends Desenvolvedor {
    private String backend;
    private String frontend;
    private String sgbd;
    private Integer horasMentoria;

    public DesenvolvedorWeb(String nome, Integer qtdHoras, Double valorHora, Integer horasMentoria, String sgbd, String frontend, String backend) {
        super(nome, qtdHoras, valorHora);
        this.horasMentoria = horasMentoria;
        this.sgbd = sgbd;
        this.frontend = frontend;
        this.backend = backend;
    }

    public DesenvolvedorWeb() {

    }

    public String getBackend() {
        return backend;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }

    public String getFrontend() {
        return frontend;
    }

    public void setFrontend(String frontend) {
        this.frontend = frontend;
    }

    public String getSgbd() {
        return sgbd;
    }

    public void setSgbd(String sgbd) {
        this.sgbd = sgbd;
    }

    public Integer getHorasMentoria() {
        return horasMentoria;
    }

    public void setHorasMentoria(Integer horasMentoria) {
        this.horasMentoria = horasMentoria;
    }

    public Double calcularSalario(){
        Double salario = qtdHoras * valorHora;
        Double salarioMentoria = (double) (horasMentoria * 300);
        return salario + salarioMentoria;
    }

    public Boolean isFullstack(){
        if (backend == null || frontend == null || sgbd == null){
            return false;
        }else{
            return true;
        }
    }
}
