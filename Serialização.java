import java.io.*;

class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    
    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}

public class SerializacaoExemplo {

    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("Carlos", 30);

        
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("pessoa.ser"))) {

            oos.writeObject(pessoa);
            System.out.println("Objeto serializado com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("pessoa.ser"))) {

            Pessoa pessoaRecuperada = (Pessoa) ois.readObject();

            System.out.println("Objeto desserializado:");
            System.out.println("Nome: " + pessoaRecuperada.nome);
            System.out.println("Idade: " + pessoaRecuperada.idade);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
