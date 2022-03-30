import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.SoldItems;


public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        /*Fazer um programa para cirar o caminho de um arquivo .csv contendo os dados de itens vendidos. Cada item possui um nome, preço unitário e quantidade, separados por vírgula.
        Você deve gerar um novo arquivo chamado "summary.csv", localizado em uma subpasta chamada "out" a partir da pasta original do arquivo de origem, contendo apenas o nome e o valor total para
        aquele item (preço unitário multiplicado pela quantidade), conforme exemplo.*/
        
        List<SoldItems> soldItems = new ArrayList<>();
        
        System.out.print("How many products will be sold: ");
        int n = sc.nextInt();
        
        for(int i=1; i<=n; i++) {
            System.out.println("Product #" + i + ":");
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            soldItems.add(new SoldItems(name, price, quantity));
            System.out.println();
        }

        //Salvando o produto vendido
        System.out.print("Enter a folder path to save source datas: ");
        sc.nextLine();
        String strPath = sc.nextLine();
        File path = new File(strPath);
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (SoldItems updatedList : soldItems){
                bw.write(updatedList.toString());
                bw.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("File Saved!");
        System.out.println();

        //Gerando a subpasta "out" 
        boolean success = new File(path.getParent() + "\\out").mkdir();
        System.out.println("SubDirectory 'out' created successfully: " + success);

        //Gerando o arquivo summary.csv
        System.out.print("Enter a folder path to save summary datas: ");
        String strPath2 = sc.nextLine();
        File path2 = new File(strPath2);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path2))) {
            for (SoldItems summary : soldItems){
                bw.write(summary.getName() + "," + String.format("%.2f", summary.totalValue()));
                bw.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("File Saved!");

        sc.close();
    }
}
