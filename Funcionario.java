package br.com.prozeducacao.HelpDesk;

public class Funcionario {
    private String nome;
    private String email;
    private String setor;

    public Funcionario(String nome, String email, String setor) {
        this.nome = nome;
        this.email = email;
        this.setor = setor;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSetor() {
        return setor;
    }
    
    public void setSetor(String setor) {
        this.setor = setor;
    }
        
    public String exibirDados() {
        return "Funcionário: " + nome +
               "\nEmail: " + email +
               "\nSetor: " + setor;
    }
}