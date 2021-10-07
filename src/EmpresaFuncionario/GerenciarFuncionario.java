package EmpresaFuncionario;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class GerenciarFuncionario {

    public static void main(String[] args) {
        Funcionario func = new Funcionario();
        Empresa empresa = new Empresa();

        System.out.println("Digite a opção desejada: ");
        System.out.println("1 - Cadastrar funcionário");
        System.out.println("2 - Cadastrar Empresa");
        System.out.println("3 - Atualizar Salário");
        System.out.println("4 - Demitir Funcionário");
        System.out.println("5 - Listar Funcionário");
        System.out.println("6 - Listar Funcionário de todas as empresas");
        System.out.println("7 - Adicionar funcionário ao quadro da empresa");
        System.out.println("8 - Verificar existência de funcionário na empresa");
        System.out.println("9 - FINALIZAR");

        System.out.println("Entre com sua opção: ");
        Scanner entrada = new Scanner(System.in);
        int option  = entrada.nextInt();

        switch (option) {
            case 1:
            // Cadastrar funcionário
            System.out.println("Digite o ID do funcionário: ");
            int idfuncionario = entrada.nextInt();
            func.setIdFunc(idfuncionario);

            System.out.println("Digite o salário do funcionário: ");
            double salario = entrada.nextInt();
            func.setSalario(salario);
            
            func.setEstaAtivo(true);
            
            System.out.println("Digite o nome do funcionário: ");
            String nome = entrada.next();
            func.setNomeFunc(nome);

            System.out.println("Digite o departamento do funcionário: ");
            String departamentoF = entrada.next();
            func.setDepartamento(departamentoF);

            System.out.println("Digite o número do documento do funcionário: ");
            String doc = entrada.next();
            func.setDocumento(doc);

            func.setDataContratacao(LocalDate.now());
            break;

            case 2:
            // Cadastrar Empresa
            System.out.println("Digite o id da Empresa: ");
            String IdEmpresa = entrada.next();
            empresa.setIdEmpresa(IdEmpresa);

            System.out.println("Digite a Razão Social da Empresa: ");
            String Rsocial = entrada.next();
            empresa.setRazaoSocial(Rsocial);

            System.out.println("Digite o CNPJ da empresa: ");
            String cnpj = entrada.next();
            empresa.setCnpj(cnpj);
            break;

            case 3:
            System.out.println("Digite o novo salário do funcionário");
            double novoSalario = entrada.nextInt();
            func.atualizarSalario(novoSalario);
            break;

            case 4:
            System.out.println("Demitir Funcionário");
            System.out.println("Deseja mesmo demitir esse funcionário? (Sim ou Não)");
            String decisao = entrada.next();
            if (Objects.equals(decisao, "Sim")){
                func.demitirFuncionario();
            }
            break;

            case 5:
            // listar funcionário
            func.imprimirFuncionario();
            break;

            case 6:
            System.out.println("Listar Funcionário de todas as empresas");
            empresa.mostrarTodosEmpregados();
            break;

            case 7:
            System.out.println("Adicionar funcionário ao quadro da empresa");
            empresa.adicionarEmpregados (func, empresa);
            break;

            case 8:
            System.out.println("Verificar existência de funcionário na empresa");
            if (empresa.contemFuncionario (func)) {
                System.out.println("Funcionário existente");

            } else {
                System.out.println("Funcionário não encontrado!");
            }    
            break;

            case 9:
            System.out.println("FINALIZAR");
            break;

            default:
            System.out.println("Desculpe, não consegui entender o que quis dizer. Por favor tente novamente.");
        }
    }
}