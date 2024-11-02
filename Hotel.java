
import java.util.List;
import java.util.ArrayList;

public class Hotel {
    private String nome;
    private String endereco;
    private ArrayList<Quarto> listaDeQuartos;

    public Hotel(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaDeQuartos = new ArrayList<>();
    }

    /*
     * Método adicionarQuarto: Esse método adiciona um novo quarto ao hotel.
     * Primeiro, ele verifica se já
     * existe um quarto com o mesmo número na lista de quartos do hotel. Se um
     * quarto com o mesmo número já existe, exibe uma mensagem de erro e interrompe
     * o processo de adição. Caso contrário, adiciona o novo quarto à lista e exibe
     * uma mensagem confirmando a adição.
     */
    public void adicionarQuarto(Quarto quarto) {
        for (Quarto q : listaDeQuartos) {
            if (q.getNumero() == quarto.getNumero()) {
                System.out.println("Erro: Ja existe um quarto com o numero " + quarto.getNumero() + " no hotel.");
                return;
            }
        }
        listaDeQuartos.add(quarto);
        System.out.println("Quarto " + quarto.getNumero() + " adicionado ao hotel " + nome + ".");
    }

    /*
     * Método removerQuartos: recebe um objeto "Quarto" como parâmetro e, se ele
     * estiver na lista, será removido
     */
    public void removerQuarto(Quarto quarto) {
        listaDeQuartos.remove(quarto);
    }

    /*
     * Método buscarQuartoPorNumero: este método recebe um int "numero" como
     * parâmetro e busca um quarto com número correspondente no ArrayList
     * listaDeQuartos, através de uma condicional if, se o quarto for encontrado,
     * ele é retornado. caso contrário. uma mensagem de erro é exibida e o método
     * retorna null
     */
    public Quarto buscarQuartoPorNumero(int numero) {
        for (Quarto quarto : listaDeQuartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        System.out.println("Quarto não encontrado.");
        return null;
    }

    /*
     * Esse método lista todos os quartos disponíveis no hotel. Para cada quarto na
     * lista, ele verifica se o quarto está disponível chamando método
     * isEstaDisponivel. Se o quarto está disponível, seu número é exibido na saída.
     * 
     */
    public void listarQuartosDisponiveis() {
        System.out.println("Quartos disponiveis no hotel " + nome + ":");
        for (Quarto quarto : listaDeQuartos) {
            if (quarto.isEstaDisponivel()) {
                System.out.println("Quarto " + quarto.getNumero());
            }
        }
    }

    /*
     * Esse método permite atualizar os detalhes de um quarto específico. Primeiro, ele busca o quarto pelo número fornecico usando o métodoc buscarQuartoPorNumero. Se o quarto for encontrado, ele define o novo tipo e o novo preço usando os métodos setTipo e setPreco. Caso contrário, uma mensagem é exibida indicando que o quarto não foi encontrado.
     */
    public void atualizarDetalhesQuarto(int numero, tipoQuarto novoTipo, double novoPreco) {
        Quarto quarto = buscarQuartoPorNumero(numero);
        if (quarto != null) {
            quarto.setTipo(novoTipo);
            quarto.setPreco(novoPreco);
            System.out.println("Detalhes do quarto " + numero + " atualizados.");
        } else {
            System.out.println("Quarto nao encontrado.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Quarto> getListaDeQuartos() {
        return listaDeQuartos;
    }

    public void setListaDeQuartos(ArrayList<Quarto> listaDeQuartos) {
        this.listaDeQuartos = listaDeQuartos;
    }

}
