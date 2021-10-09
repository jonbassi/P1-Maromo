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
    // Funcionários
    // public List<Funcionario> getFuncionarios() { return funcionarios; }
    // public void setFuncionarios(List<Funcionario> funcionarios) { this.funcionarios.addAll(funcionarios); }
    // // Empresa
    // public List<Empresa> getEmpresas() { return empresas; }
    // public void setEmpresas(List<Empresa> empresas) { this.empresas.addAll(empresas); }
    // CNPJ
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    // Razão Social
    public String getRazaoSocial() { return razaoSocial; }
    public void setRazaoSocial(String razaoSocial) { this.razaoSocial = razaoSocial; }


    // Methods


    public Boolean existeEmpresa(Empresa e) {
        boolean status = false;

        for (Empresa empresaVerify : empresas){
            if (Objects.equals(e.idEmpresa, empresaVerify.idEmpresa)){
                status = true;
                break;
            }
        }
        return status;
    }

    public void adicionarEmpregados(EmpresaFuncionario.Funcionario f) {
        funcionarios.add(f);
        

    }

    public void mostrarFuncionarioEspecifico(Funcionario f) {
        for (Funcionario ignored : funcionarios) {
            f.imprimirFuncionario();
        }
    }

    //Empresa única
    public void mostrarEmpregados(Empresa e){

        if(existeEmpresa(e)) {
            System.out.println(e.funcionarios);
        } else{
            System.out.println("Empresa inexistente.");
        }
    }

    // Todas empresas
    public void mostrarTodosEmpregados() {
        for (Funcionario funcionario : funcionarios) {
            funcionario.imprimirFuncionario();
        }
    }
    
    public Boolean contemFuncionario(int f) {
        boolean status = false;
        for (Funcionario funcionario : funcionarios) {
            status = f == funcionario.getIdFunc();
        }
        return status;
    }

    public void inativarfuncionario(Funcionario f) {
        for (Funcionario funcionario : funcionarios) {
            if (f.getIdFunc() == funcionario.getIdFunc()) {
                if(f.getEstaAtivo()) {
                    f.setEstaAtivo(false);
                }
            }        
        }
    }
    
    public void mostrarFuncionariosAtivos() {
        for (Funcionario funcionario : funcionarios) {
            if(funcionario.getEstaAtivo()) {
                funcionario.imprimirFuncionario();
            }
        }
    }
}

