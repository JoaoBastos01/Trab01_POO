
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class SistemaReservas {

    private Administrador adm;
    private List<Cliente> clientes;
    private ArrayList<Hotel> hoteis;
    private ArrayList<Reserva> reservas;
    private ArrayList<Quarto> quartos;

    Scanner scanner = new Scanner(System.in);

    public SistemaReservas() {
        this.adm = new Administrador("Joao", 0);
        this.clientes = new ArrayList<Cliente>();
        this.hoteis = new ArrayList<Hotel>();
        this.reservas = new ArrayList<Reserva>();
        this.quartos = new ArrayList<Quarto>();
    }

    /*
     * Método adicionarHotel: Este método solicita ao usuário o nome e endereço de
     * um hotel e utiliza o administrador (adm) para adicionar o hotel à lista
     * hoteis. Se o hotel já existir, exibe uma mensagem indicando a duplicidade;
     * caso contrário, o novo hotel é adicionado, e uma mensagem de confirmação é
     * exibida.
     */
    public void adicionarHotel() {
        System.out.println("Digite o nome do hotel: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o endereco do hotel: ");
        String endereco = scanner.nextLine();
        this.adm.adicionarHotel(hoteis, nome, endereco);
    }

    /*
     * Método listarHoteis: Este método lista todos os hotéis cadastrados no
     * sistema. Se a lista hoteis estiver vazia, ele informa que não há hotéis
     * cadastrados; caso contrário, imprime o nome e endereço de cada hotel na
     * lista.
     */
    public void listarHoteis() {
        if (hoteis.isEmpty()) {
            System.out.println("Nenhum hotel cadastrado no sistema. ");
        } else {
            System.out.println("Lista de hoteis no sistema: ");
            for (Hotel hotel : hoteis) {
                System.out.println("Hotel: " + hotel.getNome() + ". || Endereco: " + hotel.getEndereco() + ". ");
            }
        }
    }

    /*
     * Método adicionarQuarto: Este método adiciona um quarto a um hotel específico
     * ou à lista geral de quartos não vinculados. O usuário escolhe entre adicionar
     * o quarto a um hotel específico ou à lista geral, fornecendo detalhes como
     * número, tipo e preço do quarto. Em seguida, o quarto é adicionado ao hotel
     * selecionado ou à lista geral de quartos não vinculados.
     */
    public void adicionarQuarto() {
        System.out.println("Escolha onde deseja adicionar o quarto:");
        System.out.println("1 - Adicionar a um hotel especifico. ");
        System.out.println("2 - Adicionar a lista geral de quartos nao vinculados. ");
        System.out.print("Digite a opcao (1 ou 2): ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        switch (opcao) {
            case 1:
                System.out.println("Digite o nome do hotel: ");
                String nome = scanner.nextLine();
                Hotel hotelEncontrado = null;
                for (Hotel hotel : hoteis) {
                    if (hotel.getNome().equalsIgnoreCase(nome)) {
                        hotelEncontrado = hotel;
                        break;
                    }
                }
                if (hotelEncontrado == null) {
                    System.out.println("Hotel nao encontrado no sistema.");
                    return;
                }
                System.out.println("Digite o numero do quarto: ");
                int numero = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Tipo do quarto:");
                for (tipoQuarto tipo : tipoQuarto.values()) {
                    System.out.println(tipo.ordinal() + 1 + ". " + tipo);
                }
                int tipoEscolhido = scanner.nextInt();
                scanner.nextLine();
                if (tipoEscolhido < 1 || tipoEscolhido > tipoQuarto.values().length) {
                    System.out.println("Tipo de quarto invalido.");
                    return;
                }
                tipoQuarto tipo = tipoQuarto.values()[tipoEscolhido - 1];
                System.out.println("preco do quarto: ");
                Double preco = scanner.nextDouble();
                scanner.nextLine();
                Quarto quarto = new Quarto(numero, tipo, preco);
                hotelEncontrado.adicionarQuarto(quarto);
                break;
            case 2:
                System.out.println("Digite o numero do quarto: ");
                int numero2 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Tipo do quarto:");
                for (tipoQuarto tipo2 : tipoQuarto.values()) {
                    System.out.println(tipo2.ordinal() + 1 + ". " + tipo2);
                }
                int tipoEscolhido2 = scanner.nextInt();
                scanner.nextLine();
                if (tipoEscolhido2 < 1 || tipoEscolhido2 > tipoQuarto.values().length) {
                    System.out.println("Tipo de quarto invalido.");
                    return;
                }
                tipoQuarto tipo2 = tipoQuarto.values()[tipoEscolhido2 - 1];
                System.out.println("preco do quarto: ");
                Double preco2 = scanner.nextDouble();
                scanner.nextLine();
                Quarto quarto2 = new Quarto(numero2, tipo2, preco2);
                quartos.add(quarto2);
                System.out.println("Quarto adicionado a lista de quartos nao vinculados. ");
                break;
            default:
                System.out.println(
                        "Opcao invalida. Escolha 1 para adicionar ao hotel ou 2 para adicionar a lista geral. ");
        }

    }

    /*
     * Método listarQuartosDiponiveis: Solicita ao usuário o nome de um hotel e, se
     * o hotel estiver na lista hoteis, exibe os quartos disponíveis. Se o hotel não
     * for encontrado, exibe uma mensagem informando que o hotel não está no
     * sistema.
     */
    public void listarQuartosDisponiveis() {
        System.out.println("Digite o nome do hotel: ");
        String nome = scanner.nextLine();
        for (Hotel hotel : hoteis) {
            if (hotel.getNome().equals(nome)) {
                hotel.listarQuartosDisponiveis();
            } else {
                System.out.println("Hotel nao encontrado no sistema. ");
            }
        }
    }

    /*
     * Método fazerReserva: registra uma nova reserva para um cliente em um quarto específico de um hotel. Ele coleta dados do cliente, hotel, quarto, e datas de check-in e check-out, verifica a disponibilidade do quarto e, se disponível, cria a reserva. A reserva é então adicionada à lista de reservas e ao cliente, e uma mensagem de confirmação é exibida.
     */
    public void fazerReserva() {
        System.out.println("Digite o nome do cliente:  ");
        String nome = scanner.nextLine();
        System.out.println("Digite o email do cliente: ");
        String email = scanner.nextLine();
        System.out.println("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();

        Cliente cliente = new Cliente(nome, email, telefone);
        clientes.add(cliente);

        System.out.println("Digite o nome do hotel: ");
        String nomeHotel = scanner.nextLine();
        Hotel hotel = null;

        for (Hotel h : hoteis) {
            if (h.getNome().equals(nomeHotel)) {
                hotel = h;
                break;
            }
        }

        if (hotel == null) {
            System.out.println("Hotel nao encontrado no sistema. ");
            return;
        }

        System.out.println("Digite o numero do quarto: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        Quarto quarto = hotel.buscarQuartoPorNumero(numero);
        if (quarto == null) {
            System.out.println("Quarto nao encontrado. ");
            return;
        }

        System.out.print("Data de check-In (AAAA-MM-DD): ");
        String checkInString = scanner.nextLine();
        System.out.print("Data de check-Out (AAAA-MM-DD): ");
        String checkOutString = scanner.nextLine();

        Date checkIn = stringToDate(checkInString);
        Date checkOut = stringToDate(checkOutString);

        if (checkIn == null || checkOut == null) {
            System.out.println("Erro: Formato de data invalido. A reserva nao foi realizada.");
            return;
        }

        Reserva reserva = new Reserva(cliente, quarto, checkIn, checkOut);
        if (quarto.reservar(reserva)) {
            reservas.add(reserva);
            cliente.fazerReserva(reserva);
            System.out.println("Reserva do quarto numero " + quarto.getNumero() + " para o/a cliente "
                    + cliente.getNome() + " realizada com sucesso. O numero de sua reserva e: "
                    + reserva.getNumeroReserva());
        } else {
            System.out.println("Reserva nao realizada. O quarto nao esta disponivel nas datas selecionadas.");

        }
    }

    /*
     * Método cancelarReserva: permite ao usuário cancelar uma reserva específica. Após solicitar o número da reserva, o método procura a reserva na lista reservas. Se encontrada, a reserva é cancelada, removida da lista de reservas e das reservas do cliente, com uma mensagem confirmando o cancelamento.
     */
    public void cancelarReserva() {
        System.out.println("Digite o numero da reserva: ");
        int numeroReserva = scanner.nextInt();
        scanner.nextLine();
        Reserva reservaParaCancelar = null;
        for (Reserva reserva : reservas) {
            if (reserva.getNumeroReserva() == numeroReserva) {
                reservaParaCancelar = reserva;
                break;
            }
        }

        if (reservaParaCancelar == null) {
            System.out.println("Reserva nao encontrada.");
            return;
        }

        reservaParaCancelar.cancelarReserva();
        reservas.remove(reservaParaCancelar);
        reservaParaCancelar.getCliente().getReservas().remove(reservaParaCancelar);
        System.out.println("Reserva cancelada com sucesso.");

    }


    /*
     * Método listarReservasCliente: lista todas as reservas de um cliente específico. Após receber o nome do cliente, ele busca o cliente na lista clientes e exibe as reservas associadas. Se o cliente não for encontrado ou não tiver reservas, exibe uma mensagem apropriada.
     */
    public void listarReservasCliente() {
        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nomeCliente)) {
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado == null) {
            System.out.println("Cliente nao encontrado.");
            return;
        }

        List<Reserva> reservasCliente = clienteEncontrado.getReservas();
        if (reservasCliente.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada para o cliente " + nomeCliente + ".");
        } else {
            System.out.println("Reservas do cliente " + nomeCliente + ":");
            for (Reserva reserva : reservasCliente) {
                System.out.println("Reserva numero: " + reserva.getNumeroReserva());
            }
        }
    }

    /*
     * Método stringToDate: Converte uma data no formato de string (yyyy-MM-dd) em um objeto Date. Caso a string não siga o formato esperado, o método exibe uma mensagem de erro e retorna null.
     */
    public Date stringToDate(String dataEmString) {
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatador.parse(dataEmString);
        } catch (ParseException e) {
            System.out.println("Formato de data invalido. Por favor use YYYY-MM-DD.");
            return null;
        }
    }

    /*
    Método verificarDisponibilidadeQuarto: verifica a disponibilidade de um quarto para uma reserva específica. Ele percorre todas as reservas ativas para o quarto e confirma que a nova reserva não se sobrepõe a reservas existentes. Retorna true se o quarto estiver disponível e false se houver sobreposição.
     * 
     */
    private boolean verificarDisponibilidadeQuarto(Quarto quarto, Date checkIn, Date checkOut) {
        for (Reserva reserva : reservas) {
            if (reserva.getQuarto().equals(quarto) && reserva.getStatus() == StatusReserva.ATIVA) {
                Date reservaCheckIn = reserva.getDataCheckIn();
                Date reservaCheckOut = reserva.getDataCheckOut();
                if (!(checkOut.before(reservaCheckIn) || checkIn.after(reservaCheckOut))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setAdm(Administrador adm) {
        this.adm = adm;
    }

    public Administrador getAdm() {
        return adm;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Hotel> getHoteis() {
        return hoteis;
    }

    public void setHoteis(ArrayList<Hotel> hoteis) {
        this.hoteis = hoteis;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public ArrayList<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(ArrayList<Quarto> quartos) {
        this.quartos = quartos;
    }
}
