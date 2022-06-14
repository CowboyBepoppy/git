package classes.itens;
import classes.avaliacao.Avaliacao;
import java.util.Scanner;

public abstract class Item {
    private String titulo;
    private String genero;
    private double valor;
    private Avaliacao[] avaliacoes = new Avaliacao[30];
    public abstract void mostrarItem();

    public void avaliar() {
        Scanner in = new Scanner(System.in);
        Avaliacao a = new Avaliacao();
        System.out.print("Nome avaliador: ");
        a.setNome(in.nextLine());
        System.out.println("Nota (0 até 10): ");

        a.setRating(in.nextDouble());
        in.nextLine();
        System.out.print("Deixe um comentário (opcional): ");
        a.setFeedback(in.nextLine());
        for (int i = 0; i < getAvaliacoes().length; i++) {
            if (getAvaliacoes()[i] == null) {
                getAvaliacoes()[i] = a;
                break;
            }
        }
    }

    public double getTotalRating() {
        double soma = 0;
        int contador = 0;
        for (Avaliacao a : getAvaliacoes()) {
            if (a != null) {
                soma += a.getRating();
                contador++;
            }
        }
        return soma/contador;
    }

    // GETTERS & SETTERS

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Avaliacao[] getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(Avaliacao[] avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
