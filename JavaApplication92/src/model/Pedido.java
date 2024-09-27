/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author S.lucas
 */
public class Pedido {

    private int pkpedido;
    private int fkusuario;
    private int fkproduto;
    private String nomeP;
    private double valorP;

    public Pedido(int pkpedido, int fkusuario, int fkproduto, String nomeP, double valorP) {
        this.pkpedido = pkpedido;
        this.fkusuario = fkusuario;
        this.fkproduto = fkproduto;
        this.nomeP = nomeP;
        this.valorP = valorP;
    }

    public Pedido() {
    }

    public String getNomeP() {
        return nomeP;
    }

    public void setNomeP(String nomeP) {
        this.nomeP = nomeP;
    }

    public double getValorP() {
        return valorP;
    }

    public void setValorP(double valorP) {
        this.valorP = valorP;
    }

    public int getPkpedido() {
        return pkpedido;
    }
    
    public void setPkpedido(int pkpedido) {
        this.pkpedido = pkpedido;
    }

    public int getFkusuario() {
        return fkusuario;
    }

    public void setFkusuario(int fkusuario) {
        this.fkusuario = fkusuario;
    }

    public int getFkproduto() {
        return fkproduto;
    }

    public void setFkproduto(int fkproduto) {
        this.fkproduto = fkproduto;
    }
}
