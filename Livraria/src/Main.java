import classes.guardados.Estante;
import classes.itens.DVD;
import classes.itens.Item;
import classes.itens.Livro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Estante estante = new Estante(5);
        Item item = null;
        while (true) {
            System.out.println("\n ------------ Menu -------------");
            System.out.println("|Informe o que você deseja fazer:  |");
            System.out.println("|(1): Adicionar um item a estante  |");
            System.out.println("|(2): Avaliar um item da estante   |");
            //case dentro do case avaliar

            int continuar = ler.nextInt();
            ler.nextLine();
            if (continuar == 1) {
                System.out.println("Quantos itens quer adicionar?");
                int quantidade = ler.nextInt();
                ler.nextLine();
                for (int i = 0; i < quantidade; i++) {
                    System.out.println("------------------------------------");
                    System.out.println("Informe o item a ser adicionado: DVD (1) lIVRO (2)");
                    int escolha = ler.nextInt();

                    ler.nextLine();
                    switch (escolha) {
                        case 1:
                            item = new DVD();
                            System.out.print("Informe o nome do diretor: ");
                            ((DVD) item).setDiretor(ler.nextLine());
                            System.out.print("Qual a duração do filme, em horas: ");
                            ((DVD) item).setDuracao(ler.nextDouble());
                            ler.nextLine();
                            System.out.print("Qual o ano de lançamento: ");
                            ((DVD) item).setAnoLancamento(ler.nextInt());
                            ler.nextLine();
                            estante.adicionarItem(item);
                            break;
                        case 2:
                            item = new Livro();
                            System.out.print("Digite o nome do autor: ");
                            ((Livro) item).setAutor(ler.nextLine());
                            System.out.print("Informe a quantidade de páginas do livreo: ");
                            ((Livro) item).setQtdePaginas(ler.nextInt());
                            ler.nextLine();
                            System.out.print("Informe o ano de publicação: ");
                            ((Livro) item).setAnoPublicacao(ler.nextInt());
                            ler.nextLine();
                            System.out.print("Informe a edição do livro: ");
                            ((Livro) item).setEdicao(ler.nextInt());
                            ler.nextLine();
                            estante.adicionarItem(item);
                            break;
                        default:
                            System.err.println("Escolha invalida!");
                    }
                    System.out.print("Informe o título: ");
                    assert item != null;
                    item.setTitulo(ler.nextLine());
                    System.out.print("Informe o gênero: ");
                    item.setGenero(ler.nextLine());
                    System.out.print("Informe o valor, em reais R$: ");
                    item.setValor(ler.nextDouble());
                    ler.nextLine();

                    for (Item l : estante.getItens()) {
                        if (l != null) {
                            System.out.println("------------------------------------");
                            System.out.println("O título da obra: " + l.getTitulo());
                            System.out.println("O genero da obra: " + l.getGenero());
                            if (l instanceof DVD) {
                                System.out.println("O ano de lançamento da obra: " + ((DVD) l).getAnoLancamento());
                                System.out.println("O diretor da obra: " + ((DVD) l).getDiretor());
                            } else if (l instanceof Livro) {
                                System.out.println("O ano de publicação da obra: " + ((Livro) l).getAnoPublicacao());
                                System.out.println("O autor da obra: " + ((Livro) l).getAutor());
                            }
                            System.out.println("------------------------------------");
                        }
                    }
                    System.out.println("A quantidade de itens na instante é de: " + estante.quantidadeItens());
                }
            } else if (continuar == 2) {
                System.out.print("Informe o item a ser avaliado (Título do DVD ou Livro): ");
                Item avaliar = estante.buscarItem(ler.nextLine());
                if (avaliar == null) {
                    System.err.println("Item nao encontrado");
                } else {
                    System.out.println("Segue o formulario para a avaliação do item: " + avaliar.getTitulo());
                    avaliar.avaliar();
                }
            }
            System.out.println("Voce deseja fazer mais alguma ação? (S/N)");
            if (ler.nextLine().equals("N")) {
                System.out.println("Obrigado por utilizar nossa estante!");
                break;
            }

        }
    }
}
