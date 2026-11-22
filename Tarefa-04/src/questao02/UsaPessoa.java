package questao02;

import java.util.Scanner;

// Questão 2 - Usa a classe Pessoa
public class UsaPessoa {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = teclado.nextLine();

        System.out.print("Idade: ");
        int idade = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Endereço: ");
        String endereco = teclado.nextLine();

        Pessoa pessoa = new Pessoa(nome, idade, endereco);

        System.out.println();
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());
        System.out.println("Endereço: " + pessoa.getEndereco());

        pessoa.fazAniversario();
        pessoa.fazAniversario();
        pessoa.fazAniversario();

        System.out.println();
        System.out.println("Depois de 3 aniversários:");
        pessoa.imprime();

        teclado.close();
    }
}
