public class Main {

    public static void main(String[] args) {
        // instanciando banco
        Banco Itau = new Banco("Itau");
        Menu menu = new Menu();

        // instanciando contas
        ContaCorrente contaCorrente1 = new ContaCorrente();
        ContaCorrente contaCorrente2 = new ContaCorrente();
        ContaPoupanca contaPoupanca1 = new ContaPoupanca();
        ContaPoupanca contaPoupanca2 = new ContaPoupanca();

        // adicionando contas ao banco
        Cliente cliente1 = new Cliente("João", 1234567);
        Cliente cliente2 = new Cliente("Maria", 7654321);
        Cliente cliente3 = new Cliente("José", 4567891);

        // adicionando contas ao cliente
        Itau.adicionarConta(cliente1, contaCorrente1);
        Itau.adicionarConta(cliente2, contaCorrente2);
        Itau.adicionarConta(cliente3, contaPoupanca1);
        Itau.adicionarConta(cliente3, contaPoupanca2);

        // removendo conta por CPF
        Itau.removerPorCPF(1234567);

        // exibindo contas
        Itau.obterContas();

        // depositando
        contaCorrente1.depositar(1000);
        contaCorrente2.depositar(2000);
        contaPoupanca1.depositar(3000);
        contaPoupanca2.depositar(4000);

        Itau.obterContas();

        // sacando
        contaCorrente1.sacar(500);
        contaCorrente2.sacar(1000);
        contaPoupanca1.sacar(1500);
        contaPoupanca2.sacar(2000);

        Itau.obterContas();

        // transferindo
        contaCorrente1.transferir(100, contaCorrente2);
        contaPoupanca1.transferir(200, contaPoupanca2);
        contaCorrente2.transferir(300, contaPoupanca1);

        // exibindo contas
        Itau.obterContas();

        // exibiindo contas ordenadas por saldo
        System.out.println(Itau.exibirContasOrdenadasPorSaldo());

        // exibindo conta com maior saldo
        Itau.obterContaComMaiorSaldo();

        // exibindo conta com menor saldo
        Itau.obterContaComMenorSaldo();

        // exibindo quantidade de contas
        Itau.obterQuantidadeContas();

        // exibindo conta por CPF
        Itau.obterContaPorCPF(7654321);




    }
}
