import java.util.Date;

public class Reserva {

private int id;
private Cliente cliente;
private Quarto quarto;
private Date dateCheckin;
private Date dateCheckout;

public Reserva(Cliente cliente, Quarto quarto, Date dateCheckin, Date dateCheckout) {
    this.cliente = cliente;
    this.quarto = quarto;
    this.dateCheckin = dateCheckin;
    this.dateCheckout = dateCheckout;
    confirmarReserva();
}


public Reserva(Cliente cliente) {
    this.cliente = cliente;
}

public void setId(int id) {
    this.id = id;
}

public void setClient(Cliente cliente) {
    this.cliente = cliente;
}


public void setQuarto(Quarto quarto) {
    this.quarto = quarto;
}

public void setDateCheckin(Date dateCheckin) {
    this.dateCheckin = dateCheckin;
}

public void setDateCheckout(Date dateCheckout) {
    this.dateCheckout = dateCheckout;
}

public int getId() {
    return id;
}

public Cliente getCliente() {
    return cliente;
}


public Quarto getQuarto() {
    return quarto;
}

public Date getDateCheckin() {
    return dateCheckin;
}

public Date getDateCheckout() {
    return dateCheckout;
}

public void confirmarReserva() {
    if (quarto.getDisponibilidade()) {
        quarto.reservarQuarto();
        System.out.println("Reserva confirmada para " + cliente.getNome());
    } else {
        System.out.println("Quarto nao esta disponivel.");
    }
}

public void cancelarReserva() {
    quarto.liberarQuarto();
System.out.println("Reserva cancelada para " + cliente.getNome());
}


}
