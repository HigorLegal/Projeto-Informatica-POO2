/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Produto;
import model.Usuario;

/**
 *
 * @author S.lucas
 */
public class ProdutoController {
    
    public Produto buscaPk(int id) {
        String sql = "SELECT pkproduto,nome,valor from tbproduto where pkproduto = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;

        Produto pro = new Produto();
        try {
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, id);
            resultado = comando.executeQuery();
            if (resultado.next()) {

                
                pro.setPkproduto(resultado.getInt("pkproduto"));
                pro.setNome(resultado.getString("nome"));
                pro.setValor(resultado.getDouble("valor"));

            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());

        } finally {

            gerenciador.fecharConexao(comando, resultado);
        }
        return pro;
    }
}
