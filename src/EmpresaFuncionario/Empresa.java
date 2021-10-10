package EmpresaFuncionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Empresa {

    // Attributes
    
    private String idEmpresa;
    private String razaoSocial;
    private String cnpj;
    public List<Funcionario> funcionarios = new ArrayList<>();
    public List<Empresa> empresas = new ArrayList<>();

    // Setters and Getters

    // ID Empresa
    public String getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(String idEmpresa) { this.idEmpresa = idEmpresa; }

    // CNPJ
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    // Razão Social
    public String getRazaoSocial() { return razaoSocial; }
    public void setRazaoSocial(String razaoSocial) { this.razaoSocial = razaoSocial; }


    // Methods

    // Verificar a existência de uma empresa.
    public Boolean existeEmpresa(Empresa e) {
        boolean status = false;

        for (Empresa empresaExiste : empresas) {
            if (Objects.equals(e.idEmpresa, empresaExiste.idEmpresa)) {
                status = true;
                break;
            }
        }
        return status;
    }

    // Verificar a existência de um funcionário
    public Boolean existeFuncionario(int f) {
        boolean status = false;
        for (Funcionario funcionario : funcionarios) {
            status = f == funcionario.getIdFunc();
        }
        return status;
    }

    // Adicionar empregados / funcionários a lista.
    public void adicionarEmpregados(EmpresaFuncionario.Funcionario f) {
        funcionarios.add(f);
    }

    // Mostrar um funcionário específico de uma empresa.
    public void mostrarFuncionarioEspecifico(Funcionario f) {
        for (Funcionario ignored : funcionarios) {
            f.imprimirFuncionario();
        }
    }

    // Mostrar empregados de uma empresa.
    public void mostrarEmpregados(Empresa e) {

        if(existeEmpresa(e)) {
            System.out.println(e.funcionarios);
        } else {
            System.out.println("Empresa inexistente.");
        }
    }

    // Mostrar empregados de todas as empresas.
    public void mostrarTodosEmpregados() {
        for (Funcionario funcionario : funcionarios) {
            funcionario.imprimirFuncionario();
        }
    }

    // Inativar funcionário específico.
    public void inativarfuncionario(Funcionario f) {
        for (Funcionario funcionario : funcionarios) {
            if (f.getIdFunc() == funcionario.getIdFunc()) {
                if(f.getEstaAtivo()) {
                    f.setEstaAtivo(false);
                }
            }        
        }
    }

    // Mostrar todos funcionários ativos.
    public void mostrarFuncionariosAtivos() {
        for (Funcionario funcionario : funcionarios) {
            if(funcionario.getEstaAtivo()) {
                funcionario.imprimirFuncionario();
            }
        }
    }
}

