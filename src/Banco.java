import java.util.*;

public class Banco {
    private String nome;
    private Map<Cliente, Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new HashMap<>();
    }

    public void adicionarConta(Cliente cliente, Conta conta) {
        this.contas.put(cliente, conta);
    }

    public void removerPorCPF(long CPF) {
        for (Cliente cliente : contas.keySet()) {
            if (cliente.getCPF() == CPF) {
                contas.remove(cliente);
                break;
            }
        }
    }

    public void removerPorNumeroConta(int numeroConta) {
        for (Conta conta : contas.values()) {
            if (conta.getNumero() == numeroConta) {
                contas.remove(conta);
                break;
            }
        }
    }

    public void obterContas(){
        System.out.println(contas);
    }

    public Map<Cliente, Conta> exibirContasOrdenadasPorSaldo() {
        List<Map.Entry<Cliente, Conta>> ContasParaOrdenarPorSaldo = new ArrayList<>(contas.entrySet());

        ContasParaOrdenarPorSaldo.sort(new ComparatorPorSaldo());

        Map<Cliente, Conta> ContasOrdenadasPorSaldo = new LinkedHashMap<>();

        for (Map.Entry<Cliente, Conta> entry : ContasParaOrdenarPorSaldo) {
            ContasOrdenadasPorSaldo.put(entry.getKey(), entry.getValue());
        }

        return ContasOrdenadasPorSaldo;
    }

    public Conta obterContaComMaiorSaldo() {
        List<Map.Entry<Cliente, Conta>> ContasParaOrdenarPorSaldo = new ArrayList<>(contas.entrySet());
        ContasParaOrdenarPorSaldo.sort(new ComparatorPorSaldo());
        return ContasParaOrdenarPorSaldo.getLast().getValue();
    }

    public Conta obterContaComMenorSaldo() {
        List<Map.Entry<Cliente, Conta>> ContasParaOrdenarPorSaldo = new ArrayList<>(contas.entrySet());
        ContasParaOrdenarPorSaldo.sort(new ComparatorPorSaldo());
        return ContasParaOrdenarPorSaldo.getFirst().getValue();
    }

    public int obterQuantidadeContas() {
        return contas.size();
    }

    public Conta obterContaPorCPF(long CPF) {
        for (Cliente cliente : contas.keySet()) {
            if (cliente.getCPF() == CPF) {
                return contas.get(cliente);
            }
        }
        return null;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banco banco = (Banco) o;
        return Objects.equals(nome, banco.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

}


