

import java.util.List;
import java.util.ArrayList;

public class Cliente {

    private String nome;
    private String email;
    private String telefone;
    private List<Reserva> reservas;

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.reservas = new ArrayList<>();
    }

    /*
     * Método fazerReserva: recebe como parâmetro, um objeto do tipo "Reserva", e o
     * insere na lista "reservas".
     */
    public void fazerReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    /*
     * Método cancelarReserva: recebe como parâmetro, um objeto do tipo "Reserva",
     * e, se ele esta estiver presente na lista reservas, será removido.
     */
    public void cancelarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

}
