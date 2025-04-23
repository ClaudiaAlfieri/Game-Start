import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TrabalhoPCE_Claudia_Alfieri {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println(" ");
        System.out.println("******************************************************************************************");
        System.out.println("*     ██████╗  █████╗ ███╗   ███╗███████╗    ███████╗████████╗ █████╗ ██████╗ ████████╗  *\n" +
                "*   ██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██╔════╝╚══██╔══╝██╔══██╗██╔══██╗╚══██╔══╝   *\n" +
                "*   ██║  ███╗███████║██╔████╔██║█████╗      ███████╗   ██║   ███████║██████╔╝   ██║      *\n" +
                "*   ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ╚════██║   ██║   ██╔══██║██╔══██╗   ██║      *\n" +
                "*   ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ███████║   ██║   ██║  ██║██║  ██║   ██║      *\n" +
                "*    ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝    ╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝      * ");
        System.out.println("******************************************************************************************");
        System.out.println(" ");

        //Caminho do arquivo
        File ficheiro = new File("GameStart_V2.csv");
        Scanner leitorParaLinhas = new Scanner(ficheiro);

        //Leitor para ler o ficheiro normalmente
        Scanner leitor = new Scanner(ficheiro);

        String linha, linha2;
        int numLinhas = 0;

        //Para não contar a primeira linha = cabeçalho
        linha = leitorParaLinhas.nextLine();

        while (leitorParaLinhas.hasNextLine()) {
            linha = leitorParaLinhas.nextLine();
            numLinhas++;
        }

        //Criar a matriz

        String[][] matrizMain = new String[numLinhas][9];

        //Cabeçalho - ignorar a 1a linha
        linha2 = leitor.nextLine();

        while (leitor.hasNextLine()) {
            for (int i = 0; i < numLinhas; i++) {
                linha2 = leitor.nextLine();
                String[] itensLinha = linha2.split(";");
                for (int coluna = 0; coluna < itensLinha.length; coluna++) {
                    matrizMain[i][coluna] = itensLinha[coluna];
                }
            }
        }

        //Fechar leitor

        leitor.close();
        leitorParaLinhas.close();

        //Chama o Menu Principal

        menuPrincipal(matrizMain);
    }

    /**
     * *Função do Menu Principal
     * @param matrizMain
     **/

    public static void menuPrincipal(String[][] matrizMain) throws FileNotFoundException {

        //Menu Principal

        Scanner input = new Scanner(System.in);

        String senhaUser;
        int opcaoUser;

        do {
            System.out.println("***************************");
            System.out.println("****     ---Menu---    ****");
            System.out.println("***************************");
            System.out.println("***  1. Administrativo  ***");
            System.out.println("***  2. Cliente         ***");
            System.out.println("***  3. Sair            ***");
            System.out.println("***************************");

            System.out.println("Escolha uma opção");
            opcaoUser = input.nextInt();


            switch (opcaoUser) {
                case 1:
                    System.out.println("Insira a senha de Administrativo ");
                    input.nextLine();
                    senhaUser = input.nextLine();
                    funcaoLogin(senhaUser, matrizMain);
                    return;
                case 2:
                    menuCliente(matrizMain);
                    return;
                case 3:
                    System.out.println("Programa encerrado");
                    break;
            }

        } while (opcaoUser != 3);
    }

    /**
     * *Função para retornar ao menu anterior
     **/

    public static void funcaoRetorno() {

        Scanner input = new Scanner(System.in);
        System.out.println("Digite 1 para retornar ao menu anterior");
        input.nextInt();
    }

    /**
     * *Função login para verificar senha usuário
     * @param senhaUser
     * @param matrizMain
    **/

    public static void funcaoLogin(String senhaUser, String[][] matrizMain) throws FileNotFoundException {

        String senha = "123456789";

        //Testar a senha do input usuário

        if (senhaUser.equals(senha)) {
            System.out.println("Senha corrreta. Bem vindo!");
            System.out.println(" ");
            menuAdmin(matrizMain);
        } else {
            System.out.println("Senha incorreta");
            System.out.println(" ");
        }
    }


    /**
     * *Função para imprimir o ficheiro completo
     * @param matrizMain
     **/

    public static void imprimirAll(String[][] matrizMain) throws FileNotFoundException {

        System.out.println("******************************************************");
        System.out.println("\n");
        //Imprimir o ficheiro completo

        for(int linha = 0; linha < matrizMain.length; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                System.out.println(matrizMain[linha][coluna]);
            }
        }
        System.out.println("******************************************************");
        System.out.println("\n");
        funcaoRetorno();
    }

    /**
     * *Função para imprimir o total das vendas
     * @param matrizMain
     **/

    public static void totalVendas(String[][] matrizMain) throws FileNotFoundException {

        System.out.println("******************************************************");
        System.out.println("\n");

        double total = 0;

        //Para calcular acumulado das vendas

        for(int i = 0; i< matrizMain.length; i++){
            double valor = Double.parseDouble(matrizMain[i][8]);
            total += valor;
        }
        //Imprime na consola
        System.out.println("O total das vendas é: " + matrizMain.length + " e o valor acumulado é: " + total + " €");

        System.out.println("******************************************************");
        System.out.println("\n");
        funcaoRetorno();
    }


    /**
     * *Função para imprimir o lucro das vendas
     * @param matrizMain
     **/

     public static void lucroTotal(String[][] matrizMain) throws FileNotFoundException {

         System.out.println("******************************************************");
         System.out.println("\n");

        double total = 0, lucroTotal = 0;

        //Para calcular acumulado das vendas

        for(int i = 0; i< matrizMain.length; i++){
           double valor = Double.parseDouble(matrizMain[i][8]);
           total += valor;
        }

        //Para calcular o lucro

        lucroTotal = total * 0.20;

        //Imprime na consola

        System.out.println ("O lucro total da vendas é: " + lucroTotal + " €");

        System.out.println("******************************************************");
        System.out.println("\n");
        funcaoRetorno();
        }

    /**
     * *Função para imprimir as informações de um cliente
     * @param matrizMain
     * @param id
     **/

    public static void mostrarCliente(String[][] matrizMain, int id) throws FileNotFoundException{

        System.out.println("******************************************************");
        System.out.println("\n");

        String nome =" ", tel=" ", mail=" ";

        //Ciclo para encontrar os campos nome, contacto e email no ficheiro

        for(int i = 0; i< matrizMain.length; i++) {
            int idCliente = Integer.parseInt(matrizMain[i][1]);
            String nomeCliente = matrizMain[i][2];
            String contacto = matrizMain[i][3];
            String email = matrizMain[i][4];

            //Encontrar o cliente pelo id

            if (id == idCliente) {
                nome = nomeCliente;
                tel = contacto;
                mail = email;
            }
        }

        System.out.println("Nome: " + nome + " Contacto: " + tel + " E-mail: " + mail);

        System.out.println("******************************************************");
        System.out.println("\n");
        funcaoRetorno();
    }

    /**  Função que encontra o jogo mais caro vendido e quem o comprou
    @param matrizMain
    **/

    public static void jogoMaisCaro(String[][] matrizMain) throws FileNotFoundException {

        System.out.println("******************************************************");
        System.out.println("\n");

        double total = 0, maior = 0.0;
        String jogoCaro = " ", quemComprou = " ";

        //Para encontrar o jogo mais caro

        for(int i = 0; i< matrizMain.length; i++){
            double valor = Double.parseDouble(matrizMain[i][8]);

            if (valor > maior) {
                maior = valor;
                jogoCaro = matrizMain[i][7];

                //Para encontrar quem comprou o jogo mais caro
                quemComprou = matrizMain[i][2];
            }
        }

        //Imprimir na consola
            System.out.println("O jogo mais caro vendido foi: " + jogoCaro + ". E quem o comprou foi: " + quemComprou);

        System.out.println("******************************************************");
        System.out.println("\n");
        funcaoRetorno();
    }

    /**  Função que encontra o melhor ciente
    @param matrizMain
    **/

    public static void melhorCliente(String[][] matrizMain) throws FileNotFoundException {

        System.out.println("******************************************************");
        System.out.println("\n");

        int[] totalGasto = new int[100];
        String[] nomeCliente = new String[100];
        String[][] jogosCliente = new String[100][100];
        int[] contadorJogos = new int[100];
        String tel=" ", mail=" ";

        // Ciclo para correr a matriz e contar o gasto e os jogos de cada cliente

        for (int i = 0; i < matrizMain.length; i++) {
            int clienteId = Integer.parseInt(matrizMain[i][1]) - 1;
            double price = Double.parseDouble(matrizMain[i][8]);
            totalGasto[clienteId] += price;
            nomeCliente[clienteId] = matrizMain[i][2];
            String contacto = matrizMain[i][3];
            String email = matrizMain[i][4];

            jogosCliente[clienteId][contadorJogos[clienteId]] = matrizMain[i][7]; // Guarda o jogo comprado
            contadorJogos[clienteId]++;
        }

        // Ciclo para encontrar o cliente que gastou mais
        int maiorGasto = 0;
        for (int i = 1; i < totalGasto.length; i++) {
            if (totalGasto[i] > totalGasto[maiorGasto]) {
                maiorGasto = i;
            }
        }

        // Encontrar os dados de contacto e e-mail do cliente.
        for(int i = 0; i< matrizMain.length; i++) {
            int idCliente = Integer.parseInt(matrizMain[i][1]);
            String contacto = matrizMain[i][3];
            String email = matrizMain[i][4];
            tel = contacto;
            mail = email;
        }

        // Imprimir tudo na consola
        System.out.println("O melhor cliente foi " + nomeCliente[maiorGasto] + ". Contacto " +  tel + " e e-mail "+  mail + ". Com um gasto total de " + totalGasto[maiorGasto] + " €");
        System.out.println("E os jogos comprados foram:");
        for (int i = 0; i < contadorJogos[maiorGasto]; i++) {
            System.out.println(jogosCliente[maiorGasto][i]);
        }
        System.out.println("******************************************************");
        System.out.println("\n");
        funcaoRetorno();
    }

    /**
     * *Função do Menu Administrativo
     * @param matrizMain
     **/

    public static void menuAdmin(String[][] matrizMain) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("***********************************************************");
            System.out.println("****                 --- Menu ADMIN ---                ****");
            System.out.println("***********************************************************");
            System.out.println("*** 1. Exibir conteúdo do arquivo                       ***");
            System.out.println("*** 2. Mostrar número total de vendas e valor acumulado ***");
            System.out.println("*** 3. Calcular lucro total                             ***");
            System.out.println("*** 4. Exibir informações de um cliente                 ***");
            System.out.println("*** 5. Jogo mais caro vendido e quem o comprou          ***");
            System.out.println("*** 6. Melhor cliente                                   ***");
            System.out.println("*** 7. Retornar ao menu inicial                         ***");
            System.out.println("*** 8. Sair                                             ***");
            System.out.println("***********************************************************");

            System.out.println("Escolha uma opção: ");
            opcao = input.nextInt();

                switch (opcao) {
                    case 1:
                        imprimirAll(matrizMain);
                        break;
                    case 2:
                        totalVendas(matrizMain);
                        break;
                    case 3:
                        lucroTotal(matrizMain);
                        break;
                    case 4: {
                        System.out.print("Digite o ID do cliente: ");
                         int id = input.nextInt();
                         mostrarCliente(matrizMain, id);
                    };
                        break;
                    case 5:
                        jogoMaisCaro(matrizMain);
                        break;
                    case 6:
                        melhorCliente(matrizMain);
                        break;
                    case 7:
                        menuPrincipal(matrizMain);
                        return;
                    case 8:
                        System.out.println("Programa encerrado");
                        return;
                    default:
                        System.out.println("Opção inválida.");

            }
        }while (opcao != 8);
    }

    // Funções Menu Cliente

    /**
     * *Função para retornar ao menu anterior
     **/

    public static void funcaoRetorno1() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        System.out.println("Digite 1 para retornar ao menu anterior");
        input.nextInt();
    }

    /**
     * *Função para registrar um novo cliente
     **/

    public static void registro() throws FileNotFoundException {

        System.out.println("******************************************************");
        System.out.println("\n");

        String nome, contacto, email;

        Scanner scanner = new Scanner(System.in);

        //Solicitar dados do novo cliente

        System.out.println("Inserir Cliente");
        System.out.println("Nome: ");
        nome = scanner.nextLine();
        System.out.println("Contacto: ");
        contacto = scanner.nextLine();
        System.out.println("E-mail: ");
        email = scanner.nextLine();

        //Imprimir na consola

        System.out.println(" Cliente inserido com sucesso: \n Nome: " + nome + " \n Contacto: " + contacto + " \n Email: " + email );

        System.out.println("******************************************************");
        System.out.println("\n");
        funcaoRetorno1();
    }

    /**
    Função para exibir vagas de estacionamento disponíveis
    **/

    public static void estacionamento() throws FileNotFoundException {

        System.out.println("******************************************************");
        System.out.println("\n");

        System.out.println( "As vagas de estacionamento disponíveis são: " );

        //Calcular as vagas disponíveis (números triangulares multiplos de 5)

        for(int vaga = 1; vaga <= 121; vaga++) {
            int soma = 0;
            for (int contador = 1; contador < vaga; contador++) {
                soma += contador;
                if (soma == vaga) {
                    if (vaga % 5 == 0){
                        System.out.println(vaga);
                    }
                }
            }
        }
        System.out.println("******************************************************");
        System.out.println("\n");
        funcaoRetorno1();
    }


    /**
     * *Função para imprimir todos os jogos disponíveis
     * @param matrizMain
     **/

    public static void jogos(String[][] matrizMain) throws FileNotFoundException {

        System.out.println("******************************************************");
        System.out.println("\n");
        String jogo = " ";
        boolean jogoImpresso;

        // Ciclo para encontrar os nomes de todos os jogos

        System.out.println("Os jogos disponíveis são: " );
        for (int i = 0; i < matrizMain.length; i++) {
            jogo = matrizMain[i][7];
            jogoImpresso = false;

            // Ciclo para tirar os nomes repetidos
            for (int j = 0; j < i; j++) {
                if (matrizMain[j][7].equals(jogo)) {
                    jogoImpresso = true;
                    break;
                }
            }

            // Imprimir os nomes dos jogos disponíveis
            if (jogoImpresso == false) {
                System.out.println(jogo);
            }
        }
        System.out.println("******************************************************");
        System.out.println("\n");
        funcaoRetorno1();
    }


    /**
     * *Função para imprimir as informações de uma Editora
     * @param matrizMain
     * @param editora
     **/

    public static void mostrarEditora(String[][] matrizMain, String editora) throws FileNotFoundException {

        System.out.println("******************************************************");
        System.out.println("\n");
        System.out.println("Editora a pesquisar:  \n" + "*** " + editora + " ***");

        // Cria um array para as categorias
        String[] categorias = new String[20];
        int categoriaContador = 0;

        // Ciclo para correr a matriz e procurar pela editora
        for (int i = 0; i < matrizMain.length; i++) {
            String categoria = matrizMain[i][6];
            String jogo = matrizMain[i][7];
            String editoraAtual = matrizMain[i][5];

            if (editoraAtual.equals(editora)) {
                // Ciclo para checar se a categoria já está no array
                boolean categoriaListada = false;
                for (int j = 0; j < categoriaContador; j++) {
                    if (categorias[j].equals(categoria)) {
                        categoriaListada = true;
                        break;
                    }
                }
                if (categoriaListada == false && categoriaContador < categorias.length) {
                    categorias[categoriaContador] = categoria;
                    categoriaContador++;
                }
            }
        }

        // Ciclo para imprimir a categoria
        for (int i = 0; i < categoriaContador; i++) {
            String categoria = categorias[i];
            System.out.println("__ " + categoria + " __");

            // Ciclo para imprimir os jogos da categoria
            for (int j = 0; j < matrizMain.length; j++) {
                String categoriaAtual = matrizMain[j][6];
                String jogo = matrizMain[j][7];
                String editoraAtual = matrizMain[j][5];

                if (editoraAtual.equals(editora) && categoriaAtual.equals(categoria)) {
                    System.out.println(jogo);
                }
            }
        }
        System.out.println("******************************************************");
        System.out.println("\n");
        funcaoRetorno();

    }

    /**
     * *Função do Menu Cliente
     * @param matrizMain
     **/

    public static void menuCliente(String[][] matrizMain) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("***********************************************************");
            System.out.println("****                --- Menu CLIENTE ---               ****");
            System.out.println("***********************************************************");
            System.out.println("*** 1. Registrar novo cliente                           ***");
            System.out.println("*** 2. Vagas de estacionamento                          ***");
            System.out.println("*** 3. Jogos disponíveis                                ***");
            System.out.println("*** 4. Busca por editora                                ***");
            System.out.println("*** 5. Retornar ao menu inicial                         ***");
            System.out.println("*** 6. Sair                                             ***");
            System.out.println("***********************************************************");

            System.out.println("Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    registro();
                    break;
                case 2:
                    estacionamento();
                    break;
                case 3:
                    jogos(matrizMain);
                    break;
                case 4: {
                    System.out.print("Digite o nome da Editora que gostaria de pesquisar: ");
                    String editora = input.next();
                    mostrarEditora(matrizMain, editora);
                    };
                    break;
                case 5:
                    menuPrincipal(matrizMain);
                    return;
                case 6:
                    System.out.println("Programa encerrado");
                    return;
                default:
                    System.out.println("Opção inválida.");

            }
        }while (opcao != 6);
    }
}