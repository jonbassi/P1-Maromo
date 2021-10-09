package EmpresaFuncionario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GerenciarFuncionario {

    public static void main(String[] args) {
        boolean status = true;

        List<Funcionario> listaDeFuncionarios = new ArrayList<>();
        List<Empresa> listaDeEmpresas = new ArrayList<>();

        int idFunc = 1;

        // TODO : Criar uma lista de funcionários. ✅ 👌
        // TODO : Criar uma lista de empresas. ✅ 👌
        // TODO : Adicionar funcionário a lista de funcionários | Adicionar empresa a lista de empresas. ✅ 👌
        // TODO : Testar. ✅ 👌

        while(status) {

            Funcionario func = new Funcionario();
            Empresa empresa = new Empresa();

            System.out.println();
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
            int option = entrada.nextInt();

            switch (option) {
                case 1:
                    // Cadastrar funcionário
                    //System.out.println("Digite o ID do funcionário: ");
                    //int idfuncionario = entrada.nextInt();
                    func.setIdFunc(idFunc);

                    System.out.println("Digite o salário do funcionário: ");
                    double salario = entrada.nextDouble();
                    func.setSalario(salario);
                    if(entrada.hasNextLine()) {
                        String nome = entrada.nextLine();
                        func.setNomeFunc(nome);
                    }

                    System.out.println("Digite o nome do funcionário: ");

                    if(entrada.hasNextLine()) {
                        String nome = entrada.nextLine();
                        func.setNomeFunc(nome);
                    }

                    System.out.println("Digite o departamento do funcionário: ");
                    String departamentoF = entrada.nextLine();
                    func.setDepartamento(departamentoF);

                    System.out.println("Digite a profissão do funcionário: ");
                    String profissaoF = entrada.nextLine();
                    func.setProfissao(profissaoF);

                    System.out.println("Digite o número do documento do funcionário: ");
                    String doc = entrada.nextLine();
                    func.setDocumento(doc);

                    func.setDataContratacao(LocalDate.now());
                    func.setEstaAtivo(true);

                    listaDeFuncionarios.add(func);
                    idFunc += 1;

                    break;

                case 2:
                    // Cadastrar Empresa
                    System.out.println("Digite o id da Empresa: ");
                    String IdEmpresa = entrada.next();
                    empresa.setIdEmpresa(IdEmpresa);
                    if(entrada.hasNextLine()) {
                        String idEmpresa = entrada.nextLine();
                        func.setNomeFunc(idEmpresa);
                    }

                    System.out.println("Digite a Razão Social da Empresa: ");
                    String Rsocial = entrada.next();
                    empresa.setRazaoSocial(Rsocial);
                    if(entrada.hasNextLine()) {
                        String rsocial = entrada.nextLine();
                        func.setNomeFunc(rsocial);
                    }

                    System.out.println("Digite o CNPJ da empresa: ");
                    String cnpj = entrada.next();
                    empresa.setCnpj(cnpj);
                    if(entrada.hasNextLine()) {
                        String CNPJ = entrada.nextLine();
                        func.setNomeFunc(CNPJ);
                    }

                    listaDeEmpresas.add(empresa);

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
                    if (Objects.equals(decisao, "Sim")) {
                        func.demitirFuncionario();
                    }
                    break;

                case 5:
                    // Mostrar um funcionário específico
                    // Pedir empresa do funcionário
                    boolean found = false;
                    System.out.println("Digite o ID do funcionário que quer buscar: ");
                    int idBuscar = entrada.nextInt();
                    for (Funcionario funcionarioBusca : listaDeFuncionarios) {
                        if (idBuscar == funcionarioBusca.getIdFunc()) {
                            funcionarioBusca.imprimirFuncionario();
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Funcionário não encontrado 😢");
                    }

                    break;

                case 6:
                    System.out.println("Listar Funcionário de todas as empresas");
                    empresa.mostrarTodosEmpregados();
                    break;

                case 7:
                    System.out.println("Adicionar funcionário ao quadro da empresa");
                    empresa.adicionarEmpregados(func);
                    break;

                case 8:
                    System.out.println("Verificar existência de funcionário na empresa");
                    if (empresa.contemFuncionario(func)) {
                        System.out.println("Funcionário existente");

                    } else {
                        System.out.println("Funcionário não encontrado!");
                    }
                    break;

                case 9:
                    status = false;
                    break;

                default:
                    System.out.println("Desculpe, não consegui entender o que quis dizer. Por favor tente novamente.");
            }
        }
    }
}