package java14;

import java.util.Objects;

public class PessoaClass {

    private final String nome;
    private final int idade;

    public PessoaClass(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome='" + nome + '\'' + ", idade=" + idade + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PessoaClass)) return false;
        PessoaClass pessoa = (PessoaClass) o;
        return idade == pessoa.idade && nome.equals(pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade);
    }
}
