/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.Icon;

/**
 *
 * @author S.lucas
 */
public class Produto {
 private   int pkproduto;
   private String	nome; 
   private double	valor ;
   private  Icon image; 

    public Produto() {
    }

    public Produto(int pkproduto, String nome, double valor, Icon image) {
        this.pkproduto = pkproduto;
        this.nome = nome;
        this.valor = valor;
        this.image = image;
    }

    public int getPkproduto() {
        return pkproduto;
    }

    public void setPkproduto(int pkproduto) {
        this.pkproduto = pkproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }
   
}
