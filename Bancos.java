package condoware.CondoWare;

import java.util.List;
import java.util.ArrayList;

public class Bancos {
    private static Bancos bancoUnico;
    
    static List<Condominio> bdCondominio;
    static List<Funcionario> bdFuncionario;
    static List<Condomino> bdCondomino;
    static List<AreaDeLazer> bdAreaDeLazer;
    static List<Veiculo> bdVeiculo;
    static List<Apartamento> bdApartamento;
    
    private Bancos() {
        bdCondominio = new ArrayList<>();
        bdFuncionario = new ArrayList<>();
        bdCondomino = new ArrayList<>();
        bdAreaDeLazer = new ArrayList<>();
        bdVeiculo = new ArrayList<>();
        bdApartamento = new ArrayList<>();
    }
    
    public static Bancos getBancos() {
        if(bancoUnico == null) {
            bancoUnico = new Bancos();
        }
        return bancoUnico;
    }
    
    public List<Condominio> getBdCondominio(){
        return bdCondominio;
    }
    public List<Funcionario> getBdFuncionario(){
        return bdFuncionario;
    }
    public List<Condomino> getBdCondomino(){
        return bdCondomino;
    }
    public List<AreaDeLazer> getBdAreaDeLazer(){
        return bdAreaDeLazer;
    }
    public List<Veiculo> getBdVeiculo(){
        return bdVeiculo;
    }
    public List<Apartamento> getBdApartamento(){
        return bdApartamento;
    }
    
    
    public Condominio addCondominio(Condominio condominio) {
        bdCondominio.add(condominio);
        return condominio;
    }
    
    public Funcionario addFuncionario(Funcionario funcionario) {
        bdFuncionario.add(funcionario);
        return funcionario;
    }
    
    public Condomino addCondomino(Condomino condomino) {
        bdCondomino.add(condomino);
        return condomino;
    }
    
    public AreaDeLazer addAreaDeLazer(AreaDeLazer areaDeLazer) {
        bdAreaDeLazer.add(areaDeLazer);
        return areaDeLazer;
    }
    
    public Veiculo addVeiculo(Veiculo veiculo) {
        bdVeiculo.add(veiculo);
        return veiculo;
    }
    
    public Apartamento addApartamento(Apartamento apartamento) {
        bdApartamento.add(apartamento);
        return apartamento;
    }
}
