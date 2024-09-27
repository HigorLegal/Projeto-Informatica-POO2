

package model;
import  java.util.Date;
import javax.swing.Icon;

public class Usuario {

private int pkusuario;
private String nome;
private String senha;
private String email;
private boolean ativo;     
private Icon Image; 

    public Usuario() {
    }

    public Usuario(int pkusuario, String nome, String email, String senha, Date dataNasc, boolean ativo, Icon Image) {
        this.pkusuario = pkusuario;
        this.nome = nome;
     
        this.senha = senha;
        this.email = email;
        
        this.ativo = ativo;
        this.Image = Image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  

    public Icon getImage() {
        return Image;
    }

    public void setImage(Icon Image) {
        this.Image = Image;
    }

    public int getPkusuario() {
        return pkusuario;
    }

    public void setPkusuario(int pkusuario) {
        this.pkusuario = pkusuario;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

  
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date converterDateToString(Date a) {
        return  a;
    }

    public String ativoToString() {
        if(ativo){
        return  "Ativo";
        }else{
        return  "Inativo";
        }
        
    }


}
