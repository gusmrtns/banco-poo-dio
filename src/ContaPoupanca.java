public class ContaPoupanca extends Conta{


    public ContaPoupanca() {
        super();
    }

    public void renderJuros(double taxa){
        this.saldo += this.saldo * taxa;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "agencia=" + agencia +
                //formatar numero para 2 casas decimais
                ", numero=" + String.format("%.2f", numero) +
                ", saldo=" + saldo +
                '}';
    }
}
