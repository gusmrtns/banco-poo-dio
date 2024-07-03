import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

public class Conta {

    private static final int AGENCIA_PADRAO = 1;
    private static double SEQUENCIAL = Math.random();

    protected int agencia;
    protected double numero;
    protected double saldo;
    protected Cliente cliente;


    public Conta() {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL;
        this.saldo = 0.0;
    }

    public void sacar(double valor){
        this.saldo -= valor;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void transferir(double valor, Conta destino){
        this.sacar(valor);
        destino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public double getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return getNumero() == conta.getNumero();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNumero());
    }
}

class ComparatorPorSaldo implements Comparator<Map.Entry<Cliente, Conta>> {
    @Override
    public int compare(Map.Entry<Cliente, Conta> c1, Map.Entry<Cliente, Conta> c2) {
        return Double.compare(c1.getValue().getSaldo(), c2.getValue().getSaldo());
    }
}
