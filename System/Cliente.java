import java.util.ArrayList;


public class Cliente {
	
	private String nome;
	private String email;
	private int numeroTel;
	private ArrayList<Reserva> reservas;
	
	
	public Cliente(String nome, String email, int numeroTel) {
		this.nome = nome;
		this.email = email;
		this.numeroTel = numeroTel;
		
	}

	public void Reserva(Cliente cliente) {
		Reserva reserva = new Reserva(cliente);
		reservas.add(reserva);
	}
	
	public void cancelarReserva(Cliente cliente) {
		Reserva reserva = new Reserva(cliente);
		reservas.remove(reserva);
	}

public void setName(String nome) {
	this.nome = nome;
}

public void setEmail(String email) {
	this.email = email;
}

public void setNumero(int numeroTel) {
	this.numeroTel = numeroTel;
}
public void setReservas(ArrayList<Reserva> reservas) {
	this.reservas = reservas;
}
public String getNome() {
	return nome;
}

public String getEmail() {
	return email;
}

public int getNumero() {
	return numeroTel;
}

public ArrayList<Reserva> getReservas() {
	return reservas;
}



}