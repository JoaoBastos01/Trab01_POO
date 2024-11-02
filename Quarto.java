
import java.util.ArrayList;
import java.util.Date;

public class Quarto {
    private int numero;
    private tipoQuarto tipo;
    private double preco;
    private boolean estaDisponivel;
    private ArrayList<Reserva> reservas;

    public Quarto(int numero, tipoQuarto tipo, double preco) {
        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
        this.estaDisponivel = true;
        this.reservas = new ArrayList<>();
    }

    /*
     * Método reservar: Este método tenta adicionar uma reserva ao quarto.
     * Primeiramente, verifica a
     * disponibilidade do quarto nas datas da reserva, usando o método
     * verificarDisponibilidade. Se o quarto estiver disponível, a reserva é
     * adicionada à lista reservas, uma mensagem de sucesso é exibida, e o método
     * retorna true. Caso contrário, exibe uma mensagem de erro e retorna false.
     */
    public boolean reservar(Reserva reserva) {
        if (verificarDisponibilidade(reserva.getDataCheckIn(), reserva.getDataCheckOut())) {
            reservas.add(reserva);
            System.out.println("Reserva adicionada ao quarto " + numero);
            return true;
        }
        System.out.println("Erro: O quarto nao esta disponivel nas datas selecionadas.");
        return false;
    }

    /*
     * Método liberar: Recebe um objeto "Reserva" como parâmetro e remove da lista
     * de reservas do quarto.
     * Uma mensagem de confirmação é exibida após a remoção.
     */
    public void liberar(Reserva reserva) {
        reservas.remove(reserva);
        System.out.println("Reserva removida do quarto " + numero);
    }

    /*
     * Método verificarDisponibilidade: Esse método verifica se o quarto está
     * disponível para um intervalo de datas (checkIn e checkOut).
     * Primeiro, compara a data de checkOut com a data atual (hoje). Se checkOut for
     * antes de hoje, o quarto é considerado indisponível e o método retorna false.
     * Em seguida, ele verifica se as datas do intervalo fornecido se sobrepõem a
     * alguma reserva existente.
     * Se nenhuma reserva existente se sobrepõe ao intervalo solicitado, o método
     * retorna true, indicando que o quarto está disponível. Caso contrário, retorna
     * false.
     */
    public boolean verificarDisponibilidade(Date checkIn, Date checkOut) {
        Date hoje = new Date();

        if (checkOut.before(hoje)) {
            return false;
        }

        for (Reserva reserva : reservas) {
            Date reservaCheckIn = reserva.getDataCheckIn();
            Date reservaCheckOut = reserva.getDataCheckOut();
            if (!(checkOut.before(reservaCheckIn) || checkIn.after(reservaCheckOut))) {
                return false;
            }
        }
        return true;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public tipoQuarto getTipo() {
        return tipo;
    }

    public void setTipo(tipoQuarto tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isEstaDisponivel() {
        return estaDisponivel;
    }

    public void setEstaDisponivel(boolean estaDisponivel) {
        this.estaDisponivel = estaDisponivel;
    }
}
