package br.com.prozeducacao.HelpDesk;
	
import java.util.Date;

public class Chamado {
    private String titulo;          // Título do chamado
    private String descricao;       // Descrição detalhada do problema
    private Funcionario funcionario;// Funcionário que abriu o chamado
    private Date dataAbertura;      // Data em que o chamado foi criado
    private String status;          // Status do chamado ("Aberto", "Em atendimento", "Resolvido")
    private Tecnico tecnico;        // Técnico responsável pelo atendimento

    public Chamado(String titulo, String descricao, Funcionario funcionario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.funcionario = funcionario;
        this.dataAbertura = new Date();
        this.status = "Aberto";
        this.tecnico = null;    
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
    public String exibirDados() {
    return "Título: " + titulo +
           "\nDescrição: " + descricao +
           "\nSolicitante: " + funcionario.getNome() +
           "\nData de Abertura: " + dataAbertura +
           "\nStatus: " + status +
           "\nTécnico: " + (tecnico != null ? tecnico.getNome() : "Não atribuído");
    }
}