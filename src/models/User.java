package models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lucas Oliveira
 */
public class User {
    private int id;
    private String nome;
    private String documento;
    private String telefone;
    private String email;
    
    public User(){}

    public User(int id, String nome, String documento, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
        this.email = email;
    }
    
    public User(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.nome = rs.getString("nome");
        this.documento = rs.getString("documento");
        this.telefone = rs.getString("telefone");
        this.email = rs.getString("email");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
