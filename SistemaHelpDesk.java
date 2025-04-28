package br.com.prozeducacao.HelpDesk;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class SistemaHelpDesk {

	
    public static void main(String[] args) {
    	ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        ArrayList<Chamado> chamados = new ArrayList<>();
    	
    	int opcao;
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(""
                + "1 - Cadastrar Funcionário\n"
                + "2 - Cadastrar Técnico\n"
                + "3 - Cadastrar Chamado\n"
                + "4 - Atribuir Técnico ao Chamado\n"
                + "5 - Listar Chamados por Status\n"
                + "6 - Listar Chamados por Funcionário\n"
                + "7 - Atualizar Status do Chamado\n"
                + "0 - Sair\n"
                + "Escolha uma opção:"));


			switch (opcao) {
            case 1 -> {
                String nome = JOptionPane.showInputDialog("Nome do Funcionário:");
                String email = JOptionPane.showInputDialog("Email:");
                String setor = JOptionPane.showInputDialog("Setor:");
                funcionarios.add(new Funcionario(nome, email, setor));
                JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
            }

            case 2 -> {
                String nome = JOptionPane.showInputDialog("Nome do Técnico:");
                String especialidade = JOptionPane.showInputDialog("Especialidade:");
                tecnicos.add(new Tecnico(nome, especialidade));
                JOptionPane.showMessageDialog(null, "Técnico cadastrado com sucesso!");
            }

            case 3 -> {
                if (funcionarios.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Cadastre um funcionário primeiro.");
                    break;
                }

                String titulo = JOptionPane.showInputDialog("Título do Chamado:");
                String descricao = JOptionPane.showInputDialog("Descrição do Chamado:");
                String listaFuncionarios = "";
                for (int i = 0; i < funcionarios.size(); i++) {
                    listaFuncionarios += i + " - " + funcionarios.get(i).getNome() + "\n";
                }
                int indice = Integer.parseInt(JOptionPane.showInputDialog("Escolha o funcionário:\n" + listaFuncionarios));
                Chamado chamado = new Chamado(titulo, descricao, funcionarios.get(indice));
                chamados.add(chamado);
                JOptionPane.showMessageDialog(null, "Chamado cadastrado com sucesso!");
            }

            case 4 -> {
                if (chamados.isEmpty() || tecnicos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Cadastre chamados e técnicos primeiro.");
                    break;
                }

                String listaChamados = "";
                for (int i = 0; i < chamados.size(); i++) {
                    listaChamados += i + " - " + chamados.get(i).getTitulo() + "\n";
                }
                int chamadoIndex = Integer.parseInt(JOptionPane.showInputDialog("Escolha o chamado:\n" + listaChamados));

                String listaTecnicos = "";
                for (int i = 0; i < tecnicos.size(); i++) {
                    listaTecnicos += i + " - " + tecnicos.get(i).getNome() + "\n";
                }
                int tecnicoIndex = Integer.parseInt(JOptionPane.showInputDialog("Escolha o técnico:\n" + listaTecnicos));

                chamados.get(chamadoIndex).setTecnico(tecnicos.get(tecnicoIndex));
                chamados.get(chamadoIndex).setStatus("Em atendimento");
                JOptionPane.showMessageDialog(null, "Técnico atribuído com sucesso!");
            }

            case 5 -> {
                String status = JOptionPane.showInputDialog("Digite o status (Aberto, Em atendimento, Resolvido):");
                String resultado = "";
                for (Chamado c : chamados) {
                    if (c.getStatus().equalsIgnoreCase(status)) {
                        resultado += c.exibirDados() + "\n";
                    }
                }
                JOptionPane.showMessageDialog(null, resultado.isEmpty() ? "Nenhum chamado encontrado." : resultado);
            }

            case 6 -> {
                String nome = JOptionPane.showInputDialog("Digite o nome do funcionário:");
                String resultado = "";
                for (Chamado c : chamados) {
                    if (c.getFuncionario().getNome().equalsIgnoreCase(nome)) {
                        resultado += c.exibirDados() + "\n";
                    }
                }
                JOptionPane.showMessageDialog(null, resultado.isEmpty() ? "Nenhum chamado encontrado para esse funcionário." : resultado);
            }

            case 7 -> {
                String listaChamados = "";
                for (int i = 0; i < chamados.size(); i++) {
                    listaChamados += i + " - " + chamados.get(i).getTitulo() + " (" + chamados.get(i).getStatus() + ")\n";
                }
                int indice = Integer.parseInt(JOptionPane.showInputDialog("Escolha o chamado:\n" + listaChamados));
                String novoStatus = JOptionPane.showInputDialog("Novo status (Aberto, Em atendimento, Resolvido):");
                chamados.get(indice).setStatus(novoStatus);
                JOptionPane.showMessageDialog(null, "Status atualizado!");
            }

            case 8 -> {
                String todos = "";
                for (Chamado c : chamados) {
                    todos += c + "\n";
                }
                JOptionPane.showMessageDialog(null, todos.isEmpty() ? "Nenhum chamado cadastrado." : todos);
            }

            case 0 -> JOptionPane.showMessageDialog(null, "Encerrando o sistema...");
            default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
        }
    } while (opcao != 0);
}
}