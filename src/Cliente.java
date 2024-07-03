import java.util.Comparator;
import java.util.Objects;

public class Cliente {
    private String nome;
    private long CPF;


    public Cliente(String nome, long CPF) {
        this.nome = nome;
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public long getCPF() {
        return CPF;
    }

    @Override
    public String toString() {
        return "nome:'" + nome + '\'' +
                ", CPF=" + CPF +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return getCPF() == cliente.getCPF();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCPF());
    }
}

class ComparatorPorCPF implements Comparator<Cliente> {

    @Override
    public int compare(Cliente c1, Cliente c2) {
        return Long.compare(c1.getCPF(), c2.getCPF());
    }
}

