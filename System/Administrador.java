import java.util.ArrayList;

public class Administrador {
    private int id;
    private String nome;
    private ArrayList<Hotel> hoteis;

    public Administrador(int id, String nome) {
        this.id = id;
        this.nome = nome;
        hoteis = new ArrayList<Hotel>();
    }

    public void adicionarHotel(String nomeHotel, String endHotel) {
        for (Hotel h : hoteis) {
            if (h.getNome().equals(nomeHotel)) {
                System.out.println("Hotel ja existe. ");
                break;
            }
        }
        Hotel hotel = new Hotel(nomeHotel, endHotel);
        hoteis.add(hotel);
        System.out.println("Hotel " + hotel.getNome() + " adicionado. ");
    }

    public void removerHotel(String nomeHotel) {
        Hotel hotel;
        for (Hotel h : hoteis) {
            if (h.getNome().equals(nomeHotel)) {
            hotel = h;
            hoteis.remove(hotel);
            System.out.println("Hotel " + hotel.getNome() + " removido. ");
            break;
            }
        }
    }

    public void adicionarQuartoHotel(Hotel hotel, Quarto quarto) {
        hotel.adicionarQuarto(quarto);
    }

    public Hotel searchHotelName(String nome) {
        for (Hotel hotel : hoteis) {
            if (hotel.getNome().equalsIgnoreCase(nome)) {
                return hotel;
            }
        }
        return null;
    }

    public void listHotels(ArrayList<Hotel> hoteis) {
        for (int i = 0; i < hoteis.size(); i++) {
            hoteis.get(i).getNome();
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


}
