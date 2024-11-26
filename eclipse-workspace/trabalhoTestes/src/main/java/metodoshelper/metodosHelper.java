package metodoshelper;

import java.util.ArrayList;
import java.util.List;

public class metodosHelper {
    private List<String> entregadores = new ArrayList<>();
    private List<String> oficinas = new ArrayList<>();

    public List<String> obterEntregadores() {
        return entregadores;
    }

    public List<String> obterOficinas() {
        return oficinas;
    }

    public String escolherOficina(String nome) {
        if (oficinas.contains(nome)) {
            return "Oficina escolhida: " + nome;
        } else {
            throw new IllegalArgumentException("A oficina solicitada não foi encontrada.");
        }
    }

    public void registrarEntregador(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do entregador não pode ser vazio ou nulo.");
        }
        entregadores.add(nome);
    }

    public void registrarOficina(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da oficina não pode ser vazio ou nulo.");
        }
        oficinas.add(nome);
    }
}
