import classes.guardados.Estante;
import classes.itens.DVD;
import classes.itens.Livro;

import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Estante estante = new Estante(5);
        DVD dvd = new DVD();
        Livro livro = new Livro();

        System.out.print("Quantos itens?: ");
        int numItens = in.nextInt();
        in.nextLine();

        for (int i = 0; i < numItens; i++) {
            System.out.print("DVD ou Livro? (1)-DVD (2)-Livro");
            if (in.nextLine().equalsIgnoreCase("1")) {
                System.out.print("Título: ");
                dvd.setTitulo(in.nextLine());
                System.out.print("Gênero: ");
                dvd.setGenero(in.nextLine());
                System.out.print("Valor: R$");
                dvd.setValor(in.nextDouble());
                in.nextLine();
                System.out.print("Ano de lançamento: ");
                dvd.setAnoLancamento(in.nextInt());
                in.nextLine();
                System.out.print("Nome do diretor: ");
                dvd.setDiretor(in.nextLine());
                System.out.print("Duração: ");
                dvd.setDuracao(in.nextDouble());
                in.nextLine();
                //AdicionarDVD

            } else {
                System.out.print("Título: ");
                livro.setTitulo(in.nextLine());

                System.out.print("Gênero: ");
                livro.setGenero(in.nextLine());

                System.out.print("Valor: R$");
                livro.setValor(in.nextDouble());
                in.nextLine();

                System.out.print("Autor: ");
                livro.setAutor(in.nextLine());

                System.out.print("Ano de publicação: ");
                livro.setAnoPublicacao(in.nextInt());
                in.nextLine();

                System.out.print("Quantidade de páginas: ");
                livro.setQtdePaginas(in.nextInt());
                in.nextLine();

                System.out.print("Edição: ");
                livro.setEdicao(in.nextInt());
                in.nextLine();
                //ADICIONAR
            }
        }
    }
}
