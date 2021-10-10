package EmpresaFuncionario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GerenciarFuncionario {

    // TODO : Tratamento de Erros e Exceções.

    public static void main(String[] args) {
        boolean status = true;

        List<Funcionario> listaDeFuncionarios = new ArrayList<>();
        List<Empresa> listaDeEmpresas = new ArrayList<>();

        int idFunc = 1;
        int idEmpresa = 1;

        while(status) {

            Funcionario func = new Funcionario();
            Empresa empresa  = new Empresa();

            System.out.println();
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
            int option      = entrada.nextInt();

            switch (option) {
                case 1:
                    // Cadastrar funcionário.
                    System.out.println("Digite o nome do funcionário: ");
                    if(entrada.hasNextLine()) {
                        String nomefunc = entrada.nextLine();
                        func.setNomeFunc(nomefunc);
                    }
                    String nomefunc = entrada.nextLine();
                    func.setNomeFunc(nomefunc);

                    System.out.println("Digite o salário do funcionário: ");
                    if (entrada.hasNextLine()) {
                        double salario = entrada.nextDouble();
                        func.setSalario(salario);
                    }

                    System.out.println("Digite o departamento do funcionário: ");
                    String departamentoFunc = entrada.nextLine();
                    func.setDepartamento(departamentoFunc);
                    if(entrada.hasNextLine()) {
                        String departamentoFuncx = entrada.nextLine();
                        func.setDepartamento(departamentoFuncx);
                    }

                    System.out.println("Digite a profissão do funcionário: ");
                    String profissaoFunc = entrada.nextLine();
                    func.setProfissao(profissaoFunc);

                    System.out.println("Digite o número do documento do funcionário: ");
                    String docFunc = entrada.nextLine();
                    func.setDocumento(docFunc);

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
                    String empresaRsocial = entrada.next();
                    empresa.setRazaoSocial(empresaRsocial);
                    if(entrada.hasNextLine()) {
                        String empresaRazaoSocial = entrada.nextLine();
                        func.setNomeFunc(empresaRazaoSocial);
                    }

                    System.out.println("Digite o CNPJ da empresa: ");
                    String empresaCnpj = entrada.next();
                    empresa.setCnpj(empresaCnpj);
                    if(entrada.hasNextLine()) {
                        String empresaCNPJ = entrada.nextLine();
                        func.setNomeFunc(empresaCNPJ);
                    }

                    // Auto set
                    empresa.setIdEmpresa(String.valueOf(idEmpresa));

                    // Lista
                    listaDeEmpresas.add(empresa);

                    //ID count
                    idEmpresa += 1;

                    break;

                case 3:
                    // Atualizar salário.
                    System.out.println("Busque a empresa de");
                    System.out.println("Digite o novo salário do funcionário");
                    System.out.println("Pesquise o funcionario que deseja alterar o salario");
                    double novoSalarioFunc = entrada.nextDouble();
                    func.atualizarSalario(novoSalarioFunc);
                    break;

                case 4:
                    // Demitir funcionário.
                    System.out.println("Demitir Funcionário");
                    System.out.println("Deseja mesmo demitir esse funcionário? (Sim ou Não)");
                    String decisaoDemitirFunc = entrada.next();
                    if (Objects.equals(decisaoDemitirFunc, "Sim")) {
                        func.demitirFuncionario();
                    }
                    break;

                case 5:
                    // Listar funcionário.
                    System.out.println("Digite o ID do funcionário que deseja buscar: ");
                    int funcIdBuscar = entrada.nextInt();

                    System.out.println("Digite o ID da empresa do funcionário: ");
                    int empresaIdBuscar = entrada.nextInt();

                    boolean found = false;

                    for (Empresa empresaBuscaObj : listaDeEmpresas) {
                        if (String.valueOf(empresaIdBuscar).equals(empresaBuscaObj.getIdEmpresa())) {
                            for (Funcionario funcionarioBuscaObj : listaDeFuncionarios) {
                                if(funcIdBuscar == funcionarioBuscaObj.getIdFunc() && empresaBuscaObj.existeFuncionario(funcIdBuscar)) {
                                    empresaBuscaObj.mostrarFuncionarioEspecifico(funcionarioBuscaObj);
                                    found = true;
                                    break;
                                }
                            }
                        }
                    }

                    if(!found) {
                        System.out.println("Empresa e/ou funcionário não encontrado(s).");
                    }

                    break;


                case 6:
                    // Listar funcionários de todas as empresas.
                    for (Funcionario funcionarioTodasEmpresasObj : listaDeFuncionarios) {
                        System.out.println("Funcionário: " + funcionarioTodasEmpresasObj.getNomeFunc());
                        for (Empresa EmpresaTodasObj : listaDeEmpresas) {
                            System.out.println("Empresa: " + EmpresaTodasObj.getRazaoSocial());
                            System.out.println();
                            System.out.println();
                            break;
                        }
                    }

                    break;

                case 7:
                    // Adicionar funcionário ao quadro da empresa.
                    System.out.println("Digite o ID do funcionário que você deseja adicionar: ");
                    int funcIdAdd = entrada.nextInt();

                    System.out.println("Digite o ID da empresa que você deseja incluir o funcionário: ");
                    int empresaIdAdd = entrada.nextInt();

                    boolean added = false;

                    for (Empresa empresaAddObj : listaDeEmpresas) {
                        if (String.valueOf(empresaIdAdd).equals(empresaAddObj.getIdEmpresa())) {
                            for (Funcionario funcAddObj : listaDeFuncionarios) {
                                if (funcIdAdd == funcAddObj.getIdFunc()) {
                                    empresaAddObj.adicionarEmpregados(funcAddObj);
                                    added = true;
                                    break;
                                }
                            }
                        }
                    }

                    if(!added) {
                        System.out.println("Empresa e/ou funcionário não encontrado(s).");
                    }

                    break;

                case 8:
                    // Verificar a existência de um funcionário na empresa.
                    System.out.println("Digite o ID do funcionário que você deseja verificar: ");
                    int funcIdBuscaVerify = entrada.nextInt();

                    System.out.println("Digite o ID da empresa que esse funcionário está cadastrado: ");
                    int empresaIdBuscaVerify = entrada.nextInt();

                    boolean verifyFound = false;

                    for (Empresa empresaBuscaVerifyObj : listaDeEmpresas) {
                        if (String.valueOf(empresaIdBuscaVerify).equals(empresaBuscaVerifyObj.getIdEmpresa())) {
                            if (empresaBuscaVerifyObj.existeFuncionario(funcIdBuscaVerify)) {
                                System.out.println("Funcionário existente nessa empresa");
                                verifyFound = true;
                                break;
                            }
                        }
                    }

                    if(!verifyFound) {
                        System.out.println("Empresa e/ou funcionário não encontrado(s).");
                    }

                    break;

                case 9:
                    // Sair.
                    status = false;
                    break;

                default:
                    System.out.println("Desculpe, não consegui entender o que quis dizer. Por favor tente novamente.");
            }
        }
    }
}