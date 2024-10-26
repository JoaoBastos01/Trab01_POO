
import java.util.ArrayList;


public class Hotel extends Object {
    private String nome;
    private String endereco;
    private ArrayList<Quarto> quartos;

    @Override
    public String toString() {
        return "Hotel{" +
                "Nome: " + nome +
                ", Endereço: " + endereco +
                ", Quartos: " + quartos +
                '}';
    }
    
    public Hotel(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.quartos = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
        System.out.println("Quarto adicionado ao hotel " + getNome());
    }
    
    public void removerQuarto(Quarto quarto) {
        quartos.remove(quarto);
        System.out.println("Quarto removido do hotel " + getNome());
    }

    public void listaQuartosHotel() {
        for (Quarto quarto : quartos) {
            System.out.println(quarto.toString());
        }
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome inválido.");
        }
    }


    public void setEndereco(String endereco) {
        if (endereco != null && !endereco.trim().isEmpty()) {
            this.endereco = endereco;
        } else {
            throw new IllegalArgumentException("Endereço inválido.");
        }
    }
    
    public void setQuartos(ArrayList<Quarto> quartos) {
        this.quartos = quartos;
    }

    public String getNome() {
        return nome;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public ArrayList<Quarto> getQuartos() {
        return quartos;
    }
    
}