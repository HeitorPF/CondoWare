package condoware.CondoWare;

public class Funcionario extends Pessoa {
    private Float salario;
    private String cargo;
    
    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
