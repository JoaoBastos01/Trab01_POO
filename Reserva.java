

import java.util.Date;

public class Reserva {
    private static int contadorReservas = 1;

    private int numeroReserva;
    private Cliente cliente;
    private Hotel hotel;
    private Quarto quarto;
    private Date dataCheckIn;
    private Date dataCheckOut;
    private StatusReserva status;

    public Reserva(Cliente cliente, Quarto quarto, Date dataCheckIn, Date dataCheckout) {
        this.numeroReserva = contadorReservas++;
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckout;
        this.status = StatusReserva.ATIVA;
    }

    /*
     * Método validarReserva: valida as datas de uma reserva (dataCheckIn e
     * dataCheckOut).
     * Verifica se as datas não são nulas, se a data de check-in é anterior à data
     * de check-out e se a data de check-in é no presente ou no futuro.
     * Se alguma dessas condições falhar, exibe uma mensagem de erro e retorna
     * false; caso todas as condições sejam atendidas, exibe uma mensagem de sucesso
     * e retorna true.
     */
    public boolean validarReserva() {

        if (dataCheckIn == null || dataCheckOut == null) {
            System.out.println("Erro: Data de check-in ou check-out nao pode ser nula. ");
            return false;
        }
        if (!dataCheckIn.before(dataCheckOut)) {
            System.out.println("Erro: Data de check-in deve ser anterior a data de check-out.");
            return false;
        }
        Date hoje = new Date();
        if (dataCheckIn.before(hoje)) {
            System.out.println("Erro: Data de check-in deve ser no presente ou no futuro.");
            return false;
        }

        System.out.println("Datas validas para reserva. ");
        return true;
    }

    /*
     * Método confirmarReserva: Este método confirma uma reserva, primeiro chamando
     * o método validarReserva para assegurar que as datas são válidas.
     * Se validarReserva retornar true, a reserva é confirmada, e uma mensagem de
     * confirmação com o número do quarto e o nome do cliente é exibida.
     * Caso contrário, exibe uma mensagem indicando falha na confirmação devido a
     * datas inválidas.
     */
    public void confirmarReserva() {

        if (validarReserva()) {
            System.out.println("Reserva do quarto " + quarto.getNumero() + " para o/a cliente" + cliente.getNome()
                    + " confirmada. ");
        } else {
            System.out.println("Falha na confirmacao: datas invalidas. ");
        }
    }

    /*
     * Método cancelarReserva: cancela a reserva alterando seu status.
     * Verifica se o status da reserva está marcado como ATIVA. Se estiver, altera o
     * status para CANCELADA e exibe uma mensagem confirmando o cancelamento.
     * Caso a reserva já esteja cancelada, exibe uma mensagem informando que a
     * reserva já foi cancelada anteriormente.
     */
    public void cancelarReserva() {
        if (this.status == StatusReserva.ATIVA) {
            this.status = StatusReserva.CANCELADA;
            System.out.println("Reserva cancelada com sucesso.");
        } else {
            System.out.println("A reserva ja foi cancelada.");
        }
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Date getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(Date dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public Date getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(Date dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void setStatus(StatusReserva status) {
        this.status = status;
    }
}
