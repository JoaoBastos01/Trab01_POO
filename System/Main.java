import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistemas sistema = new Sistemas();
        int option;

        do {
            System.out.println("===== Menu Principal =====");
            System.out.println("1. Adicionar Novo Hotel");
            System.out.println("2. Listar Todos os Hoteis");
            System.out.println("3. Adicionar Quarto a um Hotel");
            System.out.println("4. Listar Quartos Disponiveis em um Hotel");
            System.out.println("5. Fazer Reserva");
            System.out.println("6. Cancelar Reserva");
            System.out.println("7. Listar Reservas de um Cliente");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opcao: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Nome do hotel: ");
                    String nomeHotel = scanner.next();
                    System.out.print("Endereco do hotel: ");
                    String endHotel = scanner.next();
                    sistema.adicionarHotel(nomeHotel, endHotel);
                    break;
                case 2:
                    sistema.listarHoteis();
                    break;
                case 3:
                    System.out.print("Nome do hotel: ");
                    nomeHotel = scanner.next();
                    Hotel hotelSelecionado = sistema.encontrarHotelNome(nomeHotel);
                    if (hotelSelecionado == null) {
                        System.out.println("Hotel nao encontrado. ");
                        break;
                    }
                    System.out.print("Numero do quarto: ");
                    int numeroQuarto = scanner.nextInt();
                    System.out.println("Tipo do quarto: ");
                    for (tipoQuarto tipo : tipoQuarto.values()) {
                        System.out.println(tipo.ordinal() + 1 + ". " + tipo);
                    }
                    int tipoEscolhido = scanner.nextInt();
                    tipoQuarto tipoQuartoEscolhido = tipoQuarto.values()[tipoEscolhido - 1];
                    System.out.print("preco do quarto: ");
                    double preco = scanner.nextDouble();
                    Quarto quarto = new Quarto(numeroQuarto, tipoQuartoEscolhido, preco);
                    hotelSelecionado.adicionarQuarto(quarto);
                    sistema.adicionarQuarto(quarto);
                    System.out.println("Quarto criado e adicionado ao hotel: " + hotelSelecionado.getNome());
                    break;
                case 4:
                    System.out.print("Nome do hotel para listagem de quartos disponiveis: ");
                    String nomeHotelLista = scanner.next();
                    Hotel nomeHotelEscolhido = sistema.encontrarHotelNome(nomeHotelLista);
                    if (nomeHotelEscolhido == null) {
                        System.out.println("Hotel não encontrado. ");
                        break;
                    }
                    sistema.listarQuartosHotel(nomeHotelEscolhido);
                    break;
                case 5:
                    System.out.println("Id da reserva (Inteiro): ");
                    int ID = scanner.nextInt();
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.next();
                    System.out.print("Email do cliente: ");
                    String email = scanner.next();
                    System.out.print("Telefone do cliente: ");
                    int numTel = scanner.nextInt();
                    Cliente cliente = new Cliente(nomeCliente, email, numTel);
                    System.out.print("Nome do hotel: ");
                    nomeHotel = scanner.next();
                    System.out.print("Numero do Quarto: ");
                    int numQuarto = scanner.nextInt();
                    System.out.print("Data de check-In (AAAA-MM-DD): ");
                    String checkInString = scanner.next();
                    System.out.print("Data de check-Out (AAAA-MM-DD): ");
                    String checkOutString = scanner.next();
                    Date checkIn = sistema.stringToDate(checkInString);
                    Date checkOut = sistema.stringToDate(checkOutString);
                    if (checkIn == null) {
                        System.out.println("Data invalida. ");
                        break;
                    }
                    if (checkOut == null) {
                        System.out.println("Data invalida. ");
                        break;
                    }
                    sistema.fazerReserva(ID, cliente, nomeHotel, numQuarto, checkIn, checkOut);
                    break;
                case 6:
                    System.out.print("ID da reserva: ");
                    int reservationId = scanner.nextInt();
                    sistema.cancelarReserva(reservationId);
                    break;
                case 7:
                    System.out.print("Client Name: ");
                    nomeCliente = scanner.next();
                    // sistema.listReservationsByClient(clientName);
                    break;
                case 8:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (option != 8);

        scanner.close();
    }
}
