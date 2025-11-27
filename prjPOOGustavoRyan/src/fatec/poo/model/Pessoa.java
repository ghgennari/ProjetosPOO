
package fatec.poo.model;

/**
 *
 * @author Ryan
 */
public class Pessoa {
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;

    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public static boolean validarCPF(String cpf){
    cpf = cpf.replaceAll("[^0-9]", "");

    if (cpf.length() != 11)
        return false;

    if (cpf.matches("(\\d)\\1{10}"))
        return false;

    int soma = 0;
    for (int i = 0; i < 9; i++)
        soma += Character.getNumericValue(cpf.charAt(i)) * (i + 1);

    int digito1 = soma % 11;
    if (digito1 == 10) digito1 = 0;

    soma = 0;
    for (int i = 0; i < 10; i++)
        soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);

    int digito2 = (soma * 10) % 11;
    if (digito2 == 10) digito2 = 0;

    return digito1 == Character.getNumericValue(cpf.charAt(9)) &&
           digito2 == Character.getNumericValue(cpf.charAt(10));
    }
}
