import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sistemas {
    private Administrador adm;
    private ArrayList<Hotel> hoteis;
    private ArrayList<Reserva> reservas;
    private ArrayList<Quarto> quartos;
    
    public Sistemas() {
        this.adm = new Administrador(1, "Joao");
        hoteis = new ArrayList<Hotel>();
        reservas = new ArrayList<Reserva>();
        quartos = new ArrayList<Quarto>();
    }

    public void adicionarHotel(String nomeHotel, String endHotel) {
        adm.adicionarHotel(nomeHotel, endHotel);
        for (Hotel h : hoteis) {
            if (h.getNome().equals(nomeHotel)) {
                System.out.println("Hotel ja existe. ");
                break;
            }
        }
        Hotel hotel = new Hotel(nomeHotel, endHotel);
        hoteis.add(hotel);
    }

    public void removerHotel(String nomeHotel) {
        adm.removerHotel(nomeHotel);
    }
    
    public void listarHoteis() {
        if (hoteis.isEmpty()) {
            System.out.println("Nao tem hoteis no sistema. ");
        } else {
            System.out.println("Hoteis no sistema:");
            for (Hotel hotel : hoteis) {
                System.out.println("Nome: " + hotel.getNome() + ", Endereco: " + hotel.getEndereco());
            }
        }
    }
    
    public Hotel encontrarHotelNome(String nomeHotel) {
        for (Hotel hotel : hoteis) {
            if (hotel.getNome().equalsIgnoreCase(nomeHotel)) {
                return hotel;
            }
        }
        return null;
    }
    
    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }
    
    public void adicionarQuartoHotel(String nomeHotel, Quarto quarto) {
        for (Hotel hotel : hoteis) {
            if (hotel.getNome().equals(nomeHotel)) {
                hotel.adicionarQuarto(quarto);
                return;
            }
        }
        System.out.println("Hotel nao encontrado.");
    }
    
    public void listarQuartosHotel(Hotel hotel) {
        hotel.listaQuartosHotel();
    }
    
    public void fazerReserva(int Id, Cliente cliente, String nomeHotel, int numQuarto, Date checkIn, Date checkOut) {
        Hotel hotel = null;
        for (Hotel h : hoteis) {
            if (h.getNome().equals(nomeHotel)) {
                hotel = h;
                break;
            }
        }
        Quarto quarto = null;
        for (Quarto q : hotel.getQuartos()) {
            if (q.getNumQuarto() == numQuarto && q.getDisponibilidade()) {
                quarto = q;
                Reserva reserva = new Reserva(cliente, quarto, checkIn, checkOut);
                reservas.add(reserva);
                System.out.println("chegou no reservarQuarto");
                quarto.reservarQuarto();
                break;
            } else {
                System.out.println("Quarto não disponivel.");
                break;
            }
        }
        System.out.println("Reserva no hotel " + nomeHotel + " do quarto numero " + numQuarto + " para o cliente "
                + cliente.getNome() + " realizada com sucesso. ");
    }
    
    public void cancelarReserva(int ID) {
    Reserva reserva = null;
    for (Reserva r : reservas) {
    if (ID == r.getId()) {
    reserva = r;
    reserva.cancelarReserva();
    System.out.println("Reserva cancelada com sucesso. ");
    }
    }
    }
    
    public Date stringToDate(String dataEmString) {
        SimpleDateFormat formatador = new SimpleDateFormat("YYYY-MM-DD");
        try {
            return formatador.parse(dataEmString);
        } catch (ParseException e) {
            System.out.println("Formato de data invalido. Por favor use YYYY-MM-DD. ");
            return null;
        }
    }
    
    public Administrador getAdm() {
        return adm;
    }

    public ArrayList<Hotel> getHoteis() {
        return hoteis;
    }
    
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
    
    public void setAdm(Administrador adm) {
        this.adm = adm;
    }

    public void setHoteis(ArrayList<Hotel> hoteis) {
        this.hoteis = hoteis;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }


}
