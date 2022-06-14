
import classes.avaliacao.Avaliacao;
import classes.guardados.Estante;
import classes.itens.DVD;
import classes.itens.Item;
import classes.itens.Livro;

import java.util.Scanner;


public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Estante estante = new Estante(5);
        int escolha = -1;
        while (escolha != 0) {
            System.out.println("1 - Adicionar um item na estante");
            System.out.println("2 - Buscar um item e tratar");
            System.out.println("3 - Remover item da estante");
            System.out.println("4 - Ver itens na estante");
            System.out.println("0 - Sair");
            escolha = in.nextInt();
            in.nextLine();
            switch (escolha) {
                case 1:
                    cadastrarItem(estante);
                    break;
                case 2:
                    buscarEAvaliarItem(estante);
                    break;
                case 3:
                    removerItem(estante);
                    break;
                case 4:
                    mostrarItens(estante);
                    break;
            }

        }
    }
// colocar o nome do item na lista
    public static void cadastrarItem(Estante estante) {
        if (estante.estanteCheia()) {
            System.out.println("Estante cheia!");
        } else {
            System.out.println("--ADICIONAR ITEM--");
            Item item = null;
            int tipo = -1;
            while (tipo < 1 || tipo > 2) {
                System.out.println("1-Livro/2-DVD:");
                tipo = in.nextInt();
                in.nextLine();
                switch (tipo) {
                    case 1:
                        item = new Livro();
                        break;
                    case 2:
                        item = new DVD();
                        break;
                    default:
                        System.err.println("Valor inválido");
                        break;
                }
            }
            System.out.print("Digite o título: ");
            item.setTitulo(in.nextLine());
            System.out.print("Digite o gênero: ");
            item.setGenero(in.nextLine());
            System.out.print("Digite o valor: R$"); //Impedir que coloque String
            item.setValor(in.nextDouble());

            in.nextLine();
            System.out.println("------------------------------------------------------");
            estante.adicionarItem(item);
        }
    }

    public static void buscarEAvaliarItem(Estante estante) {
        System.out.println("--Buscar e tratar--");
        System.out.print("Título da procura: ");
        Item i = estante.buscarItem(in.nextLine());
        if (i == null) {
            System.out.println("Nenhum item encontrado!");
        } else {
            System.out.println("Encontrado: " + i.getTitulo());
            System.out.println("Você deseja:");
            System.out.println("1 - Avaliar");
            System.out.println("2 - Ver avaliações");
            int escolha = in.nextInt();
            switch (escolha) {
                case 1:
                    i.avaliar();
                    break;
                case 2:
                    System.out.println("--AVALIAÇÕES--");
                    for (Avaliacao a : i.getAvaliacoes()) {
                        if (a != null) {
                            System.out.println(a.getNome() + " - " + a.getRating() + "\n-----------\nFeedback: " + a.getFeedback() + "\n---------------------");
                        }
                    }
                    System.out.println("Nota geral: " + i.getTotalRating());
                    break;
            }
        }
        System.out.println("------------------------------------------------------");
    }

    public static void removerItem(Estante estante) {
        System.out.println("--REMOVER ITEM--");
        if (estante.quantidadeItens() == 0) {
            System.out.println("Estante vazia!");
        } else {
            System.out.println("Qual posição deseja remover? ");
            Item i = estante.removerItem(in.nextInt());
            if (i == null) {
                System.out.println("A posição está vazia!");
            } else {
                System.out.println(i.getTitulo() + " foi removido.");
            }
        }
        System.out.println("------------------------------------------------------");
    }

    public static void mostrarItens(Estante estante) {
        System.out.println("--ESTANTE--");
        System.out.println("A estante tem " + estante.quantidadeItens() + " item(ns).");
        if (estante.estanteCheia()) {
            System.out.println("A estante está cheia!");
        }
        for (int j = 0; j < 5; j++) {

            Item itemf = estante.getItensEstante()[j];
            if (itemf != null) {
                System.out.println("---------------------------");
                itemf.mostrarItem();
                System.out.println("Posição na estante: " + j);
            }
        }
        System.out.println("------------------------------------------------------");
    }
}
