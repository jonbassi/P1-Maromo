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
        int idEmpresa = 1;

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

                    System.out.println("Digite o nome do funcionário: ");

                    if(entrada.hasNextLine()) {
                        String nome = entrada.nextLine();
                        func.setNomeFunc(nome);
                    }

                    System.out.println("Digite o salário do funcionário: ");
                    double salario = entrada.nextDouble();
                    func.setSalario(salario);

                    System.out.println("Digite o departamento do funcionário: ");
                    String departamentoF = entrada.nextLine();
                    func.setDepartamento(departamentoF);

                    System.out.println("Digite a profissão do funcionário: ");
                    String profissaoF = entrada.nextLine();
                    func.setProfissao(profissaoF);

                    System.out.println("Digite o número do documento do funcionário: ");
                    String doc = entrada.nextLine();
                    func.setDocumento(doc);

                    // Auto set
                    func.setDataContratacao(LocalDate.now());
                    func.setEstaAtivo(true);
                    func.setIdFunc(idFunc);

                    // Lista
                    listaDeFuncionarios.add(func);

                    //ID count
                    idFunc += 1;

                    break;

                case 2:
                    // Cadastrar Empresa
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

                    // Auto set
                    empresa.setIdEmpresa(String.valueOf(idEmpresa));

                    // Lista
                    listaDeEmpresas.add(empresa);

                    //ID count
                    idEmpresa += 1;

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

                    System.out.println("Digite o ID da empresa do funcionário ");
                    int idBuscarEmpresa = entrada.nextInt();
                    for (Empresa empresabusca : listaDeEmpresas) {
                        if (String.valueOf(idBuscarEmpresa).equals(empresabusca.getIdEmpresa())) {
                            // func.
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
                            // found = False ser para quando não encontrar o funcionário na lista de funcionários.
                            if(!found){
                                System.out.println("Funcionário não encontrado 😢");
                            }
                            break;
                        }
                        System.out.println("Empresa não encontrada");
                        break;
                    }

                    break;

                case 6:
                    System.out.println("Listar Funcionário de todas as empresas");
                    empresa.mostrarTodosEmpregados();
                    break;

                case 7:
                    System.out.println("Adicionar funcionário ao quadro da empresa");

                    System.out.println("Digite o ID do funcionário que você deseja adicionar: ");
                    int idFuncAdd = entrada.nextInt();

                    System.out.println("Digite o ID da empresa que você deseja incluir o funcionário: ");
                    int idEmpAdd = entrada.nextInt();

                    boolean added = false;

                    for (Empresa empresaAdd : listaDeEmpresas) {
                        if (String.valueOf(idEmpAdd).equals(empresaAdd.getIdEmpresa())) {
                            for (Funcionario funcAdd : listaDeFuncionarios) {
                                if (idFuncAdd == funcAdd.getIdFunc()) {
                                    empresaAdd.adicionarEmpregados(funcAdd);
                                    added = true;
                                    break;
                                }
                            }
                        }
                    }

                    if(!added) {
                        System.out.println("Empresa e/ou funcionário não encontrado(s).");
                    }

                    // TODO : Percorre a lista
                    // TODO : Acha o funcionário especificado
                    // TODO : Empresa especificada
                    // TODO : Inclui esse funcionário no objeto empresa (Empresa especificada) no método adicionar empregados

                    break;

                case 8:
                    // TODO : Testar após o caso 7 estar completo, pois não consigo o retorno da lista de funcionários cadastrado na empresa
                    System.out.println("Verificar existência de funcionário na empresa");
                    System.out.println("Digite o ID do funcionário que você deseja verificar: ");
                    int idFuncBusca = entrada.nextInt();

                    System.out.println("Digite o ID da empresa que esse funcionário está cadastrado: ");
                    int idEmpBusca = entrada.nextInt();

                    for (Empresa empresaBusca : listaDeEmpresas){
                        if (String.valueOf(idEmpBusca).equals(empresaBusca.getIdEmpresa())) {
                            if (empresaBusca.contemFuncionario(idFuncBusca)){
                                System.out.println("Funcionário existente nessa empresa");
                            } else {
                                System.out.println("Funcionário não encontrado!");
                            }
                        } else {
                            System.out.println("Empresa não encontrada, por favor, verifique se o ID está correto.");
                        }
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