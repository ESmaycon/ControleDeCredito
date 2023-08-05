package br.com.controleCredito.Main;

import br.com.controleCredito.modelos.CartaoCredito;
import br.com.controleCredito.modelos.Compra;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o seu limite: ");
        double limite = leitura.nextDouble();
        CartaoCredito cartao = new CartaoCredito(limite);

        int sair = 1;
        while (sair != 0 ){
            System.out.println("Produto: ");
            String descricao = leitura.next();

            System.out.println("Valor do Produto: ");
            double valor = leitura.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada){
                System.out.println("Compra realizada! ");
                System.out.println("Digite 0 para sair ou 1 para continuar: ");
                sair = leitura.nextInt();
            } else {
                System.out.println("Saldo insuficente para realizar compra");
                sair = 0;
            }

            System.out.println("********************************************\n");
            System.out.println("COMPRAS REALIZADAS:\n");
            Collections.sort(cartao.getCompras());
            for (Compra c : cartao.getCompras()){
                System.out.println(c.getDescricao() +  " - " + "R$"+c.getValor() );
            }
            System.out.println("\n1********************************************");

            System.out.println("\nSaldo do cartão: " + "R$"+cartao.getSaldo());
        }
    }
}
