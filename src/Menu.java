
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner l;
    private boolean execute;
    private List<Dados> dados;

    public static void main(String[] args) {
        new Menu();
    }

    private Menu() {
        l = new Scanner(System.in);
        execute = true;
        dados = new ArrayList<Dados>();
        System.out.println();
        System.out.println();
        System.out.println("BEM VINDO AO CADASTRO DE USUÁRIOS");
        System.out.println();

        while (execute) {
            String opcao = menu();

            if (opcao.equalsIgnoreCase("1")) {
                cadastrar();
            } else if (opcao.equalsIgnoreCase("2")) {
                listarCadastros();
            } else if (opcao.equalsIgnoreCase("3")) {
                execute = false;
            } else {
                System.out.println("\nOpção Inválida!!! \n");
            }
        }
    }

    private String menu() {
        System.out.println();
        System.out.println("Selecione a opção:");
        System.out.println("1 - Novo cadastro");
        System.out.println("2 - Listar cadastros");
        System.out.println("3 - Sair");
        System.out.println();
        return l.nextLine();
    }

    private void cadastrar() {
        boolean cadastrando = true;

        while (cadastrando) {
            System.out.println("Cadastro de Usuário");
            Dados d = new Dados();
            d.setNome(textInput("Nome:"));
            d.setLogin(textInput("Login: "));
            d.setCargo(textInput("Cargo: "));

            String cadastrar = textInput("Adicionar cadastro (S/N) ?");
            if (cadastrar.equalsIgnoreCase("s")) {
                System.out.println("Cadastro realizadp !!!");
                dados.add(d);
            } else if (cadastrar.equalsIgnoreCase("n")) {
                System.out.println("Cadastro ignorado !!!");
            } else {
                System.out.println("\nOpção inválida! Por favor verifique novamente os dados inseridos \n");
            }

            String continua = textInput("Continuar cadastrando (S/N) ?");
            if (continua.equalsIgnoreCase("N")) {
                cadastrando = false;
            } else if (continua.equalsIgnoreCase("s")) {
                // se for s sai do if e volta para o inicio do while
            } else {
                System.out.println("\nOpção inválida! \n");
                cadastrando = false;
            }
        }
    }

    private void listarCadastros() {
        if (dados.size() == 0) {
            System.out.println("\nNão existem cadastros !!!\n");
        } else {
            System.out.println("\nLista de Cadastros\n");
            for (int i = 0; i < dados.size(); i++) {
                Dados d = dados.get(i);
                System.out.println("Cadastro número: " + i);
                System.out.println("\tNome: " + d.getNome());
                System.out.println("\tLogin: " + d.getLogin());
                System.out.println("\tCargo: " + d.getCargo() + "\n");
            }
            System.out.println("\nFim da lista\n");
        }
    }

    private String textInput(String label) {
        System.out.println(label);
        return l.nextLine();
    }
}