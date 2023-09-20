import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase;
        String chave;

        System.out.println("Escolha uma opção:");
        System.out.println("1 - Criptografar");
        System.out.print("2 - Descriptografar");
        int n = sc.nextInt();

        if(n<1||n>2){
            System.out.println("Opção inválida!");
        }
        if(n==2){
            System.out.println("2 - Descriptografar");
            System.out.println("Digite a frase a ser descriptografada: ");
            sc.nextLine();
            frase = sc.nextLine();
            frase = frase.toUpperCase();
            System.out.print("Digite a chave: ");
            chave = sc.nextLine();
            chave = chave.toUpperCase();
            System.out.println("Frase original: "+descriptografar(frase, chave));
        }
        if(n==1){
            System.out.println("1 - Criptografar");
            System.out.println("Digite a frase a ser criptografada: ");
            sc.nextLine();
            frase = sc.nextLine();
            frase = frase.toUpperCase();
            System.out.print("Digite a chave: ");
            chave = sc.nextLine();
            chave = chave.toUpperCase();
            System.out.println("Frase criptograda: "+criptografar(frase, chave));
        }
        sc.close();
    }
    public static String criptografar(String frase, String chave){
        String fraseCifra = "";
        int cont =0;
        while (chave.length()!=frase.length()) {
            chave+=(chave.charAt(cont));
            cont++;
        }
        for (int i = 0; i<frase.length(); i++){
            int letra = (frase.charAt(i) + chave.charAt(i))%26;
            letra+= 'A';
            fraseCifra +=(char)(letra);
        }
        return fraseCifra;
    }
    public static String descriptografar(String frase, String chave){
        String fraseDecif = "";
        int cont =0;
        while (chave.length()!=frase.length()) {
            chave+=(chave.charAt(cont));
            cont++;
        }
        for (int i = 0; i<frase.length() && i<chave.length(); i++){
            int letra = (frase.charAt(i)- chave.charAt(i) + 26)%26;
            letra+='A';
            fraseDecif +=(char)(letra);
        }
        return fraseDecif;
    }
}