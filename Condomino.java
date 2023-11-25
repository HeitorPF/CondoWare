package condoware.CondoWare;

public class Condomino extends Pessoa {
    
    private int numAp;

    private Veiculo veiculo = new Veiculo();
    
    public int getNumAp() {
        return numAp;
    }

    public void setNumAp(int numAp) {
        this.numAp = numAp;
    }
    
    public Veiculo addVeiculo(String placa, String modelo, String marca) {
        veiculo.setPlaca(placa);
        veiculo.setModelo(modelo);
        veiculo.setMarca(marca);
        return veiculo;
    }
    
   
}
