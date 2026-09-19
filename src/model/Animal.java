package model;

public class Animal {
    private int id;
    private String nome;
    private int anoNasc;
    private int idEspecie;
    private String sexo;
    private int idCliente;

    public Animal(int id, String nome, int anoNasc, String sexo, int idEspecie, int idCliente) {
        this.id = id;
        this.nome = nome;
        this.anoNasc = anoNasc;
        this.sexo = sexo;   
        this.idEspecie = idEspecie;
        this.idCliente = idCliente;
    }

    Animal(int i, String toto, int i0, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getanoNasc() {
        return anoNasc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnoNasc(int anoNasc) {
        this.anoNasc = anoNasc;
    }

    public void setIdEspecie(int idEspecie) {
        this.idEspecie = idEspecie;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setanoNasc(int anoNasc) {
        this.anoNasc = anoNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getAnoNasc() {
        return anoNasc;
    }
    
    public int getIdEspecie() {
        return idEspecie;
    }

    public int getIdCliente() {
        return idCliente;
    }

    @Override
    public String toString() {
        return "Animal{" + "nome=" + nome + '}';
    }

    public void setAnoNasc(Integer integer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
