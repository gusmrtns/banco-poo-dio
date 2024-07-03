public class ContaCorrente extends Conta {


    public ContaCorrente() {
        super();
    }

    public void pagarBoleto(double valor){
        this.saldo -= valor;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "agencia=" + agencia +
                ", numero=" + String.format("%.2f", numero) +
                ", saldo=" + saldo +
                '}';
    }
}
