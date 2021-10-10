package EmpresaFuncionario;

import java.time.LocalDate;

public class Funcionario {

    // Attributes

    private int idFunc;
    private double salario;
    private boolean estaAtivo;
    private String nomeFunc;
    private String departamento;
    private String profissao;
    private String documento;
    private LocalDate dataContratacao;

    // Setters and Getters

    // ID Funcionário    
    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }
    public int getIdFunc() {
        return idFunc;
    }

    // Salário
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public double getSalario() {
        return salario;
    }

    // Está ativo
    public void setEstaAtivo(boolean estaAtivo) {
        this.estaAtivo = estaAtivo;
    }
    public boolean getEstaAtivo() {
        return estaAtivo;
    }

    // Nome Funcionário
    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }
    public String getNomeFunc() {
        return nomeFunc;
    }

    // Departamento
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    public String getDepartamento() {
        return departamento;
    }

    // Profissão
    public void setProfissao(String profissao) { this.profissao = profissao;}
    public String getProfissao() {
        return profissao;
    }

    // Documento
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getDocumento() {
        return documento;
    }

    // Data de Contratação
    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
    public LocalDate getDataContratacao() { return dataContratacao; }


    
    // Methods

    // Atualizar o salário do funcionário.
    public void atualizarSalario(double valor) {
        if (valor > 0) {
            setSalario(valor);
        }
    }

    // Demitir o funcionário.
    public void demitirFuncionario() {
        setNomeFunc(null);
        setDocumento(null);
        setEstaAtivo(false);
        setDepartamento(null);
        setProfissao(null);
        setDataContratacao(null);
        setSalario(0);
        setIdFunc(-1);
    }

    // Imprimir os dados do funcionário.
    public void imprimirFuncionario() {
        String active;
        if(getEstaAtivo()) {
            active = "Ativo";
        } else {
            active = "Inativo";
        }

        System.out.println("ID do Funcionário: " + idFunc);
        System.out.println("Nome do Funcionário: " + nomeFunc);
        System.out.println("Departamento: " + departamento);
        System.out.println("Profissão: " + profissao);
        System.out.println("Documento: " + documento);
        System.out.println("Data da Contratação: " + dataContratacao);
        System.out.println("Salário do Funcionário: " + salario);
        System.out.println("Ativo: " + active);
    }
}
