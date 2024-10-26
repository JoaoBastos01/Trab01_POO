
public class Quarto {
    private int numQuarto;
    private tipoQuarto tipoQuarto;
    private double preco;
    private boolean disponibilidade;


    public Quarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public Quarto(int numQuarto, tipoQuarto tipoQuarto, double preco) {
        this.numQuarto = numQuarto;
        this.tipoQuarto = tipoQuarto;
        this.preco = preco;
        this.disponibilidade = true;
    }

    @Override
    public String toString() {
        return "Quarto: " + numQuarto + ", tipo: " + tipoQuarto + ", preco: " + preco + ", disponibilidade: " + disponibilidade;
    }

    public void setRoomNumber(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public void setTipoQuarto(tipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getNumQuarto() {
        return numQuarto;
    }

    public tipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public double getPreco() {
        return preco;
    }

    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void reservarQuarto() {
        System.out.println(this.getDisponibilidade());
        if (this.getDisponibilidade() == true) {
            this.disponibilidade = false;

        } else { 
            System.out.println("Quarto " + numQuarto + " ja esta reservado. ");
        }
    }

    public void liberarQuarto() {
        this.disponibilidade = true;
    }


}
