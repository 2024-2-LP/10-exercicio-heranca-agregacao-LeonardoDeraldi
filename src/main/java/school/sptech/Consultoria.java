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
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            totalSalario += desenvolvedor.calcularSalario();
        }
        return totalSalario;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer qtdMobile = 0;
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor instanceof DesenvolvedorMobile) {
                qtdMobile++;
            }
        }
        return qtdMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> salarioMaior = new ArrayList<>();

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor.calcularSalario() >= salario) {
                salarioMaior.add(desenvolvedor);
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
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor.calcularSalario() < menorSalario) {
                menorSalario = desenvolvedor.calcularSalario();
                desenvolvedorMenor = desenvolvedor;
            }
        }
        return desenvolvedorMenor;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> dev = new ArrayList<>();

        for (Desenvolvedor desenvolvedorDaVez : desenvolvedores) {
            if(desenvolvedorDaVez instanceof DesenvolvedorMobile){
                if(((DesenvolvedorMobile) desenvolvedorDaVez).getPlataforma().equals(tecnologia) || ((DesenvolvedorMobile) desenvolvedorDaVez).getLinguagem().equals(tecnologia)){
                    dev.add(desenvolvedorDaVez);
                }
            }
            if(desenvolvedorDaVez instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) desenvolvedorDaVez).getBackend().equals(tecnologia)|| ((DesenvolvedorWeb) desenvolvedorDaVez).getFrontend().equals(tecnologia) || ((DesenvolvedorWeb) desenvolvedorDaVez).getSgbd().equals(tecnologia)){
                    dev.add(desenvolvedorDaVez);
                }
            }
        }
        return dev;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        List<Desenvolvedor> retornar = buscarPorTecnologia(tecnologia);
        Double contador = 0.0;
        for (Desenvolvedor desenvolvedor : retornar) {
            contador+= desenvolvedor.calcularSalario();
        }
        return contador;
    }
}
