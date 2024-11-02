

import java.util.ArrayList;

public class Administrador {
    private String nome;
    private int id;

    // Construtor Administrador,
    public Administrador(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    /*
     *Método adicionarHotel: verifica se um hotel com o mesmo nome e endereço já
     * existe na lista hoteis. Se encontrar um hotel duplicado, ele exibe uma
     * mensagem informando que o hotel já existe e encerra o processo. Caso
     * contrário, cria um novo objeto Hotel com o nome e endereço fornecidos,
     * adiciona-o à lista e exibe uma mensagem confirmando a adição. Este método
     * evita a duplicação de hotéis na lista com base no nome e endereço.
     */
    public void adicionarHotel(ArrayList<Hotel> hoteis, String nome, String endereco) {
        for (Hotel hotel : hoteis) {
            if (hotel.getNome().equalsIgnoreCase(nome) && hotel.getEndereco().equalsIgnoreCase(endereco)) {
                System.out.println("Hotel ja existe no sistema.");
                return;
            }
        }
        Hotel novoHotel = new Hotel(nome, endereco);
        hoteis.add(novoHotel);
        System.out.println("Hotel " + novoHotel.getNome() + " adicionado ao sistema.");
    }

    /*
     * Método removerHotel: tem a função de remover um hotel específico de uma
     * ArrayList de hotéis, com base na String nome fornecida. Recebe como
     * parâmetros uma ArrayList "hoteis", e uma String "nome". É criada uma variável
     * booleana de controle chamda de "encontrado", que indicará se o hotel foi
     * encontrado na lista durante a iteração. É criado o loop for each, que cada
     * objeto Hotel na lista hoteis, em cada iteração, é verificado se o nome do
     * hotel sendo percorrido no momento é igual ao nome passado como parâmetro. Se
     * for encontrado algum hotel com nome correspondente, este hotel é removido da
     * lista, seguido de uma mensagem de confirmação printada indicando que o hotel
     * foi removido. A variável encontrado é definida como true, e o laço é
     * encerrado com um break. Após o laço for, verifica se "encontrado" é false, e
     * caso sejam uma mensagem dizendo que o hotel não foi encontrado no sistema é
     * impressa.
     */
    public void removerHotel(ArrayList<Hotel> hoteis, String nome) {
        boolean encontrado = false;
        for (Hotel hotel : hoteis) {
            if (hotel.getNome().equals(nome)) {
                hoteis.remove(hotel);
                System.out.println("Hotel " + hotel.getNome() + " removido do sistema.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Hotel nao encontrado no sistema.");
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
