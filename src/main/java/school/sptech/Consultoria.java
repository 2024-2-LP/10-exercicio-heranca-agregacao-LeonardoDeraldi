package school.sptech;

import school.sptech.especialistas.DesenvolvedorWeb;
import school.sptech.especialistas.DesenvolvedorMobile;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;
    private List<DesenvolvedorMobile> desenvolvedoresMobiles;

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
        this.desenvolvedoresMobiles = new ArrayList<>();
    }

    public Consultoria() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<DesenvolvedorMobile> getDesenvolvedoresMobiles() {
        return desenvolvedoresMobiles;
    }

    public void setDesenvolvedoresMobiles(List<DesenvolvedorMobile> desenvolvedoresMobiles) {
        this.desenvolvedoresMobiles = desenvolvedoresMobiles;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }

    public Boolean contratar(Desenvolvedor desenvolvedor){
        Boolean contratado = false;
            if (desenvolvedores.size() < vagas){
                desenvolvedores.add(desenvolvedor);
                contratado = true;
        }
        return contratado;
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
        else {
            return false;
        }
        return true;
    }

    public Double getTotalSalarios(){
        Double totalSalario = 0.0;
        for (int i = 0; i < desenvolvedores.size(); i++) {
            totalSalario+=desenvolvedores.get(i).calcularSalario();
        }
        return totalSalario;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer qtdMobile = 0;
        for (int i = 0; i < desenvolvedores.size(); i++) {
            if (desenvolvedores.get(i) instanceof DesenvolvedorMobile ){
                qtdMobile++;
            }
        }
        return qtdMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> salarioMaior = new ArrayList<>();

        for (int i = 0; i < desenvolvedores.size(); i++) {
            if (desenvolvedores.get(i).calcularSalario() >= salario){
                salarioMaior.add(desenvolvedores.get(i));
            }
        }
        return salarioMaior;
    }

    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores.isEmpty()){
            return null;
        }
        Double menorSalario = desenvolvedores.get(0).calcularSalario();
        Desenvolvedor desenvolvedorMenor = desenvolvedores.get(0);
        for (int i = 0; i < desenvolvedores.size(); i++) {
            if (desenvolvedores.get(i).calcularSalario() < menorSalario){
                menorSalario = desenvolvedores.get(i).calcularSalario();
                desenvolvedorMenor = desenvolvedores.get(i);
            }
        }
        return desenvolvedorMenor;
    }
}
