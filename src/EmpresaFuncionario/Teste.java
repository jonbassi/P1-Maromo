package EmpresaFuncionario;

import java.time.LocalDate;

public class Teste {
    public static void main(String[] args) {
        EmpresaFuncionario.Funcionario funcionario = new Funcionario();
        Empresa empresa = new Empresa();

        funcionario.setNomeFunc("Carlos Emanuel Fernandes");
        funcionario.setDocumento("12.123.123-1");
        funcionario.setIdFunc(1);
        funcionario.setDepartamento("Vendas");
        funcionario.setSalario(1200);
        funcionario.setDataContratacao(LocalDate.now());
        funcionario.setEstaAtivo(true);

        empresa.adicionarEmpregados(funcionario);

        empresa.mostrarTodosEmpregados();



    }
}

