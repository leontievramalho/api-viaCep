package Main;

import Api.CepApiConsumer;
import Model.Address;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String nome = JOptionPane.showInputDialog("Qual seu nome? ");
        String cep = JOptionPane.showInputDialog("Para consultar seu endereço, digite seu Cep: ");
        Address endereco = CepApiConsumer.getAddress(cep);
        endereco.setNome(nome);
        StringBuilder exibirEnd = new StringBuilder();
        exibirEnd.append("Endereço de ");
        exibirEnd.append(endereco.getNome() + ": ");
        exibirEnd.append("\nCEP: ");
        exibirEnd.append(endereco.getCep());
        exibirEnd.append("\nUF: ");
        exibirEnd.append(endereco.getUf());
        exibirEnd.append("\nCidade: ");
        exibirEnd.append(endereco.getLocalidade());
        exibirEnd.append("\nBairro: ");
        exibirEnd.append(endereco.getBairro());
        exibirEnd.append("\nLogradouro: ");
        exibirEnd.append(endereco.getLogradouro());

        JOptionPane.showMessageDialog(null, exibirEnd);
    }
}
