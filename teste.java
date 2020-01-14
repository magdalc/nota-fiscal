package teste;

import java.util.ArrayList;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> mercado = new ArrayList<>();
        ArrayList<Double> produto = new ArrayList<>();
        double totalImpostos= 0, totalMercadorias = 0;

        int op = 1;
        while (op == 1) {
            System.out.println("Nome do Mercado:");
            mercado.add(entrada.next());

            System.out.println("Quantidade do Produto:");
            produto.add(entrada.nextDouble());
            System.out.println("Saída Registrada com Sucesso!");

            System.out.println("\nOpções:\n1- Proxima Saída\n2- Finalizar Nota\nDigite uma Opção:");
            op = entrada.nextInt();
        }

        System.out.println("\n****  NOTA FISCAL  ****");

        for (int j = 0; j < mercado.size(); j++) {
            System.out.println("\nCliente: " + mercado.get(j) + "\nQuantidade de Produtos: " + produto.get(j));
            System.out.printf("------Impostos calculados------\nICMS: R$ " + imposto(produto.get(j))[0] + " IPI: R$ " + imposto(produto.get(j))[1]
                    + "\nPIS: R$ " + imposto(produto.get(j))[2] + " COFINS: R$ " + imposto(produto.get(j))[3] + "\nTotal com Imposto: R$ " + imposto(produto.get(j))[5]);
            totalImpostos = totalImpostos + imposto(produto.get(j))[4];
            totalMercadorias = totalMercadorias + (produto.get(j) * 4.5);
        }
        System.out.println("\n-------Somatório Geral-------");
        System.out.println("Total de Impostos: R$ " + totalImpostos);
        System.out.println("Total de Mercadorias: R$ " + totalMercadorias);
        System.out.println("Total Geral: R$ " + (totalMercadorias + totalImpostos));
    }

    public static double[] imposto(double qtdProduto) {
        double impost[] = new double[6];
        
        impost[0] = qtdProduto * 4.5 * 18 / 100;  /*Calculo Icms*/
        impost[1] = qtdProduto * 4.5 * 4 / 100;  /*Calculo IPI*/
        impost[2] = qtdProduto * 4.5 * 1.86 / 100;  /*Calculo PIS*/
        impost[3] = qtdProduto * 4.5 * 8.54 / 100;  /*Calculo COFINS*/
        impost[4] = impost[0] + impost[1] + impost[2] + impost[3];/*Somatório de Impostos*/
        impost[5] = impost[0] + impost[1] + impost[2] + impost[3] + (qtdProduto * 4.5);/*Somatório de Impostos COM a Mercadoria*/
        return impost;
    }
}
