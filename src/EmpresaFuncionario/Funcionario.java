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
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public String getDepartamento() {
        return departamento;
    }
    // Profissão
    public void setProfissao(String departamento) {
        this.profissao = profissao;
    }
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

    // O método atualizarSalario recebe como argumento um valor double que se refere ao valor dado como aumento, deve atualizar o campo salário.
    public void atualizarSalario(double valor) {
        if (valor > 0){
    // Verificar se nessa situação o valor já virá certo com o novo salário ou se terá que somar o valor com o salário atual
            setSalario(valor);
        }
    }

    // O método demitirFuncionario altera o campo estaAtivo para false.
    public void demitirFuncionario() {
        setNomeFunc(null);
        setDocumento(null);
        setEstaAtivo(false);
        setDepartamento(null);
        setProfissao(null); // bassi
        setDataContratacao(null);
        setSalario(0);
        setIdFunc(-1);
    }

    // O método imprimir deve exibir todos os dados de um objeto instanciado.
    public void imprimirFuncionario() {
        String active;
    // Verificar se precisa usar o get ou se dá pra utilizar direto a variável
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
